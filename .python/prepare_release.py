#!/usr/bin/env python3
"""Build, verify, hash and atomically collect a signed universal release APK."""

from __future__ import annotations

import hashlib
import json
import os
import re
import shlex
import shutil
import subprocess
import sys
import tempfile
import zlib
from pathlib import Path
from typing import NoReturn


ROOT = Path(__file__).resolve().parents[1]
APP_ID = "io.github.supermonster003.autojs6.plugin.pinyin4j"
RELEASE_METADATA = ROOT / "app" / "build" / "outputs" / "apk" / "release" / "output-metadata.json"
VERSION_PROPERTIES = ROOT / "version.properties"
ENGLISH_CHANGELOG = ROOT / "app" / "src" / "main" / "assets" / "doc" / "CHANGELOG-en.md"
SIGN_PROPERTIES = ROOT / "sign.properties"
OUTPUT_ROOT = ROOT / "app" / "releases"
ARTIFACT_PREFIX = "autojs6-plugin-pinyin4j"


class ReleaseError(RuntimeError):
    """A release precondition or verification failed."""


def fail(message: str) -> NoReturn:
    raise ReleaseError(message)


def read_properties(path: Path) -> dict[str, str]:
    if not path.is_file():
        fail(f"Properties file does not exist: {path}")
    result: dict[str, str] = {}
    for raw_line in path.read_text(encoding="utf-8").splitlines():
        line = raw_line.strip()
        if not line or line.startswith(("#", "!")):
            continue
        if "=" not in line:
            fail(f"Malformed property in {path}: {raw_line}")
        key, value = line.split("=", 1)
        result[key.strip()] = value.strip()
    return result


def run_checked(command: list[str]) -> None:
    print(f"+ {shlex.join(command)}", flush=True)
    completed = subprocess.run(command, cwd=ROOT, check=False)
    if completed.returncode != 0:
        fail(f"Command failed with exit code {completed.returncode}: {shlex.join(command)}")


def gradle_command() -> list[str]:
    wrapper = ROOT / ("gradlew.bat" if os.name == "nt" else "gradlew")
    if not wrapper.is_file():
        fail(f"Gradle wrapper does not exist: {wrapper}")
    return [str(wrapper), ":app:assembleRelease", "--console=plain", "--stacktrace"]


def load_release_apk(expected_version_name: str, expected_version_code: int) -> Path:
    if not RELEASE_METADATA.is_file():
        fail(f"Release metadata was not generated: {RELEASE_METADATA}")
    try:
        metadata = json.loads(RELEASE_METADATA.read_text(encoding="utf-8"))
    except (OSError, json.JSONDecodeError) as error:
        fail(f"Cannot read release metadata: {error}")

    if metadata.get("applicationId") != APP_ID:
        fail(f"Unexpected applicationId in release metadata: {metadata.get('applicationId')!r}")
    if metadata.get("variantName") != "release":
        fail(f"Unexpected variant in release metadata: {metadata.get('variantName')!r}")

    elements = metadata.get("elements")
    if not isinstance(elements, list) or len(elements) != 1:
        fail("Release metadata must contain exactly one APK element")
    element = elements[0]
    if element.get("filters"):
        fail("Release APK is split by ABI or density; one universal APK is required")
    if element.get("versionName") != expected_version_name:
        fail(
            "Version name mismatch: "
            f"version.properties={expected_version_name!r}, metadata={element.get('versionName')!r}",
        )
    if element.get("versionCode") != expected_version_code:
        fail(
            "Version code mismatch: "
            f"version.properties={expected_version_code}, metadata={element.get('versionCode')!r}",
        )

    output_file = element.get("outputFile")
    if not isinstance(output_file, str) or Path(output_file).name != output_file:
        fail(f"Unsafe or missing APK output name in metadata: {output_file!r}")
    apk = (RELEASE_METADATA.parent / output_file).resolve()
    if apk.parent != RELEASE_METADATA.parent.resolve() or not apk.is_file():
        fail(f"Release APK does not exist in the expected output directory: {apk}")
    if apk.stat().st_size == 0:
        fail(f"Release APK is empty: {apk}")
    return apk


def unescape_java_property(value: str) -> str:
    result: list[str] = []
    index = 0
    escapes = {"t": "\t", "n": "\n", "r": "\r", "f": "\f"}
    while index < len(value):
        character = value[index]
        if character != "\\" or index + 1 >= len(value):
            result.append(character)
            index += 1
            continue
        index += 1
        escaped = value[index]
        if escaped == "u" and index + 4 < len(value):
            code_point = value[index + 1 : index + 5]
            try:
                result.append(chr(int(code_point, 16)))
            except ValueError:
                result.extend(("\\", escaped))
            else:
                index += 4
        else:
            result.append(escapes.get(escaped, escaped))
        index += 1
    return "".join(result)


def android_sdk_directory() -> Path:
    for variable in ("ANDROID_SDK_ROOT", "ANDROID_HOME"):
        value = os.environ.get(variable)
        if value:
            sdk = Path(value).expanduser().resolve()
            if sdk.is_dir():
                return sdk

    local_properties = ROOT / "local.properties"
    if local_properties.is_file():
        sdk_value = read_properties(local_properties).get("sdk.dir")
        if sdk_value:
            sdk = Path(unescape_java_property(sdk_value)).expanduser().resolve()
            if sdk.is_dir():
                return sdk
    fail("Android SDK not found; set ANDROID_SDK_ROOT/ANDROID_HOME or sdk.dir in local.properties")


def version_sort_key(path: Path) -> tuple[int, ...]:
    numbers = tuple(int(part) for part in re.findall(r"\d+", path.parent.name))
    return numbers or (0,)


def find_apksigner() -> Path:
    override = os.environ.get("APKSIGNER")
    if override:
        tool = Path(override).expanduser().resolve()
        if tool.is_file():
            return tool
        fail(f"APKSIGNER does not point to a file: {tool}")

    sdk = android_sdk_directory()
    executable = "apksigner.bat" if os.name == "nt" else "apksigner"
    candidates = list((sdk / "build-tools").glob(f"*/{executable}"))
    if not candidates:
        fail(f"No {executable} found under {sdk / 'build-tools'}")
    return max(candidates, key=version_sort_key).resolve()


def verify_signature(apk: Path) -> None:
    apksigner = find_apksigner()
    command = [str(apksigner), "verify", "--verbose", str(apk)]
    print(f"+ {shlex.join(command)}", flush=True)
    completed = subprocess.run(
        command,
        cwd=ROOT,
        check=False,
        text=True,
        stdout=subprocess.PIPE,
        stderr=subprocess.STDOUT,
    )
    if completed.stdout:
        print(completed.stdout.rstrip())
    if completed.returncode != 0:
        fail(f"APK signature verification failed with exit code {completed.returncode}")


def file_digests(path: Path) -> tuple[str, str]:
    crc32 = 0
    sha256 = hashlib.sha256()
    with path.open("rb") as stream:
        for chunk in iter(lambda: stream.read(1024 * 1024), b""):
            crc32 = zlib.crc32(chunk, crc32)
            sha256.update(chunk)
    return f"{crc32 & 0xFFFFFFFF:08x}", sha256.hexdigest()


def atomic_copy(source: Path, destination: Path) -> None:
    destination.parent.mkdir(parents=True, exist_ok=True)
    descriptor, temporary_name = tempfile.mkstemp(
        prefix=f".{destination.name}.",
        suffix=".tmp",
        dir=destination.parent,
    )
    temporary = Path(temporary_name)
    try:
        with os.fdopen(descriptor, "wb") as output, source.open("rb") as input_stream:
            shutil.copyfileobj(input_stream, output, length=1024 * 1024)
            output.flush()
            os.fsync(output.fileno())
        if os.name != "nt":
            os.chmod(temporary, 0o644)
        os.replace(temporary, destination)
    finally:
        temporary.unlink(missing_ok=True)


def atomic_write_text(destination: Path, content: str) -> None:
    destination.parent.mkdir(parents=True, exist_ok=True)
    descriptor, temporary_name = tempfile.mkstemp(
        prefix=f".{destination.name}.",
        suffix=".tmp",
        dir=destination.parent,
    )
    temporary = Path(temporary_name)
    try:
        with os.fdopen(descriptor, "w", encoding="utf-8", newline="\n") as output:
            output.write(content)
            output.flush()
            os.fsync(output.fileno())
        if os.name != "nt":
            os.chmod(temporary, 0o644)
        os.replace(temporary, destination)
    finally:
        temporary.unlink(missing_ok=True)


def release_notes(version_name: str) -> str:
    if not ENGLISH_CHANGELOG.is_file():
        fail(f"English changelog does not exist: {ENGLISH_CHANGELOG}")
    changelog = ENGLISH_CHANGELOG.read_text(encoding="utf-8")
    pattern = re.compile(rf"(?ms)^# v{re.escape(version_name)}\s*\n.*?(?=^# v|\Z)")
    match = pattern.search(changelog)
    if match is None:
        fail(f"English changelog has no release section for v{version_name}")
    return match.group(0).rstrip() + "\n"


def publish(apk: Path, version_name: str) -> tuple[Path, str, str]:
    if not re.fullmatch(r"[0-9A-Za-z][0-9A-Za-z._-]*", version_name):
        fail(f"Version name is unsafe for an artifact path: {version_name!r}")

    crc32, sha256 = file_digests(apk)
    output_directory = OUTPUT_ROOT / f"v{version_name}"
    artifact_name = f"{ARTIFACT_PREFIX}-v{version_name}-universal-{crc32}.apk"
    artifact = output_directory / artifact_name
    notes = output_directory / "RELEASE_NOTES.md"
    sums = output_directory / "SHA256SUMS.txt"

    atomic_copy(apk, artifact)
    atomic_write_text(notes, release_notes(version_name))
    atomic_write_text(sums, f"{sha256}  {artifact_name}\n")

    for stale in output_directory.glob(f"{ARTIFACT_PREFIX}-v{version_name}-universal-*.apk"):
        if stale != artifact:
            stale.unlink()

    return artifact, crc32, sha256


def prepare_release() -> None:
    properties = read_properties(VERSION_PROPERTIES)
    version_name = properties.get("VERSION_NAME", "")
    try:
        version_code = int(properties["VERSION_BUILD"])
    except (KeyError, ValueError):
        fail("VERSION_BUILD must be an integer in version.properties")
    if not version_name:
        fail("VERSION_NAME is missing from version.properties")
    if not SIGN_PROPERTIES.is_file():
        fail("sign.properties is required so the release APK is signed")

    run_checked([sys.executable, str(ROOT / ".python" / "generate_markdown.py"), "--check"])
    run_checked(gradle_command())
    apk = load_release_apk(version_name, version_code)
    verify_signature(apk)
    artifact, crc32, sha256 = publish(apk, version_name)

    print("RELEASE_OK")
    print(f"artifact={artifact.relative_to(ROOT)}")
    print(f"versionName={version_name}")
    print(f"versionCode={version_code}")
    print(f"crc32={crc32}")
    print(f"sha256={sha256}")


def main() -> int:
    try:
        prepare_release()
    except ReleaseError as error:
        print(f"RELEASE_ERROR: {error}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

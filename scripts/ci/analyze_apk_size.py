#!/usr/bin/env python3
"""Measure the release APK and its pinned pinyin4j resource footprint."""

from __future__ import annotations

import argparse
import hashlib
import json
import sys
import zipfile
from datetime import date
from pathlib import Path
from typing import Any


PINYIN_RESOURCE_ENTRIES = (
    "pinyindb/multi_pinyin.txt",
    "pinyindb/pinyin_gwoyeu_mapping.xml",
    "pinyindb/pinyin_mapping.xml",
    "pinyindb/unicode_to_hanyu_pinyin.txt",
)


class ApkSizeError(RuntimeError):
    """The APK cannot support a meaningful and reproducible size analysis."""


def analyze(apk_path: Path) -> dict[str, Any]:
    if not apk_path.is_file():
        raise ApkSizeError(f"APK does not exist: {apk_path}")
    apk_bytes = apk_path.read_bytes()
    try:
        with zipfile.ZipFile(apk_path) as archive:
            corrupt_entry = archive.testzip()
            if corrupt_entry is not None:
                raise ApkSizeError(f"APK ZIP integrity check failed at {corrupt_entry}")
            resources = {}
            for entry_name in PINYIN_RESOURCE_ENTRIES:
                try:
                    info = archive.getinfo(entry_name)
                except KeyError as error:
                    raise ApkSizeError(f"APK is missing pinned resource {entry_name}") from error
                resources[entry_name] = zip_metrics(info, len(apk_bytes))
            try:
                dex = zip_metrics(archive.getinfo("classes.dex"), len(apk_bytes))
            except KeyError as error:
                raise ApkSizeError("APK is missing classes.dex") from error
            native_entries = [
                name for name in archive.namelist()
                if name.startswith("lib/") and name.endswith(".so")
            ]
    except zipfile.BadZipFile as error:
        raise ApkSizeError(f"Invalid APK ZIP: {error}") from error

    resource_packaged_bytes = sum(item["packagedBytes"] for item in resources.values())
    return {
        "apk": str(apk_path.resolve()),
        "apkBytes": len(apk_bytes),
        "apkSha256": hashlib.sha256(apk_bytes).hexdigest(),
        "resources": resources,
        "resourcePackagedBytes": resource_packaged_bytes,
        "resourceApkPercent": resource_packaged_bytes * 100.0 / len(apk_bytes),
        "classesDex": dex,
        "nativeEntryCount": len(native_entries),
    }


def zip_metrics(info: zipfile.ZipInfo, apk_bytes: int) -> dict[str, int | float]:
    return {
        "sourceBytes": info.file_size,
        "packagedBytes": info.compress_size,
        "apkPercent": info.compress_size * 100.0 / apk_bytes,
    }


def render_report(result: dict[str, Any], measured_on: str) -> str:
    apk_name = Path(result["apk"]).name
    lines = [
        "# Pinyin4j APK 体积基线",
        "",
        f"测量日期: `{measured_on}`  ",
        f"被测 release APK: `{apk_name}`  ",
        f"APK SHA-256: `{result['apkSha256']}`  ",
        f"APK 大小: `{result['apkBytes']:,}` bytes ({result['apkBytes'] / 1024:.2f} KiB)  ",
        f"原生库条目: `{result['nativeEntryCount']}`",
        "",
        "## ZIP 条目测量",
        "",
        "| 条目 | 源大小 | APK 内大小 | APK 占比 |",
        "|---|---:|---:|---:|",
    ]
    for entry_name in PINYIN_RESOURCE_ENTRIES:
        item = result["resources"][entry_name]
        lines.append(
            f"| `{entry_name}` | {item['sourceBytes']:,} | {item['packagedBytes']:,} | "
            f"{item['apkPercent']:.2f}% |"
        )
    lines.extend(
        [
            f"| 四份 pinyin4j 数据合计 | — | {result['resourcePackagedBytes']:,} | "
            f"{result['resourceApkPercent']:.2f}% |",
            f"| `classes.dex` | {result['classesDex']['sourceBytes']:,} | "
            f"{result['classesDex']['packagedBytes']:,} | {result['classesDex']['apkPercent']:.2f}% |",
            "",
            "`packagedBytes` 使用 APK ZIP 中的 `compress_size`; APK 签名块, 对齐和中央目录不属于任何单一条目, 因此各项占比不会合计到 100%.",
            "",
            "## 回归用途",
            "",
            "- 依赖或 R8 配置变更后必须重新生成本报告并解释 APK 或四份词表资源的变化.",
            "- 当前发布策略保持单一 universal APK 且不包含原生库.",
            "- 体积门禁建议以当前 APK 大小上浮 10% 作为预警线, 不是自动接受依赖升级的依据.",
            "",
            "复测命令:",
            "",
            "```powershell",
            ".\\gradlew.bat :app:assembleRelease",
            "py scripts\\ci\\analyze_apk_size.py app\\build\\outputs\\apk\\release\\app-release.apk --report docs\\performance\\apk-size-baseline-2026-09-01.md",
            "```",
            "",
        ]
    )
    return "\n".join(lines)


def parse_args(argv: list[str] | None = None) -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("apk", type=Path)
    parser.add_argument("--report", type=Path, help="write a Markdown report")
    parser.add_argument("--date", default=date.today().isoformat(), help="measurement date")
    parser.add_argument("--json", action="store_true", help="print full JSON")
    parser.add_argument("--max-bytes", type=int, help="fail if the APK exceeds this size")
    return parser.parse_args(argv)


def main(argv: list[str] | None = None) -> int:
    args = parse_args(argv)
    try:
        result = analyze(args.apk)
        if args.max_bytes is not None and result["apkBytes"] > args.max_bytes:
            raise ApkSizeError(
                f"APK size {result['apkBytes']} exceeds limit {args.max_bytes}",
            )
        if args.report is not None:
            args.report.parent.mkdir(parents=True, exist_ok=True)
            args.report.write_text(
                render_report(result, args.date),
                encoding="utf-8",
                newline="\n",
            )
    except (OSError, ApkSizeError) as error:
        print(f"APK_SIZE_ERROR {error}", file=sys.stderr)
        return 1

    if args.json:
        print(json.dumps(result, ensure_ascii=False, indent=2))
    else:
        print(
            "APK_SIZE_OK "
            f"apk_bytes={result['apkBytes']} "
            f"resources_bytes={result['resourcePackagedBytes']} "
            f"resources_percent={result['resourceApkPercent']:.2f} "
            f"native_entries={result['nativeEntryCount']} "
            f"sha256={result['apkSha256']}"
        )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

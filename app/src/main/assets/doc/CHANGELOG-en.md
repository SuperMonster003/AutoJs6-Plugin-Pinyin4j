******

### Release History

******

# v1.1.0

###### 2026/09/01

* `Fixed` Removed the trailing separator produced for non-whitespace separators and now preserve non-Chinese characters, including leading and trailing whitespace, exactly
* `Fixed` Normalized pinyin4j 2.5.1's legacy breve third-tone vowels to standard caron forms (for example `yŭ` to `yǔ`), consistently in lowercase and uppercase
* `Improved` Added JVM unit tests for option names and aliases, value shortcuts, output combinations, defaults, errors, tone conversion and runtime metadata, plus Android instrumentation coverage for real service discovery and Binder round trips
* `Improved` Added GitHub Actions workflows that reject generated-document drift, run unit tests, build the debug APK, compile instrumentation tests and upload the APK artifact
* `Improved` Added `.python/prepare_release.py` to build and verify a signed universal APK, validate its version, calculate CRC32 and SHA-256, and atomically generate `SHA256SUMS.txt` and English `RELEASE_NOTES.md`
* `Improved` Standardize the README layout and Gradle platform version management

# v1.0.1

###### 2026/08/31

* `Hint` This release only improves documentation and supporting tooling; Pinyin conversion behavior and every script API remain unchanged
* `Fixed` Corrected the wrong `pinyin4j.asTone(text)` usage found in earlier docs: the host actually exposes `pinyin4j.as(text)` (the underlying AIDL method is still named `asTone`)
* `Improved` Reworked the README in 10 languages: added sections for usage, quick start, option reference table, script API, self check, FAQ, permissions and security, sibling plugin comparison and plugin interface
* `Improved` Upgraded the docs generator to the unified implementation shared across sibling plugins: `--check` drift detection, cross-language key and shape validation, fullwidth symbol rejection and version alignment checks
* `Improved` Brought the Plugin Center instructions (`plugin_instruction.md`) into the same multilingual JSON generation pipeline, eliminating double-source maintenance
* `Improved` Added the ROADMAP.md development roadmap and established bidirectional cross-references and a comparison with the sibling plugin Pinyin

# v1.0.0

###### 2026/07/15

* `Added` Pinyin4j plugin service: plugin ID `pinyin4j`, automatically discovered and invoked by AutoJs6 via `org.autojs.plugin.PINYIN4J`, wrapping the `com.belerweb:pinyin4j:2.5.1` library
* `Added` Conversion API: `pinyin4j.of(text, options)` converts Chinese text to Hanyu Pinyin character by character; passing a string as the second argument uses it directly as the separator
* `Added` Tone restoring API: `pinyin4j.as(text)` restores number-toned Pinyin (such as `han4`) to mark-toned Pinyin (such as `hàn`), backed by the AIDL method `asTone`
* `Added` Flexible options: aliases such as `case` / `tone` / `v` / `sep` and value shortcuts such as `MARK` / `NUMBER` / `NO`, with localized errors thrown on invalid values
* `Added` Multilingual resources: plugin info and instructions available in 10 languages
* `Added` README and CHANGELOG generated as multilingual Markdown from JSON sources via `.python/generate_markdown.py`

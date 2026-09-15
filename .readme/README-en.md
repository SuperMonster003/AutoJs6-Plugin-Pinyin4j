<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Pinyin4j plugin for Chinese to Hanyu Pinyin conversion</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Pinyin4j?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Languages

******

The README.md is currently available in the following languages:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- English [en] # current
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### Introduction

******

The Pinyin4j Plugin brings lightweight per-character romanization to AutoJs6. Scripts can convert text to a formatted Hanyu Pinyin string, query every dictionary pronunciation as a Unicode-aligned matrix in Hanyu, Tongyong, Wade-Giles, MPS2, Yale or Gwoyeu Romatzyh, and turn tone-number text into tone marks.

The plugin is a separately installed APK running in its own process; AutoJs6 discovers it automatically through the plugin mechanism and communicates with it via AIDL. Conversion is powered by the classic Java library [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`). The measured release is only 376 KiB, and all conversion happens locally on the device with no network access. Since AutoJs6 v6.8.0, the host's `pinyin4j` module is implemented by this plugin.

This plugin and [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) are sister plugins: this one offers simple and reliable per-character transcription at a tiny size, while the Pinyin plugin ships full dictionaries and Jieba segmentation, supporting heteronym disambiguation and a surname mode for accuracy-focused scenarios. Both can be installed side by side; see `Sister Plugin Comparison` below.

******

### Features

******

- Works out of the box: automatically discovered by AutoJs6 after installation, no host restart needed; scripts use the global object `pinyin4j` directly.
- Extremely lightweight: the measured release is only 376 KiB, pure JVM with no native libraries, compatible with all CPU architectures.
- Three tone formats: no tone, tone numbers (`han4`) and tone marks (`hàn`), selectable as needed.
- Flexible output: configurable letter case, three `ü` representations (`lv` / `lu:` / `lü`) and an arbitrary syllable separator.
- Tone utility: `pinyin4j.as(text)` converts tone-number text into the tone-mark form in one step.
- All readings and six systems: `pinyin4j.readings(text, options)` returns one ordered candidate row per Unicode code point and supports Hanyu, Tongyong, Wade-Giles, MPS2, Yale and Gwoyeu Romatzyh.
- Lenient values: options are case-insensitive and accept several short aliases (such as `tone: "MARK"`); invalid values raise localized error messages.
- Fully offline: conversion relies on bundled data and runs locally on the device, without any network requests.
- Multilingual: plugin info, instructions, README and changelog are available in 10 languages.

******

### Usage

******

1. Upgrade AutoJs6 to internal build 3923 (6.7.1 Alpha4) or later; since v6.8.0 pinyin capabilities are fully delegated to plugins, so the latest version is recommended.
2. Download the plugin APK from the [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) page and install it on the device running AutoJs6, or install it online directly from the AutoJs6 Plugin Center.
3. Open the AutoJs6 Plugin Center, confirm that the `Pinyin4j` plugin is recognized, then grant authorization and make sure it is enabled.
4. Call the `pinyin4j` global object directly in scripts, following the `Quick Start` examples below; you may also run the `Quick Self-Check` first to confirm the plugin is active.

> The plugin ships as a single universal package (pure JVM, no CPU architecture variants) and supports devices running Android 7.0 (API 24) or later. It has no standalone UI and creates no launcher icon; AutoJs6 discovers and manages it centrally.

******

### Quick Start

******

Basic conversion: lowercase pinyin without tones by default; the second argument may simply be a separator:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

Tone numbers and `ü` representations:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

Tone utility: convert tone-number text into tone marks:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

All candidate readings and alternative romanization systems:

```javascript
console.log(pinyin4j.readings("重A𠀀"));
// [["zhong4", "chong2"], ["A"], ["𠀀"]]

console.log(pinyin4j.readings("间", { system: "WADE_GILES" }));
// [["chien1", "chien4"]]
```

******

### Options

******

`pinyin4j.of(text, options)` supports the following options (short alias keys in parentheses):

| Option | Default | Description |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | Output letter case: `LOWERCASE` or `UPPERCASE` |
| `toneType` (`tone`) | `WITHOUT_TONE` | Tone format: `WITHOUT_TONE` for none, `WITH_TONE_NUMBER` for tone numbers, `WITH_TONE_MARK` for tone marks |
| `vCharType` (`v`, `vChar`) | `WITH_V` | How `ü` is written: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); defaults to `WITH_U_UNICODE` when the tone-mark format is used |
| `separator` (`sep`) | `""` | Separator between syllables, any string; a trailing separator at the end of the output is removed |

Values are case-insensitive and accept short aliases, such as `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"`. Passing an invalid value throws an exception with a localized message.

******

### Scripting API

******

The `pinyin4j` global object provides the following methods (calling `pinyin4j(text, options)` directly is equivalent to `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
pinyin4j.readings(text, options?) -> string[][]
```

- `of` iterates Unicode code points and queries the pinned pinyin4j 2.5.1 dictionary directly: all 20,378 mapped BMP characters (including `〇`) convert, while unmapped and supplementary-plane code points remain intact. It still chooses only the first pronunciation, with no contextual disambiguation.
- `readings` returns an ordered `string[][]` aligned one row per Unicode code point. Hanyu defaults to lowercase numeric tones and supports the existing case/tone/v options; `romanization` (or `system`) selects Hanyu, Tongyong, Wade-Giles, MPS2, Yale or Gwoyeu Romatzyh. Non-Hanyu systems reject explicit Hanyu-only formatting options, and separators do not apply to matrices.
- AutoJs6 negotiates `pinyin4j.readings.version = 1`: older plugins safely produce single-candidate Hanyu rows, while non-Hanyu requests require the new plugin. Node.js can call the same provider asynchronously through `autojs6:bridge.callAutoJs` with the explicit `pinyin4j` capability.
- The second argument of `of` can be either an options object or a plain string used as the separator.
- `as` converts only complete recognized syllables with tone digits `0`-`4`, preserves input case, and accepts `v`, `u:`, or `ü`; invalid syllables, tone digit `5`, and fragments adjacent to letters or digits remain unchanged. This method corresponds to `asTone` in the plugin's AIDL interface.
- Option values are case-insensitive and accept several short aliases (see `Options` above); invalid values throw an exception with a localized message.
- All methods return synchronously; the first conversion lazily loads the pinyin4j dictionary and is therefore slower than steady-state calls, as documented in the conversion benchmark.

******

### Quick Self-Check

******

After installing and enabling the plugin, run this one-liner:

```javascript
console.log(pinyin4j.of("拼音"));
```

If it prints `pinyin`, the plugin is working properly.

******

### FAQ

******

#### How do I confirm the plugin is active?

Open the AutoJs6 Plugin Center; if the `Pinyin4j` plugin is listed and enabled, the host has recognized it. Then run the `Quick Self-Check` script above; printing `pinyin` means it works.

#### Scripts report a missing plugin or say `pinyin4j` is unavailable?

Make sure the AutoJs6 internal build is at least 3923, and that the plugin is installed, authorized and enabled in the Plugin Center. Since AutoJs6 v6.8.0 the host no longer bundles the pinyin4j library; this plugin provides the capability entirely.

#### Why is there no plugin icon in the app list or on the home screen?

This is expected. The plugin has no standalone UI and creates no launcher icon; after installation AutoJs6 discovers and invokes it in the background, and all interaction happens inside AutoJs6.

#### Heteronym pronunciations look wrong (e.g. "重庆" is not read as chongqing)?

`pinyin4j.of` converts character by character and still takes the first dictionary pronunciation. Use `pinyin4j.readings` to retrieve all dictionary candidates for each character, but note that it does not use phrase context to choose among them. For contextual disambiguation, phrase dictionaries or surname readings, use the sister plugin [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### Why does `pinyin4j.asTone(text)` from older docs or scripts not work?

On the host side the method is named `pinyin4j.as(text)`; `asTone` is the method name in the plugin's AIDL interface, and both behave identically. Use `pinyin4j.as(text)` in scripts.

#### Does the plugin access the network or request sensitive permissions?

No. Conversion data is bundled in the package and conversion happens locally on the device. The manifest only declares the plugin permission needed to communicate with AutoJs6, without requesting network, storage or any other sensitive system permission.

#### How do I choose between this plugin and the sister plugin Pinyin?

Choose this plugin when lightweight per-character transcription or a full candidate list is enough and package size matters; choose [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) when you need contextual heteronym disambiguation, segmentation, phrase dictionaries or surname readings. They do not conflict and can be installed together; see `Sister Plugin Comparison` below.

******

### Permissions & Security

******

The plugin is designed to keep its data and permission surface as small as possible:

- Minimal permissions: the manifest only declares the AutoJs6 plugin permission (`org.autojs.permission.PLUGIN`), without requesting network, storage, camera or any other sensitive system permission.
- Local conversion: text to convert only travels within the device via Binder; conversion data is fully bundled, everything is offline and no data leaves the device.
- Signature and authorization: AutoJs6 verifies the plugin signature, and the plugin must be authorized and enabled in the Plugin Center before scripts can call it; the service and wake entry are both protected by the plugin permission, so third-party apps cannot invoke them directly.
- Open and auditable: the plugin code and its documentation pipeline are fully open source, and conversion is powered by the widely used open-source library pinyin4j.

Only obtain plugin packages from the official [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) page or the AutoJs6 Plugin Center; a package from an unknown source may be tampered with even if its name and version look identical.

******

### Sister Plugin Comparison

******

AutoJs6 offers two official pinyin plugins with different focuses; they can be installed side by side:

| Aspect | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| Underlying implementation | Classic Java library `pinyin4j` | Bundled dictionaries + Jieba segmentation |
| Global object | `pinyin4j` | `pinyin` |
| Heteronyms | All candidates via `readings`; no contextual disambiguation | Supported, can return all candidates |
| Segmentation & phrases | Not supported, per-character conversion | Supported (phrase dictionary + Jieba) |
| Surname mode | Not supported | Supported |
| Output form | Formatted string or Unicode-aligned candidate matrix | 2D candidate array (combinable via `compact()`) or compact string |
| Styles & formats | 6 romanization systems; Hanyu has 3 tone formats + case + `ü` forms | 6 pinyin styles |
| Package size | 376 KiB ([measured release baseline](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/apk-size-baseline-2026-09-01.md)) | 5.95 MiB ([measured full release](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md), bundled dictionaries) |
| Performance profile | Lightweight character path; [measured JVM/Android baseline](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/conversion-baseline-2026-09-01.md) | [Measured segmenter run](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md); heavier dictionary, segmentation, and heteronym path, varying by mode |
| Best for | Size and simplicity first: quick per-character transcription | Accuracy first: heteronyms, phrases, person names |

The two plugins are independent and never conflict; with both installed, scripts may call `pinyin4j` and `pinyin` separately as needed. See [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) for details on the Pinyin plugin.

******

### Plugin Interface

******

The following information targets AutoJs6 host and plugin developers; the host uses these identifiers to discover the plugin and negotiate capabilities:

```text
application id: io.github.supermonster003.autojs6.plugin.pinyin4j
plugin id: pinyin4j
engine: pinyin4j
variant: default
discovery action: org.autojs.plugin.PINYIN4J
discovery category: pinyin4j
wake action: org.autojs.plugin.action.WAKE
binder interface: IPinyin4jPlugin
binder methods: getInfo / of / asTone / readings
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

`Pinyin4jPluginService` responds to the `org.autojs.plugin.PINYIN4J` action (category `pinyin4j`) and exposes 4 methods through `IPinyin4jPlugin`. `readings` is appended to preserve transaction order, returns a strictly bounded JSON matrix, and is advertised by integer capability `pinyin4j.readings.version = 1`; old hosts continue using `of` and `asTone`. Invalid options throw `IllegalArgumentException`. The service and `WakeActivity` are protected by `org.autojs.permission.PLUGIN`, so third-party apps cannot invoke them directly.

******

### Roadmap

******

ROADMAP.md tracks evidence by milestone. M3 is complete in v1.3.0: Unicode and tone boundaries, all-reading matrices, six romanization systems, append-only AIDL capability negotiation, Rhino and Node.js host routes, and old-plugin Hanyu fallback are implemented and tested. M4 dependency-risk, performance, size, and selection baselines remain complete.

- [View ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### Release History

******

#### v1.3.2

_2026/09/15_

- `Improvement` Raise compileSdk and targetSdk to 37 (Android 17); the plugin's behavior does not depend on the new target

#### v1.3.1

_2026/09/13_

- `Fix` Keep the plugin version date in English regardless of the build machine locale
- `Improvement` Consistent localized resources, explicit plugin activation and validated release preparation

#### v1.3.0

_2026/09/11_

- `Hint` `pinyin4j.readings()` and the Node.js provider require an updated AutoJs6 host containing the readings v1 contract; older hosts can continue using `of` and `as`
- `Feature` `pinyin4j.readings(text, options)` returns every ordered dictionary pronunciation in one row per Unicode code point, with unmapped input preserved as a single candidate
- `Feature` `romanization` / `system` exposes Hanyu, Tongyong, Wade-Giles, MPS2, Yale and Gwoyeu Romatzyh; Hanyu supports numeric, marked or omitted tones, letter case and `ü` forms
- `Improvement` Appended the Binder `readings` transaction and integer capability `pinyin4j.readings.version = 1`; new hosts call it only after negotiation and safely fall back to one Hanyu candidate per code point for old plugins
- `Improvement` Added strict source, matrix and UTF-8 JSON limits plus Android 9/12/13/15 Binder coverage; the same plugin capability is available to Node.js through the host's explicit `pinyin4j` capability
- `Improvement` Build verification rejects accidental native dependencies and produces a JSON report

##### For more release history, refer to

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-en.md)

******

### Build

******

This section targets developers who want to build the plugin from source.

Build a debug APK:

```powershell
.\gradlew.bat :app:assembleDebug
```

Build a release APK (single universal package; signed automatically once signing is configured in the untracked `sign.properties`):

```powershell
.\gradlew.bat :app:assembleRelease
```

For a verified release archive, run `py .python/prepare_release.py`. It checks generated docs, builds and verifies the signed universal APK, validates version metadata, calculates CRC32 and SHA-256, and atomically writes the APK, `SHA256SUMS.txt` and English `RELEASE_NOTES.md` under `app/releases/v<version>`.

Build parameters are centralized in `version.properties`: minimum SDK 24 (Android 7.0), target SDK 37, current version 1.3.2.

******

### Localization & Docs Generation

******

```text
.readme/common.json
.readme/lang_*.json
.readme/template_readme.md
.readme/template_plugin_instruction.md
.changelog/lang_*.json
.changelog/template_changelog.md
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` provides localized plugin descriptions and error messages, and `plugin_instruction.md` provides the usage instructions shown in the host Plugin Center. The README, changelog and instructions are all generated from JSON sources: after editing sources under `.readme/` and `.changelog/`, run `py .python/generate_markdown.py` to regenerate all artifacts; generated artifacts are never edited by hand. Run `py .python/generate_markdown.py --check` to verify that sources and artifacts are in sync.

******

### License

******

The project code is licensed under [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). Pinyin conversion is powered by the [pinyin4j](https://github.com/belerweb/pinyin4j) library (`com.belerweb:pinyin4j:2.5.1`).

******

### Links

******

- AutoJs6 Pinyin4j documentation: https://docs.autojs6.com/#/pinyin4j
- AutoJs6 project: https://github.com/SuperMonster003/AutoJs6
- Sister plugin Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- pinyin4j project: https://github.com/belerweb/pinyin4j
- pinyin4j Maven coordinates: https://mvnrepository.com/artifact/com.belerweb/pinyin4j


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/16kb.md)

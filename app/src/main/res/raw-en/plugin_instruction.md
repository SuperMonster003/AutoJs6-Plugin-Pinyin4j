The Pinyin4j Plugin brings lightweight Chinese-to-Hanyu-Pinyin conversion to AutoJs6. Once installed, scripts can use the global object `pinyin4j` to convert Chinese text to pinyin character by character, with configurable letter case, tone format, `ü` representation and syllable separator; a utility method for turning tone-number text into tone marks is also included.

### Quick Start

Basic conversion: lowercase pinyin without tones by default; the second argument may simply be a separator:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### Options

`pinyin4j.of(text, options)` supports the following options (short alias keys in parentheses):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

Values are case-insensitive and accept short aliases, such as `tone: "MARK"` / `"NUMBER"` / `"NO"`; a plain string as the second argument is treated as the separator.

### Quick Self-Check

After installing and enabling the plugin, run this one-liner:

```javascript
console.log(pinyin4j.of("拼音"));
```

If it prints `pinyin`, the plugin is working properly.

For more usage and option details, see the [AutoJs6 Pinyin4j documentation](https://docs.autojs6.com/#/pinyin4j) and the [project homepage](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

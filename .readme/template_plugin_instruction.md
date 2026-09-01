{{ p_introduction_what }}

### {{ h3_quick_start }}

{{ p_quick_start_basic }}:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### {{ h3_options }}

{{ p_options_intro }}:

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

{{ p_instruction_options }}

### {{ h3_self_check }}

{{ p_self_check_intro }}:

```javascript
console.log(pinyin4j.of("拼音"));
```

{{ p_self_check_result }}

{{ p_instruction_docs }}

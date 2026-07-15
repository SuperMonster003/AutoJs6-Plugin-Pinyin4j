Use Pinyin4j to convert Chinese text to Hanyu Pinyin:

```js
let text = "汉字转拼音";
console.log(pinyin4j.of(text));
console.log(pinyin4j.of(text, {
    toneType: "WITH_TONE_MARK",
    vCharType: "WITH_U_UNICODE",
    separator: " ",
}));
console.log(pinyin4j.asTone("han4 zi4 zhuan3 pin1 yin1"));
```

Options use the keys `caseType`, `toneType`, `vCharType`, and `separator`.

Common values:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

For more usage examples, refer to the [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) section in the AutoJs6 documentation.

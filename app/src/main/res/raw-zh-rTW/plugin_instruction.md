使用 Pinyin4j 將中文文字轉換為漢語拼音:

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

選項使用 `caseType`, `toneType`, `vCharType` 和 `separator` 作為鍵.

常用值:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

更多用法範例可參閱 AutoJs6 文件中的 [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) 部分.

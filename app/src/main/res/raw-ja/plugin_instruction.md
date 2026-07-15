Pinyin4j を使用して中国語テキストを漢語ピンインに変換します:

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

オプションは `caseType`, `toneType`, `vCharType`, `separator` をキーとして使用します.

よく使う値:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

その他の使用例は AutoJs6 ドキュメントの [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) セクションを参照してください.

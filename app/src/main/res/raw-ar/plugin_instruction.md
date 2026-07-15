استخدم Pinyin4j لتحويل النص الصيني إلى بينيين Hanyu:

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

تستخدم الخيارات المفاتيح `caseType`, و `toneType`, و `vCharType`, و `separator`.

القيم الشائعة:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

لمزيد من أمثلة الاستخدام, راجع قسم [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) في وثائق AutoJs6.

Используйте Pinyin4j для преобразования китайского текста в пиньинь Hanyu:

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

Параметры используют ключи `caseType`, `toneType`, `vCharType`, и `separator`.

Распространенные значения:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

Дополнительные примеры использования см. в разделе [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) документации AutoJs6.

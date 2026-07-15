Use Pinyin4j para convertir texto chino a pinyin Hanyu:

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

Las opciones usan las claves `caseType`, `toneType`, `vCharType`, y `separator`.

Valores comunes:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

Para mas ejemplos de uso, consulte la seccion [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) en la documentacion de AutoJs6.

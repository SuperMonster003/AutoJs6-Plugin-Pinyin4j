Utilisez Pinyin4j pour convertir le texte chinois en pinyin Hanyu:

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

Les options utilisent les cles `caseType`, `toneType`, `vCharType`, et `separator`.

Valeurs courantes:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

Pour plus d exemples d utilisation, consultez la section [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) dans la documentation AutoJs6.

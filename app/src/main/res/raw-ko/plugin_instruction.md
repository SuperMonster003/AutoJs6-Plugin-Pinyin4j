Pinyin4j를 사용해 중국어 텍스트를 한어 병음으로 변환합니다:

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

옵션은 `caseType`, `toneType`, `vCharType`, `separator` 키를 사용합니다.

일반적인 값:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
```

더 많은 사용 예시는 AutoJs6 문서의 [Pinyin4j](https://docs.autojs6.com/#/pinyin4j) 섹션을 참조하십시오.

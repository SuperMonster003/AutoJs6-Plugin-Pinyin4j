Pinyin4j 플러그인은 AutoJs6 에 경량 글자 단위 로마자 변환을 제공합니다. 스크립트는 형식화된 Hanyu Pinyin 문자열을 만들고, Unicode code point 별로 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 또는 Gwoyeu Romatzyh 의 모든 사전 발음을 행렬로 조회하며, 숫자 성조를 성조 기호로 변환할 수 있습니다.

### 빠른 시작

기본 변환: 기본적으로 소문자 무성조 병음을 출력하며, 두 번째 인수로 구분자를 바로 전달할 수 있습니다:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### 옵션

`pinyin4j.of(text, options)` 는 다음 옵션을 지원합니다 (괄호 안은 사용 가능한 축약 키 이름):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

값은 대소문자를 구분하지 않으며 `tone: "MARK"` / `"NUMBER"` / `"NO"` 같은 축약 별칭을 지원합니다. 두 번째 인수로 문자열을 바로 전달하면 구분자로 간주됩니다.

### 빠른 자가 점검

플러그인을 설치하고 활성화한 뒤 다음 한 줄 스크립트를 실행합니다:

```javascript
console.log(pinyin4j.of("拼音"));
```

`pinyin` 이 출력되면 플러그인이 정상적으로 동작하는 것입니다.

더 자세한 사용법과 옵션 설명은 [AutoJs6 Pinyin4j 문서](https://docs.autojs6.com/#/pinyin4j) 와 [프로젝트 홈페이지](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) 를 참고하세요.

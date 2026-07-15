<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>중국어를 한어 병음으로 변환하는 Pinyin4j 플러그인</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Pinyin4j?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/commit/f8ef60df665f9475af38cca0f7f4a083956d4839"><img alt="Created" src="https://img.shields.io/date/1783216223?color=2e7d32&label=Created"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 언어 (Languages)

******

현재 README.md는 다음 언어를 지원합니다:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- 한국어 [ko] # 현재
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### 소개

******

AutoJs6 Pinyin4j 플러그인은 AutoJs6에 Pinyin4j 기반 중국어에서 한어 병음으로 변환하는 기능을 제공합니다. 성조 없음, 숫자 성조, 성조 기호 출력을 지원합니다.

******

### 기능

******

- 플러그인 ID가 `pinyin4j`인 `pinyin4j` 플러그인 서비스를 제공합니다.
- `pinyin4j.of(text, options)` 및 `pinyin4j.asTone(text)` 같은 AutoJs6 API를 지원합니다.
- 병음 대소문자, 성조 유형, `ü` 표기 방식, 구분자를 설정할 수 있습니다.
- 플러그인 메타데이터, 사용 설명, README, CHANGELOG는 스페인어/프랑스어/러시아어/아랍어/일본어/한국어/영어/간체 중국어/홍콩 번체/대만 번체로 현지화되어 있습니다.
- `com.belerweb:pinyin4j`를 기반으로 합니다.

******

### 사용 예시

******

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

******

### 옵션

******

일반적인 옵션은 다음과 같습니다:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator: any string
```

`pinyin4j.asTone(text)`는 숫자 성조 병음을 성조 기호 병음으로 변환합니다.

******

### 릴리스 기록

******

# v1.0.0

###### 2026/07/15

* `추가` 플러그인 ID `pinyin4j`, 엔진 `pinyin4j`의 Pinyin4j 플러그인 서비스를 추가, `com.belerweb:pinyin4j` 기반으로 빌드
* `추가` `org.autojs.plugin.PINYIN4J`를 통한 호스트 검색 및 호출을 추가
* `추가` `pinyin4j.of(text, options)`로 중국어 텍스트를 한어 병음으로 변환하도록 지원, 대소문자 유형, 성조 유형, `ü` 표기 방식, 구분자를 설정 가능
* `추가` `pinyin4j.asTone(text)`로 숫자 성조 병음을 성조 기호 병음으로 변환하도록 지원
* `추가` 스페인어/프랑스어/러시아어/아랍어/일본어/한국어/영어/간체 중국어/홍콩 번체/대만 번체 플러그인 메타데이터와 사용 설명을 추가
* `추가` `.python/generate_markdown.py`를 통한 JSON 기반 README 및 CHANGELOG 생성을 추가

##### 더 많은 릴리스 기록

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.changelog/CHANGELOG-ko.md)

******

### 빌드

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release 빌드:

```powershell
.\gradlew.bat :app:assembleRelease
```

빌드 매개변수는 `version.properties`에서 가져옵니다. 현재 최소 SDK는 24이고 대상 SDK는 36입니다.

******

### 리소스 구조

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml`에는 현지화된 플러그인 설명과 오류 메시지가 포함됩니다. `plugin_instruction.md`에는 호스트에서 표시하는 사용 설명이 포함됩니다. README와 CHANGELOG는 `.python/generate_markdown.py`가 JSON 소스에서 생성합니다.

******

### 링크

******

- AutoJs6 Pinyin4j 문서: https://docs.autojs6.com/#/pinyin4j
- Pinyin4j 프로젝트: https://github.com/belerweb/pinyin4j
- Pinyin4j Maven 좌표: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

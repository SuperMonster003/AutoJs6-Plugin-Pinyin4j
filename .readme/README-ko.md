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
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 언어 (Languages)

******

현재 README.md 는 다음 언어를 지원합니다:

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

Pinyin4j 플러그인은 AutoJs6 에 경량 글자 단위 로마자 변환을 제공합니다. 스크립트는 형식화된 Hanyu Pinyin 문자열을 만들고, Unicode code point 별로 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 또는 Gwoyeu Romatzyh 의 모든 사전 발음을 행렬로 조회하며, 숫자 성조를 성조 기호로 변환할 수 있습니다.

플러그인은 독립적으로 설치되는 APK 로 자체 프로세스에서 실행되며, AutoJs6 이 플러그인 메커니즘으로 자동 발견하고 AIDL 로 통신합니다. 변환 능력은 고전적인 Java 라이브러리 [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`) 에서 나오며, release 실측은 376 KiB 에 불과하고 변환은 전부 기기 로컬에서 이루어져 네트워크가 필요 없습니다. AutoJs6 v6.8.0 부터 호스트의 `pinyin4j` 모듈은 본 플러그인이 구현을 제공합니다.

본 플러그인과 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 은 서로 자매 플러그인입니다: 본 플러그인은 아주 작은 크기로 간단하고 신뢰할 수 있는 글자 단위 병음 표기를 제공하고, Pinyin 플러그인은 완전한 사전과 Jieba 분절을 내장하여 다음자 중의성 해소와 성씨 모드를 지원하므로 발음 정확성을 중시하는 상황에 적합합니다. 둘은 동시에 설치할 수 있으며, 자세한 내용은 아래 `자매 플러그인 비교` 를 참고하세요.

******

### 기능 하이라이트

******

- 즉시 사용 가능: 설치 후 AutoJs6 이 자동으로 발견하며, 호스트를 재시작할 필요 없이 스크립트에서 전역 객체 `pinyin4j` 를 바로 사용합니다.
- 극도로 가벼움: release 실측은 376 KiB 에 불과하며, 순수 JVM 구현으로 네이티브 라이브러리를 전혀 포함하지 않아 모든 CPU 아키텍처에 대응합니다.
- 세 가지 성조 형식: 성조 없음, 숫자 성조 (`han4`), 성조 기호 (`hàn`) 를 필요에 따라 선택할 수 있습니다.
- 유연한 출력: 대소문자, `ü` 의 세 가지 표기 방식 (`lv` / `lu:` / `lü`), 임의의 음절 구분자를 설정할 수 있습니다.
- 성조 유틸리티: `pinyin4j.as(text)` 가 숫자 성조 텍스트를 한 번에 성조 기호 형태로 변환합니다.
- 전체 발음과 6개 체계: `pinyin4j.readings(text, options)` 는 Unicode code point 마다 정렬된 후보 행을 반환하고 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 및 Gwoyeu Romatzyh 를 지원합니다.
- 관대한 값 처리: 옵션은 대소문자를 구분하지 않고 여러 축약 별칭 (예: `tone: "MARK"`) 을 지원하며, 잘못된 값에는 현지화된 오류 메시지를 제공합니다.
- 완전 오프라인: 변환은 내장 데이터를 기반으로 기기 로컬에서 이루어지며, 어떤 네트워크 요청도 보내지 않습니다.
- 다국어: 플러그인 정보, 사용 설명, README, 변경 로그가 10 개 언어로 제공됩니다.

******

### 사용 방법

******

1. AutoJs6 을 내부 빌드 3923 (6.7.1 Alpha4) 이상으로 업그레이드합니다. v6.8.0 부터 병음 기능은 완전히 플러그인이 담당하므로 최신 버전 사용을 권장합니다.
2. [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 페이지에서 플러그인 APK 를 내려받아 AutoJs6 이 실행되는 기기에 설치하거나, AutoJs6 의 플러그인 센터에서 바로 온라인으로 설치합니다.
3. AutoJs6 의 플러그인 센터를 열어 `Pinyin4j` 플러그인이 인식되었는지 확인하고, 권한 부여를 마친 뒤 활성화 상태로 둡니다.
4. 스크립트에서 `pinyin4j` 전역 객체를 직접 호출합니다. 아래 `빠른 시작` 예시를 참고하세요. 먼저 `빠른 자가 점검` 을 실행해 플러그인이 동작하는지 확인할 수도 있습니다.

> 플러그인은 범용 설치 패키지 하나만 제공하며 (순수 JVM 구현으로 CPU 아키텍처를 구분하지 않습니다), Android 7.0 (API 24) 이상 기기를 지원합니다. 플러그인은 독립된 화면이 없고 설치 후 홈 화면에 아이콘을 만들지 않으며, AutoJs6 이 일괄적으로 발견하고 관리합니다.

******

### 빠른 시작

******

기본 변환: 기본적으로 소문자 무성조 병음을 출력하며, 두 번째 인수로 구분자를 바로 전달할 수 있습니다:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

숫자 성조와 `ü` 표기 방식:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

성조 유틸리티: 숫자 성조 텍스트를 성조 기호로 변환:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

모든 후보 발음과 다른 로마자 체계:

```javascript
console.log(pinyin4j.readings("重A𠀀"));
// [["zhong4", "chong2"], ["A"], ["𠀀"]]

console.log(pinyin4j.readings("间", { system: "WADE_GILES" }));
// [["chien1", "chien4"]]
```

******

### 옵션

******

`pinyin4j.of(text, options)` 는 다음 옵션을 지원합니다 (괄호 안은 사용 가능한 축약 키 이름):

| 옵션 | 기본값 | 설명 |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | 출력 대소문자: `LOWERCASE` 는 소문자, `UPPERCASE` 는 대문자 |
| `toneType` (`tone`) | `WITHOUT_TONE` | 성조 형식: `WITHOUT_TONE` 은 성조 없음, `WITH_TONE_NUMBER` 는 숫자 성조, `WITH_TONE_MARK` 는 성조 기호 |
| `vCharType` (`v`, `vChar`) | `WITH_V` | `ü` 표기 방식: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); 성조 기호 형식에서는 기본값이 `WITH_U_UNICODE` 로 전환됩니다 |
| `separator` (`sep`) | `""` | 음절 사이의 구분자로 임의의 문자열 사용 가능; 출력 끝의 구분자는 제거됩니다 |

값은 대소문자를 구분하지 않으며 `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"` 같은 축약 별칭을 지원합니다. 잘못된 값을 전달하면 현지화된 문구가 포함된 예외가 발생합니다.

******

### 스크립트 API

******

`pinyin4j` 전역 객체는 다음 메서드를 제공합니다 (`pinyin4j(text, options)` 를 직접 호출하는 것은 `pinyin4j.of` 와 동일합니다):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
pinyin4j.readings(text, options?) -> string[][]
```

- `of` 는 Unicode code point 단위로 고정된 pinyin4j 2.5.1 사전을 직접 조회합니다. 실제로 수록된 BMP 문자 20,378개 (`〇` 포함) 를 변환하고, 미수록 문자와 보충 평면 code point 는 온전히 보존합니다. 여전히 첫 번째 발음만 선택하며 문맥 중의성 해소는 하지 않습니다.
- `readings` 는 Unicode code point 마다 한 행이 대응하는 정렬된 `string[][]` 를 반환합니다. Hanyu 는 소문자 숫자 성조가 기본이며 기존 case/tone/v 옵션을 지원하고, `romanization` (또는 `system`) 으로 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 또는 Gwoyeu Romatzyh 를 선택합니다. 비 Hanyu 체계는 Hanyu 전용 형식 옵션을 거부하며 행렬에는 구분자가 적용되지 않습니다.
- AutoJs6 는 `pinyin4j.readings.version = 1` 을 협상합니다. 이전 플러그인은 Hanyu 단일 후보 행으로 안전하게 대체되고 다른 체계는 새 플러그인이 필요합니다. Node.js 는 명시적 `pinyin4j` capability 가 있는 `autojs6:bridge.callAutoJs` 를 통해 동일한 provider 를 비동기로 호출할 수 있습니다.
- `of` 의 두 번째 인수는 옵션 객체일 수도 있고, 구분자로 쓸 문자열을 바로 전달할 수도 있습니다.
- `as` 는 경계가 완전하고 사전에서 인식되는 `0`-`4` 숫자 성조 음절만 변환하며, 입력 대소문자를 유지하면서 `v` / `u:` / `ü` 를 처리합니다. 잘못된 음절, 숫자 `5`, 영숫자에 붙은 조각은 그대로 유지됩니다. 이 메서드는 플러그인 AIDL 인터페이스의 `asTone` 에 대응합니다.
- 옵션 값은 대소문자를 구분하지 않고 여러 축약형을 지원하며 (위 `옵션` 참고), 잘못된 값은 현지화된 문구가 포함된 예외를 발생시킵니다.
- 모든 메서드는 동기적으로 반환합니다. 첫 변환은 pinyin4j 사전을 지연 로딩하므로 안정 상태 호출보다 느리며, 실측값은 변환 벤치마크에 기록되어 있습니다.

******

### 빠른 자가 점검

******

플러그인을 설치하고 활성화한 뒤 다음 한 줄 스크립트를 실행합니다:

```javascript
console.log(pinyin4j.of("拼音"));
```

`pinyin` 이 출력되면 플러그인이 정상적으로 동작하는 것입니다.

******

### 자주 묻는 질문

******

#### 플러그인이 정상 동작하는지 어떻게 확인하나요?

AutoJs6 의 플러그인 센터를 열어 `Pinyin4j` 플러그인이 보이고 활성화 상태이면 호스트가 인식한 것입니다. 이어서 위의 `빠른 자가 점검` 스크립트를 실행해 `pinyin` 이 출력되면 정상 동작하는 것입니다.

#### 스크립트에서 플러그인이 없다거나 `pinyin4j` 를 사용할 수 없다는 오류가 발생합니다?

AutoJs6 내부 빌드가 3923 이상인지, 그리고 플러그인 센터에서 플러그인의 설치, 권한 부여, 활성화가 완료되었는지 확인하세요. AutoJs6 v6.8.0 부터 호스트는 더 이상 pinyin4j 라이브러리를 내장하지 않으며, 관련 기능은 전적으로 본 플러그인이 담당합니다.

#### 앱 목록과 홈 화면에 플러그인 아이콘이 없는 이유는 무엇인가요?

정상입니다. 플러그인은 독립된 화면이 없고 홈 화면에 실행 아이콘도 만들지 않습니다. 설치 후 AutoJs6 이 백그라운드에서 자동으로 발견하고 호출하며, 모든 상호작용은 AutoJs6 안에서 이루어집니다.

#### 다음자 발음이 기대와 다릅니다 (예: "重庆" 이 chongqing 으로 읽히지 않음)?

`pinyin4j.of` 는 계속 각 글자의 첫 번째 사전 발음을 사용합니다. `pinyin4j.readings` 로 각 글자의 모든 사전 후보를 얻을 수 있지만 단어 문맥으로 자동 선택하지는 않습니다. 문맥 중의성 해소, 단어 사전 또는 성씨 발음이 필요하면 자매 플러그인 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 을 사용하세요.

#### 문서나 옛 스크립트의 `pinyin4j.asTone(text)` 는 왜 사용할 수 없나요?

호스트 쪽에서 이 메서드의 이름은 `pinyin4j.as(text)` 입니다. `asTone` 은 플러그인 AIDL 인터페이스의 메서드 이름이며 둘의 동작은 같습니다. 스크립트에서는 `pinyin4j.as(text)` 를 사용하세요.

#### 플러그인이 네트워크에 접속하거나 민감한 권한을 요청하나요?

아니요. 변환 데이터는 설치 패키지에 내장되어 있고 변환은 기기 로컬에서 이루어집니다. 플러그인 매니페스트는 AutoJs6 과 통신하는 데 필요한 플러그인 권한만 선언하며, 네트워크, 저장소 등 어떤 민감한 시스템 권한도 요청하지 않습니다.

#### 자매 플러그인 Pinyin 과는 어떻게 선택하나요?

가벼운 글자 단위 병음 표기나 전체 후보 목록이면 충분하고 설치 패키지 크기가 중요하다면 본 플러그인을, 다음자의 문맥 중의성 해소, 분절, 단어 사전, 성씨 발음이 필요하다면 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 을 선택하세요. 둘은 서로 충돌하지 않아 동시에 설치할 수 있으며, 자세한 내용은 아래 `자매 플러그인 비교` 를 참고하세요.

******

### 권한과 보안

******

플러그인은 설계상 데이터 표면과 권한 표면을 최대한 좁힙니다:

- 최소 권한: 플러그인 매니페스트는 AutoJs6 플러그인 권한 (`org.autojs.permission.PLUGIN`) 만 선언하며, 네트워크, 저장소, 카메라 등 어떤 민감한 시스템 권한도 요청하지 않습니다.
- 로컬 변환: 변환할 텍스트는 Binder 를 통해 기기 안에서만 전달되고, 변환 데이터는 전부 내장되어 전 과정이 오프라인이며 데이터가 기기를 벗어나지 않습니다.
- 서명과 권한 부여: AutoJs6 은 플러그인 서명을 검증하며, 플러그인은 플러그인 센터에서 권한 부여와 활성화를 마친 뒤에야 스크립트에서 호출될 수 있습니다. 서비스와 웨이크 진입점은 모두 플러그인 권한으로 보호되어 서드파티 앱이 직접 호출할 수 없습니다.
- 공개적이고 감사 가능: 플러그인 코드와 문서 생성 파이프라인이 모두 오픈 소스이며, 변환 능력은 널리 쓰이는 오픈 소스 라이브러리 pinyin4j 에서 나옵니다.

플러그인 설치 패키지는 공식 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 페이지나 AutoJs6 플러그인 센터에서만 받으세요. 출처가 불분명한 패키지는 이름과 버전이 같아 보여도 변조되었을 수 있습니다.

******

### 자매 플러그인 비교

******

AutoJs6 은 공식적으로 두 가지 병음 플러그인을 제공하며, 각기 중점이 다르고 동시에 설치할 수 있습니다:

| 비교 항목 | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| 기반 구현 | 고전적인 Java 라이브러리 `pinyin4j` | 내장 사전 + Jieba 분절 |
| 전역 객체 | `pinyin4j` | `pinyin` |
| 다음자 | `readings` 로 모든 후보 제공, 문맥 중의성 해소 없음 | 지원, 모든 후보 반환 가능 |
| 분절과 단어 | 미지원, 글자 단위 변환 | 지원 (단어 사전 + Jieba) |
| 성씨 모드 | 미지원 | 지원 |
| 출력 형태 | 형식화 문자열 또는 Unicode 정렬 후보 행렬 | 2차원 후보 배열 (`compact()` 로 조합 가능) 또는 압축 문자열 |
| 스타일과 형식 | 6개 체계; Hanyu 는 3개 성조 + 대소문자 + `ü` 형식 | 6 가지 병음 스타일 |
| 설치 패키지 크기 | 376 KiB ([release 실측 기준](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/apk-size-baseline-2026-09-01.md)) | 5.95 MiB ([full release 실측](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md), 내장 사전) |
| 성능 특성 | 가벼운 글자 단위 경로; [JVM/Android 실측 기준](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/conversion-baseline-2026-09-01.md) | [분절기 실측](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md); 사전, 분절, 다음자 처리가 더 무거우며 모드에 따라 성능이 달라짐 |
| 적합한 상황 | 크기와 단순함 우선: 빠른 글자 단위 병음 표기 | 발음 정확성 우선: 다음자, 단어, 인명 |

두 플러그인은 서로 의존하지 않고 충돌하지도 않습니다. 동시에 설치하면 스크립트에서 필요에 따라 `pinyin4j` 와 `pinyin` 을 각각 호출할 수 있습니다. Pinyin 플러그인에 대한 자세한 내용은 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 을 참고하세요.

******

### 플러그인 인터페이스

******

다음 정보는 AutoJs6 호스트와 플러그인 개발자를 위한 것으로, 호스트는 이 식별자들로 플러그인을 발견하고 기능을 협상합니다:

```text
application id: io.github.supermonster003.autojs6.plugin.pinyin4j
plugin id: pinyin4j
engine: pinyin4j
variant: default
discovery action: org.autojs.plugin.PINYIN4J
discovery category: pinyin4j
wake action: org.autojs.plugin.action.WAKE
binder interface: IPinyin4jPlugin
binder methods: getInfo / of / asTone / readings
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

`Pinyin4jPluginService` 는 `org.autojs.plugin.PINYIN4J` (category `pinyin4j`) 에 응답하고 `IPinyin4jPlugin` 로 4개 메서드를 노출합니다. `readings` 는 transaction 순서를 유지하도록 끝에 추가되고 엄격히 제한된 JSON 행렬을 반환하며 정수 capability `pinyin4j.readings.version = 1` 로 선언됩니다. 이전 호스트는 `of` 와 `asTone` 을 계속 사용합니다. 잘못된 옵션은 `IllegalArgumentException` 입니다. 서비스와 `WakeActivity` 는 `org.autojs.permission.PLUGIN` 으로 보호됩니다.

******

### 개발 로드맵

******

ROADMAP.md 는 마일스톤별 증거를 기록합니다. M3 는 v1.3.0 에서 완료됐습니다. Unicode/성조 경계, 전체 발음 행렬, 6개 체계, 추가형 AIDL 협상, Rhino/Node.js 경로 및 이전 플러그인 Hanyu 대체가 구현되고 테스트됐습니다. M4 의 의존성 위험, 성능, 크기 및 선택 기준선도 완료 상태입니다.

- [ROADMAP.md 보기](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### 릴리스 기록

******

#### v1.3.0

_2026/09/01_

- `힌트` `pinyin4j.readings()` 와 Node.js provider 는 readings v1 계약이 포함된 최신 AutoJs6 호스트가 필요합니다; 이전 호스트는 계속 `of` 와 `as` 를 사용할 수 있습니다
- `추가` `pinyin4j.readings(text, options)` 는 Unicode code point 마다 모든 사전 발음을 정렬해 반환하고 미수록 입력은 단일 후보로 보존
- `추가` `romanization` / `system` 으로 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 및 Gwoyeu Romatzyh 를 공개; Hanyu 는 숫자/기호/무성조, 대소문자 및 `ü` 형식을 지원
- `개선` Binder 끝에 `readings` transaction 과 정수 capability `pinyin4j.readings.version = 1` 을 추가; 새 호스트는 협상 후에만 호출하고 이전 플러그인은 code point 별 Hanyu 단일 후보로 안전하게 대체
- `개선` 소스, 행렬 및 UTF-8 JSON 의 엄격한 한도와 Android 9/12/13/15 Binder 검증을 추가; 같은 능력을 호스트의 명시적 `pinyin4j` capability 를 통해 Node.js 에 제공

#### v1.2.0

_2026/09/01_

- `힌트` 다중 발음과 6개 로마자 표기 체계는 현재 테스트된 플러그인 코어와 계약 제안으로만 존재합니다. AutoJs6 AIDL 과 호스트 경로가 업그레이드되기 전까지 `pinyin4j.readings()` 는 공개 스크립트 API 가 아닙니다
- `수정` `of` 가 사전의 빈 문자나 보충 평면 문자를 누락 또는 분할하지 않도록 수정했습니다. Unicode code point 단위로 순회하고, `〇` 를 포함한 실제 매핑을 모두 변환하며, 미수록 입력을 온전히 보존하고 구분자를 code point 에 맞춥니다
- `수정` `pinyin4j.as(text)` 는 완전하고 유효한 숫자 성조 음절만 변환하며, 잘못됐거나 영숫자 안에 붙은 조각을 보존합니다. 대소문자와 `v` / `u:` / `ü` 를 처리하고 `jue4` -> `juè` 같은 일반 `ue` 표기도 올바르게 변환합니다
- `개선` BMP 전체 순회 테스트로 사전의 실제 범위를 고정했습니다. 매핑은 20,378개이며 20,377개가 U+4E00-U+9FA5, 나머지는 `〇` 입니다. 이전 범위 안의 525개 빈 항목과 말뭉치 SHA-256 도 회귀 검사합니다
- `개선` Hanyu, Tongyong, Wade-Giles, MPS2, Yale, Gwoyeu Romatzyh 의 모든 후보를 처리하는 테스트된 코어와 추가형 JSON AIDL, 기능 협상, 구 구현 폴백 계약 제안을 추가했습니다
- `개선` pinyin4j 2.5.1 바이너리/소스 해시, 업스트림과 라이선스 메타데이터 조사, 알려진 경계, 업그레이드 또는 fork 게이트를 담은 위험 목록을 추가했습니다
- `개선` 재현 가능한 JVM 및 Android Service/AIDL 진입점 성능 기준, release APK ZIP/리소스 크기 분석기, 실측 기반 자매 플러그인 선택 비교를 추가했습니다

#### v1.1.0

_2026/09/01_

- `수정` 공백이 아닌 구분자가 출력 끝에 남는 문제를 제거하고, 앞뒤 공백을 포함한 비한자 문자를 정확히 보존
- `수정` pinyin4j 2.5.1 이 3성 모음에 사용하는 기존 breve 를 표준 caron 형식으로 통일 (예: `yŭ` 에서 `yǔ`), 대문자와 소문자 모두 지원
- `개선` 옵션 정식 이름과 별칭, 값 축약형, 출력 조합, 기본값, 오류, 성조 변환, 런타임 메타데이터를 다루는 JVM 단위 테스트와 실제 서비스 검색 및 Binder 왕복을 검증하는 Android instrumentation 테스트 추가
- `개선` 생성 문서 불일치를 차단하고 단위 테스트, debug APK 빌드, instrumentation 테스트 컴파일, APK 산출물 업로드를 수행하는 GitHub Actions 워크플로 추가
- `개선` 서명된 universal APK 빌드 및 검증, 버전 확인, CRC32 와 SHA-256 계산, `SHA256SUMS.txt` 와 영문 `RELEASE_NOTES.md` 원자적 생성을 한 번에 수행하는 `.python/prepare_release.py` 추가
- `개선` README 레이아웃과 Gradle 플랫폼 버전 관리 방식을 통일

##### 더 많은 릴리스 기록은 다음을 참고

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-ko.md)

******

### 빌드

******

이 절은 소스에서 플러그인을 빌드하려는 개발자를 위한 것입니다.

debug APK 빌드:

```powershell
.\gradlew.bat :app:assembleDebug
```

release APK 빌드 (단일 범용 패키지; 버전 관리에서 제외된 `sign.properties` 에 서명을 설정하면 자동 서명됩니다):

```powershell
.\gradlew.bat :app:assembleRelease
```

검증된 릴리스 보관 파일을 만들려면 `py .python/prepare_release.py` 를 실행합니다. 생성 문서 검사, 서명된 universal APK 빌드와 검증, 버전 메타데이터 확인, CRC32 와 SHA-256 계산을 수행하고 APK, `SHA256SUMS.txt`, 영문 `RELEASE_NOTES.md` 를 `app/releases/v<버전>` 에 원자적으로 기록합니다.

빌드 매개변수는 `version.properties` 에 집중되어 있습니다: 최소 SDK 24 (Android 7.0), 대상 SDK 36, 현재 버전 1.3.0.

******

### 현지화와 문서 생성

******

```text
.readme/common.json
.readme/lang_*.json
.readme/template_readme.md
.readme/template_plugin_instruction.md
.changelog/lang_*.json
.changelog/template_changelog.md
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG-*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` 은 현지화된 플러그인 설명과 오류 메시지를, `plugin_instruction.md` 는 호스트 플러그인 센터에 표시되는 사용 설명을 제공합니다. README, 변경 로그, 사용 설명은 모두 JSON 소스에서 생성됩니다: `.readme/` 와 `.changelog/` 아래의 소스 파일을 수정한 뒤 `py .python/generate_markdown.py` 를 실행해 모든 산출물을 다시 생성하세요. 생성된 산출물은 손으로 편집하지 않습니다. `py .python/generate_markdown.py --check` 로 소스와 산출물의 동기화를 검증할 수 있습니다.

******

### 라이선스

******

프로젝트 코드는 [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE) 라이선스를 따릅니다. 병음 변환 능력은 [pinyin4j](https://github.com/belerweb/pinyin4j) 라이브러리 (`com.belerweb:pinyin4j:2.5.1`) 에서 나옵니다.

******

### 관련 링크

******

- AutoJs6 Pinyin4j 문서: https://docs.autojs6.com/#/pinyin4j
- AutoJs6 프로젝트: https://github.com/SuperMonster003/AutoJs6
- 자매 플러그인 Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- pinyin4j 프로젝트: https://github.com/belerweb/pinyin4j
- pinyin4j Maven 좌표: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

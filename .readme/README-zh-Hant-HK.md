<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>用於中文轉漢語拼音的 Pinyin4j 插件</p>

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

### 語言 (Languages)

******

當前 README.md 支援以下語言:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- 繁體中文 (香港) [zh-Hant-HK] # 當前
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### 簡介

******

AutoJs6 Pinyin4j 插件為 AutoJs6 提供基於 Pinyin4j 的中文轉漢語拼音能力, 支援無聲調, 數字聲調和音調符號輸出.

******

### 功能

******

- 提供 `pinyin4j` 插件服務, 插件 ID 為 `pinyin4j`.
- 支援 AutoJs6 中的 `pinyin4j.of(text, options)` 和 `pinyin4j.asTone(text)`.
- 支援配置拼音大小寫, 聲調類型, `ü` 字符表示方式和分隔符.
- 插件資訊, 使用說明, README 與 CHANGELOG 均支援西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體.
- 基於 `com.belerweb:pinyin4j`.

******

### 使用示例

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

### 選項

******

常用選項包括:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator: any string
```

`pinyin4j.asTone(text)` 可將數字聲調拼音轉換為音調符號拼音.

******

### 發行歷史

******

# v1.0.0

###### 2026/07/15

* `新增` Pinyin4j 插件服務, 插件 ID 為 `pinyin4j`, 引擎為 `pinyin4j`
* `新增` 支援通過 `org.autojs.plugin.PINYIN4J` 發現並調用插件
* `新增` 支援 `pinyin4j.of(text, options)` 將中文文本轉換為漢語拼音, 並可配置大小寫, 聲調類型, `ü` 字符表示方式和分隔符
* `新增` 支援 `pinyin4j.asTone(text)` 將數字聲調拼音轉換為音調符號拼音
* `新增` 插件資訊和使用說明的多語言資源: 西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體
* `新增` README 和 CHANGELOG 由 JSON 源文件與 `.python/generate_markdown.py` 生成
* `新增` 基於 `com.belerweb:pinyin4j`

##### 更多發行歷史可參閱

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.changelog/CHANGELOG-zh-Hant-HK.md)

******

### 構建

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release 構建:

```powershell
.\gradlew.bat :app:assembleRelease
```

構建參數來自 `version.properties`, 當前最低 SDK 為 24, 目標 SDK 為 36.

******

### 資源結構

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` 提供插件描述和錯誤資訊本地化; `plugin_instruction.md` 提供宿主側展示的插件使用說明. README 與 CHANGELOG 由 `.python/generate_markdown.py` 根據 JSON 源文件生成.

******

### 相關連結

******

- AutoJs6 Pinyin4j 文檔: https://docs.autojs6.com/#/pinyin4j
- Pinyin4j 項目: https://github.com/belerweb/pinyin4j
- Pinyin4j Maven 坐標: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

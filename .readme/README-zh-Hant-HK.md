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
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 語言 (Languages)

******

目前 README.md 支援以下語言:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- 繁體中文 (香港) [zh-Hant-HK] # 目前
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

Pinyin4j 插件 (Pinyin4j Plugin) 為 AutoJs6 提供輕量的中文轉漢語拼音能力. 安裝後, 腳本可透過全局對象 `pinyin4j` 將中文文本逐字轉換為拼音, 並按需配置大小寫, 聲調格式, `ü` 的表示方式與音節分隔符; 另提供將數字聲調文本轉換為聲調符號的實用方法.

插件是一個獨立安裝的 APK, 運行於自身進程, 由 AutoJs6 透過插件機制自動發現並以 AIDL 通信. 轉換能力來自經典 Java 庫 [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), 安裝包僅約 0.3 MB, 轉換完全在設備本地完成, 無需網絡. 自 AutoJs6 v6.8.0 起, 宿主的 `pinyin4j` 模塊由本插件提供實現.

本插件與 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 互為姊妹插件: 本插件以極小體積提供簡單可靠的逐字注音; Pinyin 插件內置完整字典與 Jieba 分詞, 支援多音字消歧與姓氏模式, 適合追求讀音準確性的場景. 兩者可同時安裝, 詳見下方 `姊妹插件對比`.

******

### 功能亮點

******

- 開箱即用: 安裝後由 AutoJs6 自動發現, 無需重啟宿主, 腳本直接使用全局對象 `pinyin4j`.
- 極致輕量: 安裝包僅約 0.3 MB, 純 JVM 實現, 不含任何原生庫, 適配全部 CPU 架構.
- 三種聲調格式: 無聲調, 數字聲調 (`han4`) 與聲調符號 (`hàn`), 按需選用.
- 靈活輸出: 可配置大小寫, `ü` 的三種表示方式 (`lv` / `lu:` / `lü`) 與任意音節分隔符.
- 聲調工具: `pinyin4j.as(text)` 將數字聲調文本一步轉換為聲調符號形式.
- 取值寬鬆: 選項大小寫不敏感並支援多種簡寫別名 (如 `tone: "MARK"`), 非法取值給出本地化錯誤提示.
- 完全離線: 轉換基於內置數據在設備本地完成, 不發起任何網絡請求.
- 多語言: 插件信息, 使用說明, README 與更新日誌覆蓋 10 種語言.

******

### 使用方法

******

1. 將 AutoJs6 升級到內部版本號 3923 (6.7.1 Alpha4) 及以上; 自 v6.8.0 起拼音能力完全由插件承擔, 推薦直接使用最新版本.
2. 從 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 頁面下載插件 APK 安裝到運行 AutoJs6 的設備上, 或直接在 AutoJs6 的插件中心在線安裝.
3. 打開 AutoJs6 的插件中心, 確認 `Pinyin4j` 插件已被識別, 完成授權並處於啟用狀態.
4. 在腳本中直接調用 `pinyin4j` 全局對象, 參考下方 `快速上手` 示例; 也可先運行 `快速自檢` 確認插件生效.

> 插件僅提供一個通用安裝包 (純 JVM 實現, 不區分 CPU 架構), 支援 Android 7.0 (API 24) 及以上的設備. 插件無獨立界面, 安裝後不在桌面創建圖標, 由 AutoJs6 統一發現與管理.

******

### 快速上手

******

基礎轉換: 預設輸出小寫無聲調拼音, 第二參數可直接傳分隔符:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

數字聲調與 `ü` 的表示方式:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

聲調工具: 將數字聲調文本轉換為聲調符號:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

******

### 選項

******

`pinyin4j.of(text, options)` 支援以下選項 (括號內為可用簡寫鍵名):

| 選項 | 預設值 | 說明 |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | 輸出大小寫: `LOWERCASE` 小寫, `UPPERCASE` 大寫 |
| `toneType` (`tone`) | `WITHOUT_TONE` | 聲調格式: `WITHOUT_TONE` 無聲調, `WITH_TONE_NUMBER` 數字聲調, `WITH_TONE_MARK` 聲調符號 |
| `vCharType` (`v`, `vChar`) | `WITH_V` | `ü` 的表示方式: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); 聲調符號格式下預設切換為 `WITH_U_UNICODE` |
| `separator` (`sep`) | `""` | 音節之間的分隔符, 可為任意字符串; 輸出末尾的分隔符會被去除 |

取值不區分大小寫且支援簡寫別名, 如 `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"`. 傳入非法取值時會拋出帶本地化錯誤信息的異常.

******

### 腳本 API

******

`pinyin4j` 全局對象提供以下方法 (直接調用 `pinyin4j(text, options)` 等價於 `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

- `of` 逐字轉換: 基本漢字區 (U+4E00-U+9FA5) 內的字符轉換為拼音, 其餘字符原樣保留; 每個字固定取 pinyin4j 詞典的第一讀音, 不做多音字消歧.
- `of` 的第二參數既可以是選項對象, 也可以直接傳一個字符串作為分隔符.
- `as` 將文本中的數字聲調音節 (如 `han4`) 替換為聲調符號形式 (如 `hàn`), 兼容以 `v` 或 `u:` 表示的 `ü`, 無法識別的片段原樣保留; 該方法對應插件 AIDL 接口中的 `asTone`.
- 選項取值大小寫不敏感並支援多種簡寫 (見上方 `選項`), 非法取值會拋出帶本地化錯誤信息的異常.
- 全部方法同步返回, 無需初始化等待.

******

### 快速自檢

******

安裝並啟用插件後, 運行以下單行腳本:

```javascript
console.log(pinyin4j.of("拼音"));
```

輸出 `pinyin` 即表示插件已正常工作.

******

### 常見問題

******

#### 如何確認插件已經生效?

打開 AutoJs6 的插件中心, 能看到 `Pinyin4j` 插件並處於啟用狀態即表示宿主已識別; 再運行上方 `快速自檢` 腳本, 輸出 `pinyin` 即為生效.

#### 腳本報錯提示缺少插件或 `pinyin4j` 不可用?

請確認 AutoJs6 內部版本號不低於 3923, 且插件已在插件中心完成安裝, 授權與啟用. 自 AutoJs6 v6.8.0 起, 宿主不再內置 pinyin4j 庫, 相關能力完全由本插件承擔.

#### 為什麼應用列表和桌面上沒有插件圖標?

這是正常現象. 插件沒有獨立界面, 也不在桌面創建啟動圖標, 安裝後由 AutoJs6 在後台自動發現和調用, 全部交互都在 AutoJs6 內完成.

#### 多音字讀音不符合預期 (如 "重慶" 未讀作 chongqing)?

本插件按單字轉換, 每個字固定取詞典的第一讀音, 不結合詞組語境消歧, 這是輕量方案的固有取捨. 需要多音字消歧, 詞組詞典或姓氏讀音時, 請使用姊妹插件 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### 文檔或舊腳本中的 `pinyin4j.asTone(text)` 為什麼不可用?

宿主側該方法的名稱是 `pinyin4j.as(text)`; `asTone` 是插件 AIDL 接口中的方法名, 二者行為一致. 請在腳本中使用 `pinyin4j.as(text)`.

#### 插件會聯網或申請敏感權限嗎?

不會. 轉換數據內置於安裝包, 轉換在設備本地完成; 插件清單僅聲明與 AutoJs6 通信所需的插件權限, 不申請網絡, 存儲等任何敏感系統權限.

#### 與姊妹插件 Pinyin 如何選擇?

只需輕量逐字注音且在意安裝包體積時選擇本插件; 需要多音字, 分詞, 詞組或姓氏讀音時選擇 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin). 兩者互不衝突, 可同時安裝, 詳見下方 `姊妹插件對比`.

******

### 權限與安全

******

插件在設計上盡可能收窄數據面與權限面:

- 最小權限: 插件清單僅聲明 AutoJs6 插件權限 (`org.autojs.permission.PLUGIN`), 不申請網絡, 存儲, 相機等任何敏感系統權限.
- 本地轉換: 待轉換文本僅經 Binder 在設備內傳遞, 轉換數據全部內置, 全程離線, 數據不出設備.
- 簽名與授權: AutoJs6 會校驗插件簽名, 插件需在插件中心授權並啟用後才能被腳本調用; 服務與喚醒入口均受插件權限保護, 第三方應用無法直接調用.
- 開源可審計: 插件代碼與文檔生成鏈路全部開源, 轉換能力來自廣泛使用的開源庫 pinyin4j.

請僅從官方 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 頁面或 AutoJs6 插件中心獲取插件安裝包; 來源不明的安裝包即使名稱與版本號相同, 也可能被篡改.

******

### 姊妹插件對比

******

AutoJs6 官方提供兩個拼音插件, 各有側重, 可同時安裝:

| 對比項 | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| 底層實現 | 經典 Java 庫 `pinyin4j` | 內置字典 + Jieba 分詞 |
| 全局對象 | `pinyin4j` | `pinyin` |
| 多音字 | 不支援, 固定取首個讀音 | 支援, 可返回全部候選 |
| 分詞與詞組 | 不支援, 逐字轉換 | 支援 (詞組詞典 + Jieba) |
| 姓氏模式 | 不支援 | 支援 |
| 輸出形式 | 字符串, 可配置分隔符 | 二維候選數組 (可 `compact()` 組合) 或緊湊字符串 |
| 風格與格式 | 3 種聲調格式 + 大小寫 + `ü` 表示方式 | 6 種拼音風格 |
| 安裝包體積 | 約 0.3 MB | 約 6 MB (內置字典) |
| 適用場景 | 體積與簡單性優先: 快速逐字注音 | 讀音準確性優先: 多音字, 詞組, 人名 |

兩個插件互不依賴也互不衝突; 同時安裝後, 腳本可按需分別調用 `pinyin4j` 與 `pinyin`. Pinyin 插件詳見 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

******

### 插件接口

******

以下信息面向 AutoJs6 宿主與插件開發者, 宿主通過這些標識發現插件並完成能力協商:

```text
application id: io.github.supermonster003.autojs6.plugin.pinyin4j
plugin id: pinyin4j
engine: pinyin4j
variant: default
discovery action: org.autojs.plugin.PINYIN4J
discovery category: pinyin4j
wake action: org.autojs.plugin.action.WAKE
binder interface: IPinyin4jPlugin
binder methods: getInfo / of / asTone
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

`Pinyin4jPluginService` 響應 `org.autojs.plugin.PINYIN4J` action (category `pinyin4j`), 通過 AIDL 接口 `IPinyin4jPlugin` 暴露 3 個方法; `of` 的選項經 `Bundle` 傳遞 (鍵: `caseType` / `toneType` / `vCharType` / `separator`), 非法取值拋出帶本地化錯誤信息的 `IllegalArgumentException`. 服務與 `WakeActivity` 均受 `org.autojs.permission.PLUGIN` 權限保護, 第三方應用無法直接調用.

******

### 開發路線圖

******

插件的能力規劃與完成情況以可勾選清單維護在 ROADMAP.md 中, 按里程碑組織並附驗收條件, 涵蓋多讀音查詢, 更多羅馬化體系, 字符覆蓋範圍與持續集成等方向. 未勾選條目表示規劃意向而非目前版本能力, 歡迎通過 Issues 參與討論.

- [查看 ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### 發行歷史

******

#### v1.1.0

_2026/09/01_

- `修復` 移除非空白分隔符導致的輸出末尾殘留, 並精確保留包括首尾空白在內的非漢字字符
- `修復` 將 pinyin4j 2.5.1 使用 breve 的舊式第三聲元音統一為標準 caron 形式 (如 `yŭ` 轉為 `yǔ`), 同時覆蓋大小寫
- `優化` 新增 JVM 單元測試, 覆蓋選項標準名與別名, 取值簡寫, 輸出組合, 默認值, 異常, 聲調轉換及運行時元數據; 新增 Android instrumentation 測試驗證真實服務發現與 Binder 往返
- `優化` 新增 GitHub Actions 工作流, 自動攔截生成文檔漂移, 運行單元測試, 構建 debug APK, 編譯 instrumentation 測試並上傳 APK 產物
- `優化` 新增 `.python/prepare_release.py`, 一鍵構建並驗證簽名 universal APK, 校驗版本, 計算 CRC32 與 SHA-256, 原子生成 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
- `優化` 統一 README 版式與 Gradle 平台版本管理方式

#### v1.0.1

_2026/08/31_

- `提示` 本版本僅改進文檔與配套工程, 拼音轉換行為與全部腳本 API 保持不變
- `修復` 修正舊版文檔中錯誤的 `pinyin4j.asTone(text)` 寫法: 宿主實際暴露的方法為 `pinyin4j.as(text)` (底層 AIDL 接口方法名仍為 `asTone`)
- `優化` 重構 10 種語言的 README: 新增使用方法, 快速上手, 選項速查表, 腳本 API, 快速自檢, 常見問題, 權限與安全, 姊妹插件對比及插件接口等章節
- `優化` 文檔生成腳本升級為同族插件統一實現: 支援 `--check` 漂移檢測, 跨語言鍵位與形狀對齊校驗, 全形符號攔截以及版本對齊校驗
- `優化` 插件中心使用說明 (`plugin_instruction.md`) 納入同一套多語言 JSON 生成鏈路, 消除雙源維護
- `優化` 新增 ROADMAP.md 開發路線圖, 並與姊妹插件 Pinyin 建立雙向互鏈與選型對比

#### v1.0.0

_2026/07/15_

- `新增` Pinyin4j 插件服務: 插件 ID 為 `pinyin4j`, 由 AutoJs6 通過 `org.autojs.plugin.PINYIN4J` 自動發現並調用, 封裝 `com.belerweb:pinyin4j:2.5.1` 庫
- `新增` 拼音轉換 API: `pinyin4j.of(text, options)` 將中文逐字轉換為漢語拼音, 第二參數傳入字符串時直接作為分隔符
- `新增` 聲調還原 API: `pinyin4j.as(text)` 將數字聲調拼音 (如 `han4`) 還原為符號聲調拼音 (如 `hàn`), 對應 AIDL 接口方法 `asTone`
- `新增` 靈活的選項體系: 支援 `case` / `tone` / `v` / `sep` 等別名與 `MARK` / `NUMBER` / `NO` 等取值簡寫, 非法取值拋出本地化錯誤提示
- `新增` 多語言資源: 插件信息與使用說明覆蓋 10 種語言
- `新增` README 與 CHANGELOG 由 JSON 源文件與 `.python/generate_markdown.py` 生成多語言 Markdown

##### 更多發行歷史可參閱

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hant-HK.md)

******

### 構建

******

本節面向希望從源碼構建插件的開發者.

構建 debug APK:

```powershell
.\gradlew.bat :app:assembleDebug
```

構建 release APK (單一通用包; 在不入庫的 `sign.properties` 中配置簽名後自動簽名):

```powershell
.\gradlew.bat :app:assembleRelease
```

生成已驗證的發布歸檔可運行 `py .python/prepare_release.py`. 腳本會檢查生成文檔, 構建並驗證簽名 universal APK, 校驗版本元數據, 計算 CRC32 與 SHA-256, 並將 APK, `SHA256SUMS.txt` 及英文 `RELEASE_NOTES.md` 原子寫入 `app/releases/v<版本號>`.

構建參數集中於 `version.properties`: 最低 SDK 24 (Android 7.0), 目標 SDK 36, 目前版本 1.1.0.

******

### 本地化與文檔生成

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

`strings.xml` 提供本地化插件描述與錯誤信息, `plugin_instruction.md` 提供宿主插件中心展示的使用說明. README, 更新日誌與使用說明均由 JSON 源生成: 修改 `.readme/` 與 `.changelog/` 下的源文件後運行 `py .python/generate_markdown.py` 重新生成全部產物, 生成產物不手工編輯; 運行 `py .python/generate_markdown.py --check` 可校驗源文件與產物是否同步.

******

### 許可

******

項目代碼使用 [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). 拼音轉換能力來自 [pinyin4j](https://github.com/belerweb/pinyin4j) 庫 (`com.belerweb:pinyin4j:2.5.1`).

******

### 相關連結

******

- AutoJs6 Pinyin4j 文件: https://docs.autojs6.com/#/pinyin4j
- AutoJs6 項目: https://github.com/SuperMonster003/AutoJs6
- 姊妹插件 Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- pinyin4j 項目: https://github.com/belerweb/pinyin4j
- pinyin4j Maven 坐標: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

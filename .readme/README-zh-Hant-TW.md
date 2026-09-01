<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>用於中文轉漢語拼音的 Pinyin4j 外掛</p>

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
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- 繁體中文 (台灣) [zh-Hant-TW] # 目前
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

Pinyin4j 外掛 (Pinyin4j Plugin) 為 AutoJs6 提供輕量的中文轉漢語拼音能力. 安裝後, 腳本可透過全域物件 `pinyin4j` 將中文文字逐字轉換為拼音, 並按需設定大小寫, 聲調格式, `ü` 的表示方式與音節分隔符號; 另提供將數字聲調文字轉換為聲調符號的實用方法.

外掛是一個獨立安裝的 APK, 在自身處理程序中執行, 由 AutoJs6 透過外掛機制自動發現並以 AIDL 通訊. 轉換能力來自經典 Java 程式庫 [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), 安裝套件僅約 0.3 MB, 轉換完全在裝置本地完成, 無需網路. 自 AutoJs6 v6.8.0 起, 主程式的 `pinyin4j` 模組由本外掛提供實作.

本外掛與 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 互為姊妹外掛: 本外掛以極小體積提供簡單可靠的逐字注音; Pinyin 外掛內建完整字典與 Jieba 分詞, 支援多音字消歧與姓氏模式, 適合追求讀音準確性的場景. 兩者可同時安裝, 詳見下方 `姊妹外掛比較`.

******

### 功能亮點

******

- 開箱即用: 安裝後由 AutoJs6 自動發現, 無需重新啟動主程式, 腳本直接使用全域物件 `pinyin4j`.
- 極致輕量: 安裝套件僅約 0.3 MB, 純 JVM 實作, 不含任何原生程式庫, 適用於全部 CPU 架構.
- 三種聲調格式: 無聲調, 數字聲調 (`han4`) 與聲調符號 (`hàn`), 按需選用.
- 靈活輸出: 可設定大小寫, `ü` 的三種表示方式 (`lv` / `lu:` / `lü`) 與任意音節分隔符號.
- 聲調工具: `pinyin4j.as(text)` 將數字聲調文字一步轉換為聲調符號形式.
- 取值寬鬆: 選項不區分大小寫並支援多種簡寫別名 (如 `tone: "MARK"`), 非法取值給出在地化錯誤提示.
- 完全離線: 轉換基於內建資料在裝置本地完成, 不發起任何網路請求.
- 多語言: 外掛資訊, 使用說明, README 與更新日誌覆蓋 10 種語言.

******

### 使用方法

******

1. 將 AutoJs6 升級到內部版本號 3923 (6.7.1 Alpha4) 及以上; 自 v6.8.0 起拼音能力完全由外掛承擔, 建議直接使用最新版本.
2. 從 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 頁面下載外掛 APK 並安裝到執行 AutoJs6 的裝置上, 或直接在 AutoJs6 的外掛中心線上安裝.
3. 開啟 AutoJs6 的外掛中心, 確認 `Pinyin4j` 外掛已被識別, 完成授權並處於啟用狀態.
4. 在腳本中直接呼叫 `pinyin4j` 全域物件, 參考下方 `快速上手` 範例; 也可先執行 `快速自檢` 確認外掛生效.

> 外掛僅提供一個通用安裝套件 (純 JVM 實作, 不區分 CPU 架構), 支援 Android 7.0 (API 24) 及以上的裝置. 外掛無獨立介面, 安裝後不在桌面建立圖示, 由 AutoJs6 統一發現與管理.

******

### 快速上手

******

基礎轉換: 預設輸出小寫無聲調拼音, 第二參數可直接傳分隔符號:

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

聲調工具: 將數字聲調文字轉換為聲調符號:

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
| `separator` (`sep`) | `""` | 音節之間的分隔符號, 可為任意字串; 輸出結尾的分隔符號會被移除 |

取值不區分大小寫且支援簡寫別名, 如 `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"`. 傳入非法取值時會拋出包含在地化訊息的例外.

******

### 腳本 API

******

`pinyin4j` 全域物件提供以下方法 (直接呼叫 `pinyin4j(text, options)` 等價於 `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

- `of` 逐字轉換: 基本漢字區 (U+4E00-U+9FA5) 內的字元轉換為拼音, 其餘字元原樣保留; 每個字固定取 pinyin4j 詞典的第一讀音, 不做多音字消歧.
- `of` 的第二參數既可以是選項物件, 也可以直接傳一個字串作為分隔符號.
- `as` 將文字中的數字聲調音節 (如 `han4`) 替換為聲調符號形式 (如 `hàn`), 相容以 `v` 或 `u:` 表示的 `ü`, 無法識別的片段原樣保留; 該方法對應外掛 AIDL 介面中的 `asTone`.
- 選項取值不區分大小寫並支援多種簡寫 (見上方 `選項`), 非法取值會拋出包含在地化訊息的例外.
- 全部方法同步回傳, 無需初始化等待.

******

### 快速自檢

******

安裝並啟用外掛後, 執行以下單行腳本:

```javascript
console.log(pinyin4j.of("拼音"));
```

輸出 `pinyin` 即表示外掛已正常運作.

******

### 常見問題

******

#### 如何確認外掛已經生效?

開啟 AutoJs6 的外掛中心, 能看到 `Pinyin4j` 外掛並處於啟用狀態即表示主程式已識別; 再執行上方 `快速自檢` 腳本, 輸出 `pinyin` 即為生效.

#### 腳本出現錯誤提示缺少外掛或 `pinyin4j` 無法使用?

請確認 AutoJs6 內部版本號不低於 3923, 且外掛已在外掛中心完成安裝, 授權與啟用. 自 AutoJs6 v6.8.0 起, 主程式不再內建 pinyin4j 程式庫, 相關能力完全由本外掛承擔.

#### 為什麼應用程式清單和桌面上沒有外掛圖示?

這是正常現象. 外掛沒有獨立介面, 也不在桌面建立啟動圖示, 安裝後由 AutoJs6 在背景自動發現和呼叫, 全部互動都在 AutoJs6 內完成.

#### 多音字讀音不符合預期 (如 "重慶" 未讀作 chongqing)?

本外掛按單字轉換, 每個字固定取詞典的第一讀音, 不結合詞組語境消歧, 這是輕量方案的固有取捨. 需要多音字消歧, 詞組詞典或姓氏讀音時, 請使用姊妹外掛 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### 文件或舊腳本中的 `pinyin4j.asTone(text)` 為什麼無法使用?

主程式側該方法的名稱是 `pinyin4j.as(text)`; `asTone` 是外掛 AIDL 介面中的方法名, 二者行為一致. 請在腳本中使用 `pinyin4j.as(text)`.

#### 外掛會連網或申請敏感權限嗎?

不會. 轉換資料內建於安裝套件, 轉換在裝置本地完成; 外掛資訊清單僅宣告與 AutoJs6 通訊所需的外掛權限, 不申請網路, 儲存空間等任何敏感系統權限.

#### 與姊妹外掛 Pinyin 如何選擇?

只需輕量逐字注音且在意安裝套件體積時選擇本外掛; 需要多音字, 分詞, 詞組或姓氏讀音時選擇 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin). 兩者互不衝突, 可同時安裝, 詳見下方 `姊妹外掛比較`.

******

### 權限與安全

******

外掛在設計上盡可能收窄資料面與權限面:

- 最小權限: 外掛資訊清單僅宣告 AutoJs6 外掛權限 (`org.autojs.permission.PLUGIN`), 不申請網路, 儲存空間, 相機等任何敏感系統權限.
- 本地轉換: 待轉換文字僅經 Binder 在裝置內傳遞, 轉換資料全部內建, 全程離線, 資料不出裝置.
- 簽章與授權: AutoJs6 會驗證外掛簽章, 外掛需在外掛中心授權並啟用後才能被腳本呼叫; 服務與喚醒入口均受外掛權限保護, 第三方應用程式無法直接呼叫.
- 開源可稽核: 外掛程式碼與文件產生鏈路全部開源, 轉換能力來自廣泛使用的開源程式庫 pinyin4j.

請僅從官方 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 頁面或 AutoJs6 外掛中心取得外掛安裝套件; 來源不明的安裝套件即使名稱與版本號相同, 也可能被竄改.

******

### 姊妹外掛比較

******

AutoJs6 官方提供兩個拼音外掛, 各有側重, 可同時安裝:

| 比較項目 | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| 底層實作 | 經典 Java 程式庫 `pinyin4j` | 內建字典 + Jieba 分詞 |
| 全域物件 | `pinyin4j` | `pinyin` |
| 多音字 | 不支援, 固定取首個讀音 | 支援, 可回傳全部候選 |
| 分詞與詞組 | 不支援, 逐字轉換 | 支援 (詞組詞典 + Jieba) |
| 姓氏模式 | 不支援 | 支援 |
| 輸出形式 | 字串, 可設定分隔符號 | 二維候選陣列 (可 `compact()` 組合) 或緊湊字串 |
| 風格與格式 | 3 種聲調格式 + 大小寫 + `ü` 表示方式 | 6 種拼音風格 |
| 安裝套件體積 | 約 0.3 MB | 約 6 MB (內建字典) |
| 適用場景 | 體積與簡單性優先: 快速逐字注音 | 讀音準確性優先: 多音字, 詞組, 人名 |

兩個外掛互不依賴也互不衝突; 同時安裝後, 腳本可按需分別呼叫 `pinyin4j` 與 `pinyin`. Pinyin 外掛詳見 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

******

### 外掛介面

******

以下資訊面向 AutoJs6 主程式與外掛開發者, 主程式透過這些識別碼發現外掛並完成能力協商:

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

`Pinyin4jPluginService` 回應 `org.autojs.plugin.PINYIN4J` action (category `pinyin4j`), 透過 AIDL 介面 `IPinyin4jPlugin` 公開 3 個方法; `of` 的選項經 `Bundle` 傳遞 (鍵: `caseType` / `toneType` / `vCharType` / `separator`), 非法取值拋出包含在地化訊息的 `IllegalArgumentException`. 服務與 `WakeActivity` 均受 `org.autojs.permission.PLUGIN` 權限保護, 第三方應用程式無法直接呼叫.

******

### 開發路線圖

******

外掛的能力規劃與完成情況以可勾選清單維護在 ROADMAP.md 中, 按里程碑組織並附驗收條件, 涵蓋多讀音查詢, 更多羅馬化體系, 字元覆蓋範圍與持續整合等方向. 未勾選條目表示規劃意向而非目前版本能力, 歡迎透過 Issues 參與討論.

- [檢視 ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### 發行歷史

******

#### v1.1.0

_2026/09/01_

- `修復` 移除非空白分隔符號造成的輸出結尾殘留, 並精確保留包含開頭與結尾空白在內的非中文字元
- `修復` 將 pinyin4j 2.5.1 使用 breve 的舊式第三聲母音統一為標準 caron 形式 (如 `yŭ` 轉為 `yǔ`), 並同時涵蓋大小寫
- `最佳化` 新增 JVM 單元測試, 涵蓋選項標準名稱與別名, 值縮寫, 輸出組合, 預設值, 例外, 聲調轉換及執行階段中繼資料; 新增 Android instrumentation 測試驗證實際服務探索與 Binder 往返
- `最佳化` 新增 GitHub Actions 工作流程, 自動攔截產生文件漂移, 執行單元測試, 建置 debug APK, 編譯 instrumentation 測試並上傳 APK 成品
- `最佳化` 新增 `.python/prepare_release.py`, 一鍵建置並驗證已簽署 universal APK, 驗證版本, 計算 CRC32 與 SHA-256, 以原子方式產生 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
- `最佳化` 統一 README 版式與 Gradle 平台版本管理方式

#### v1.0.1

_2026/08/31_

- `提示` 本版本僅改進文件與配套工程, 拼音轉換行為與全部腳本 API 保持不變
- `修復` 修正舊版文件中錯誤的 `pinyin4j.asTone(text)` 寫法: 主程式實際公開的方法為 `pinyin4j.as(text)` (底層 AIDL 介面方法名仍為 `asTone`)
- `最佳化` 重構 10 種語言的 README: 新增使用方法, 快速上手, 選項速查表, 腳本 API, 快速自檢, 常見問題, 權限與安全, 姊妹外掛比較及外掛介面等章節
- `最佳化` 文件產生腳本升級為同族外掛統一實作: 支援 `--check` 漂移偵測, 跨語言鍵位與形狀對齊驗證, 全形符號攔截以及版本對齊驗證
- `最佳化` 外掛中心使用說明 (`plugin_instruction.md`) 納入同一套多語言 JSON 產生鏈路, 消除雙源維護
- `最佳化` 新增 ROADMAP.md 開發路線圖, 並與姊妹外掛 Pinyin 建立雙向連結與選型比較

#### v1.0.0

_2026/07/15_

- `新增` Pinyin4j 外掛服務: 外掛 ID 為 `pinyin4j`, 由 AutoJs6 透過 `org.autojs.plugin.PINYIN4J` 自動發現並呼叫, 封裝 `com.belerweb:pinyin4j:2.5.1` 程式庫
- `新增` 拼音轉換 API: `pinyin4j.of(text, options)` 將中文逐字轉換為漢語拼音, 第二參數傳入字串時直接作為分隔符號
- `新增` 聲調還原 API: `pinyin4j.as(text)` 將數字聲調拼音 (如 `han4`) 還原為符號聲調拼音 (如 `hàn`), 對應 AIDL 介面方法 `asTone`
- `新增` 靈活的選項體系: 支援 `case` / `tone` / `v` / `sep` 等別名與 `MARK` / `NUMBER` / `NO` 等取值簡寫, 非法取值拋出在地化錯誤提示
- `新增` 多語言資源: 外掛資訊與使用說明覆蓋 10 種語言
- `新增` README 與 CHANGELOG 由 JSON 來源檔與 `.python/generate_markdown.py` 產生多語言 Markdown

##### 更多發行歷史可參閱

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hant-TW.md)

******

### 建置

******

本節面向希望從原始碼建置外掛的開發者.

建置 debug APK:

```powershell
.\gradlew.bat :app:assembleDebug
```

建置 release APK (單一通用套件; 在不入庫的 `sign.properties` 中設定簽章後自動簽章):

```powershell
.\gradlew.bat :app:assembleRelease
```

產生已驗證的發佈歸檔可執行 `py .python/prepare_release.py`. 指令碼會檢查產生文件, 建置並驗證已簽署 universal APK, 驗證版本中繼資料, 計算 CRC32 與 SHA-256, 並將 APK, `SHA256SUMS.txt` 及英文 `RELEASE_NOTES.md` 以原子方式寫入 `app/releases/v<版本號>`.

建置參數集中於 `version.properties`: 最低 SDK 24 (Android 7.0), 目標 SDK 36, 目前版本 1.1.0.

******

### 在地化與文件產生

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

`strings.xml` 提供在地化外掛描述與錯誤資訊, `plugin_instruction.md` 提供主程式外掛中心展示的使用說明. README, 更新日誌與使用說明均由 JSON 來源產生: 修改 `.readme/` 與 `.changelog/` 下的來源檔後執行 `py .python/generate_markdown.py` 重新產生全部產物, 產生產物不手工編輯; 執行 `py .python/generate_markdown.py --check` 可校驗來源檔與產物是否同步.

******

### 授權

******

專案程式碼使用 [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). 拼音轉換能力來自 [pinyin4j](https://github.com/belerweb/pinyin4j) 程式庫 (`com.belerweb:pinyin4j:2.5.1`).

******

### 相關連結

******

- AutoJs6 Pinyin4j 文件: https://docs.autojs6.com/#/pinyin4j
- AutoJs6 專案: https://github.com/SuperMonster003/AutoJs6
- 姊妹外掛 Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- pinyin4j 專案: https://github.com/belerweb/pinyin4j
- pinyin4j Maven 座標: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

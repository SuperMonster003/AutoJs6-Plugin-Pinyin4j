******

### 發行歷史

******

# v1.3.2

###### 2026/09/15

* `優化` 將 compileSdk 與 targetSdk 提升到 37 (Android 17), 插件行為不受新目標版本影響

# v1.3.1

###### 2026/09/13

* `修復` 外掛版本日期固定使用英文, 不隨建置機器的語言變化
* `優化` 統一多語言資源, 明確插件啟用契約並驗證發佈產物

# v1.3.0

###### 2026/09/11

* `提示` `pinyin4j.readings()` 與 Node.js provider 需要包含 readings v1 契約的新版 AutoJs6 宿主; 舊版宿主仍可繼續使用 `of` 與 `as`
* `新增` `pinyin4j.readings(text, options)` 按 Unicode 碼點逐行返回全部有序詞典讀音, 無映射輸入原樣保留為單候選
* `新增` `romanization` / `system` 開放 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 與 Gwoyeu Romatzyh; Hanyu 支援數字/符號/無聲調, 大小寫與 `ü` 形式
* `優化` 在 Binder 末尾追加 `readings` transaction 與整數 capability `pinyin4j.readings.version = 1`; 新宿主僅在協商後調用, 對舊插件按碼點安全回退為 Hanyu 單候選
* `優化` 增加嚴格的源文本, 矩陣與 UTF-8 JSON 上限及 Android 9/12/13/15 Binder 覆蓋; 同一插件能力透過宿主明確 `pinyin4j` capability 向 Node.js 開放
* `優化` 建置階段阻止意外引入原生相依套件, 並輸出 JSON 校驗報告

# v1.2.0

###### 2026/09/01

* `提示` 多讀音與六種羅馬化體系目前僅作為經過測試的插件側核心和契約方案; 在 AutoJs6 AIDL 與宿主路由升級前, `pinyin4j.readings()` 不是公開腳本 API
* `修復` `of` 不再丟失詞典空洞字符或拆分補充平面字符: 現按 Unicode code point 遍歷, 轉換包括 `〇` 在內的全部實際詞條, 完整保留無詞條輸入並讓分隔符與 code point 對齊
* `修復` `pinyin4j.as(text)` 現只轉換完整有效的數字聲調音節, 保留無效或嵌入字母數字的片段, 支援大小寫及 `v` / `u:` / `ü`, 並正確處理 `jue4` -> `juè` 一類普通 `ue` 拼寫
* `優化` 以窮舉 BMP 測試固定詞典真實覆蓋: 共 20,378 個映射, 其中 20,377 個位於 U+4E00-U+9FA5, 另一個為 `〇`; 舊範圍內 525 個空洞和語料 SHA-256 指紋也納入回歸
* `優化` 新增經過測試的全部候選讀音核心, 覆蓋 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 與 Gwoyeu Romatzyh, 並記錄追加式 JSON AIDL, 能力協商和舊實現回退方案
* `優化` 新增 pinyin4j 2.5.1 風險清單, 記錄二進制與源碼哈希, 上游和許可證元數據問題, 已知邊界及升級或分叉門禁
* `優化` 新增可復測的 JVM 與 Android Service/AIDL 入口性能基線, release APK ZIP/資源體積分析器, 並用實測數據更新姊妹插件選型對比

# v1.1.0

###### 2026/09/01

* `修復` 移除非空白分隔符導致的輸出末尾殘留, 並精確保留包括首尾空白在內的非漢字字符
* `修復` 將 pinyin4j 2.5.1 使用 breve 的舊式第三聲元音統一為標準 caron 形式 (如 `yŭ` 轉為 `yǔ`), 同時覆蓋大小寫
* `優化` 新增 JVM 單元測試, 覆蓋選項標準名與別名, 取值簡寫, 輸出組合, 默認值, 異常, 聲調轉換及運行時元數據; 新增 Android instrumentation 測試驗證真實服務發現與 Binder 往返
* `優化` 新增 GitHub Actions 工作流, 自動攔截生成文檔漂移, 運行單元測試, 構建 debug APK, 編譯 instrumentation 測試並上傳 APK 產物
* `優化` 新增 `.python/prepare_release.py`, 一鍵構建並驗證簽名 universal APK, 校驗版本, 計算 CRC32 與 SHA-256, 原子生成 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
* `優化` 統一 README 版式與 Gradle 平台版本管理方式

# v1.0.1

###### 2026/08/31

* `提示` 本版本僅改進文檔與配套工程, 拼音轉換行為與全部腳本 API 保持不變
* `修復` 修正舊版文檔中錯誤的 `pinyin4j.asTone(text)` 寫法: 宿主實際暴露的方法為 `pinyin4j.as(text)` (底層 AIDL 接口方法名仍為 `asTone`)
* `優化` 重構 10 種語言的 README: 新增使用方法, 快速上手, 選項速查表, 腳本 API, 快速自檢, 常見問題, 權限與安全, 姊妹插件對比及插件接口等章節
* `優化` 文檔生成腳本升級為同族插件統一實現: 支援 `--check` 漂移檢測, 跨語言鍵位與形狀對齊校驗, 全形符號攔截以及版本對齊校驗
* `優化` 插件中心使用說明 (`plugin_instruction.md`) 納入同一套多語言 JSON 生成鏈路, 消除雙源維護
* `優化` 新增 ROADMAP.md 開發路線圖, 並與姊妹插件 Pinyin 建立雙向互鏈與選型對比

# v1.0.0

###### 2026/07/15

* `新增` Pinyin4j 插件服務: 插件 ID 為 `pinyin4j`, 由 AutoJs6 通過 `org.autojs.plugin.PINYIN4J` 自動發現並調用, 封裝 `com.belerweb:pinyin4j:2.5.1` 庫
* `新增` 拼音轉換 API: `pinyin4j.of(text, options)` 將中文逐字轉換為漢語拼音, 第二參數傳入字符串時直接作為分隔符
* `新增` 聲調還原 API: `pinyin4j.as(text)` 將數字聲調拼音 (如 `han4`) 還原為符號聲調拼音 (如 `hàn`), 對應 AIDL 接口方法 `asTone`
* `新增` 靈活的選項體系: 支援 `case` / `tone` / `v` / `sep` 等別名與 `MARK` / `NUMBER` / `NO` 等取值簡寫, 非法取值拋出本地化錯誤提示
* `新增` 多語言資源: 插件信息與使用說明覆蓋 10 種語言
* `新增` README 與 CHANGELOG 由 JSON 源文件與 `.python/generate_markdown.py` 生成多語言 Markdown

******

### 發行歷史

******

# v1.1.0

###### 2026/09/01

* `修復` 移除非空白分隔符號造成的輸出結尾殘留, 並精確保留包含開頭與結尾空白在內的非中文字元
* `修復` 將 pinyin4j 2.5.1 使用 breve 的舊式第三聲母音統一為標準 caron 形式 (如 `yŭ` 轉為 `yǔ`), 並同時涵蓋大小寫
* `最佳化` 新增 JVM 單元測試, 涵蓋選項標準名稱與別名, 值縮寫, 輸出組合, 預設值, 例外, 聲調轉換及執行階段中繼資料; 新增 Android instrumentation 測試驗證實際服務探索與 Binder 往返
* `最佳化` 新增 GitHub Actions 工作流程, 自動攔截產生文件漂移, 執行單元測試, 建置 debug APK, 編譯 instrumentation 測試並上傳 APK 成品
* `最佳化` 新增 `.python/prepare_release.py`, 一鍵建置並驗證已簽署 universal APK, 驗證版本, 計算 CRC32 與 SHA-256, 以原子方式產生 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
* `最佳化` 統一 README 版式與 Gradle 平台版本管理方式

# v1.0.1

###### 2026/08/31

* `提示` 本版本僅改進文件與配套工程, 拼音轉換行為與全部腳本 API 保持不變
* `修復` 修正舊版文件中錯誤的 `pinyin4j.asTone(text)` 寫法: 主程式實際公開的方法為 `pinyin4j.as(text)` (底層 AIDL 介面方法名仍為 `asTone`)
* `最佳化` 重構 10 種語言的 README: 新增使用方法, 快速上手, 選項速查表, 腳本 API, 快速自檢, 常見問題, 權限與安全, 姊妹外掛比較及外掛介面等章節
* `最佳化` 文件產生腳本升級為同族外掛統一實作: 支援 `--check` 漂移偵測, 跨語言鍵位與形狀對齊驗證, 全形符號攔截以及版本對齊驗證
* `最佳化` 外掛中心使用說明 (`plugin_instruction.md`) 納入同一套多語言 JSON 產生鏈路, 消除雙源維護
* `最佳化` 新增 ROADMAP.md 開發路線圖, 並與姊妹外掛 Pinyin 建立雙向連結與選型比較

# v1.0.0

###### 2026/07/15

* `新增` Pinyin4j 外掛服務: 外掛 ID 為 `pinyin4j`, 由 AutoJs6 透過 `org.autojs.plugin.PINYIN4J` 自動發現並呼叫, 封裝 `com.belerweb:pinyin4j:2.5.1` 程式庫
* `新增` 拼音轉換 API: `pinyin4j.of(text, options)` 將中文逐字轉換為漢語拼音, 第二參數傳入字串時直接作為分隔符號
* `新增` 聲調還原 API: `pinyin4j.as(text)` 將數字聲調拼音 (如 `han4`) 還原為符號聲調拼音 (如 `hàn`), 對應 AIDL 介面方法 `asTone`
* `新增` 靈活的選項體系: 支援 `case` / `tone` / `v` / `sep` 等別名與 `MARK` / `NUMBER` / `NO` 等取值簡寫, 非法取值拋出在地化錯誤提示
* `新增` 多語言資源: 外掛資訊與使用說明覆蓋 10 種語言
* `新增` README 與 CHANGELOG 由 JSON 來源檔與 `.python/generate_markdown.py` 產生多語言 Markdown

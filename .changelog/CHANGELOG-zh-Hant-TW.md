******

### 發行歷史

******

# v1.0.0

###### 2026/07/15

* `新增` Pinyin4j 外掛服務, 外掛 ID 為 `pinyin4j`, 引擎為 `pinyin4j`, 基於 `com.belerweb:pinyin4j`
* `新增` 支援透過 `org.autojs.plugin.PINYIN4J` 發現並呼叫外掛
* `新增` 支援 `pinyin4j.of(text, options)` 將中文文字轉換為漢語拼音, 並可設定大小寫, 聲調類型, `ü` 字元表示方式和分隔符
* `新增` 支援 `pinyin4j.asTone(text)` 將數字聲調拼音轉換為音調符號拼音
* `新增` 外掛資訊和使用說明的多語言資源: 西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體
* `新增` README 和 CHANGELOG 由 JSON 來源檔案與 `.python/generate_markdown.py` 生成

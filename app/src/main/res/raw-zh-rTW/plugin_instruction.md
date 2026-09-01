Pinyin4j 外掛 (Pinyin4j Plugin) 為 AutoJs6 提供輕量的中文轉漢語拼音能力. 安裝後, 腳本可透過全域物件 `pinyin4j` 將中文文字逐字轉換為拼音, 並按需設定大小寫, 聲調格式, `ü` 的表示方式與音節分隔符號; 另提供將數字聲調文字轉換為聲調符號的實用方法.

### 快速上手

基礎轉換: 預設輸出小寫無聲調拼音, 第二參數可直接傳分隔符號:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### 選項

`pinyin4j.of(text, options)` 支援以下選項 (括號內為可用簡寫鍵名):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

取值不區分大小寫且支援簡寫別名, 如 `tone: "MARK"` / `"NUMBER"` / `"NO"`; 第二參數直接傳字串時視為分隔符號.

### 快速自檢

安裝並啟用外掛後, 執行以下單行腳本:

```javascript
console.log(pinyin4j.of("拼音"));
```

輸出 `pinyin` 即表示外掛已正常運作.

更多用法與選項說明可參閱 [AutoJs6 Pinyin4j 文件](https://docs.autojs6.com/#/pinyin4j) 與 [專案主頁](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

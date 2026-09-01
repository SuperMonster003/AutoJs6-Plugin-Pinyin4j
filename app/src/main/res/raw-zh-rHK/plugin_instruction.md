Pinyin4j 插件 (Pinyin4j Plugin) 為 AutoJs6 提供輕量逐字羅馬化能力. 腳本既可輸出格式化的漢語拼音字符串, 也可按 Unicode 碼點查詢 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 或 Gwoyeu Romatzyh 的全部詞典讀音矩陣, 並可將數字聲調文本轉換為聲調符號.

### 快速上手

基礎轉換: 預設輸出小寫無聲調拼音, 第二參數可直接傳分隔符:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
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

取值不區分大小寫且支援簡寫別名, 如 `tone: "MARK"` / `"NUMBER"` / `"NO"`; 第二參數直接傳字符串時視為分隔符.

### 快速自檢

安裝並啟用插件後, 運行以下單行腳本:

```javascript
console.log(pinyin4j.of("拼音"));
```

輸出 `pinyin` 即表示插件已正常工作.

更多用法與選項說明可參閱 [AutoJs6 Pinyin4j 文件](https://docs.autojs6.com/#/pinyin4j) 與 [項目主頁](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

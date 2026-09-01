Pinyin4j 插件 (Pinyin4j Plugin) 为 AutoJs6 提供轻量逐字罗马化能力. 脚本既可输出格式化的汉语拼音字符串, 也可按 Unicode 码点查询 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 或 Gwoyeu Romatzyh 的全部词典读音矩阵, 并可将数字声调文本转换为声调符号.

### 快速上手

基础转换: 默认输出小写无声调拼音, 第二参数可直接传分隔符:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### 选项

`pinyin4j.of(text, options)` 支持以下选项 (括号内为可用简写键名):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

取值不区分大小写且支持简写别名, 如 `tone: "MARK"` / `"NUMBER"` / `"NO"`; 第二参数直接传字符串时视为分隔符.

### 快速自检

安装并启用插件后, 运行以下单行脚本:

```javascript
console.log(pinyin4j.of("拼音"));
```

输出 `pinyin` 即表示插件已正常工作.

更多用法与选项说明可参阅 [AutoJs6 Pinyin4j 文档](https://docs.autojs6.com/#/pinyin4j) 与 [项目主页](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

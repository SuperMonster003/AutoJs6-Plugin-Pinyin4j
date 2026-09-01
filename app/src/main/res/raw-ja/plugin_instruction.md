Pinyin4j プラグインは AutoJs6 に軽量な文字単位ローマ字変換を提供します. スクリプトは整形済み Hanyu Pinyin 文字列に加え, Unicode code point ごとに Hanyu, Tongyong, Wade-Giles, MPS2, Yale, Gwoyeu Romatzyh の全辞書読みを行列で取得でき, 数字声調を声調記号へ変換できます.

### クイックスタート

基本の変換: 既定では小文字の声調なしピンインを出力し, 第 2 引数には区切り文字を直接渡せます:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### オプション

`pinyin4j.of(text, options)` は次のオプションに対応しています (括弧内は利用できる短縮キー名):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

値は大文字小文字を区別せず, `tone: "MARK"` / `"NUMBER"` / `"NO"` のような短縮エイリアスに対応しています. 第 2 引数に文字列を直接渡した場合は区切り文字と見なされます.

### クイックセルフチェック

プラグインをインストールして有効にした後, 次の 1 行スクリプトを実行します:

```javascript
console.log(pinyin4j.of("拼音"));
```

`pinyin` と出力されればプラグインは正常に動作しています.

より詳しい使い方とオプションの説明は [AutoJs6 Pinyin4j ドキュメント](https://docs.autojs6.com/#/pinyin4j) と [プロジェクトホームページ](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) を参照してください.

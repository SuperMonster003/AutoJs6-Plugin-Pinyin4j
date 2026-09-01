Pinyin4j プラグイン (Pinyin4j Plugin) は AutoJs6 に軽量な中国語から漢語ピンインへの変換機能を提供します. インストール後は, スクリプトからグローバルオブジェクト `pinyin4j` を通じて中国語テキストを 1 文字ずつピンインに変換でき, 大文字小文字, 声調形式, `ü` の表記方法, 音節区切り文字を必要に応じて設定できます. さらに, 数字声調テキストを声調記号に変換するユーティリティメソッドも用意されています.

### クイックスタート

基本の変換: 既定では小文字の声調なしピンインを出力し, 第 2 引数には区切り文字を直接渡せます:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
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

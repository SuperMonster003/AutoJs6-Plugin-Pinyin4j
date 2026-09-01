<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>中国語を漢語ピンインに変換する Pinyin4j プラグイン</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Pinyin4j?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 言語 (Languages)

******

現在の README.md は次の言語に対応しています:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- 日本語 [ja] # 現在
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### 概要

******

Pinyin4j プラグイン (Pinyin4j Plugin) は AutoJs6 に軽量な中国語から漢語ピンインへの変換機能を提供します. インストール後は, スクリプトからグローバルオブジェクト `pinyin4j` を通じて中国語テキストを 1 文字ずつピンインに変換でき, 大文字小文字, 声調形式, `ü` の表記方法, 音節区切り文字を必要に応じて設定できます. さらに, 数字声調テキストを声調記号に変換するユーティリティメソッドも用意されています.

プラグインは単独でインストールされる APK として自身のプロセスで動作し, AutoJs6 がプラグイン機構により自動的に検出して AIDL で通信します. 変換機能は定番の Java ライブラリ [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`) によるもので, インストールパッケージはわずか約 0.3 MB, 変換はすべて端末ローカルで完結しネットワークは不要です. AutoJs6 v6.8.0 以降, ホストの `pinyin4j` モジュールは本プラグインが実装を提供します.

本プラグインと [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) は姉妹プラグインの関係にあります: 本プラグインは極小サイズでシンプルかつ確実な 1 文字ごとの注音を提供し, Pinyin プラグインは完全な辞書と Jieba 分かち書きを内蔵して多音字の曖昧性解消や姓モードに対応し, 読みの正確性を重視する場面に適しています. 両者は同時にインストールでき, 詳しくは下の `姉妹プラグイン比較` を参照してください.

******

### 機能ハイライト

******

- すぐに使える: インストール後は AutoJs6 が自動的に検出し, ホストの再起動は不要で, スクリプトからグローバルオブジェクト `pinyin4j` をそのまま使用できます.
- 徹底した軽量さ: インストールパッケージはわずか約 0.3 MB, 純粋な JVM 実装でネイティブライブラリを一切含まず, すべての CPU アーキテクチャに対応します.
- 3 つの声調形式: 声調なし, 数字声調 (`han4`), 声調記号 (`hàn`) から必要に応じて選べます.
- 柔軟な出力: 大文字小文字, `ü` の 3 種類の表記方法 (`lv` / `lu:` / `lü`), 任意の音節区切り文字を設定できます.
- 声調ユーティリティ: `pinyin4j.as(text)` が数字声調テキストを一度に声調記号形式へ変換します.
- 寛容な値指定: オプションは大文字小文字を区別せず複数の短縮エイリアス (例: `tone: "MARK"`) に対応し, 不正な値にはローカライズされたエラーメッセージを表示します.
- 完全オフライン: 変換は内蔵データに基づいて端末ローカルで完結し, ネットワークリクエストを一切発行しません.
- 多言語対応: プラグイン情報, 使用説明, README, 更新履歴が 10 言語で提供されます.

******

### 使用方法

******

1. AutoJs6 を内部ビルド 3923 (6.7.1 Alpha4) 以上に更新します. v6.8.0 以降ピンイン機能は完全にプラグインが担うため, 最新バージョンの利用をおすすめします.
2. [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) ページからプラグイン APK をダウンロードして AutoJs6 が動作する端末にインストールするか, AutoJs6 のプラグインセンターから直接オンラインでインストールします.
3. AutoJs6 のプラグインセンターを開き, `Pinyin4j` プラグインが認識されていることを確認したうえで, 許可を与えて有効な状態にします.
4. スクリプトからグローバルオブジェクト `pinyin4j` を直接呼び出します. 下の `クイックスタート` の例を参考にしてください. 先に `クイックセルフチェック` を実行してプラグインの動作を確認することもできます.

> プラグインは汎用インストールパッケージを 1 つだけ提供し (純粋な JVM 実装で CPU アーキテクチャを区別しません), Android 7.0 (API 24) 以上の端末をサポートします. プラグインには独立した画面がなく, インストール後もホーム画面にアイコンを作成せず, AutoJs6 が一元的に検出して管理します.

******

### クイックスタート

******

基本の変換: 既定では小文字の声調なしピンインを出力し, 第 2 引数には区切り文字を直接渡せます:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

数字声調と `ü` の表記方法:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

声調ユーティリティ: 数字声調テキストを声調記号に変換:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

******

### オプション

******

`pinyin4j.of(text, options)` は次のオプションに対応しています (括弧内は利用できる短縮キー名):

| オプション | 既定値 | 説明 |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | 出力の大文字小文字: `LOWERCASE` は小文字, `UPPERCASE` は大文字 |
| `toneType` (`tone`) | `WITHOUT_TONE` | 声調形式: `WITHOUT_TONE` は声調なし, `WITH_TONE_NUMBER` は数字声調, `WITH_TONE_MARK` は声調記号 |
| `vCharType` (`v`, `vChar`) | `WITH_V` | `ü` の表記方法: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); 声調記号形式では既定で `WITH_U_UNICODE` に切り替わります |
| `separator` (`sep`) | `""` | 音節間の区切り文字で, 任意の文字列を指定可能; 出力末尾の区切り文字は取り除かれます |

値は大文字小文字を区別せず, `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"` のような短縮エイリアスに対応しています. 不正な値を渡すとローカライズされたメッセージ付きの例外がスローされます.

******

### スクリプト API

******

グローバルオブジェクト `pinyin4j` は次のメソッドを提供します (`pinyin4j(text, options)` の直接呼び出しは `pinyin4j.of` と等価です):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

- `of` は 1 文字ずつ変換します: 基本漢字ブロック (U+4E00-U+9FA5) 内の文字はピンインに変換され, それ以外の文字はそのまま保持されます. 各文字は常に pinyin4j 辞書の最初の読みを取り, 多音字の曖昧性解消は行いません.
- `of` の第 2 引数にはオプションオブジェクトのほか, 区切り文字として文字列を直接渡すこともできます.
- `as` はテキスト中の数字声調音節 (例: `han4`) を声調記号形式 (例: `hàn`) に置き換えます. `v` や `u:` で表記された `ü` にも対応し, 認識できない断片はそのまま保持されます. このメソッドはプラグイン AIDL インターフェースの `asTone` に対応します.
- オプションの値は大文字小文字を区別せず複数の短縮形に対応します (上の `オプション` を参照). 不正な値はローカライズされたメッセージ付きの例外をスローします.
- すべてのメソッドは同期的に返り, 初期化の待機は不要です.

******

### クイックセルフチェック

******

プラグインをインストールして有効にした後, 次の 1 行スクリプトを実行します:

```javascript
console.log(pinyin4j.of("拼音"));
```

`pinyin` と出力されればプラグインは正常に動作しています.

******

### よくある質問

******

#### プラグインが有効になったことをどう確認できますか?

AutoJs6 のプラグインセンターを開き, `Pinyin4j` プラグインが表示されて有効な状態であればホストに認識されています. 続いて上の `クイックセルフチェック` スクリプトを実行し, `pinyin` と出力されれば有効です.

#### スクリプトでプラグインが見つからない, または `pinyin4j` が利用できないというエラーが出ます?

AutoJs6 の内部ビルドが 3923 以上であること, そしてプラグインセンターでプラグインのインストール, 許可, 有効化が完了していることを確認してください. AutoJs6 v6.8.0 以降, ホストは pinyin4j ライブラリを内蔵しなくなり, 関連機能は完全に本プラグインが担います.

#### アプリ一覧やホーム画面にプラグインのアイコンがないのはなぜですか?

正常な動作です. プラグインには独立した画面がなく, ホーム画面にランチャーアイコンも作成しません. インストール後は AutoJs6 がバックグラウンドで自動的に検出して呼び出し, すべての操作は AutoJs6 内で完結します.

#### 多音字の読みが期待どおりではありません (例: "重庆" が chongqing と読まれない)?

本プラグインは単字単位で変換し, 各文字は常に辞書の最初の読みを取り, 語句の文脈による曖昧性解消は行いません. これは軽量方式ならではのトレードオフです. 多音字の曖昧性解消, 語句辞書, 姓の読みが必要な場合は, 姉妹プラグイン [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) をご利用ください.

#### ドキュメントや古いスクリプトにある `pinyin4j.asTone(text)` が使えないのはなぜですか?

ホスト側でのこのメソッドの名前は `pinyin4j.as(text)` です. `asTone` はプラグイン AIDL インターフェースにおけるメソッド名で, 両者の動作は同一です. スクリプトでは `pinyin4j.as(text)` を使用してください.

#### プラグインはネットワークにアクセスしたり機密性の高い権限を要求したりしますか?

いいえ. 変換データはインストールパッケージに内蔵され, 変換は端末ローカルで完結します. プラグインのマニフェストは AutoJs6 との通信に必要なプラグイン権限のみを宣言し, ネットワークやストレージなどの機密性の高いシステム権限は一切要求しません.

#### 姉妹プラグイン Pinyin とはどう使い分ければよいですか?

軽量な 1 文字ごとの注音だけが必要でインストールパッケージのサイズを重視する場合は本プラグインを, 多音字, 分かち書き, 語句, 姓の読みが必要な場合は [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) を選んでください. 両者は競合せず同時にインストールでき, 詳しくは下の `姉妹プラグイン比較` を参照してください.

******

### 権限とセキュリティ

******

プラグインは設計上, データ面と権限面を可能な限り狭めています:

- 最小権限: プラグインのマニフェストは AutoJs6 プラグイン権限 (`org.autojs.permission.PLUGIN`) のみを宣言し, ネットワーク, ストレージ, カメラなどの機密性の高いシステム権限を一切要求しません.
- ローカル変換: 変換対象のテキストは Binder を介して端末内だけで受け渡され, 変換データはすべて内蔵で, 全過程がオフラインで完結し, データが端末の外に出ることはありません.
- 署名と許可: AutoJs6 はプラグインの署名を検証し, プラグインはプラグインセンターで許可されて有効になった後にのみスクリプトから呼び出せます. サービスとウェイクエントリはいずれもプラグイン権限で保護され, サードパーティアプリから直接呼び出せません.
- オープンで監査可能: プラグインコードとドキュメント生成パイプラインはすべてオープンソースで, 変換機能は広く使われているオープンソースライブラリ pinyin4j によるものです.

プラグインのインストールパッケージは公式の [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) ページまたは AutoJs6 のプラグインセンターからのみ入手してください. 出所不明のパッケージは, 名前とバージョン番号が同じでも改ざんされている可能性があります.

******

### 姉妹プラグイン比較

******

AutoJs6 は公式に 2 つのピンインプラグインを提供しており, それぞれ重点が異なり, 同時にインストールできます:

| 比較項目 | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| 基盤実装 | 定番の Java ライブラリ `pinyin4j` | 内蔵辞書 + Jieba 分かち書き |
| グローバルオブジェクト | `pinyin4j` | `pinyin` |
| 多音字 | 非対応, 常に最初の読みを取得 | 対応, 全候補を返却可能 |
| 分かち書きと語句 | 非対応, 1 文字ずつ変換 | 対応 (語句辞書 + Jieba) |
| 姓モード | 非対応 | 対応 |
| 出力形式 | 文字列, 区切り文字を設定可能 | 2 次元候補配列 (`compact()` で組み合わせ可能) またはコンパクト文字列 |
| スタイルと形式 | 3 つの声調形式 + 大文字小文字 + `ü` の表記方法 | 6 種類のピンインスタイル |
| インストールパッケージサイズ | 約 0.3 MB | 約 6 MB (内蔵辞書) |
| 適した用途 | サイズとシンプルさ優先: 高速な 1 文字ごとの注音 | 読みの正確性優先: 多音字, 語句, 人名 |

2 つのプラグインは互いに依存せず競合もしません. 同時にインストールすれば, スクリプトから必要に応じて `pinyin4j` と `pinyin` をそれぞれ呼び出せます. Pinyin プラグインの詳細は [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) を参照してください.

******

### プラグインインターフェース

******

以下の情報は AutoJs6 ホストとプラグイン開発者向けです. ホストはこれらの識別子でプラグインを検出し, 機能ネゴシエーションを行います:

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

`Pinyin4jPluginService` は `org.autojs.plugin.PINYIN4J` action (category `pinyin4j`) に応答し, AIDL インターフェース `IPinyin4jPlugin` を通じて 3 つのメソッドを公開します. `of` のオプションは `Bundle` で渡され (キー: `caseType` / `toneType` / `vCharType` / `separator`), 不正な値はローカライズされたメッセージ付きの `IllegalArgumentException` をスローします. サービスと `WakeActivity` はいずれも `org.autojs.permission.PLUGIN` 権限で保護され, サードパーティアプリから直接呼び出せません.

******

### 開発ロードマップ

******

プラグインの機能計画と完了状況は, マイルストーンごとに受け入れ条件付きで整理されたチェック可能なリストとして ROADMAP.md で管理されています. 複数読みの照会, さらなるローマ字化体系, 文字カバー範囲, 継続的インテグレーションなどを扱います. 未チェックの項目は計画中の意向であり, 現行バージョンの機能ではありません. Issues での議論を歓迎します.

- [ROADMAP.md を見る](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### リリース履歴

******

#### v1.1.0

_2026/09/01_

- `修正` 空白以外の区切り文字が出力末尾に残る問題を修正し, 先頭と末尾の空白を含む非漢字を正確に保持
- `修正` pinyin4j 2.5.1 が第三声母音に用いる旧来の breve を標準の caron 形式へ統一 (例: `yŭ` から `yǔ`), 大文字と小文字の両方に対応
- `改善` オプションの正式名と別名, 値の短縮形, 出力組み合わせ, 既定値, 例外, 声調変換, ランタイムメタデータを対象とする JVM 単体テストと, 実サービス検出および Binder 往復を検証する Android instrumentation テストを追加
- `改善` 生成文書のずれを拒否し, 単体テスト, debug APK ビルド, instrumentation テストのコンパイル, APK 成果物のアップロードを行う GitHub Actions ワークフローを追加
- `改善` 署名済み universal APK のビルドと検証, バージョン確認, CRC32 と SHA-256 の計算, `SHA256SUMS.txt` と英語版 `RELEASE_NOTES.md` のアトミック生成を一括実行する `.python/prepare_release.py` を追加
- `改善` README のレイアウトと Gradle プラットフォームのバージョン管理方式を統一

#### v1.0.1

_2026/08/31_

- `ヒント` 本バージョンはドキュメントと付随ツールの改善のみで, ピンイン変換の動作とすべてのスクリプト API は変わりません
- `修正` 旧版ドキュメントの誤った `pinyin4j.asTone(text)` 表記を修正: ホストが実際に公開するメソッドは `pinyin4j.as(text)` です (基盤の AIDL インターフェースメソッド名は引き続き `asTone`)
- `改善` 10 言語の README を再構成: 使用方法, クイックスタート, オプション早見表, スクリプト API, クイックセルフチェック, よくある質問, 権限とセキュリティ, 姉妹プラグイン比較, プラグインインターフェースなどの章を追加
- `改善` ドキュメント生成スクリプトを同系プラグインで統一された実装へ更新: `--check` によるドリフト検出, 言語間のキーと形状の整合検証, 全角記号の排除, バージョン整合の検証に対応
- `改善` プラグインセンターの使用説明 (`plugin_instruction.md`) を同じ多言語 JSON 生成パイプラインに統合し, 二重ソース保守を解消
- `改善` ROADMAP.md 開発ロードマップを追加し, 姉妹プラグイン Pinyin との双方向リンクと選択比較を確立

#### v1.0.0

_2026/07/15_

- `追加` Pinyin4j プラグインサービス: プラグイン ID は `pinyin4j` で, AutoJs6 が `org.autojs.plugin.PINYIN4J` により自動検出して呼び出し, `com.belerweb:pinyin4j:2.5.1` ライブラリをラップ
- `追加` ピンイン変換 API: `pinyin4j.of(text, options)` が中国語を 1 文字ずつ漢語ピンインに変換し, 第 2 引数に文字列を渡すとそのまま区切り文字として使用
- `追加` 声調復元 API: `pinyin4j.as(text)` が数字声調ピンイン (例: `han4`) を声調記号ピンイン (例: `hàn`) に復元し, AIDL インターフェースメソッド `asTone` に対応
- `追加` 柔軟なオプション体系: `case` / `tone` / `v` / `sep` などのエイリアスと `MARK` / `NUMBER` / `NO` などの値の短縮形に対応し, 不正な値にはローカライズされたエラーメッセージをスロー
- `追加` 多言語リソース: プラグイン情報と使用説明が 10 言語をカバー
- `追加` README と CHANGELOG は JSON ソースファイルと `.python/generate_markdown.py` から多言語 Markdown として生成

##### その他のリリース履歴は以下を参照

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-ja.md)

******

### ビルド

******

この節はソースからプラグインをビルドしたい開発者向けです.

debug APK をビルド:

```powershell
.\gradlew.bat :app:assembleDebug
```

release APK をビルド (単一の汎用パッケージ; バージョン管理外の `sign.properties` に署名を設定すると自動的に署名されます):

```powershell
.\gradlew.bat :app:assembleRelease
```

検証済みリリースアーカイブを生成するには `py .python/prepare_release.py` を実行します. 生成文書の検査, 署名済み universal APK のビルドと検証, バージョンメタデータの確認, CRC32 と SHA-256 の計算を行い, APK, `SHA256SUMS.txt`, 英語版 `RELEASE_NOTES.md` を `app/releases/v<バージョン>` にアトミックに書き込みます.

ビルドパラメータは `version.properties` に集約されています: 最小 SDK 24 (Android 7.0), ターゲット SDK 36, 現在のバージョン 1.1.0.

******

### ローカライズとドキュメント生成

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

`strings.xml` はローカライズされたプラグイン説明とエラーメッセージを, `plugin_instruction.md` はホストのプラグインセンターに表示される使用説明を提供します. README, 更新履歴, 使用説明はすべて JSON ソースから生成されます: `.readme/` と `.changelog/` 配下のソースを編集した後, `py .python/generate_markdown.py` を実行して全成果物を再生成してください. 生成物は手動で編集しません. `py .python/generate_markdown.py --check` でソースと成果物の同期を検証できます.

******

### ライセンス

******

プロジェクトコードは [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE) の下でライセンスされています. ピンイン変換機能は [pinyin4j](https://github.com/belerweb/pinyin4j) ライブラリ (`com.belerweb:pinyin4j:2.5.1`) によるものです.

******

### 関連リンク

******

- AutoJs6 Pinyin4j ドキュメント: https://docs.autojs6.com/#/pinyin4j
- AutoJs6 プロジェクト: https://github.com/SuperMonster003/AutoJs6
- 姉妹プラグイン Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- pinyin4j プロジェクト: https://github.com/belerweb/pinyin4j
- pinyin4j Maven 座標: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

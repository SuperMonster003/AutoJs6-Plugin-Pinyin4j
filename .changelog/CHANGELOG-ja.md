******

### リリース履歴

******

# v1.0.0

###### 2026/07/15

* `追加` プラグイン ID `pinyin4j`, エンジン `pinyin4j` の Pinyin4j プラグインサービスを追加, `com.belerweb:pinyin4j` を基盤に構築
* `追加` `org.autojs.plugin.PINYIN4J` によるホストからの検出と呼び出しを追加
* `追加` `pinyin4j.of(text, options)` による中国語テキストから漢語ピンインへの変換を追加, 大文字小文字, 声調タイプ, `ü` の表記, 区切り文字を設定可能
* `追加` `pinyin4j.asTone(text)` による数字声調ピンインから声調記号付きピンインへの変換を追加
* `追加` スペイン語/フランス語/ロシア語/アラビア語/日本語/韓国語/英語/簡体字中国語/香港繁体字/台湾繁体字のプラグインメタデータと使用説明を追加
* `追加` `.python/generate_markdown.py` による JSON ベースの README と CHANGELOG 生成を追加

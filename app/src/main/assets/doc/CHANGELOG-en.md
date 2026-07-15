# v1.0.0

###### 2026/07/15

* `Feature` Added the Pinyin4j plugin service with plugin ID `pinyin4j` and engine `pinyin4j`, built on `com.belerweb:pinyin4j`
* `Feature` Added host discovery and invocation through `org.autojs.plugin.PINYIN4J`
* `Feature` Supported `pinyin4j.of(text, options)` for converting Chinese text to Hanyu Pinyin with configurable case type, tone type, `ü` representation, and separator
* `Feature` Supported `pinyin4j.asTone(text)` for converting tone-number pinyin to tone-mark pinyin
* `Feature` Added localized plugin metadata and usage instructions for Spanish, French, Russian, Arabic, Japanese, Korean, English, Simplified Chinese, Hong Kong Traditional Chinese, and Taiwan Traditional Chinese
* `Feature` Added JSON-driven README and CHANGELOG generation through `.python/generate_markdown.py`

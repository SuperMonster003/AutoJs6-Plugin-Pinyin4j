# v1.3.0

###### 2026/09/01

* `Hint` `pinyin4j.readings()` and the Node.js provider require an updated AutoJs6 host containing the readings v1 contract; older hosts can continue using `of` and `as`
* `Added` `pinyin4j.readings(text, options)` returns every ordered dictionary pronunciation in one row per Unicode code point, with unmapped input preserved as a single candidate
* `Added` `romanization` / `system` exposes Hanyu, Tongyong, Wade-Giles, MPS2, Yale and Gwoyeu Romatzyh; Hanyu supports numeric, marked or omitted tones, letter case and `ü` forms
* `Improved` Appended the Binder `readings` transaction and integer capability `pinyin4j.readings.version = 1`; new hosts call it only after negotiation and safely fall back to one Hanyu candidate per code point for old plugins
* `Improved` Added strict source, matrix and UTF-8 JSON limits plus Android 9/12/13/15 Binder coverage; the same plugin capability is available to Node.js through the host's explicit `pinyin4j` capability

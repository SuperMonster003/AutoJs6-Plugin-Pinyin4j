# v1.0.0

###### 2026/07/15

* `Ajout` Ajout du service de plugin Pinyin4j avec l ID de plugin `pinyin4j` et le moteur `pinyin4j`, base sur `com.belerweb:pinyin4j`
* `Ajout` Ajout de la decouverte et de l invocation par l hote via `org.autojs.plugin.PINYIN4J`
* `Ajout` Prise en charge de `pinyin4j.of(text, options)` pour convertir le texte chinois en pinyin Hanyu avec casse, type de ton, representation de `ü`, et separateur configurables
* `Ajout` Prise en charge de `pinyin4j.asTone(text)` pour convertir le pinyin avec numeros de ton en pinyin avec marques de ton
* `Ajout` Ajout de metadonnees de plugin et d instructions d utilisation localisees en espagnol/francais/russe/arabe/japonais/coreen/anglais/chinois simplifie/chinois traditionnel de Hong Kong/chinois traditionnel de Taiwan
* `Ajout` Ajout de la generation README et CHANGELOG pilotee par JSON via `.python/generate_markdown.py`

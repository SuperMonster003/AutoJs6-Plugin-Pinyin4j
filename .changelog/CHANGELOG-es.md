******

### Historial de versiones

******

# v1.0.0

###### 2026/07/15

* `Nuevo` Se agrego el servicio de plugin Pinyin4j con ID de plugin `pinyin4j` y motor `pinyin4j`, basado en `com.belerweb:pinyin4j`
* `Nuevo` Se agrego descubrimiento e invocacion desde el host mediante `org.autojs.plugin.PINYIN4J`
* `Nuevo` Se admitio `pinyin4j.of(text, options)` para convertir texto chino a pinyin Hanyu con tipo de mayusculas/minusculas, tipo de tono, representacion de `ü`, y separador configurables
* `Nuevo` Se admitio `pinyin4j.asTone(text)` para convertir pinyin con numeros de tono a pinyin con marcas de tono
* `Nuevo` Se agregaron metadatos del plugin e instrucciones de uso localizadas en espanol/frances/ruso/arabe/japones/coreano/ingles/chino simplificado/chino tradicional de Hong Kong/chino tradicional de Taiwan
* `Nuevo` Se agrego generacion de README y CHANGELOG basada en JSON mediante `.python/generate_markdown.py`

******

### Historial De Versiones

******

# v1.1.0

###### 2026/09/01

* `Corrección` Se eliminó el separador final producido por separadores que no son espacios y ahora se conservan exactamente los caracteres no chinos, incluidos los espacios iniciales y finales
* `Corrección` Se normalizaron las vocales de tercer tono con breve heredadas de pinyin4j 2.5.1 a las formas estándar con caron (por ejemplo, `yŭ` a `yǔ`), tanto en minúsculas como en mayúsculas
* `Mejora` Se añadieron pruebas unitarias JVM para nombres y alias de opciones, abreviaturas de valores, combinaciones de salida, valores predeterminados, errores, conversión de tonos y metadatos de ejecución, además de pruebas Android instrumentation para el descubrimiento real del servicio y recorridos Binder
* `Mejora` Se añadieron flujos de GitHub Actions que rechazan diferencias en documentos generados, ejecutan pruebas unitarias, compilan el APK debug y las pruebas instrumentation, y suben el APK resultante
* `Mejora` Se añadió `.python/prepare_release.py` para compilar y verificar un APK universal firmado, validar la versión, calcular CRC32 y SHA-256, y generar de forma atómica `SHA256SUMS.txt` y `RELEASE_NOTES.md` en inglés
* `Mejora` Unificar el diseño del README y la gestión de versiones de la plataforma Gradle

# v1.0.1

###### 2026/08/31

* `Pista` Esta versión solo mejora la documentación y las herramientas asociadas; el comportamiento de conversión a pinyin y todas las API de script permanecen sin cambios
* `Corrección` Se corrigió el uso erróneo `pinyin4j.asTone(text)` presente en documentos antiguos: el host en realidad expone `pinyin4j.as(text)` (el método AIDL subyacente sigue llamándose `asTone`)
* `Mejora` Se reelaboró el README en 10 idiomas: se añadieron secciones de uso, inicio rápido, tabla de referencia de opciones, API de script, autocomprobación, preguntas frecuentes, permisos y seguridad, comparación de plugins hermanos e interfaz del plugin
* `Mejora` Se actualizó el generador de docs a la implementación unificada compartida entre plugins hermanos: detección de desviaciones con `--check`, validación de claves y formas entre idiomas, rechazo de símbolos de ancho completo y comprobaciones de alineación de versiones
* `Mejora` Se incorporaron las instrucciones del centro de plugins (`plugin_instruction.md`) a la misma cadena de generación JSON multilingüe, eliminando el mantenimiento de fuentes duplicadas
* `Mejora` Se añadió la hoja de ruta ROADMAP.md y se establecieron referencias cruzadas bidireccionales y una comparación con el plugin hermano Pinyin

# v1.0.0

###### 2026/07/15

* `Función` Servicio del plugin Pinyin4j: ID de plugin `pinyin4j`, descubierto e invocado automáticamente por AutoJs6 mediante `org.autojs.plugin.PINYIN4J`, envolviendo la biblioteca `com.belerweb:pinyin4j:2.5.1`
* `Función` API de conversión: `pinyin4j.of(text, options)` convierte texto chino a pinyin Hanyu carácter por carácter; pasar una cadena como segundo argumento la usa directamente como separador
* `Función` API de restauración de tonos: `pinyin4j.as(text)` restaura pinyin con tonos numéricos (como `han4`) a pinyin con marcas de tono (como `hàn`), respaldado por el método AIDL `asTone`
* `Función` Opciones flexibles: alias como `case` / `tone` / `v` / `sep` y atajos de valores como `MARK` / `NUMBER` / `NO`, con errores localizados al pasar valores no válidos
* `Función` Recursos multilingües: metadatos del plugin e instrucciones disponibles en 10 idiomas
* `Función` README y CHANGELOG generados como Markdown multilingüe desde fuentes JSON mediante `.python/generate_markdown.py`

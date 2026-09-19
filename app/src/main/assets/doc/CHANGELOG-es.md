******

### Historial De Versiones

******

# v1.3.2

###### 2026/09/19

* `Corrección` Advertencias de lectura de SDK XML v4 con AGP 9.1 y comprobaciones de alineación nativa de APK activadas por error al ensamblar pruebas unitarias JVM, mediante los plugins de compilación compartidos 1.8.3
* `Mejora` compileSdk y targetSdk suben a 37 (Android 17); el comportamiento del plugin no depende del nuevo objetivo

# v1.3.1

###### 2026/09/13

* `Corrección` Mantener la fecha de versión del complemento en inglés sin depender del idioma del equipo de compilación
* `Mejora` Recursos traducidos coherentes, activación explícita del complemento y validación de los paquetes de publicación

# v1.3.0

###### 2026/09/11

* `Aviso` `pinyin4j.readings()` y el provider de Node.js requieren un host AutoJs6 actualizado con el contrato readings v1; los hosts antiguos pueden seguir usando `of` y `as`
* `Función` `pinyin4j.readings(text, options)` devuelve todas las pronunciaciones ordenadas del diccionario en una fila por punto de código Unicode, conservando entradas sin mapeo como candidato único
* `Función` `romanization` / `system` expone Hanyu, Tongyong, Wade-Giles, MPS2, Yale y Gwoyeu Romatzyh; Hanyu admite tonos numéricos, marcados u omitidos, mayúsculas/minúsculas y formas de `ü`
* `Mejora` Se añadió al final la transacción Binder `readings` y la capacidad entera `pinyin4j.readings.version = 1`; los hosts nuevos solo la llaman tras negociar y recurren con seguridad a un candidato Hanyu por punto para plugins antiguos
* `Mejora` Se añadieron límites estrictos de fuente, matriz y JSON UTF-8 junto con cobertura Binder en Android 9/12/13/15; la misma capacidad se ofrece a Node.js mediante la capacidad explícita `pinyin4j` del host
* `Mejora` La verificación de compilación rechaza dependencias nativas accidentales y genera un informe JSON

# v1.2.0

###### 2026/09/01

* `Aviso` Las pronunciaciones múltiples y los seis sistemas de romanización existen por ahora solo como núcleo probado del plugin y propuesta de contrato; `pinyin4j.readings()` no será una API pública de scripts hasta actualizar el AIDL y las rutas del host AutoJs6
* `Corrección` `of` ya no descarta los huecos del diccionario ni divide caracteres de planos suplementarios: ahora recorre puntos de código Unicode, convierte cada entrada real incluido `〇`, conserva intacta toda entrada sin mapeo y alinea los separadores con los puntos de código
* `Corrección` `pinyin4j.as(text)` ahora convierte solo sílabas numéricas completas y válidas, conserva fragmentos no válidos o incrustados en texto alfanumérico, maneja mayúsculas y minúsculas junto con `v` / `u:` / `ü`, y trata correctamente grafías `ue` simples como `jue4` -> `juè`
* `Mejora` Se fijó la cobertura real del diccionario con una prueba BMP exhaustiva: 20,378 mapeos, 20,377 en U+4E00-U+9FA5 y el restante para `〇`; también se comprueban los 525 huecos del rango anterior y una huella SHA-256 del corpus
* `Mejora` Se añadió un núcleo probado con todos los candidatos para Hanyu, Tongyong, Wade-Giles, MPS2, Yale y Gwoyeu Romatzyh, más una propuesta documentada de AIDL JSON aditivo, negociación de capacidad y retorno a la implementación anterior
* `Mejora` Se añadió un registro de riesgos de pinyin4j 2.5.1 con hashes del binario y las fuentes, hallazgos sobre el upstream y los metadatos de licencia, límites conocidos y puertas para actualizar o crear un fork
* `Mejora` Se añadieron bases reproducibles de rendimiento JVM y del punto de entrada Android Service/AIDL, un analizador ZIP/de recursos del release APK y una comparación para elegir plugin basada en mediciones

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

* `Aviso` Esta versión solo mejora la documentación y las herramientas asociadas; el comportamiento de conversión a pinyin y todas las API de script permanecen sin cambios
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

<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin Pinyin4j para convertir chino a pinyin Hanyu</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Pinyin4j?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Idiomas (Languages)

******

El README.md actual admite los siguientes idiomas:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- Español [es] # actual
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### Introducción

******

El plugin Pinyin4j aporta a AutoJs6 una romanización ligera carácter por carácter. Los scripts pueden producir una cadena Hanyu Pinyin formateada, consultar todas las pronunciaciones del diccionario como matriz alineada por puntos de código Unicode en Hanyu, Tongyong, Wade-Giles, MPS2, Yale o Gwoyeu Romatzyh, y convertir tonos numéricos en marcas de tono.

El plugin es un APK que se instala por separado y se ejecuta en su propio proceso; AutoJs6 lo descubre automáticamente mediante el mecanismo de plugins y se comunica con él por AIDL. La conversión proviene de la clásica biblioteca Java [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), el release medido ocupa solo 376 KiB y toda la conversión ocurre localmente en el dispositivo, sin red. Desde AutoJs6 v6.8.0, el módulo `pinyin4j` del host lo implementa este plugin.

Este plugin y [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) son plugins hermanos: este ofrece una transcripción carácter por carácter simple y fiable con un tamaño mínimo, mientras que el plugin Pinyin incluye diccionarios completos y segmentación Jieba, con desambiguación de caracteres polifónicos y modo de apellidos para escenarios que priorizan la precisión. Ambos pueden instalarse a la vez; vea `Comparación De Plugins Hermanos` más abajo.

******

### Funciones Destacadas

******

- Listo para usar: AutoJs6 lo descubre automáticamente tras la instalación, sin reiniciar el host; los scripts usan directamente el objeto global `pinyin4j`.
- Extremadamente ligero: el release medido ocupa solo 376 KiB, JVM puro sin bibliotecas nativas, compatible con todas las arquitecturas de CPU.
- Tres formatos de tono: sin tono, tonos numéricos (`han4`) y marcas de tono (`hàn`), a elección.
- Salida flexible: mayúsculas o minúsculas configurables, tres representaciones de `ü` (`lv` / `lu:` / `lü`) y un separador de sílabas arbitrario.
- Utilidad de tonos: `pinyin4j.as(text)` convierte en un solo paso texto con tonos numéricos a la forma con marcas de tono.
- Todas las lecturas y seis sistemas: `pinyin4j.readings(text, options)` devuelve una fila ordenada de candidatos por punto de código Unicode y admite Hanyu, Tongyong, Wade-Giles, MPS2, Yale y Gwoyeu Romatzyh.
- Valores tolerantes: las opciones no distinguen mayúsculas de minúsculas y aceptan varios alias cortos (como `tone: "MARK"`); los valores no válidos producen mensajes de error localizados.
- Totalmente sin conexión: la conversión usa datos incluidos en el paquete y ocurre localmente en el dispositivo, sin ninguna petición de red.
- Multilingüe: metadatos del plugin, instrucciones, README y registro de cambios disponibles en 10 idiomas.

******

### Uso

******

1. Actualice AutoJs6 a la compilación interna 3923 (6.7.1 Alpha4) o superior; desde v6.8.0 las capacidades de pinyin están totalmente delegadas en plugins, por lo que se recomienda la versión más reciente.
2. Descargue el APK del plugin desde la página [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) e instálelo en el dispositivo que ejecuta AutoJs6, o instálelo en línea directamente desde el centro de plugins de AutoJs6.
3. Abra el centro de plugins de AutoJs6, confirme que el plugin `Pinyin4j` está reconocido, concédale la autorización y asegúrese de que está habilitado.
4. Llame al objeto global `pinyin4j` directamente en los scripts siguiendo los ejemplos de `Inicio Rápido` más abajo; también puede ejecutar antes la `Autocomprobación Rápida` para confirmar que el plugin está activo.

> El plugin se distribuye como un único paquete universal (JVM puro, sin variantes de arquitectura de CPU) y admite dispositivos con Android 7.0 (API 24) o superior. No tiene interfaz propia ni crea icono de lanzador; AutoJs6 lo descubre y lo gestiona de forma centralizada.

******

### Inicio Rápido

******

Conversión básica: por defecto produce pinyin en minúsculas y sin tonos; el segundo argumento puede ser directamente un separador:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

Tonos numéricos y representaciones de `ü`:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

Utilidad de tonos: convertir texto con tonos numéricos en marcas de tono:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

Todas las lecturas candidatas y otros sistemas de romanización:

```javascript
console.log(pinyin4j.readings("重A𠀀"));
// [["zhong4", "chong2"], ["A"], ["𠀀"]]

console.log(pinyin4j.readings("间", { system: "WADE_GILES" }));
// [["chien1", "chien4"]]
```

******

### Opciones

******

`pinyin4j.of(text, options)` admite las siguientes opciones (alias cortos entre paréntesis):

| Opción | Predeterminado | Descripción |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | Mayúsculas o minúsculas de salida: `LOWERCASE` minúsculas, `UPPERCASE` mayúsculas |
| `toneType` (`tone`) | `WITHOUT_TONE` | Formato de tono: `WITHOUT_TONE` sin tono, `WITH_TONE_NUMBER` tonos numéricos, `WITH_TONE_MARK` marcas de tono |
| `vCharType` (`v`, `vChar`) | `WITH_V` | Cómo se escribe `ü`: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); con el formato de marcas de tono cambia por defecto a `WITH_U_UNICODE` |
| `separator` (`sep`) | `""` | Separador entre sílabas, cualquier cadena; se elimina el separador sobrante al final de la salida |

Los valores no distinguen mayúsculas de minúsculas y aceptan alias cortos, como `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"`. Pasar un valor no válido lanza una excepción con un mensaje localizado.

******

### API De Script

******

El objeto global `pinyin4j` ofrece los siguientes métodos (llamar directamente a `pinyin4j(text, options)` equivale a `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
pinyin4j.readings(text, options?) -> string[][]
```

- `of` recorre puntos de código Unicode y consulta directamente el diccionario fijado de pinyin4j 2.5.1: convierte los 20,378 caracteres BMP con entrada (incluido `〇`) y conserva intactos los puntos sin entrada o de planos suplementarios. Sigue eligiendo solo la primera pronunciación, sin desambiguación contextual.
- `readings` devuelve un `string[][]` ordenado con una fila por punto de código Unicode. Hanyu usa por defecto minúsculas y tonos numéricos, y admite las opciones case/tone/v existentes; `romanization` (o `system`) selecciona Hanyu, Tongyong, Wade-Giles, MPS2, Yale o Gwoyeu Romatzyh. Los demás sistemas rechazan opciones de formato exclusivas de Hanyu y los separadores no se aplican a matrices.
- AutoJs6 negocia `pinyin4j.readings.version = 1`: los plugins antiguos producen de forma segura filas Hanyu de un solo candidato, mientras que los demás sistemas requieren el plugin nuevo. Node.js puede llamar al mismo provider de forma asíncrona mediante `autojs6:bridge.callAutoJs` con la capacidad explícita `pinyin4j`.
- El segundo argumento de `of` puede ser un objeto de opciones o directamente una cadena usada como separador.
- `as` convierte solo sílabas completas reconocidas con dígitos de tono de `0` a `4`, conserva mayúsculas y minúsculas, y acepta `v`, `u:` o `ü`; las sílabas no válidas, el dígito `5` y los fragmentos pegados a letras o cifras quedan sin cambios. Este método corresponde a `asTone` en la interfaz AIDL del plugin.
- Los valores de las opciones no distinguen mayúsculas de minúsculas y aceptan varios alias cortos (vea `Opciones` más arriba); los valores no válidos lanzan una excepción con un mensaje localizado.
- Todos los métodos devuelven de forma síncrona; la primera conversión carga de forma diferida el diccionario pinyin4j y por ello es más lenta que las llamadas estables, como documenta el benchmark.

******

### Autocomprobación Rápida

******

Tras instalar y habilitar el plugin, ejecute esta única línea:

```javascript
console.log(pinyin4j.of("拼音"));
```

Si imprime `pinyin`, el plugin funciona correctamente.

******

### Preguntas Frecuentes

******

#### ¿Cómo confirmo que el plugin está activo?

Abra el centro de plugins de AutoJs6; si el plugin `Pinyin4j` aparece y está habilitado, el host lo ha reconocido. Luego ejecute el script de `Autocomprobación Rápida` de más arriba; imprimir `pinyin` significa que funciona.

#### ¿Los scripts informan de que falta el plugin o de que `pinyin4j` no está disponible?

Asegúrese de que la compilación interna de AutoJs6 sea al menos 3923, y de que el plugin esté instalado, autorizado y habilitado en el centro de plugins. Desde AutoJs6 v6.8.0 el host ya no incluye la biblioteca pinyin4j; este plugin aporta la capacidad por completo.

#### ¿Por qué no hay icono del plugin en la lista de aplicaciones ni en la pantalla de inicio?

Es lo esperado. El plugin no tiene interfaz propia ni crea icono de lanzador; tras la instalación, AutoJs6 lo descubre y lo invoca en segundo plano, y toda interacción ocurre dentro de AutoJs6.

#### ¿Las pronunciaciones de los polifónicos no son las esperadas (por ejemplo, "重庆" no se lee chongqing)?

`pinyin4j.of` sigue tomando la primera pronunciación de cada carácter. Use `pinyin4j.readings` para obtener todos los candidatos del diccionario, pero no utiliza el contexto de la frase para elegir entre ellos. Para desambiguación contextual, diccionarios de frases o lecturas de apellidos, use el plugin hermano [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### ¿Por qué no funciona `pinyin4j.asTone(text)` de documentos o scripts antiguos?

En el lado del host el método se llama `pinyin4j.as(text)`; `asTone` es el nombre del método en la interfaz AIDL del plugin, y ambos se comportan igual. Use `pinyin4j.as(text)` en los scripts.

#### ¿El plugin accede a la red o solicita permisos sensibles?

No. Los datos de conversión van incluidos en el paquete y la conversión ocurre localmente en el dispositivo; el manifiesto solo declara el permiso de plugin necesario para comunicarse con AutoJs6, sin solicitar red, almacenamiento ni ningún otro permiso sensible del sistema.

#### ¿Cómo elijo entre este plugin y el plugin hermano Pinyin?

Elija este plugin cuando baste una transcripción ligera carácter por carácter o la lista completa de candidatos y le importe el tamaño del paquete; elija [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) cuando necesite desambiguación contextual de polifónicos, segmentación, diccionarios de frases o lecturas de apellidos. No entran en conflicto y pueden instalarse juntos; vea `Comparación De Plugins Hermanos` más abajo.

******

### Permisos Y Seguridad

******

El plugin está diseñado para mantener su superficie de datos y permisos lo más reducida posible:

- Permisos mínimos: el manifiesto solo declara el permiso de plugin de AutoJs6 (`org.autojs.permission.PLUGIN`), sin solicitar red, almacenamiento, cámara ni ningún otro permiso sensible del sistema.
- Conversión local: el texto a convertir solo viaja dentro del dispositivo mediante Binder; los datos de conversión van completamente incluidos, todo ocurre sin conexión y ningún dato sale del dispositivo.
- Firma y autorización: AutoJs6 verifica la firma del plugin, y el plugin debe estar autorizado y habilitado en el centro de plugins antes de que los scripts puedan llamarlo; el servicio y la entrada de activación están protegidos por el permiso de plugin, por lo que las aplicaciones de terceros no pueden invocarlos directamente.
- Abierto y auditable: el código del plugin y la cadena de generación de documentación son totalmente de código abierto, y la conversión proviene de la biblioteca de código abierto ampliamente usada pinyin4j.

Instale el plugin solo desde la página oficial [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) o el centro de plugins de AutoJs6; un paquete de origen desconocido puede estar alterado aunque el nombre y el número de versión parezcan idénticos.

******

### Comparación De Plugins Hermanos

******

AutoJs6 ofrece dos plugins de pinyin oficiales con enfoques distintos; pueden instalarse a la vez:

| Aspecto | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| Implementación subyacente | Biblioteca Java clásica `pinyin4j` | Diccionarios incluidos + segmentación Jieba |
| Objeto global | `pinyin4j` | `pinyin` |
| Polifónicos | Todos los candidatos mediante `readings`, sin desambiguación contextual | Admitido, puede devolver todos los candidatos |
| Segmentación y frases | No admitida, conversión carácter por carácter | Admitida (diccionario de frases + Jieba) |
| Modo de apellidos | No admitido | Admitido |
| Forma de salida | Cadena formateada o matriz de candidatos alineada por Unicode | Arreglo 2D de candidatos (combinable con `compact()`) o cadena compacta |
| Estilos y formatos | 6 sistemas; Hanyu ofrece 3 tonos + mayúsculas/minúsculas + formas de `ü` | 6 estilos de pinyin |
| Tamaño del paquete | 376 KiB ([medición release](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/apk-size-baseline-2026-09-01.md)) | 5.95 MiB ([release full medida](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md), diccionarios incluidos) |
| Perfil de rendimiento | Ruta ligera por carácter; [mediciones JVM/Android](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/conversion-baseline-2026-09-01.md) | [Medición del segmentador](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md); diccionario, segmentación y polifónicos más pesados, variables según el modo |
| Ideal para | Prioriza tamaño y simplicidad: transcripción rápida carácter por carácter | Prioriza la precisión: polifónicos, frases, nombres de persona |

Los dos plugins son independientes y nunca entran en conflicto; con ambos instalados, los scripts pueden llamar a `pinyin4j` y `pinyin` por separado según convenga. Vea [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) para los detalles del plugin Pinyin.

******

### Interfaz Del Plugin

******

La siguiente información está dirigida a los desarrolladores del host AutoJs6 y de plugins; el host usa estos identificadores para descubrir el plugin y negociar capacidades:

```text
application id: io.github.supermonster003.autojs6.plugin.pinyin4j
plugin id: pinyin4j
engine: pinyin4j
variant: default
discovery action: org.autojs.plugin.PINYIN4J
discovery category: pinyin4j
wake action: org.autojs.plugin.action.WAKE
binder interface: IPinyin4jPlugin
binder methods: getInfo / of / asTone / readings
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

`Pinyin4jPluginService` responde a `org.autojs.plugin.PINYIN4J` (categoría `pinyin4j`) y expone 4 métodos mediante `IPinyin4jPlugin`. `readings` se añade al final para conservar el orden de transacciones, devuelve una matriz JSON estrictamente acotada y se anuncia con la capacidad entera `pinyin4j.readings.version = 1`; los hosts antiguos siguen usando `of` y `asTone`. Las opciones inválidas lanzan `IllegalArgumentException`. El servicio y `WakeActivity` están protegidos por `org.autojs.permission.PLUGIN`.

******

### Hoja De Ruta

******

ROADMAP.md registra la evidencia por hitos. M3 se completó en v1.3.0: límites Unicode y de tonos, matrices de todas las lecturas, seis sistemas, negociación AIDL aditiva, rutas Rhino y Node.js y fallback Hanyu para plugins antiguos están implementados y probados. Las bases M4 de riesgo, rendimiento, tamaño y selección siguen completas.

- [Ver ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### Historial De Versiones

******

#### v1.3.1

_2026/09/13_

- `Corrección` Mantener la fecha de versión del complemento en inglés sin depender del idioma del equipo de compilación
- `Mejora` Recursos traducidos coherentes, activación explícita del complemento y validación de los paquetes de publicación

#### v1.3.0

_2026/09/11_

- `Aviso` `pinyin4j.readings()` y el provider de Node.js requieren un host AutoJs6 actualizado con el contrato readings v1; los hosts antiguos pueden seguir usando `of` y `as`
- `Función` `pinyin4j.readings(text, options)` devuelve todas las pronunciaciones ordenadas del diccionario en una fila por punto de código Unicode, conservando entradas sin mapeo como candidato único
- `Función` `romanization` / `system` expone Hanyu, Tongyong, Wade-Giles, MPS2, Yale y Gwoyeu Romatzyh; Hanyu admite tonos numéricos, marcados u omitidos, mayúsculas/minúsculas y formas de `ü`
- `Mejora` Se añadió al final la transacción Binder `readings` y la capacidad entera `pinyin4j.readings.version = 1`; los hosts nuevos solo la llaman tras negociar y recurren con seguridad a un candidato Hanyu por punto para plugins antiguos
- `Mejora` Se añadieron límites estrictos de fuente, matriz y JSON UTF-8 junto con cobertura Binder en Android 9/12/13/15; la misma capacidad se ofrece a Node.js mediante la capacidad explícita `pinyin4j` del host
- `Mejora` La verificación de compilación rechaza dependencias nativas accidentales y genera un informe JSON

#### v1.2.0

_2026/09/01_

- `Aviso` Las pronunciaciones múltiples y los seis sistemas de romanización existen por ahora solo como núcleo probado del plugin y propuesta de contrato; `pinyin4j.readings()` no será una API pública de scripts hasta actualizar el AIDL y las rutas del host AutoJs6
- `Corrección` `of` ya no descarta los huecos del diccionario ni divide caracteres de planos suplementarios: ahora recorre puntos de código Unicode, convierte cada entrada real incluido `〇`, conserva intacta toda entrada sin mapeo y alinea los separadores con los puntos de código
- `Corrección` `pinyin4j.as(text)` ahora convierte solo sílabas numéricas completas y válidas, conserva fragmentos no válidos o incrustados en texto alfanumérico, maneja mayúsculas y minúsculas junto con `v` / `u:` / `ü`, y trata correctamente grafías `ue` simples como `jue4` -> `juè`
- `Mejora` Se fijó la cobertura real del diccionario con una prueba BMP exhaustiva: 20,378 mapeos, 20,377 en U+4E00-U+9FA5 y el restante para `〇`; también se comprueban los 525 huecos del rango anterior y una huella SHA-256 del corpus
- `Mejora` Se añadió un núcleo probado con todos los candidatos para Hanyu, Tongyong, Wade-Giles, MPS2, Yale y Gwoyeu Romatzyh, más una propuesta documentada de AIDL JSON aditivo, negociación de capacidad y retorno a la implementación anterior
- `Mejora` Se añadió un registro de riesgos de pinyin4j 2.5.1 con hashes del binario y las fuentes, hallazgos sobre el upstream y los metadatos de licencia, límites conocidos y puertas para actualizar o crear un fork
- `Mejora` Se añadieron bases reproducibles de rendimiento JVM y del punto de entrada Android Service/AIDL, un analizador ZIP/de recursos del release APK y una comparación para elegir plugin basada en mediciones

##### Para más historial de versiones

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-es.md)

******

### Compilación

******

Esta sección está dirigida a desarrolladores que quieran compilar el plugin desde el código fuente.

Compilar un APK debug:

```powershell
.\gradlew.bat :app:assembleDebug
```

Compilar un APK release (un único paquete universal; se firma automáticamente una vez configurada la firma en el archivo no rastreado `sign.properties`):

```powershell
.\gradlew.bat :app:assembleRelease
```

Para crear un archivo de publicación verificado, ejecute `py .python/prepare_release.py`. El script comprueba los documentos generados, compila y verifica el APK universal firmado, valida los metadatos de versión, calcula CRC32 y SHA-256, y escribe atómicamente el APK, `SHA256SUMS.txt` y el archivo inglés `RELEASE_NOTES.md` en `app/releases/v<versión>`.

Los parámetros de compilación están centralizados en `version.properties`: SDK mínimo 24 (Android 7.0), SDK objetivo 36, versión actual 1.3.1.

******

### Localización Y Generación De Docs

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

`strings.xml` contiene la descripción localizada del plugin y los mensajes de error, y `plugin_instruction.md` contiene las instrucciones mostradas en el centro de plugins del host. README, registro de cambios e instrucciones se generan desde fuentes JSON: edite las fuentes bajo `.readme/` y `.changelog/`, luego ejecute `py .python/generate_markdown.py` para regenerar todos los artefactos; los artefactos generados nunca se editan a mano. Ejecute `py .python/generate_markdown.py --check` para verificar que fuentes y artefactos están sincronizados.

******

### Licencia

******

El código del proyecto está licenciado bajo la [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). La conversión a pinyin proviene de la biblioteca [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`).

******

### Enlaces

******

- Documentación de AutoJs6 Pinyin4j: https://docs.autojs6.com/#/pinyin4j
- Proyecto AutoJs6: https://github.com/SuperMonster003/AutoJs6
- Plugin hermano Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- Proyecto pinyin4j: https://github.com/belerweb/pinyin4j
- Coordenadas Maven de pinyin4j: https://mvnrepository.com/artifact/com.belerweb/pinyin4j


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/16kb.md)

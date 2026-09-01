El plugin Pinyin4j (Pinyin4j Plugin) aporta a AutoJs6 una conversión ligera de chino a pinyin Hanyu. Una vez instalado, los scripts pueden usar el objeto global `pinyin4j` para convertir texto chino a pinyin carácter por carácter, con mayúsculas o minúsculas, formato de tono, representación de `ü` y separador de sílabas configurables; también se incluye un método utilitario que convierte texto con tonos numéricos en marcas de tono.

### Inicio Rápido

Conversión básica: por defecto produce pinyin en minúsculas y sin tonos; el segundo argumento puede ser directamente un separador:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### Opciones

`pinyin4j.of(text, options)` admite las siguientes opciones (alias cortos entre paréntesis):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

Los valores no distinguen mayúsculas de minúsculas y aceptan alias cortos, como `tone: "MARK"` / `"NUMBER"` / `"NO"`; una cadena simple como segundo argumento se trata como separador.

### Autocomprobación Rápida

Tras instalar y habilitar el plugin, ejecute esta única línea:

```javascript
console.log(pinyin4j.of("拼音"));
```

Si imprime `pinyin`, el plugin funciona correctamente.

Para más detalles de uso y opciones, consulte la [documentación de AutoJs6 Pinyin4j](https://docs.autojs6.com/#/pinyin4j) y la [página del proyecto](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

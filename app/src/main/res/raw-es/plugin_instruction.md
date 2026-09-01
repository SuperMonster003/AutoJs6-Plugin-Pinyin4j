El plugin Pinyin4j aporta a AutoJs6 una romanización ligera carácter por carácter. Los scripts pueden producir una cadena Hanyu Pinyin formateada, consultar todas las pronunciaciones del diccionario como matriz alineada por puntos de código Unicode en Hanyu, Tongyong, Wade-Giles, MPS2, Yale o Gwoyeu Romatzyh, y convertir tonos numéricos en marcas de tono.

### Inicio Rápido

Conversión básica: por defecto produce pinyin en minúsculas y sin tonos; el segundo argumento puede ser directamente un separador:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
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

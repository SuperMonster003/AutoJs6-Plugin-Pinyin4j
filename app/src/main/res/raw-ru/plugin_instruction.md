Плагин Pinyin4j добавляет в AutoJs6 легковесную посимвольную романизацию. Скрипты могут формировать строку Hanyu Pinyin, получать все словарные чтения как матрицу по кодовым точкам Unicode в системах Hanyu, Tongyong, Wade-Giles, MPS2, Yale или Gwoyeu Romatzyh и превращать цифровые тоны в тоновые знаки.

### Быстрый Старт

Базовое преобразование: по умолчанию выводится пиньинь строчными буквами без тонов; вторым аргументом можно сразу передать разделитель:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### Параметры

`pinyin4j.of(text, options)` поддерживает следующие параметры (в скобках указаны краткие имена ключей):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

Значения не зависят от регистра и принимают краткие псевдонимы, например `tone: "MARK"` / `"NUMBER"` / `"NO"`; строка, переданная вторым аргументом, считается разделителем.

### Быстрая Самопроверка

После установки и включения плагина выполните этот однострочный скрипт:

```javascript
console.log(pinyin4j.of("拼音"));
```

Если выводится `pinyin`, плагин работает нормально.

Подробности использования и справку по параметрам смотрите в [документации AutoJs6 Pinyin4j](https://docs.autojs6.com/#/pinyin4j) и на [странице проекта](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

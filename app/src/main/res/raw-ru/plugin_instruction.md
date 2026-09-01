Плагин Pinyin4j (Pinyin4j Plugin) добавляет в AutoJs6 легковесное преобразование китайского текста в пиньинь. После установки скрипты могут через глобальный объект `pinyin4j` преобразовывать китайский текст в пиньинь посимвольно, настраивая по необходимости регистр букв, формат тонов, способ записи `ü` и разделитель слогов; также имеется утилитарный метод, превращающий текст с цифровыми тонами в тоновые знаки.

### Быстрый Старт

Базовое преобразование: по умолчанию выводится пиньинь строчными буквами без тонов; вторым аргументом можно сразу передать разделитель:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
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

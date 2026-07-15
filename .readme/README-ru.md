<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Плагин Pinyin4j для преобразования китайского текста в пиньинь Hanyu</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Pinyin4j?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/commit/f8ef60df665f9475af38cca0f7f4a083956d4839"><img alt="Created" src="https://img.shields.io/date/1783216223?color=2e7d32&label=Created"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Языки (Languages)

******

Текущий README.md поддерживает следующие языки:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- Русский [ru] # текущий
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### Введение

******

Плагин AutoJs6 Pinyin4j предоставляет AutoJs6 преобразование китайского текста в пиньинь Hanyu на базе Pinyin4j. Поддерживается вывод без тонов, с номерами тонов, и со знаками тонов.

******

### Возможности

******

- Предоставляет сервис плагина `pinyin4j` с ID плагина `pinyin4j`.
- Поддерживает API AutoJs6, такие как `pinyin4j.of(text, options)` и `pinyin4j.asTone(text)`.
- Поддерживает настройку регистра, типа тона, представления `ü`, и разделителя.
- Метаданные плагина, инструкции по использованию, README и CHANGELOG локализованы на испанский/французский/русский/арабский/японский/корейский/английский/упрощенный китайский/гонконгский традиционный китайский/тайваньский традиционный китайский.
- Основан на `com.belerweb:pinyin4j`.

******

### Использование

******

```js
let text = "汉字转拼音";
console.log(pinyin4j.of(text));
console.log(pinyin4j.of(text, {
    toneType: "WITH_TONE_MARK",
    vCharType: "WITH_U_UNICODE",
    separator: " ",
}));
console.log(pinyin4j.asTone("han4 zi4 zhuan3 pin1 yin1"));
```

******

### Параметры

******

Распространенные параметры включают:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator: any string
```

`pinyin4j.asTone(text)` преобразует пиньинь с номерами тонов в пиньинь со знаками тонов.

******

### История выпусков

******

# v1.0.0

###### 2026/07/15

* `Новое` Добавлен сервис плагина Pinyin4j с ID плагина `pinyin4j` и движком `pinyin4j`, Основан на `com.belerweb:pinyin4j`
* `Новое` Добавлено обнаружение и вызов хостом через `org.autojs.plugin.PINYIN4J`
* `Новое` Поддержан `pinyin4j.of(text, options)` для преобразования китайского текста в пиньинь Hanyu с настраиваемым регистром, типом тона, представлением `ü`, и разделителем
* `Новое` Поддержан `pinyin4j.asTone(text)` для преобразования пиньиня с номерами тонов в пиньинь со знаками тонов
* `Новое` Добавлены локализованные метаданные плагина и инструкции по использованию для испанского/французского/русского/арабского/японского/корейского/английского/упрощенного китайского/гонконгского традиционного китайского/тайваньского традиционного китайского
* `Новое` Добавлена генерация README и CHANGELOG из JSON через `.python/generate_markdown.py`

##### Больше истории выпусков

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.changelog/CHANGELOG-ru.md)

******

### Сборка

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Сборка Release:

```powershell
.\gradlew.bat :app:assembleRelease
```

Параметры сборки берутся из `version.properties`; текущий минимальный SDK равен 24, целевой SDK равен 36.

******

### Структура ресурсов

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` содержит локализованные описания плагина и сообщения об ошибках; `plugin_instruction.md` содержит инструкции по использованию, отображаемые хостом. README и CHANGELOG генерируются из JSON исходников с помощью `.python/generate_markdown.py`.

******

### Ссылки

******

- Документация AutoJs6 Pinyin4j: https://docs.autojs6.com/#/pinyin4j
- Проект Pinyin4j: https://github.com/belerweb/pinyin4j
- Maven координаты Pinyin4j: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

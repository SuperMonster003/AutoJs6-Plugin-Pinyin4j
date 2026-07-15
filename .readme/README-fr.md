<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin Pinyin4j pour convertir le chinois en pinyin Hanyu</p>

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

### Langues (Languages)

******

Le README.md actuel prend en charge les langues suivantes:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- Français [fr] # actuel
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### Introduction

******

Le plugin AutoJs6 Pinyin4j fournit a AutoJs6 une conversion du chinois vers le pinyin Hanyu basee sur Pinyin4j. Il prend en charge une sortie sans tons, avec numeros de ton, et avec marques de ton.

******

### Fonctions

******

- Fournit le service de plugin `pinyin4j` avec l ID de plugin `pinyin4j`.
- Prend en charge les API AutoJs6 comme `pinyin4j.of(text, options)` et `pinyin4j.asTone(text)`.
- Prend en charge la configuration de la casse, du type de ton, de la representation de `ü`, et du separateur.
- Les metadonnees du plugin, les instructions d utilisation, le README et le CHANGELOG sont localises en espagnol/francais/russe/arabe/japonais/coreen/anglais/chinois simplifie/chinois traditionnel de Hong Kong/chinois traditionnel de Taiwan.
- Base sur `com.belerweb:pinyin4j`.

******

### Utilisation

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

### Options

******

Les options courantes incluent:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator: any string
```

`pinyin4j.asTone(text)` convertit le pinyin avec numeros de ton en pinyin avec marques de ton.

******

### Historique des versions

******

# v1.0.0

###### 2026/07/15

* `Ajout` Ajout du service de plugin Pinyin4j avec l ID de plugin `pinyin4j` et le moteur `pinyin4j`, base sur `com.belerweb:pinyin4j`
* `Ajout` Ajout de la decouverte et de l invocation par l hote via `org.autojs.plugin.PINYIN4J`
* `Ajout` Prise en charge de `pinyin4j.of(text, options)` pour convertir le texte chinois en pinyin Hanyu avec casse, type de ton, representation de `ü`, et separateur configurables
* `Ajout` Prise en charge de `pinyin4j.asTone(text)` pour convertir le pinyin avec numeros de ton en pinyin avec marques de ton
* `Ajout` Ajout de metadonnees de plugin et d instructions d utilisation localisees en espagnol/francais/russe/arabe/japonais/coreen/anglais/chinois simplifie/chinois traditionnel de Hong Kong/chinois traditionnel de Taiwan
* `Ajout` Ajout de la generation README et CHANGELOG pilotee par JSON via `.python/generate_markdown.py`

##### Pour plus d historique des versions

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.changelog/CHANGELOG-fr.md)

******

### Construction

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Construction Release:

```powershell
.\gradlew.bat :app:assembleRelease
```

Les parametres de construction viennent de `version.properties`; le SDK minimum actuel est 24 et le SDK cible est 36.

******

### Structure des ressources

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` contient les descriptions du plugin et les messages d erreur localises; `plugin_instruction.md` contient les instructions d utilisation affichees par l hote. README et CHANGELOG sont generes depuis les sources JSON par `.python/generate_markdown.py`.

******

### Liens

******

- Documentation AutoJs6 Pinyin4j: https://docs.autojs6.com/#/pinyin4j
- Projet Pinyin4j: https://github.com/belerweb/pinyin4j
- Coordonnees Maven de Pinyin4j: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

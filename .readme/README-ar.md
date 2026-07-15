<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>مكون Pinyin4j الإضافي لتحويل الصينية إلى بينيين Hanyu</p>

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

### اللغات (Languages)

******

يدعم README.md الحالي اللغات التالية:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- العربية [ar] # الحالي

******

### مقدمة

******

يوفر مكون AutoJs6 Pinyin4j الإضافي تحويل الصينية إلى بينيين Hanyu في AutoJs6 بالاعتماد على Pinyin4j. وهو يدعم الخرج بلا نغمات, وبأرقام النغمات, وبعلامات النغمات.

******

### الميزات

******

- يوفر خدمة المكون الإضافي `pinyin4j` بمعرف المكون `pinyin4j`.
- يدعم واجهات AutoJs6 مثل `pinyin4j.of(text, options)` و `pinyin4j.asTone(text)`.
- يدعم ضبط حالة الأحرف, ونوع النغمة, وتمثيل `ü`, والفاصل.
- تمت ترجمة بيانات المكون الإضافي وتعليمات الاستخدام وREADME وCHANGELOG إلى الإسبانية/الفرنسية/الروسية/العربية/اليابانية/الكورية/الإنجليزية/الصينية المبسطة/الصينية التقليدية في هونغ كونغ/الصينية التقليدية في تايوان.
- مبني على `com.belerweb:pinyin4j`.

******

### الاستخدام

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

### الخيارات

******

تشمل الخيارات الشائعة:

```text
caseType: LOWERCASE, UPPERCASE
toneType: WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType: WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator: any string
```

يحول `pinyin4j.asTone(text)` البينيين ذي أرقام النغمات إلى بينيين ذي علامات النغمات.

******

### سجل الإصدارات

******

# v1.0.0

###### 2026/07/15

* `ميزة` إضافة خدمة مكون Pinyin4j الإضافي بمعرف `pinyin4j` ومحرك `pinyin4j`
* `ميزة` إضافة الاكتشاف والاستدعاء من المضيف عبر `org.autojs.plugin.PINYIN4J`
* `ميزة` دعم `pinyin4j.of(text, options)` لتحويل النص الصيني إلى بينيين Hanyu مع ضبط حالة الأحرف, ونوع النغمة, وتمثيل `ü`, والفاصل
* `ميزة` دعم `pinyin4j.asTone(text)` لتحويل البينيين ذي أرقام النغمات إلى بينيين ذي علامات النغمات
* `ميزة` إضافة بيانات المكون الإضافي وتعليمات الاستخدام المترجمة إلى الإسبانية/الفرنسية/الروسية/العربية/اليابانية/الكورية/الإنجليزية/الصينية المبسطة/الصينية التقليدية في هونغ كونغ/الصينية التقليدية في تايوان
* `ميزة` إضافة إنشاء README وCHANGELOG من JSON عبر `.python/generate_markdown.py`
* `ميزة` مبني على `com.belerweb:pinyin4j`

##### لمزيد من سجل الإصدارات

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.changelog/CHANGELOG-ar.md)

******

### البناء

******

```powershell
.\gradlew.bat :app:assembleDebug
```

بناء Release:

```powershell
.\gradlew.bat :app:assembleRelease
```

تأتي معلمات البناء من `version.properties`; الحد الأدنى الحالي لـ SDK هو 24 والـ SDK المستهدف هو 36.

******

### بنية الموارد

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/assets/doc/CHANGELOG*.md
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

يحتوي `strings.xml` على أوصاف المكون الإضافي ورسائل الخطأ المترجمة; ويحتوي `plugin_instruction.md` على تعليمات الاستخدام التي يعرضها المضيف. يتم إنشاء README وCHANGELOG من مصادر JSON بواسطة `.python/generate_markdown.py`.

******

### الروابط

******

- وثائق AutoJs6 Pinyin4j: https://docs.autojs6.com/#/pinyin4j
- مشروع Pinyin4j: https://github.com/belerweb/pinyin4j
- إحداثيات Maven لـ Pinyin4j: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

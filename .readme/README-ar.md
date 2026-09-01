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
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
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
- العربية [ar] # الحالية

******

### مقدمة

******

يضيف مكون Pinyin4j الإضافي (Pinyin4j Plugin) إلى AutoJs6 قدرة خفيفة لتحويل النص الصيني إلى بينيين Hanyu. بعد التثبيت, يمكن للبرامج النصية عبر الكائن العام `pinyin4j` تحويل النص الصيني إلى بينيين حرفا بحرف, مع ضبط حالة الأحرف وتنسيق النغمة وطريقة كتابة `ü` وفاصل المقاطع حسب الحاجة; كما تتوفر طريقة مساعدة تحول نص النغمات الرقمية إلى علامات النغمة.

المكون الإضافي حزمة APK تثبت بشكل مستقل وتعمل في عمليتها الخاصة; يكتشفها AutoJs6 تلقائيا عبر آلية المكونات الإضافية ويتواصل معها عبر AIDL. تأتي قدرة التحويل من مكتبة Java العريقة [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`); لا يتجاوز حجم release المقاس 349 KiB, ويتم التحويل بكامله محليا على الجهاز دون حاجة إلى الشبكة. ومنذ AutoJs6 v6.8.0, يوفر هذا المكون تنفيذ وحدة `pinyin4j` في المضيف.

هذا المكون و [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) مكونان شقيقان: يقدم هذا المكون بحجم ضئيل جدا نطقا حرفا بحرف بسيطا وموثوقا; بينما يضم مكون Pinyin قواميس كاملة وتقطيع كلمات Jieba, ويدعم إزالة التباس الحروف متعددة النطق ووضع أسماء العائلة, فيناسب الحالات التي تتطلب دقة النطق. يمكن تثبيتهما معا, وللتفاصيل راجع `مقارنة المكونين الشقيقين` أدناه.

******

### أبرز الميزات

******

- جاهز للاستخدام فورا: بعد التثبيت يكتشفه AutoJs6 تلقائيا دون إعادة تشغيل المضيف, وتستخدم البرامج النصية الكائن العام `pinyin4j` مباشرة.
- خفة قصوى: لا يتجاوز حجم release المقاس 349 KiB, بتنفيذ JVM خالص دون أي مكتبات أصلية, ويلائم جميع معماريات CPU.
- ثلاثة تنسيقات للنغمة: بدون نغمات, ونغمات رقمية (`han4`), وعلامات النغمة (`hàn`), حسب الحاجة.
- إخراج مرن: يمكن ضبط حالة الأحرف, وثلاث طرق لكتابة `ü` (`lv` / `lu:` / `lü`), وأي فاصل للمقاطع.
- أداة النغمات: تحول `pinyin4j.as(text)` نص النغمات الرقمية إلى صيغة علامات النغمة بخطوة واحدة.
- قيم متسامحة: الخيارات غير حساسة لحالة الأحرف وتقبل عدة أسماء مختصرة (مثل `tone: "MARK"`), والقيم غير الصالحة تعطي رسائل خطأ مترجمة.
- دون اتصال بالكامل: يعتمد التحويل على بيانات مضمنة وينفذ محليا على الجهاز, دون إرسال أي طلبات شبكة.
- متعدد اللغات: بيانات المكون الإضافي, والتعليمات, و README, وسجل التغييرات متوفرة بعشر لغات.

******

### الاستخدام

******

1. قم بترقية AutoJs6 إلى البنية الداخلية 3923 (6.7.1 Alpha4) أو أعلى; فمنذ v6.8.0 تتولى المكونات الإضافية قدرات البينيين بالكامل, وينصح باستخدام أحدث إصدار مباشرة.
2. نزل حزمة APK الخاصة بالمكون من صفحة [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) وثبتها على الجهاز الذي يشغل AutoJs6, أو ثبتها مباشرة عبر الإنترنت من مركز المكونات الإضافية في AutoJs6.
3. افتح مركز المكونات الإضافية في AutoJs6, وتأكد من أن مكون `Pinyin4j` معروف, وأكمل منحه الإذن وأنه في حالة تفعيل.
4. استدع الكائن العام `pinyin4j` مباشرة في البرامج النصية مسترشدا بأمثلة `البدء السريع` أدناه; ويمكنك أولا تشغيل `الفحص الذاتي السريع` للتأكد من عمل المكون.

> يوفر المكون الإضافي حزمة تثبيت عامة واحدة فقط (تنفيذ JVM خالص دون تمييز بين معماريات CPU), ويدعم الأجهزة العاملة بنظام Android 7.0 (واجهة API 24) وما فوق. لا يملك المكون واجهة مستقلة ولا ينشئ أيقونة على الشاشة الرئيسية بعد التثبيت, ويتولى AutoJs6 اكتشافه وإدارته مركزيا.

******

### البدء السريع

******

التحويل الأساسي: يخرج افتراضيا بينيين بأحرف صغيرة دون نغمات, ويمكن تمرير الفاصل مباشرة كمعامل ثان:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

النغمات الرقمية وطرق كتابة `ü`:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

أداة النغمات: تحويل نص النغمات الرقمية إلى علامات النغمة:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

******

### الخيارات

******

تدعم `pinyin4j.of(text, options)` الخيارات التالية (بين القوسين أسماء المفاتيح المختصرة المتاحة):

| الخيار | القيمة الافتراضية | الوصف |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | حالة أحرف الإخراج: `LOWERCASE` صغيرة, و `UPPERCASE` كبيرة |
| `toneType` (`tone`) | `WITHOUT_TONE` | تنسيق النغمة: `WITHOUT_TONE` بدون نغمات, و `WITH_TONE_NUMBER` نغمات رقمية, و `WITH_TONE_MARK` علامات النغمة |
| `vCharType` (`v`, `vChar`) | `WITH_V` | طريقة كتابة `ü`: `WITH_V` (`lv`), و `WITH_U_AND_COLON` (`lu:`), و `WITH_U_UNICODE` (`lü`); وفي تنسيق علامات النغمة يتحول الافتراضي إلى `WITH_U_UNICODE` |
| `separator` (`sep`) | `""` | الفاصل بين المقاطع, ويقبل أي سلسلة; ويحذف الفاصل الزائد في نهاية الإخراج |

القيم غير حساسة لحالة الأحرف وتقبل أسماء مختصرة, مثل `tone: "MARK"` / `"NUMBER"` / `"NO"`, و `case: "UP"` / `"LOW"`, و `v: "V"` / `"U:"` / `"U"`. وتمرير قيمة غير صالحة يرمي استثناء برسالة مترجمة.

******

### واجهة برمجة النصوص

******

يوفر الكائن العام `pinyin4j` الطرق التالية (استدعاء `pinyin4j(text, options)` مباشرة يكافئ `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

- تمر `of` على نقاط ترميز Unicode وتستعلم مباشرة من قاموس pinyin4j 2.5.1 المثبت: تتحول كل أحرف BMP ذات المدخلات وعددها 20,378 (ومنها `〇`), وتبقى النقاط غير المدرجة أو الواقعة في المستويات الإضافية كاملة كما هي. ويظل الاختيار للنطق الأول فقط دون إزالة الالتباس بحسب السياق.
- المعامل الثاني لـ `of` قد يكون كائن خيارات, أو سلسلة تمرر مباشرة لتستخدم فاصلا.
- تحول `as` فقط المقاطع الكاملة المعروفة ذات أرقام النغمات من `0` إلى `4`, وتحافظ على حالة الأحرف, وتقبل `v` أو `u:` أو `ü`; وتبقى المقاطع غير الصالحة والرقم `5` والأجزاء الملاصقة للحروف أو الأرقام كما هي. وتقابل هذه الطريقة `asTone` في واجهة AIDL الخاصة بالمكون.
- قيم الخيارات غير حساسة لحالة الأحرف وتقبل عدة اختصارات (انظر `الخيارات` أعلاه), والقيم غير الصالحة ترمي استثناء برسالة مترجمة.
- جميع الطرق تعيد النتيجة بشكل متزامن; ويحمل التحويل الأول قاموس pinyin4j عند الطلب لذلك يكون أبطأ من الاستدعاءات المستقرة, كما هو موثق في اختبار الأداء.

******

### الفحص الذاتي السريع

******

بعد تثبيت المكون وتفعيله, شغل هذا البرنامج النصي المكون من سطر واحد:

```javascript
console.log(pinyin4j.of("拼音"));
```

ظهور `pinyin` في الإخراج يعني أن المكون يعمل بشكل صحيح.

******

### الأسئلة الشائعة

******

#### كيف أتأكد من أن المكون الإضافي يعمل?

افتح مركز المكونات الإضافية في AutoJs6; رؤية مكون `Pinyin4j` مفعلا هناك تعني أن المضيف تعرف عليه. ثم شغل برنامج `الفحص الذاتي السريع` النصي أعلاه; وظهور `pinyin` يعني أنه يعمل.

#### يبلغ البرنامج النصي عن مكون مفقود أو أن `pinyin4j` غير متاح?

تأكد من أن البنية الداخلية لـ AutoJs6 ليست أقل من 3923, وأن المكون مثبت وممنوح الإذن ومفعل في مركز المكونات الإضافية. فمنذ AutoJs6 v6.8.0 لم يعد المضيف يضمن مكتبة pinyin4j, وأصبح هذا المكون يتولى هذه القدرة بالكامل.

#### لماذا لا توجد أيقونة للمكون في قائمة التطبيقات أو على الشاشة الرئيسية?

هذا متوقع. لا يملك المكون واجهة مستقلة ولا ينشئ أيقونة تشغيل على الشاشة الرئيسية; وبعد التثبيت يكتشفه AutoJs6 ويستدعيه في الخلفية, ويجري كل تفاعل داخل AutoJs6.

#### نطق الحروف متعددة النطق لا يطابق المتوقع (مثل "重庆" التي لا تقرأ chongqing)?

يحول هذا المكون كل حرف على حدة ويأخذ دائما النطق الأول في القاموس دون الاستعانة بسياق العبارات لإزالة الالتباس, وهذه مقايضة ملازمة للنهج الخفيف. إن احتجت إلى إزالة التباس الحروف متعددة النطق أو قواميس العبارات أو نطق أسماء العائلة, فاستخدم المكون الشقيق [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### لماذا لا تعمل `pinyin4j.asTone(text)` الواردة في الوثائق أو البرامج النصية القديمة?

اسم هذه الطريقة في جانب المضيف هو `pinyin4j.as(text)`; أما `asTone` فهو اسم الطريقة في واجهة AIDL الخاصة بالمكون, وسلوكهما متطابق. استخدم `pinyin4j.as(text)` في البرامج النصية.

#### هل يتصل المكون الإضافي بالشبكة أو يطلب أذونات حساسة?

لا. بيانات التحويل مضمنة في حزمة التثبيت ويتم التحويل محليا على الجهاز; ولا يعلن بيان المكون إلا إذن المكون الإضافي اللازم للتواصل مع AutoJs6, دون طلب أذونات الشبكة أو التخزين أو أي أذونات نظام حساسة أخرى.

#### كيف أختار بين هذا المكون والمكون الشقيق Pinyin?

اختر هذا المكون إن كنت تحتاج فقط إلى نطق خفيف حرفا بحرف وتهتم بحجم حزمة التثبيت; واختر [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) إن احتجت إلى الحروف متعددة النطق أو تقطيع الكلمات أو العبارات أو نطق أسماء العائلة. لا يتعارض المكونان ويمكن تثبيتهما معا, وللتفاصيل راجع `مقارنة المكونين الشقيقين` أدناه.

******

### الأذونات والأمان

******

صمم المكون الإضافي بحيث يضيق سطح البيانات والأذونات قدر الإمكان:

- أذونات دنيا: لا يعلن بيان المكون إلا إذن مكون AutoJs6 الإضافي (`org.autojs.permission.PLUGIN`), دون طلب أذونات الشبكة أو التخزين أو الكاميرا أو أي أذونات نظام حساسة أخرى.
- تحويل محلي: لا ينتقل النص المراد تحويله إلا داخل الجهاز عبر Binder; وبيانات التحويل مضمنة بالكامل, والعملية كلها دون اتصال, ولا تغادر البيانات الجهاز.
- التوقيع ومنح الإذن: يتحقق AutoJs6 من توقيع المكون, ولا يمكن للبرامج النصية استدعاء المكون إلا بعد منحه الإذن وتفعيله في مركز المكونات الإضافية; والخدمة ونقطة الإيقاظ كلتاهما محميتان بإذن المكون الإضافي, فلا تستطيع تطبيقات الجهات الخارجية استدعاءهما مباشرة.
- مفتوح وقابل للتدقيق: كود المكون وخط إنتاج الوثائق كلاهما مفتوح المصدر, وتأتي قدرة التحويل من مكتبة pinyin4j مفتوحة المصدر واسعة الانتشار.

احصل على حزمة تثبيت المكون فقط من صفحة [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) الرسمية أو من مركز المكونات الإضافية في AutoJs6; فقد تكون الحزم مجهولة المصدر معدلة حتى لو تطابق الاسم ورقم الإصدار.

******

### مقارنة المكونين الشقيقين

******

يوفر AutoJs6 رسميا مكوني بينيين إضافيين لكل منهما تركيزه, ويمكن تثبيتهما معا:

| وجه المقارنة | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| التنفيذ الأساسي | مكتبة Java العريقة `pinyin4j` | قواميس مضمنة + تقطيع كلمات Jieba |
| الكائن العام | `pinyin4j` | `pinyin` |
| الحروف متعددة النطق | غير مدعوم, يؤخذ النطق الأول دائما | مدعوم, ويمكن إعادة جميع الاحتمالات |
| تقطيع الكلمات والعبارات | غير مدعوم, تحويل حرفا بحرف | مدعوم (قاموس عبارات + Jieba) |
| وضع أسماء العائلة | غير مدعوم | مدعوم |
| شكل الإخراج | سلسلة نصية بفاصل قابل للضبط | مصفوفة احتمالات ثنائية الأبعاد (قابلة للدمج عبر `compact()`) أو سلسلة مدمجة |
| الأنماط والتنسيقات | 3 تنسيقات نغمة + حالة الأحرف + طرق كتابة `ü` | 6 أنماط بينيين |
| حجم حزمة التثبيت | 349 KiB ([قياس release](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/apk-size-baseline-2026-09-01.md)) | 5.95 MiB ([قياس إصدار full](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md), قواميس مضمنة) |
| ملف الأداء | مسار خفيف حرفا بحرف; [قياسات JVM/Android](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/conversion-baseline-2026-09-01.md) | [قياس أداة التقسيم](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md); قاموس وتقسيم ومعالجة نطق متعدد أثقل, ويتغير الأداء حسب النمط |
| الأنسب لـ | أولوية الحجم والبساطة: نطق سريع حرفا بحرف | أولوية دقة النطق: الحروف متعددة النطق والعبارات وأسماء الأشخاص |

المكونان مستقلان لا يعتمد أحدهما على الآخر ولا يتعارضان; وبعد تثبيتهما معا يمكن للبرامج النصية استدعاء `pinyin4j` و `pinyin` كل على حدة حسب الحاجة. لتفاصيل مكون Pinyin راجع [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

******

### واجهة المكون الإضافي

******

المعلومات التالية موجهة لمطوري مضيف AutoJs6 والمكونات الإضافية; يستخدم المضيف هذه المعرفات لاكتشاف المكون والتفاوض على القدرات:

```text
application id: io.github.supermonster003.autojs6.plugin.pinyin4j
plugin id: pinyin4j
engine: pinyin4j
variant: default
discovery action: org.autojs.plugin.PINYIN4J
discovery category: pinyin4j
wake action: org.autojs.plugin.action.WAKE
binder interface: IPinyin4jPlugin
binder methods: getInfo / of / asTone
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

تستجيب `Pinyin4jPluginService` لـ action `org.autojs.plugin.PINYIN4J` (بالفئة category `pinyin4j`), وتكشف 3 طرق عبر واجهة AIDL باسم `IPinyin4jPlugin`; وتمرر خيارات `of` عبر `Bundle` (المفاتيح: `caseType` / `toneType` / `vCharType` / `separator`), وترمي القيم غير الصالحة `IllegalArgumentException` برسالة مترجمة. الخدمة و `WakeActivity` كلتاهما محميتان بإذن `org.autojs.permission.PLUGIN`, فلا تستطيع تطبيقات الجهات الخارجية استدعاءهما مباشرة.

******

### خارطة الطريق

******

يسجل ROADMAP.md الأدلة حسب المرحلة. أنجز M3 في جانب المكون تغطية Unicode وحدود النغمات ونواة النطق المتعدد لستة أنظمة مع مقترح عقد, لكن API العامة ما زالت تنتظر تنسيق AIDL مع المضيف. واكتملت خطوط M4 الأساسية لمخاطر الاعتماد والأداء والحجم ودليل الاختيار. البنود غير المؤشرة ليست قدرات حالية.

- [عرض ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### سجل الإصدارات

******

#### v1.2.0

_2026/09/01_

- `تلميح` توجد النطقات المتعددة وأنظمة الكتابة اللاتينية الستة حاليا كنواة مختبرة في جانب المكون ومقترح عقد فقط; ولا تعد `pinyin4j.readings()` واجهة API عامة للبرامج النصية حتى ترقية AIDL ومسارات مضيف AutoJs6
- `إصلاح` لم تعد `of` تسقط فجوات القاموس أو تفصل أحرف المستويات الإضافية: فهي تمر الآن على نقاط ترميز Unicode, وتحول كل المدخلات الفعلية ومنها `〇`, وتحافظ على كل إدخال غير مدرج كاملا, وتجعل الفواصل متوافقة مع نقاط الترميز
- `إصلاح` تحول `pinyin4j.as(text)` الآن المقاطع الرقمية الكاملة والصالحة فقط, وتحافظ على الأجزاء غير الصالحة أو المضمنة في نص أبجدي رقمي, وتعالج حالة الأحرف و `v` / `u:` / `ü`, وتتعامل بشكل صحيح مع كتابة `ue` العادية مثل `jue4` -> `juè`
- `تحسين` ثبتت التغطية الفعلية للقاموس باختبار شامل لـ BMP: عددها 20,378 مدخلا, منها 20,377 ضمن U+4E00-U+9FA5 والباقي للحرف `〇`; كما يراجع الاختبار 525 فجوة في النطاق القديم وبصمة SHA-256 للمتن
- `تحسين` أضيفت نواة مختبرة لكل المرشحين في Hanyu و Tongyong و Wade-Giles و MPS2 و Yale و Gwoyeu Romatzyh, مع مقترح موثق لإضافة AIDL بصيغة JSON والتفاوض على القدرات والرجوع إلى التنفيذ القديم
- `تحسين` أضيف سجل مخاطر pinyin4j 2.5.1 مع تجزئات الملف الثنائي والمصدر, ونتائج فحص المصدر الأعلى وبيانات الترخيص, والحدود المعروفة, وبوابات الترقية أو إنشاء fork
- `تحسين` أضيفت خطوط أداء قابلة للتكرار لـ JVM ومدخل Android Service/AIDL, ومحلل ZIP وموارد لحزمة release APK, ومقارنة لاختيار المكون الشقيق مبنية على القياسات

#### v1.1.0

_2026/09/01_

- `إصلاح` إزالة الفاصل الزائد في نهاية المخرجات عند استخدام فاصل غير فارغ, مع الحفاظ الدقيق على المحارف غير الصينية بما فيها المسافات في البداية والنهاية
- `إصلاح` توحيد حركات النغمة الثالثة القديمة بعلامة breve في pinyin4j 2.5.1 إلى صيغة caron القياسية (مثل `yŭ` إلى `yǔ`), للأحرف الصغيرة والكبيرة
- `تحسين` إضافة اختبارات JVM لأسماء الخيارات وأسمائها البديلة, واختصارات القيم, وتوليفات المخرجات, والقيم الافتراضية, والأخطاء, وتحويل النغمات, وبيانات وقت التشغيل, مع اختبارات Android instrumentation لاكتشاف الخدمة الحقيقية والتحقق من جولات Binder
- `تحسين` إضافة مسارات GitHub Actions تمنع انحراف المستندات المولدة, وتشغل اختبارات الوحدة, وتبني debug APK, وتجمع اختبارات instrumentation, وترفع ملف APK الناتج
- `تحسين` إضافة `.python/prepare_release.py` لبناء universal APK موقع والتحقق منه, والتحقق من الإصدار, وحساب CRC32 و SHA-256, وإنشاء `SHA256SUMS.txt` و `RELEASE_NOTES.md` الإنجليزي بصورة ذرية
- `تحسين` توحيد تخطيط README وطريقة إدارة إصدارات منصة Gradle

#### v1.0.1

_2026/08/31_

- `تلميح` يقتصر هذا الإصدار على تحسين الوثائق والأدوات المصاحبة; ويبقى سلوك تحويل البينيين وجميع واجهات برمجة النصوص دون تغيير
- `إصلاح` تصحيح الكتابة الخاطئة `pinyin4j.asTone(text)` الواردة في الوثائق القديمة: الطريقة التي يكشفها المضيف فعليا هي `pinyin4j.as(text)` (ولا يزال اسم طريقة واجهة AIDL الأساسية `asTone`)
- `تحسين` إعادة بناء README بعشر لغات: أضيفت أقسام الاستخدام, والبدء السريع, وجدول الخيارات المرجعي, وواجهة برمجة النصوص, والفحص الذاتي السريع, والأسئلة الشائعة, والأذونات والأمان, ومقارنة المكونين الشقيقين, وواجهة المكون الإضافي
- `تحسين` ترقية برنامج توليد الوثائق النصي إلى تنفيذ موحد مشترك بين المكونات الشقيقة: كشف الانحراف عبر `--check`, والتحقق من تطابق المفاتيح والبنية بين اللغات, وحظر الرموز كاملة العرض, والتحقق من تطابق الإصدارات
- `تحسين` ضم تعليمات مركز المكونات الإضافية (`plugin_instruction.md`) إلى نفس خط توليد JSON متعدد اللغات, بما يزيل صيانة المصدر المزدوج
- `تحسين` إضافة خارطة الطريق ROADMAP.md وإنشاء روابط متبادلة ثنائية الاتجاه ومقارنة اختيار مع المكون الشقيق Pinyin

##### لمزيد من سجل الإصدارات

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-ar.md)

******

### البناء

******

هذا القسم موجه للمطورين الراغبين في بناء المكون من المصدر.

بناء حزمة APK بوضع debug:

```powershell
.\gradlew.bat :app:assembleDebug
```

بناء حزمة APK بوضع release (حزمة عامة واحدة; اضبط التوقيع في ملف `sign.properties` غير المتتبع ليوقع تلقائيا):

```powershell
.\gradlew.bat :app:assembleRelease
```

لإنشاء أرشيف إصدار تم التحقق منه, شغل `py .python/prepare_release.py`. يفحص البرنامج المستندات المولدة, ويبني universal APK الموقع ويتحقق منه, ويتحقق من بيانات الإصدار, ويحسب CRC32 و SHA-256, ثم يكتب APK و `SHA256SUMS.txt` و `RELEASE_NOTES.md` الإنجليزي بصورة ذرية داخل `app/releases/v<الإصدار>`.

معاملات البناء مجمعة في `version.properties`: الحد الأدنى من SDK هو 24 (Android 7.0), و SDK الهدف 36, والإصدار الحالي 1.2.0.

******

### الترجمة وإنشاء الوثائق

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

يحمل `strings.xml` وصف المكون المترجم ورسائل الخطأ, ويحمل `plugin_instruction.md` تعليمات الاستخدام المعروضة في مركز المكونات الإضافية بالمضيف. ينشأ README وسجل التغييرات والتعليمات كلها من مصادر JSON: عدل الملفات المصدرية تحت `.readme/` و `.changelog/`, ثم شغل `py .python/generate_markdown.py` لإعادة إنشاء كل المخرجات; ولا تحرر المخرجات المولدة يدويا. شغل `py .python/generate_markdown.py --check` للتحقق من تزامن المصادر والمخرجات.

******

### الترخيص

******

كود المشروع مرخص بموجب [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). وتأتي قدرة تحويل البينيين من مكتبة [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`).

******

### روابط

******

- وثائق AutoJs6 Pinyin4j: https://docs.autojs6.com/#/pinyin4j
- مشروع AutoJs6: https://github.com/SuperMonster003/AutoJs6
- المكون الشقيق Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- مشروع pinyin4j: https://github.com/belerweb/pinyin4j
- إحداثيات Maven لمكتبة pinyin4j: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

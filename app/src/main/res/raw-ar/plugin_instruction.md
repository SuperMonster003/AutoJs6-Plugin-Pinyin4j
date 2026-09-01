يضيف مكون Pinyin4j الإضافي إلى AutoJs6 كتابة لاتينية خفيفة حرفا بحرف. تستطيع البرامج النصية إنتاج سلسلة Hanyu Pinyin منسقة, والاستعلام عن كل قراءات القاموس كمصفوفة مصطفة حسب نقاط Unicode في Hanyu أو Tongyong أو Wade-Giles أو MPS2 أو Yale أو Gwoyeu Romatzyh, وتحويل النغمات الرقمية إلى علامات.

### البدء السريع

التحويل الأساسي: يخرج افتراضيا بينيين بأحرف صغيرة دون نغمات, ويمكن تمرير الفاصل مباشرة كمعامل ثان:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### الخيارات

تدعم `pinyin4j.of(text, options)` الخيارات التالية (بين القوسين أسماء المفاتيح المختصرة المتاحة):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

القيم غير حساسة لحالة الأحرف وتقبل أسماء مختصرة, مثل `tone: "MARK"` / `"NUMBER"` / `"NO"`; وتمرير سلسلة كمعامل ثان يعامل على أنه الفاصل.

### الفحص الذاتي السريع

بعد تثبيت المكون وتفعيله, شغل هذا البرنامج النصي المكون من سطر واحد:

```javascript
console.log(pinyin4j.of("拼音"));
```

ظهور `pinyin` في الإخراج يعني أن المكون يعمل بشكل صحيح.

لمزيد من تفاصيل الاستخدام وشرح الخيارات, راجع [وثائق AutoJs6 Pinyin4j](https://docs.autojs6.com/#/pinyin4j) و [صفحة المشروع](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

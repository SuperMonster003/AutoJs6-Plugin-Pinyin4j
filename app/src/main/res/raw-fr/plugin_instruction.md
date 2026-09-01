Le plugin Pinyin4j apporte à AutoJs6 une romanisation légère caractère par caractère. Les scripts peuvent produire une chaîne Hanyu Pinyin formatée, interroger toutes les prononciations du dictionnaire sous forme de matrice alignée sur les points de code Unicode en Hanyu, Tongyong, Wade-Giles, MPS2, Yale ou Gwoyeu Romatzyh, et convertir les tons numériques en marques de ton.

### Démarrage Rapide

Conversion de base: pinyin en minuscules sans tons par défaut; le second argument peut être directement un séparateur:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
console.log(JSON.stringify(pinyin4j.readings("重A𠀀")));             // [["zhong4","chong2"],["A"],["𠀀"]]
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

### Options

`pinyin4j.of(text, options)` prend en charge les options suivantes (alias courts entre parenthèses):

```text
caseType (case): LOWERCASE, UPPERCASE
toneType (tone): WITHOUT_TONE, WITH_TONE_NUMBER, WITH_TONE_MARK
vCharType (v): WITH_V, WITH_U_AND_COLON, WITH_U_UNICODE
separator (sep): any string
```

Les valeurs sont insensibles à la casse et acceptent des alias courts, comme `tone: "MARK"` / `"NUMBER"` / `"NO"`; une chaîne simple en second argument est traitée comme séparateur.

### Auto-Vérification Rapide

Après avoir installé et activé le plugin, exécutez cette ligne unique:

```javascript
console.log(pinyin4j.of("拼音"));
```

Si `pinyin` s'affiche, le plugin fonctionne correctement.

Pour plus de détails sur l'utilisation et les options, consultez la [documentation AutoJs6 Pinyin4j](https://docs.autojs6.com/#/pinyin4j) et la [page du projet](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j).

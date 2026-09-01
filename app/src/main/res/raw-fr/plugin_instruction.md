Le plugin Pinyin4j (Pinyin4j Plugin) apporte à AutoJs6 une conversion légère du chinois en pinyin Hanyu. Une fois installé, les scripts peuvent utiliser l'objet global `pinyin4j` pour convertir un texte chinois en pinyin caractère par caractère, avec casse, format de ton, représentation du `ü` et séparateur de syllabes configurables; une méthode utilitaire convertit aussi les textes à tons numériques en marques de ton.

### Démarrage Rapide

Conversion de base: pinyin en minuscules sans tons par défaut; le second argument peut être directement un séparateur:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
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

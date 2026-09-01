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
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
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

Le plugin Pinyin4j (Pinyin4j Plugin) apporte à AutoJs6 une conversion légère du chinois en pinyin Hanyu. Une fois installé, les scripts peuvent utiliser l'objet global `pinyin4j` pour convertir un texte chinois en pinyin caractère par caractère, avec casse, format de ton, représentation du `ü` et séparateur de syllabes configurables; une méthode utilitaire convertit aussi les textes à tons numériques en marques de ton.

Le plugin est un APK installé séparément qui s'exécute dans son propre processus; AutoJs6 le découvre automatiquement via le mécanisme de plugins et communique avec lui par AIDL. La conversion s'appuie sur la bibliothèque Java classique [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), le paquet ne pèse qu'environ 0.3 MB et tout se déroule localement sur l'appareil, sans réseau. Depuis AutoJs6 v6.8.0, le module `pinyin4j` de l'hôte est implémenté par ce plugin.

Ce plugin et [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) sont des plugins frères: celui-ci offre une transcription caractère par caractère simple et fiable pour une taille minuscule, tandis que le plugin Pinyin embarque des dictionnaires complets et la segmentation Jieba, avec désambiguïsation des polyphones et mode nom de famille pour les scénarios exigeants en précision. Les deux peuvent être installés côte à côte; voir `Comparaison Des Plugins Frères` ci-dessous.

******

### Points Forts

******

- Prêt à l'emploi: découvert automatiquement par AutoJs6 après l'installation, sans redémarrage de l'hôte; les scripts utilisent directement l'objet global `pinyin4j`.
- Extrêmement léger: le paquet ne pèse qu'environ 0.3 MB, en pur JVM sans aucune bibliothèque native, compatible avec toutes les architectures CPU.
- Trois formats de ton: sans ton, tons numériques (`han4`) et marques de ton (`hàn`), au choix.
- Sortie flexible: casse configurable, trois représentations du `ü` (`lv` / `lu:` / `lü`) et séparateur de syllabes arbitraire.
- Utilitaire de tons: `pinyin4j.as(text)` convertit en une étape un texte à tons numériques vers la forme à marques de ton.
- Valeurs tolérantes: les options sont insensibles à la casse et acceptent plusieurs alias courts (comme `tone: "MARK"`); les valeurs invalides produisent des messages d'erreur localisés.
- Entièrement hors ligne: la conversion repose sur des données embarquées et s'exécute localement sur l'appareil, sans aucune requête réseau.
- Multilingue: métadonnées du plugin, instructions, README et journal des modifications disponibles en 10 langues.

******

### Utilisation

******

1. Mettez AutoJs6 à niveau vers le build interne 3923 (6.7.1 Alpha4) ou supérieur; depuis v6.8.0, les capacités pinyin sont entièrement déléguées aux plugins, la dernière version est donc recommandée.
2. Téléchargez l'APK du plugin depuis la page [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) et installez-le sur l'appareil exécutant AutoJs6, ou installez-le en ligne directement depuis le centre de plugins d'AutoJs6.
3. Ouvrez le centre de plugins d'AutoJs6, vérifiez que le plugin `Pinyin4j` est reconnu, puis accordez l'autorisation et assurez-vous qu'il est activé.
4. Appelez l'objet global `pinyin4j` directement dans les scripts en suivant les exemples de `Démarrage Rapide` ci-dessous; vous pouvez aussi exécuter d'abord l'`Auto-Vérification Rapide` pour confirmer que le plugin est actif.

> Le plugin est fourni en un seul paquet universel (pur JVM, sans variantes d'architecture CPU) et prend en charge les appareils sous Android 7.0 (API 24) ou supérieur. Il n'a pas d'interface autonome et ne crée pas d'icône de lanceur; AutoJs6 le découvre et le gère de manière centralisée.

******

### Démarrage Rapide

******

Conversion de base: pinyin en minuscules sans tons par défaut; le second argument peut être directement un séparateur:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

Tons numériques et représentations du `ü`:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

Utilitaire de tons: convertir un texte à tons numériques en marques de ton:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

******

### Options

******

`pinyin4j.of(text, options)` prend en charge les options suivantes (alias courts entre parenthèses):

| Option | Défaut | Description |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | Casse de sortie: `LOWERCASE` minuscules, `UPPERCASE` majuscules |
| `toneType` (`tone`) | `WITHOUT_TONE` | Format de ton: `WITHOUT_TONE` sans ton, `WITH_TONE_NUMBER` tons numériques, `WITH_TONE_MARK` marques de ton |
| `vCharType` (`v`, `vChar`) | `WITH_V` | Écriture du `ü`: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); bascule par défaut sur `WITH_U_UNICODE` avec le format à marques de ton |
| `separator` (`sep`) | `""` | Séparateur entre syllabes, toute chaîne; un séparateur final en fin de sortie est retiré |

Les valeurs sont insensibles à la casse et acceptent des alias courts, comme `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"`. Passer une valeur invalide lève une exception avec un message localisé.

******

### API De Script

******

L'objet global `pinyin4j` fournit les méthodes suivantes (appeler directement `pinyin4j(text, options)` équivaut à `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

- `of` convertit caractère par caractère: les caractères du bloc CJK de base (U+4E00-U+9FA5) deviennent du pinyin, les autres sont conservés tels quels; chaque caractère prend toujours la première prononciation du dictionnaire pinyin4j, sans désambiguïsation des polyphones.
- Le second argument de `of` peut être un objet d'options ou une simple chaîne utilisée comme séparateur.
- `as` remplace les syllabes à tons numériques du texte (comme `han4`) par leur forme à marques de ton (comme `hàn`), en acceptant le `ü` écrit `v` ou `u:`; les fragments non reconnus sont conservés tels quels. Cette méthode correspond à `asTone` dans l'interface AIDL du plugin.
- Les valeurs d'options sont insensibles à la casse et acceptent plusieurs alias courts (voir `Options` ci-dessus); les valeurs invalides lèvent une exception avec un message localisé.
- Toutes les méthodes renvoient de manière synchrone, sans attente d'initialisation.

******

### Auto-Vérification Rapide

******

Après avoir installé et activé le plugin, exécutez cette ligne unique:

```javascript
console.log(pinyin4j.of("拼音"));
```

Si `pinyin` s'affiche, le plugin fonctionne correctement.

******

### FAQ

******

#### Comment vérifier que le plugin est actif?

Ouvrez le centre de plugins d'AutoJs6; si le plugin `Pinyin4j` y figure et est activé, l'hôte l'a reconnu. Exécutez ensuite le script d'`Auto-Vérification Rapide` ci-dessus; l'affichage de `pinyin` confirme qu'il fonctionne.

#### Un script signale un plugin manquant ou `pinyin4j` indisponible?

Vérifiez que le build interne d'AutoJs6 est au moins 3923, et que le plugin est installé, autorisé et activé dans le centre de plugins. Depuis AutoJs6 v6.8.0, l'hôte n'embarque plus la bibliothèque pinyin4j; ce plugin fournit entièrement cette capacité.

#### Pourquoi n'y a-t-il pas d'icône de plugin dans la liste des applications ou sur l'écran d'accueil?

C'est normal. Le plugin n'a pas d'interface autonome et ne crée pas d'icône de lanceur; après installation, AutoJs6 le découvre et l'appelle en arrière-plan, et toute interaction se fait dans AutoJs6.

#### Les prononciations des polyphones semblent incorrectes (par exemple "重庆" n'est pas lu chongqing)?

Ce plugin convertit caractère par caractère et prend toujours la première prononciation du dictionnaire, sans désambiguïsation par le contexte des mots; c'est le compromis inhérent à l'approche légère. Pour la désambiguïsation des polyphones, les dictionnaires d'expressions ou les lectures de noms de famille, utilisez le plugin frère [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### Pourquoi `pinyin4j.asTone(text)` mentionné dans d'anciennes docs ou d'anciens scripts ne fonctionne-t-il pas?

Côté hôte, la méthode s'appelle `pinyin4j.as(text)`; `asTone` est le nom de la méthode dans l'interface AIDL du plugin, et les deux se comportent de la même façon. Utilisez `pinyin4j.as(text)` dans les scripts.

#### Le plugin accède-t-il au réseau ou demande-t-il des permissions sensibles?

Non. Les données de conversion sont embarquées dans le paquet et la conversion se fait localement sur l'appareil; le manifeste ne déclare que la permission de plugin nécessaire pour communiquer avec AutoJs6, sans demander le réseau, le stockage ni aucune autre permission système sensible.

#### Comment choisir entre ce plugin et le plugin frère Pinyin?

Choisissez ce plugin quand une transcription légère caractère par caractère suffit et que la taille du paquet compte; choisissez [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) pour les polyphones, la segmentation, les expressions ou les lectures de noms de famille. Ils ne se gênent pas et peuvent être installés ensemble; voir `Comparaison Des Plugins Frères` ci-dessous.

******

### Permissions Et Sécurité

******

Le plugin est conçu pour réduire au maximum sa surface de données et de permissions:

- Permissions minimales: le manifeste ne déclare que la permission de plugin AutoJs6 (`org.autojs.permission.PLUGIN`), sans demander le réseau, le stockage, la caméra ni aucune autre permission système sensible.
- Conversion locale: le texte à convertir ne circule que dans l'appareil via Binder; les données de conversion sont entièrement embarquées, tout est hors ligne et aucune donnée ne quitte l'appareil.
- Signature et autorisation: AutoJs6 vérifie la signature du plugin, et le plugin doit être autorisé et activé dans le centre de plugins avant que les scripts puissent l'appeler; le service et le point d'éveil sont protégés par la permission de plugin, les applications tierces ne peuvent donc pas les appeler directement.
- Ouvert et auditable: le code du plugin et la chaîne de génération de documentation sont entièrement open source, et la conversion s'appuie sur la bibliothèque open source largement utilisée pinyin4j.

N'installez le plugin que depuis la page officielle [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) ou le centre de plugins d'AutoJs6; un paquet d'origine inconnue peut être altéré même si le nom et le numéro de version semblent identiques.

******

### Comparaison Des Plugins Frères

******

AutoJs6 propose deux plugins pinyin officiels aux priorités différentes; ils peuvent être installés côte à côte:

| Aspect | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| Implémentation sous-jacente | Bibliothèque Java classique `pinyin4j` | Dictionnaires embarqués + segmentation Jieba |
| Objet global | `pinyin4j` | `pinyin` |
| Polyphones | Non pris en charge, toujours la première prononciation | Pris en charge, peut renvoyer tous les candidats |
| Segmentation et expressions | Non prise en charge, conversion caractère par caractère | Prise en charge (dictionnaire d'expressions + Jieba) |
| Mode nom de famille | Non pris en charge | Pris en charge |
| Forme de sortie | Chaîne avec séparateur configurable | Tableau 2D de candidats (combinable via `compact()`) ou chaîne compacte |
| Styles et formats | 3 formats de ton + casse + représentations du `ü` | 6 styles de pinyin |
| Taille du paquet | Environ 0.3 MB | Environ 6 MB (dictionnaires embarqués) |
| Idéal pour | Taille et simplicité avant tout: transcription rapide caractère par caractère | Précision avant tout: polyphones, expressions, noms de personnes |

Les deux plugins sont indépendants et n'entrent jamais en conflit; une fois les deux installés, les scripts peuvent appeler `pinyin4j` et `pinyin` séparément selon le besoin. Voir [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) pour les détails du plugin Pinyin.

******

### Interface Du Plugin

******

Les informations suivantes s'adressent aux développeurs de l'hôte AutoJs6 et de plugins; l'hôte utilise ces identifiants pour découvrir le plugin et négocier les capacités:

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

`Pinyin4jPluginService` répond à l'action `org.autojs.plugin.PINYIN4J` (catégorie `pinyin4j`) et expose 3 méthodes via l'interface AIDL `IPinyin4jPlugin`; les options de `of` sont transmises via un `Bundle` (clés: `caseType` / `toneType` / `vCharType` / `separator`), et les valeurs invalides lèvent une `IllegalArgumentException` avec un message localisé. Le service et `WakeActivity` sont protégés par la permission `org.autojs.permission.PLUGIN`, les applications tierces ne peuvent donc pas les appeler directement.

******

### Feuille De Route

******

Les capacités prévues du plugin et leur état d'avancement sont maintenus sous forme de liste cochable dans ROADMAP.md, organisée par jalons avec critères d'acceptation, couvrant les requêtes multi-prononciations, d'autres systèmes de romanisation, une couverture de caractères élargie, l'intégration continue et plus encore. Les éléments non cochés sont des intentions et non des capacités actuelles; les discussions via Issues sont bienvenues.

- [Voir ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### Historique Des Versions

******

#### v1.1.0

_2026/09/01_

- `Correction` Suppression du séparateur final produit avec les séparateurs non blancs et conservation exacte des caractères non chinois, y compris les espaces en début et fin de texte
- `Correction` Normalisation des voyelles de troisième ton avec brève héritées de pinyin4j 2.5.1 vers les formes standard avec caron (par exemple `yŭ` vers `yǔ`), en minuscules comme en majuscules
- `Amélioration` Ajout de tests unitaires JVM pour les noms et alias d'options, les valeurs abrégées, les combinaisons de sortie, les valeurs par défaut, les erreurs, la conversion des tons et les métadonnées d'exécution, ainsi que de tests Android instrumentation pour la découverte réelle du service et les allers-retours Binder
- `Amélioration` Ajout de workflows GitHub Actions qui refusent toute dérive des documents générés, exécutent les tests unitaires, construisent l'APK debug, compilent les tests instrumentation et téléversent l'APK produit
- `Amélioration` Ajout de `.python/prepare_release.py` pour construire et vérifier un APK universal signé, valider sa version, calculer CRC32 et SHA-256, puis générer atomiquement `SHA256SUMS.txt` et le fichier anglais `RELEASE_NOTES.md`
- `Amélioration` Uniformiser la mise en page du README et la gestion des versions de la plateforme Gradle

#### v1.0.1

_2026/08/31_

- `Info` Cette version n'améliore que la documentation et l'outillage associé; le comportement de conversion en pinyin et toutes les API de script restent inchangés
- `Correction` Correction de l'usage erroné `pinyin4j.asTone(text)` présent dans les anciennes docs: l'hôte expose en réalité `pinyin4j.as(text)` (la méthode AIDL sous-jacente s'appelle toujours `asTone`)
- `Amélioration` Refonte du README en 10 langues: ajout des sections utilisation, démarrage rapide, tableau de référence des options, API de script, auto-vérification, FAQ, permissions et sécurité, comparaison des plugins frères et interface du plugin
- `Amélioration` Mise à niveau du générateur de docs vers l'implémentation unifiée partagée entre plugins frères: détection de dérive `--check`, validation des clés et des formes entre langues, rejet des symboles pleine largeur et contrôles d'alignement des versions
- `Amélioration` Intégration des instructions du centre de plugins (`plugin_instruction.md`) dans la même chaîne de génération JSON multilingue, éliminant la double maintenance des sources
- `Amélioration` Ajout de la feuille de route ROADMAP.md, avec renvois croisés bidirectionnels et comparaison avec le plugin frère Pinyin

#### v1.0.0

_2026/07/15_

- `Nouveauté` Service du plugin Pinyin4j: ID de plugin `pinyin4j`, découvert et appelé automatiquement par AutoJs6 via `org.autojs.plugin.PINYIN4J`, encapsulant la bibliothèque `com.belerweb:pinyin4j:2.5.1`
- `Nouveauté` API de conversion: `pinyin4j.of(text, options)` convertit le texte chinois en pinyin Hanyu caractère par caractère; une chaîne passée en second argument sert directement de séparateur
- `Nouveauté` API de restauration des tons: `pinyin4j.as(text)` restaure le pinyin à tons numériques (comme `han4`) en pinyin à marques de ton (comme `hàn`), via la méthode AIDL `asTone`
- `Nouveauté` Options flexibles: alias comme `case` / `tone` / `v` / `sep` et raccourcis de valeurs comme `MARK` / `NUMBER` / `NO`, avec erreurs localisées en cas de valeur invalide
- `Nouveauté` Ressources multilingues: métadonnées du plugin et instructions disponibles en 10 langues
- `Nouveauté` README et CHANGELOG générés en Markdown multilingue depuis les sources JSON via `.python/generate_markdown.py`

##### Pour plus d'historique des versions

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-fr.md)

******

### Compilation

******

Cette section s'adresse aux développeurs souhaitant compiler le plugin depuis les sources.

Compiler un APK debug:

```powershell
.\gradlew.bat :app:assembleDebug
```

Compiler un APK release (paquet universel unique; signé automatiquement une fois la signature configurée dans le fichier non suivi `sign.properties`):

```powershell
.\gradlew.bat :app:assembleRelease
```

Pour créer une archive de publication vérifiée, exécutez `py .python/prepare_release.py`. Le script contrôle les documents générés, construit et vérifie l'APK universal signé, valide les métadonnées de version, calcule CRC32 et SHA-256, puis écrit atomiquement l'APK, `SHA256SUMS.txt` et le fichier anglais `RELEASE_NOTES.md` dans `app/releases/v<version>`.

Les paramètres de compilation sont centralisés dans `version.properties`: SDK minimal 24 (Android 7.0), SDK cible 36, version actuelle 1.1.0.

******

### Localisation Et Génération De Docs

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

`strings.xml` contient la description localisée du plugin et les messages d'erreur, et `plugin_instruction.md` contient les instructions affichées dans le centre de plugins de l'hôte. README, journal des modifications et instructions sont tous générés depuis des sources JSON: modifiez les sources sous `.readme/` et `.changelog/`, puis exécutez `py .python/generate_markdown.py` pour régénérer tous les artefacts; les artefacts générés ne sont jamais édités à la main. Exécutez `py .python/generate_markdown.py --check` pour vérifier que sources et artefacts sont synchronisés.

******

### Licence

******

Le code du projet est sous licence [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). La conversion en pinyin s'appuie sur la bibliothèque [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`).

******

### Liens

******

- Documentation AutoJs6 Pinyin4j: https://docs.autojs6.com/#/pinyin4j
- Projet AutoJs6: https://github.com/SuperMonster003/AutoJs6
- Plugin frère Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- Projet pinyin4j: https://github.com/belerweb/pinyin4j
- Coordonnées Maven pinyin4j: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

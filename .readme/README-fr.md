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

Le plugin Pinyin4j apporte à AutoJs6 une romanisation légère caractère par caractère. Les scripts peuvent produire une chaîne Hanyu Pinyin formatée, interroger toutes les prononciations du dictionnaire sous forme de matrice alignée sur les points de code Unicode en Hanyu, Tongyong, Wade-Giles, MPS2, Yale ou Gwoyeu Romatzyh, et convertir les tons numériques en marques de ton.

Le plugin est un APK installé séparément qui s'exécute dans son propre processus; AutoJs6 le découvre automatiquement via le mécanisme de plugins et communique avec lui par AIDL. La conversion s'appuie sur la bibliothèque Java classique [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), le release mesuré ne pèse que 376 KiB et tout se déroule localement sur l'appareil, sans réseau. Depuis AutoJs6 v6.8.0, le module `pinyin4j` de l'hôte est implémenté par ce plugin.

Ce plugin et [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) sont des plugins frères: celui-ci offre une transcription caractère par caractère simple et fiable pour une taille minuscule, tandis que le plugin Pinyin embarque des dictionnaires complets et la segmentation Jieba, avec désambiguïsation des polyphones et mode nom de famille pour les scénarios exigeants en précision. Les deux peuvent être installés côte à côte; voir `Comparaison Des Plugins Frères` ci-dessous.

******

### Points Forts

******

- Prêt à l'emploi: découvert automatiquement par AutoJs6 après l'installation, sans redémarrage de l'hôte; les scripts utilisent directement l'objet global `pinyin4j`.
- Extrêmement léger: le release mesuré ne pèse que 376 KiB, en pur JVM sans aucune bibliothèque native, compatible avec toutes les architectures CPU.
- Trois formats de ton: sans ton, tons numériques (`han4`) et marques de ton (`hàn`), au choix.
- Sortie flexible: casse configurable, trois représentations du `ü` (`lv` / `lu:` / `lü`) et séparateur de syllabes arbitraire.
- Utilitaire de tons: `pinyin4j.as(text)` convertit en une étape un texte à tons numériques vers la forme à marques de ton.
- Toutes les lectures et six systèmes: `pinyin4j.readings(text, options)` renvoie une ligne ordonnée de candidats par point de code Unicode et prend en charge Hanyu, Tongyong, Wade-Giles, MPS2, Yale et Gwoyeu Romatzyh.
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

Toutes les lectures candidates et autres systèmes de romanisation:

```javascript
console.log(pinyin4j.readings("重A𠀀"));
// [["zhong4", "chong2"], ["A"], ["𠀀"]]

console.log(pinyin4j.readings("间", { system: "WADE_GILES" }));
// [["chien1", "chien4"]]
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
pinyin4j.readings(text, options?) -> string[][]
```

- `of` parcourt les points de code Unicode et interroge directement le dictionnaire pinyin4j 2.5.1 verrouillé: les 20 378 caractères BMP mappés (dont `〇`) sont convertis, tandis que les points non mappés et des plans supplémentaires restent intacts. Seule la première prononciation est choisie, sans désambiguïsation contextuelle.
- `readings` renvoie un `string[][]` ordonné avec une ligne par point de code Unicode. Hanyu utilise par défaut les minuscules et les tons numériques, avec les options case/tone/v existantes; `romanization` (ou `system`) choisit Hanyu, Tongyong, Wade-Giles, MPS2, Yale ou Gwoyeu Romatzyh. Les autres systèmes refusent les options de format propres à Hanyu et les séparateurs ne s'appliquent pas aux matrices.
- AutoJs6 négocie `pinyin4j.readings.version = 1`: les anciens plugins produisent sans risque des lignes Hanyu à candidat unique, tandis que les autres systèmes exigent le nouveau plugin. Node.js peut appeler le même provider de façon asynchrone via `autojs6:bridge.callAutoJs` avec la capacité explicite `pinyin4j`.
- Le second argument de `of` peut être un objet d'options ou une simple chaîne utilisée comme séparateur.
- `as` ne convertit que les syllabes complètes reconnues portant un chiffre de ton de `0` à `4`, conserve la casse et accepte `v`, `u:` ou `ü`; les syllabes invalides, le chiffre `5` et les fragments accolés à des lettres ou chiffres restent inchangés. Cette méthode correspond à `asTone` dans l'interface AIDL du plugin.
- Les valeurs d'options sont insensibles à la casse et acceptent plusieurs alias courts (voir `Options` ci-dessus); les valeurs invalides lèvent une exception avec un message localisé.
- Toutes les méthodes renvoient de manière synchrone; la première conversion charge paresseusement le dictionnaire pinyin4j et est donc plus lente que les appels stabilisés, comme le documente le benchmark.

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

`pinyin4j.of` continue de prendre la première prononciation de chaque caractère. Utilisez `pinyin4j.readings` pour obtenir tous les candidats du dictionnaire, mais il n'emploie pas le contexte de la phrase pour choisir. Pour la désambiguïsation contextuelle, les dictionnaires d'expressions ou les noms de famille, utilisez le plugin frère [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### Pourquoi `pinyin4j.asTone(text)` mentionné dans d'anciennes docs ou d'anciens scripts ne fonctionne-t-il pas?

Côté hôte, la méthode s'appelle `pinyin4j.as(text)`; `asTone` est le nom de la méthode dans l'interface AIDL du plugin, et les deux se comportent de la même façon. Utilisez `pinyin4j.as(text)` dans les scripts.

#### Le plugin accède-t-il au réseau ou demande-t-il des permissions sensibles?

Non. Les données de conversion sont embarquées dans le paquet et la conversion se fait localement sur l'appareil; le manifeste ne déclare que la permission de plugin nécessaire pour communiquer avec AutoJs6, sans demander le réseau, le stockage ni aucune autre permission système sensible.

#### Comment choisir entre ce plugin et le plugin frère Pinyin?

Choisissez ce plugin quand une transcription légère caractère par caractère ou la liste complète des candidats suffit et que la taille du paquet compte; choisissez [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) pour la désambiguïsation contextuelle des polyphones, la segmentation, les dictionnaires d'expressions ou les lectures de noms de famille. Ils ne se gênent pas et peuvent être installés ensemble; voir `Comparaison Des Plugins Frères` ci-dessous.

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
| Polyphones | Tous les candidats via `readings`, sans désambiguïsation contextuelle | Pris en charge, peut renvoyer tous les candidats |
| Segmentation et expressions | Non prise en charge, conversion caractère par caractère | Prise en charge (dictionnaire d'expressions + Jieba) |
| Mode nom de famille | Non pris en charge | Pris en charge |
| Forme de sortie | Chaîne formatée ou matrice de candidats alignée sur Unicode | Tableau 2D de candidats (combinable via `compact()`) ou chaîne compacte |
| Styles et formats | 6 systèmes; Hanyu offre 3 tons + casse + formes de `ü` | 6 styles de pinyin |
| Taille du paquet | 376 KiB ([mesure release](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/apk-size-baseline-2026-09-01.md)) | 5.95 MiB ([release full mesurée](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md), dictionnaires embarqués) |
| Profil de performances | Chemin léger par caractère; [mesures JVM/Android](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/conversion-baseline-2026-09-01.md) | [Mesure du segmenteur](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md); dictionnaire, segmentation et polyphones plus lourds, variables selon le mode |
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
binder methods: getInfo / of / asTone / readings
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

`Pinyin4jPluginService` répond à `org.autojs.plugin.PINYIN4J` (catégorie `pinyin4j`) et expose 4 méthodes via `IPinyin4jPlugin`. `readings` est ajouté à la fin pour préserver l'ordre des transactions, renvoie une matrice JSON strictement bornée et est annoncé par la capacité entière `pinyin4j.readings.version = 1`; les anciens hôtes continuent avec `of` et `asTone`. Les options invalides lèvent `IllegalArgumentException`. Le service et `WakeActivity` sont protégés par `org.autojs.permission.PLUGIN`.

******

### Feuille De Route

******

ROADMAP.md suit les preuves par jalon. M3 est terminé dans v1.3.0: limites Unicode et de tons, matrices de toutes les lectures, six systèmes, négociation AIDL additive, routes Rhino et Node.js et repli Hanyu pour anciens plugins sont implémentés et testés. Les bases M4 de risque, performances, taille et sélection restent terminées.

- [Voir ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### Historique Des Versions

******

#### v1.3.2

_2026/10/05_

- `Correctif` Avertissements de lecture SDK XML v4 avec AGP 9.1 et contrôles d'alignement natif des APK déclenchés par erreur lors de l'assemblage des tests unitaires JVM, avec les plugins de compilation partagés 1.8.3
- `Amélioration` compileSdk et targetSdk passent à 37 (Android 17) ; le comportement du plugin ne dépend pas de la nouvelle cible
- `Amélioration` Les icônes des informations d'application Android utilisent les illustrations et les fonds clairs et sombres d'Icon Studio, en conservant les images transparentes du centre de plugins et les choix du lanceur

#### v1.3.1

_2026/09/13_

- `Correctif` Conserver la date de version du plugin en anglais quelle que soit la langue de la machine de compilation
- `Amélioration` Ressources traduites cohérentes, activation explicite du plugin et validation des paquets de publication

#### v1.3.0

_2026/09/11_

- `Note` `pinyin4j.readings()` et le provider Node.js exigent un hôte AutoJs6 mis à jour avec le contrat readings v1; les anciens hôtes peuvent continuer à utiliser `of` et `as`
- `Fonctionnalité` `pinyin4j.readings(text, options)` renvoie toutes les prononciations ordonnées du dictionnaire, une ligne par point de code Unicode, et conserve une entrée non mappée comme candidat unique
- `Fonctionnalité` `romanization` / `system` expose Hanyu, Tongyong, Wade-Giles, MPS2, Yale et Gwoyeu Romatzyh; Hanyu prend en charge les tons numériques, marqués ou omis, la casse et les formes de `ü`
- `Amélioration` Ajout en fin de contrat de la transaction Binder `readings` et de la capacité entière `pinyin4j.readings.version = 1`; les nouveaux hôtes ne l'appellent qu'après négociation et se replient sans risque sur un candidat Hanyu par point pour les anciens plugins
- `Amélioration` Ajout de limites strictes pour la source, la matrice et le JSON UTF-8, avec couverture Binder Android 9/12/13/15; la même capacité est ouverte à Node.js via la capacité explicite `pinyin4j` de l'hôte
- `Amélioration` La vérification de compilation rejette les dépendances natives involontaires et produit un rapport JSON

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

Les paramètres de compilation sont centralisés dans `version.properties`: SDK minimal 24 (Android 7.0), SDK cible 37, version actuelle 1.3.2.

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/16kb.md)

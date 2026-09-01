<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="{{ repo_url }}/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="{{ repo_url }}/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="{{ icon_alt }}" border="0" width="128" />
    </picture>
  </p>

  <p>{{ text_plugin_synopsis }}</p>

  <p>
    <a href="{{ repo_url }}/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/{{ repo_slug }}?label=Release"/></a>
    <a href="{{ repo_url }}/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/{{ repo_slug }}?color=A24232&label=Issues"/></a>
    <a href="{{ license_url }}"><img alt="GitHub License" src="https://img.shields.io/github/license/{{ repo_slug }}?color=534BAE&label=License"/></a>
  </p>
</div>

******

### {{ h3_languages_with_ascii }}

******

{{ p_languages_all_supported_for_readme }}:

{{ placeholder_ul_languages_all_supported }}

******

### {{ h3_introduction }}

******

{{ p_introduction_what }}

{{ p_introduction_how }}

{{ p_introduction_extra }}

******

### {{ h3_features }}

******

{{ placeholder_features }}

******

### {{ h3_usage }}

******

{{ placeholder_usage_steps }}

> {{ p_usage_note }}

******

### {{ h3_quick_start }}

******

{{ p_quick_start_basic }}:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

{{ p_quick_start_tone }}:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

{{ p_quick_start_as }}:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

******

### {{ h3_options }}

******

{{ p_options_intro }}:

| {{ th_option_name }} | {{ th_option_default }} | {{ th_option_desc }} |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | {{ td_option_case }} |
| `toneType` (`tone`) | `WITHOUT_TONE` | {{ td_option_tone }} |
| `vCharType` (`v`, `vChar`) | `WITH_V` | {{ td_option_v }} |
| `separator` (`sep`) | `""` | {{ td_option_separator }} |

{{ p_options_note }}

******

### {{ h3_script_api }}

******

{{ p_script_api_intro }}:

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

{{ placeholder_api_points }}

******

### {{ h3_self_check }}

******

{{ p_self_check_intro }}:

```javascript
console.log(pinyin4j.of("拼音"));
```

{{ p_self_check_result }}

******

### {{ h3_faq }}

******

{{ placeholder_faq }}

******

### {{ h3_security }}

******

{{ p_security_intro }}

{{ placeholder_security_points }}

{{ p_security_permission }}

******

### {{ h3_sibling }}

******

{{ p_sibling_intro }}:

| {{ th_sibling_aspect }} | [Pinyin4j]({{ repo_url }}) | [Pinyin]({{ pinyin_repo_url }}) |
|---|---|---|
| {{ th_sibling_impl }} | {{ td_sibling_impl_pinyin4j }} | {{ td_sibling_impl_pinyin }} |
| {{ th_sibling_global }} | `pinyin4j` | `pinyin` |
| {{ th_sibling_heteronym }} | {{ td_sibling_heteronym_pinyin4j }} | {{ td_sibling_heteronym_pinyin }} |
| {{ th_sibling_segment }} | {{ td_sibling_segment_pinyin4j }} | {{ td_sibling_segment_pinyin }} |
| {{ th_sibling_surname }} | {{ td_sibling_surname_pinyin4j }} | {{ td_sibling_surname_pinyin }} |
| {{ th_sibling_output }} | {{ td_sibling_output_pinyin4j }} | {{ td_sibling_output_pinyin }} |
| {{ th_sibling_styles }} | {{ td_sibling_styles_pinyin4j }} | {{ td_sibling_styles_pinyin }} |
| {{ th_sibling_size }} | {{ td_sibling_size_pinyin4j }} | {{ td_sibling_size_pinyin }} |
| {{ th_sibling_performance }} | {{ td_sibling_performance_pinyin4j }} | {{ td_sibling_performance_pinyin }} |
| {{ th_sibling_scenario }} | {{ td_sibling_scenario_pinyin4j }} | {{ td_sibling_scenario_pinyin }} |

{{ p_sibling_note }}

******

### {{ h3_plugin_interface }}

******

{{ p_plugin_interface }}:

```text
application id: {{ plugin_application_id }}
plugin id: {{ plugin_id }}
engine: {{ plugin_engine }}
variant: {{ plugin_variant }}
discovery action: {{ discovery_action }}
discovery category: {{ discovery_category }}
wake action: {{ wake_action }}
binder interface: {{ binder_interface }}
binder methods: getInfo / of / asTone
minimum host build: {{ required_host_version_code }}
native library: none (pure JVM, all ABIs)
library: {{ pinyin4j_library_coordinates }}
```

{{ p_contract_service }}

******

### {{ h3_roadmap }}

******

{{ p_roadmap }}

- [{{ text_link_roadmap }}]({{ roadmap_url }})

******

### {{ h3_release_history }}

******

{{ placeholder_latest_release_history }}

##### {{ h5_for_more_release_history }}

* {{ placeholder_read_more_in_changelog_md }}

******

### {{ h3_build }}

******

{{ p_build_intro }}

{{ p_build_debug }}:

```powershell
.\gradlew.bat :app:assembleDebug
```

{{ p_build_release }}:

```powershell
.\gradlew.bat :app:assembleRelease
```

{{ p_build_artifacts }}

{{ p_build_params }}

******

### {{ h3_resource_layout }}

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

{{ p_resource_layout }}

******

### {{ h3_license }}

******

{{ p_license }}

******

### {{ h3_links }}

******

- {{ text_link_autojs6_docs_pinyin4j }}: {{ docs_pinyin4j_url }}
- {{ text_link_autojs6 }}: {{ autojs6_url }}
- {{ text_link_pinyin_plugin }}: {{ pinyin_repo_url }}
- {{ text_link_pinyin4j_official }}: {{ pinyin4j_official_url }}
- {{ text_link_pinyin4j_maven }}: {{ pinyin4j_maven_url }}

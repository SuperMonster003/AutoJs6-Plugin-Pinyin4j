<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-pinyin4j-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>用于中文转汉语拼音的 Pinyin4j 插件</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Pinyin4j?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Pinyin4j?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 语言 (Languages)

******

当前 README.md 支持以下语言:

- 简体中文 [zh-Hans] # 当前
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/.readme/README-ar.md)

******

### 简介

******

Pinyin4j 插件 (Pinyin4j Plugin) 为 AutoJs6 提供轻量的中文转汉语拼音能力. 安装后, 脚本可通过全局对象 `pinyin4j` 将中文文本逐字转换为拼音, 并按需配置大小写, 声调格式, `ü` 的表示方式与音节分隔符; 另提供将数字声调文本转换为声调符号的实用方法.

插件是一个独立安装的 APK, 运行于自身进程, 由 AutoJs6 通过插件机制自动发现并以 AIDL 通信. 转换能力来自经典 Java 库 [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), 安装包仅约 0.3 MB, 转换完全在设备本地完成, 无需网络. 自 AutoJs6 v6.8.0 起, 宿主的 `pinyin4j` 模块由本插件提供实现.

本插件与 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 互为姊妹插件: 本插件以极小体积提供简单可靠的逐字注音; Pinyin 插件内置完整字典与 Jieba 分词, 支持多音字消歧与姓氏模式, 适合追求读音准确性的场景. 两者可同时安装, 详见下方 `姊妹插件对比`.

******

### 功能亮点

******

- 开箱即用: 安装后由 AutoJs6 自动发现, 无需重启宿主, 脚本直接使用全局对象 `pinyin4j`.
- 极致轻量: 安装包仅约 0.3 MB, 纯 JVM 实现, 不含任何原生库, 适配全部 CPU 架构.
- 三种声调格式: 无声调, 数字声调 (`han4`) 与声调符号 (`hàn`), 按需选用.
- 灵活输出: 可配置大小写, `ü` 的三种表示方式 (`lv` / `lu:` / `lü`) 与任意音节分隔符.
- 声调工具: `pinyin4j.as(text)` 将数字声调文本一步转换为声调符号形式.
- 取值宽松: 选项大小写不敏感并支持多种简写别名 (如 `tone: "MARK"`), 非法取值给出本地化错误提示.
- 完全离线: 转换基于内置数据在设备本地完成, 不发起任何网络请求.
- 多语言: 插件信息, 使用说明, README 与更新日志覆盖 10 种语言.

******

### 使用方法

******

1. 将 AutoJs6 升级到内部版本号 3923 (6.7.1 Alpha4) 及以上; 自 v6.8.0 起拼音能力完全由插件承担, 推荐直接使用最新版本.
2. 从 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 页面下载插件 APK 安装到运行 AutoJs6 的设备上, 或直接在 AutoJs6 的插件中心在线安装.
3. 打开 AutoJs6 的插件中心, 确认 `Pinyin4j` 插件已被识别, 完成授权并处于启用状态.
4. 在脚本中直接调用 `pinyin4j` 全局对象, 参考下方 `快速上手` 示例; 也可先运行 `快速自检` 确认插件生效.

> 插件仅提供一个通用安装包 (纯 JVM 实现, 不区分 CPU 架构), 支持 Android 7.0 (API 24) 及以上的设备. 插件无独立界面, 安装后不在桌面创建图标, 由 AutoJs6 统一发现与管理.

******

### 快速上手

******

基础转换: 默认输出小写无声调拼音, 第二参数可直接传分隔符:

```javascript
console.log(pinyin4j.of("汉语拼音"));                             // "hanyupinyin"
console.log(pinyin4j.of("汉语拼音", " "));                        // "han yu pin yin"
console.log(pinyin4j.of("汉语拼音", { tone: "MARK", sep: " " })); // "hàn yǔ pīn yīn"
```

数字声调与 `ü` 的表示方式:

```javascript
console.log(pinyin4j.of("旅游", { tone: "NUMBER" }));             // "lv3you2"
console.log(pinyin4j.of("旅游", { tone: "NUMBER", v: "U:" }));    // "lu:3you2"
console.log(pinyin4j.of("旅游", { tone: "MARK" }));               // "lǚyóu"
```

声调工具: 将数字声调文本转换为声调符号:

```javascript
console.log(pinyin4j.as("han4 yu3 pin1 yin1"));                   // "hàn yǔ pīn yīn"
```

******

### 选项

******

`pinyin4j.of(text, options)` 支持以下选项 (括号内为可用简写键名):

| 选项 | 默认值 | 说明 |
|---|---|---|
| `caseType` (`case`) | `LOWERCASE` | 输出大小写: `LOWERCASE` 小写, `UPPERCASE` 大写 |
| `toneType` (`tone`) | `WITHOUT_TONE` | 声调格式: `WITHOUT_TONE` 无声调, `WITH_TONE_NUMBER` 数字声调, `WITH_TONE_MARK` 声调符号 |
| `vCharType` (`v`, `vChar`) | `WITH_V` | `ü` 的表示方式: `WITH_V` (`lv`), `WITH_U_AND_COLON` (`lu:`), `WITH_U_UNICODE` (`lü`); 声调符号格式下默认切换为 `WITH_U_UNICODE` |
| `separator` (`sep`) | `""` | 音节之间的分隔符, 可为任意字符串; 输出末尾的分隔符会被去除 |

取值不区分大小写且支持简写别名, 如 `tone: "MARK"` / `"NUMBER"` / `"NO"`, `case: "UP"` / `"LOW"`, `v: "V"` / `"U:"` / `"U"`. 传入非法取值时会抛出带本地化文案的异常.

******

### 脚本 API

******

`pinyin4j` 全局对象提供以下方法 (直接调用 `pinyin4j(text, options)` 等价于 `pinyin4j.of`):

```text
pinyin4j(text, options?)      -> string
pinyin4j.of(text, options?)   -> string
pinyin4j.of(text, separator)  -> string
pinyin4j.as(text)             -> string
```

- `of` 逐字转换: 基本汉字区 (U+4E00-U+9FA5) 内的字符转换为拼音, 其余字符原样保留; 每个字固定取 pinyin4j 词典的第一读音, 不做多音字消歧.
- `of` 的第二参数既可以是选项对象, 也可以直接传一个字符串作为分隔符.
- `as` 将文本中的数字声调音节 (如 `han4`) 替换为声调符号形式 (如 `hàn`), 兼容以 `v` 或 `u:` 表示的 `ü`, 无法识别的片段原样保留; 该方法对应插件 AIDL 接口中的 `asTone`.
- 选项取值大小写不敏感并支持多种简写 (见上方 `选项`), 非法取值会抛出带本地化文案的异常.
- 全部方法同步返回, 无需初始化等待.

******

### 快速自检

******

安装并启用插件后, 运行以下单行脚本:

```javascript
console.log(pinyin4j.of("拼音"));
```

输出 `pinyin` 即表示插件已正常工作.

******

### 常见问题

******

#### 如何确认插件已经生效?

打开 AutoJs6 的插件中心, 能看到 `Pinyin4j` 插件并处于启用状态即表示宿主已识别; 再运行上方 `快速自检` 脚本, 输出 `pinyin` 即为生效.

#### 脚本报错提示缺少插件或 `pinyin4j` 不可用?

请确认 AutoJs6 内部版本号不低于 3923, 且插件已在插件中心完成安装, 授权与启用. 自 AutoJs6 v6.8.0 起, 宿主不再内置 pinyin4j 库, 相关能力完全由本插件承担.

#### 为什么应用列表和桌面上没有插件图标?

这是正常现象. 插件没有独立界面, 也不在桌面创建启动图标, 安装后由 AutoJs6 在后台自动发现和调用, 全部交互都在 AutoJs6 内完成.

#### 多音字读音不符合预期 (如 "重庆" 未读作 chongqing)?

本插件按单字转换, 每个字固定取词典的第一读音, 不结合词组语境消歧, 这是轻量方案的固有取舍. 需要多音字消歧, 词组词典或姓氏读音时, 请使用姊妹插件 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### 文档或旧脚本中的 `pinyin4j.asTone(text)` 为什么不可用?

宿主侧该方法的名称是 `pinyin4j.as(text)`; `asTone` 是插件 AIDL 接口中的方法名, 二者行为一致. 请在脚本中使用 `pinyin4j.as(text)`.

#### 插件会联网或申请敏感权限吗?

不会. 转换数据内置于安装包, 转换在设备本地完成; 插件清单仅声明与 AutoJs6 通信所需的插件权限, 不申请网络, 存储等任何敏感系统权限.

#### 与姊妹插件 Pinyin 如何选择?

只需轻量逐字注音且在意安装包体积时选择本插件; 需要多音字, 分词, 词组或姓氏读音时选择 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin). 两者互不冲突, 可同时安装, 详见下方 `姊妹插件对比`.

******

### 权限与安全

******

插件在设计上尽可能收窄数据面与权限面:

- 最小权限: 插件清单仅声明 AutoJs6 插件权限 (`org.autojs.permission.PLUGIN`), 不申请网络, 存储, 相机等任何敏感系统权限.
- 本地转换: 待转换文本仅经 Binder 在设备内传递, 转换数据全部内置, 全程离线, 数据不出设备.
- 签名与授权: AutoJs6 会校验插件签名, 插件需在插件中心授权并启用后才能被脚本调用; 服务与唤醒入口均受插件权限保护, 第三方应用无法直接调用.
- 开源可审计: 插件代码与文档生成链路全部开源, 转换能力来自广泛使用的开源库 pinyin4j.

请仅从官方 [Releases](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/releases) 页面或 AutoJs6 插件中心获取插件安装包; 来源不明的安装包即使名称与版本号相同, 也可能被篡改.

******

### 姊妹插件对比

******

AutoJs6 官方提供两个拼音插件, 各有侧重, 可同时安装:

| 对比项 | [Pinyin4j](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j) | [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) |
|---|---|---|
| 底层实现 | 经典 Java 库 `pinyin4j` | 内置字典 + Jieba 分词 |
| 全局对象 | `pinyin4j` | `pinyin` |
| 多音字 | 不支持, 固定取首个读音 | 支持, 可返回全部候选 |
| 分词与词组 | 不支持, 逐字转换 | 支持 (词组词典 + Jieba) |
| 姓氏模式 | 不支持 | 支持 |
| 输出形式 | 字符串, 可配置分隔符 | 二维候选数组 (可 `compact()` 组合) 或紧凑字符串 |
| 风格与格式 | 3 种声调格式 + 大小写 + `ü` 表示方式 | 6 种拼音风格 |
| 安装包体积 | 约 0.3 MB | 约 6 MB (内置字典) |
| 适用场景 | 体积与简单性优先: 快速逐字注音 | 读音准确性优先: 多音字, 词组, 人名 |

两个插件互不依赖也互不冲突; 同时安装后, 脚本可按需分别调用 `pinyin4j` 与 `pinyin`. Pinyin 插件详见 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

******

### 插件接口

******

以下信息面向 AutoJs6 宿主与插件开发者, 宿主通过这些标识发现插件并完成能力协商:

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

`Pinyin4jPluginService` 响应 `org.autojs.plugin.PINYIN4J` action (category `pinyin4j`), 通过 AIDL 接口 `IPinyin4jPlugin` 暴露 3 个方法; `of` 的选项经 `Bundle` 传递 (键: `caseType` / `toneType` / `vCharType` / `separator`), 非法取值抛出带本地化文案的 `IllegalArgumentException`. 服务与 `WakeActivity` 均受 `org.autojs.permission.PLUGIN` 权限保护, 第三方应用无法直接调用.

******

### 开发路线图

******

插件的能力规划与完成情况以可勾选清单维护在 ROADMAP.md 中, 按里程碑组织并附验收条件, 涵盖多读音查询, 更多罗马化体系, 字符覆盖范围与持续集成等方向. 未勾选条目表示规划意向而非当前版本能力, 欢迎通过 Issues 参与讨论.

- [查看 ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### 发行历史

******

#### v1.1.0

_2026/09/01_

- `修复` 移除非空白分隔符导致的输出末尾残留, 并精确保留包括首尾空白在内的非汉字字符
- `修复` 将 pinyin4j 2.5.1 使用 breve 的旧式第三声元音统一为标准 caron 形式 (如 `yŭ` 转为 `yǔ`), 同时覆盖大小写
- `优化` 新增 JVM 单元测试, 覆盖选项标准名与别名, 取值简写, 输出组合, 默认值, 异常, 声调转换及运行时元数据; 新增 Android instrumentation 测试验证真实服务发现与 Binder 往返
- `优化` 新增 GitHub Actions 工作流, 自动拦截生成文档漂移, 运行单元测试, 构建 debug APK, 编译 instrumentation 测试并上传 APK 产物
- `优化` 新增 `.python/prepare_release.py`, 一键构建并验证签名 universal APK, 校验版本, 计算 CRC32 与 SHA-256, 原子生成 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
- `优化` 统一 README 版式与 Gradle 平台版本管理方式

#### v1.0.1

_2026/08/31_

- `提示` 本版本仅改进文档与配套工程, 拼音转换行为与全部脚本 API 保持不变
- `修复` 修正旧版文档中错误的 `pinyin4j.asTone(text)` 写法: 宿主实际暴露的方法为 `pinyin4j.as(text)` (底层 AIDL 接口方法名仍为 `asTone`)
- `优化` 重构 10 种语言的 README: 新增使用方法, 快速上手, 选项速查表, 脚本 API, 快速自检, 常见问题, 权限与安全, 姊妹插件对比及插件接口等章节
- `优化` 文档生成脚本升级为同族插件统一实现: 支持 `--check` 漂移检测, 跨语言键位与形状对齐校验, 全角符号拦截以及版本对齐校验
- `优化` 插件中心使用说明 (`plugin_instruction.md`) 纳入同一套多语言 JSON 生成链路, 消除双源维护
- `优化` 新增 ROADMAP.md 开发路线图, 并与姊妹插件 Pinyin 建立双向互链与选型对比

#### v1.0.0

_2026/07/15_

- `新增` Pinyin4j 插件服务: 插件 ID 为 `pinyin4j`, 由 AutoJs6 通过 `org.autojs.plugin.PINYIN4J` 自动发现并调用, 封装 `com.belerweb:pinyin4j:2.5.1` 库
- `新增` 拼音转换 API: `pinyin4j.of(text, options)` 将中文逐字转换为汉语拼音, 第二参数传入字符串时直接作为分隔符
- `新增` 声调还原 API: `pinyin4j.as(text)` 将数字声调拼音 (如 `han4`) 还原为符号声调拼音 (如 `hàn`), 对应 AIDL 接口方法 `asTone`
- `新增` 灵活的选项体系: 支持 `case` / `tone` / `v` / `sep` 等别名与 `MARK` / `NUMBER` / `NO` 等取值简写, 非法取值抛出本地化错误提示
- `新增` 多语言资源: 插件信息与使用说明覆盖 10 种语言
- `新增` README 与 CHANGELOG 由 JSON 源文件与 `.python/generate_markdown.py` 生成多语言 Markdown

##### 更多发行历史可参阅

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hans.md)

******

### 构建

******

本节面向希望从源码构建插件的开发者.

构建 debug APK:

```powershell
.\gradlew.bat :app:assembleDebug
```

构建 release APK (单一通用包; 在不入库的 `sign.properties` 中配置签名后自动签名):

```powershell
.\gradlew.bat :app:assembleRelease
```

生成已验证的发布归档可运行 `py .python/prepare_release.py`. 脚本会检查生成文档, 构建并验证签名 universal APK, 校验版本元数据, 计算 CRC32 与 SHA-256, 并将 APK, `SHA256SUMS.txt` 及英文 `RELEASE_NOTES.md` 原子写入 `app/releases/v<版本号>`.

构建参数集中于 `version.properties`: 最低 SDK 24 (Android 7.0), 目标 SDK 36, 当前版本 1.1.0.

******

### 本地化与文档生成

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

`strings.xml` 提供本地化插件描述与错误信息, `plugin_instruction.md` 提供宿主插件中心展示的使用说明. README, 更新日志与使用说明均由 JSON 源生成: 修改 `.readme/` 与 `.changelog/` 下的源文件后运行 `py .python/generate_markdown.py` 重新生成全部产物, 生成产物不手工编辑; 运行 `py .python/generate_markdown.py --check` 可校验源文件与产物是否同步.

******

### 许可

******

项目代码使用 [Mozilla Public License 2.0](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/LICENSE). 拼音转换能力来自 [pinyin4j](https://github.com/belerweb/pinyin4j) 库 (`com.belerweb:pinyin4j:2.5.1`).

******

### 相关链接

******

- AutoJs6 Pinyin4j 文档: https://docs.autojs6.com/#/pinyin4j
- AutoJs6 项目: https://github.com/SuperMonster003/AutoJs6
- 姊妹插件 Pinyin: https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin
- pinyin4j 项目: https://github.com/belerweb/pinyin4j
- pinyin4j Maven 坐标: https://mvnrepository.com/artifact/com.belerweb/pinyin4j

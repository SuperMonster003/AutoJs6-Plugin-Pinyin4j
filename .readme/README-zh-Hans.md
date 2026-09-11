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

Pinyin4j 插件 (Pinyin4j Plugin) 为 AutoJs6 提供轻量逐字罗马化能力. 脚本既可输出格式化的汉语拼音字符串, 也可按 Unicode 码点查询 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 或 Gwoyeu Romatzyh 的全部词典读音矩阵, 并可将数字声调文本转换为声调符号.

插件是一个独立安装的 APK, 运行于自身进程, 由 AutoJs6 通过插件机制自动发现并以 AIDL 通信. 转换能力来自经典 Java 库 [pinyin4j](https://github.com/belerweb/pinyin4j) (`com.belerweb:pinyin4j:2.5.1`), release 实测仅 376 KiB, 转换完全在设备本地完成, 无需网络. 自 AutoJs6 v6.8.0 起, 宿主的 `pinyin4j` 模块由本插件提供实现.

本插件与 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 互为姊妹插件: 本插件以极小体积提供简单可靠的逐字注音; Pinyin 插件内置完整字典与 Jieba 分词, 支持多音字消歧与姓氏模式, 适合追求读音准确性的场景. 两者可同时安装, 详见下方 `姊妹插件对比`.

******

### 功能亮点

******

- 开箱即用: 安装后由 AutoJs6 自动发现, 无需重启宿主, 脚本直接使用全局对象 `pinyin4j`.
- 极致轻量: release 实测仅 376 KiB, 纯 JVM 实现, 不含任何原生库, 适配全部 CPU 架构.
- 三种声调格式: 无声调, 数字声调 (`han4`) 与声调符号 (`hàn`), 按需选用.
- 灵活输出: 可配置大小写, `ü` 的三种表示方式 (`lv` / `lu:` / `lü`) 与任意音节分隔符.
- 声调工具: `pinyin4j.as(text)` 将数字声调文本一步转换为声调符号形式.
- 全读音与六体系: `pinyin4j.readings(text, options)` 为每个 Unicode 码点返回一行有序候选, 支持 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 与 Gwoyeu Romatzyh.
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

全部候选读音与其他罗马化体系:

```javascript
console.log(pinyin4j.readings("重A𠀀"));
// [["zhong4", "chong2"], ["A"], ["𠀀"]]

console.log(pinyin4j.readings("间", { system: "WADE_GILES" }));
// [["chien1", "chien4"]]
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
pinyin4j.readings(text, options?) -> string[][]
```

- `of` 按 Unicode code point 逐字转换: 直接查询 pinyin4j 2.5.1 词典, 可转换其实际收录的 20,378 个 BMP 字符 (含 `〇`); 无词条和补充平面字符完整原样保留, 每字仍取第一读音且不做语境消歧.
- `readings` 返回按 Unicode 码点逐行对齐的有序 `string[][]`. Hanyu 默认小写数字声调并支持既有 case/tone/v 选项; `romanization` (或 `system`) 可选择 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 或 Gwoyeu Romatzyh. 非 Hanyu 体系拒绝显式 Hanyu 专属格式选项, 分隔符不适用于矩阵.
- AutoJs6 通过 `pinyin4j.readings.version = 1` 协商能力: 旧插件可安全生成 Hanyu 单候选行, 非 Hanyu 请求需要新版插件. Node.js 可通过带显式 `pinyin4j` capability 的 `autojs6:bridge.callAutoJs` 异步调用同一 provider.
- `of` 的第二参数既可以是选项对象, 也可以直接传一个字符串作为分隔符.
- `as` 只转换边界完整且被词表识别的 `0`-`4` 数字声调音节, 正确处理大小写以及 `v` / `u:` / `ü`; 无效音节, 数字 `5` 和相邻字母数字片段原样保留. 该方法对应插件 AIDL 接口中的 `asTone`.
- 选项取值大小写不敏感并支持多种简写 (见上方 `选项`), 非法取值会抛出带本地化文案的异常.
- 全部方法同步返回; 首次转换会延迟加载 pinyin4j 词表, 因此比稳态调用慢, 实测数据见转换性能基线.

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

`pinyin4j.of` 仍按单字转换并固定取词典首个读音. 使用 `pinyin4j.readings` 可取得每个字的全部词典候选, 但不会结合词组语境自动选择. 需要语境消歧, 词组词典或姓氏读音时, 请使用姊妹插件 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).

#### 文档或旧脚本中的 `pinyin4j.asTone(text)` 为什么不可用?

宿主侧该方法的名称是 `pinyin4j.as(text)`; `asTone` 是插件 AIDL 接口中的方法名, 二者行为一致. 请在脚本中使用 `pinyin4j.as(text)`.

#### 插件会联网或申请敏感权限吗?

不会. 转换数据内置于安装包, 转换在设备本地完成; 插件清单仅声明与 AutoJs6 通信所需的插件权限, 不申请网络, 存储等任何敏感系统权限.

#### 与姊妹插件 Pinyin 如何选择?

只需轻量逐字注音或全部候选列表且在意安装包体积时选择本插件; 需要多音字语境消歧, 分词, 词组词典或姓氏读音时选择 [Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin). 两者互不冲突, 可同时安装, 详见下方 `姊妹插件对比`.

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
| 多音字 | `readings` 返回全部候选, 不做语境消歧 | 支持, 可返回全部候选 |
| 分词与词组 | 不支持, 逐字转换 | 支持 (词组词典 + Jieba) |
| 姓氏模式 | 不支持 | 支持 |
| 输出形式 | 格式化字符串或按 Unicode 对齐的候选矩阵 | 二维候选数组 (可 `compact()` 组合) 或紧凑字符串 |
| 风格与格式 | 6 种罗马化体系; Hanyu 支持 3 种声调 + 大小写 + `ü` 形式 | 6 种拼音风格 |
| 安装包体积 | 376 KiB ([release 实测基线](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/apk-size-baseline-2026-09-01.md)) | 5.95 MiB ([full release 实测](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md), 内置字典) |
| 性能特征 | 轻量逐字路径; [JVM/Android 实测基线](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/performance/conversion-baseline-2026-09-01.md) | [分词器实测](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md); 词典, 分词与多音字能力更重, 性能随模式变化 |
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
binder methods: getInfo / of / asTone / readings
minimum host build: 3923
native library: none (pure JVM, all ABIs)
library: com.belerweb:pinyin4j:2.5.1
```

`Pinyin4jPluginService` 响应 `org.autojs.plugin.PINYIN4J` action (category `pinyin4j`), 通过 `IPinyin4jPlugin` 暴露 4 个方法. `readings` 追加在末尾以保持 transaction 顺序, 返回严格有界的 JSON 矩阵, 并以整数 capability `pinyin4j.readings.version = 1` 宣告; 旧宿主继续使用 `of` 与 `asTone`. 非法选项抛出 `IllegalArgumentException`. 服务与 `WakeActivity` 均受 `org.autojs.permission.PLUGIN` 权限保护, 第三方应用无法直接调用.

******

### 开发路线图

******

ROADMAP.md 以证据清单记录里程碑. M3 已在 v1.3.0 完成: Unicode 与声调边界, 全读音矩阵, 六种罗马化体系, 追加式 AIDL 能力协商, Rhino 与 Node.js 宿主路由以及旧插件 Hanyu 回退均已实现并测试. M4 的依赖风险, 性能, 体积与选型基线保持完成.

- [查看 ROADMAP.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/ROADMAP.md)

******

### 发行历史

******

#### v1.3.0

_2026/09/11_

- `提示` `pinyin4j.readings()` 与 Node.js provider 需要包含 readings v1 契约的新版 AutoJs6 宿主; 旧版宿主仍可继续使用 `of` 与 `as`
- `新增` `pinyin4j.readings(text, options)` 按 Unicode 码点逐行返回全部有序词典读音, 无映射输入原样保留为单候选
- `新增` `romanization` / `system` 开放 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 与 Gwoyeu Romatzyh; Hanyu 支持数字/符号/无声调, 大小写与 `ü` 形式
- `优化` 在 Binder 末尾追加 `readings` transaction 与整数 capability `pinyin4j.readings.version = 1`; 新宿主仅在协商后调用, 对旧插件按码点安全回退为 Hanyu 单候选
- `优化` 增加严格的源文本, 矩阵与 UTF-8 JSON 上限及 Android 9/12/13/15 Binder 覆盖; 同一插件能力通过宿主显式 `pinyin4j` capability 向 Node.js 开放
- `优化` 构建阶段阻止意外引入原生依赖, 并输出 JSON 校验报告

#### v1.2.0

_2026/09/01_

- `提示` 多读音与六种罗马化体系目前仅作为经过测试的插件侧核心和契约方案; 在 AutoJs6 AIDL 与宿主路由升级前, `pinyin4j.readings()` 不是公开脚本 API
- `修复` `of` 不再丢失词典空洞字符或拆分补充平面字符: 现按 Unicode code point 遍历, 转换包括 `〇` 在内的全部实际词条, 完整保留无词条输入并让分隔符与 code point 对齐
- `修复` `pinyin4j.as(text)` 现只转换完整有效的数字声调音节, 保留无效或嵌入字母数字的片段, 支持大小写及 `v` / `u:` / `ü`, 并正确处理 `jue4` -> `juè` 一类普通 `ue` 拼写
- `优化` 以穷举 BMP 测试固定词典真实覆盖: 共 20,378 个映射, 其中 20,377 个位于 U+4E00-U+9FA5, 另一个为 `〇`; 旧范围内 525 个空洞和语料 SHA-256 指纹也纳入回归
- `优化` 新增经过测试的全部候选读音核心, 覆盖 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 与 Gwoyeu Romatzyh, 并记录追加式 JSON AIDL, 能力协商和旧实现回退方案
- `优化` 新增 pinyin4j 2.5.1 风险清单, 记录二进制与源码哈希, 上游和许可证元数据问题, 已知边界及升级或分叉门禁
- `优化` 新增可复测的 JVM 与 Android Service/AIDL 入口性能基线, release APK ZIP/资源体积分析器, 并用实测数据更新姊妹插件选型对比

#### v1.1.0

_2026/09/01_

- `修复` 移除非空白分隔符导致的输出末尾残留, 并精确保留包括首尾空白在内的非汉字字符
- `修复` 将 pinyin4j 2.5.1 使用 breve 的旧式第三声元音统一为标准 caron 形式 (如 `yŭ` 转为 `yǔ`), 同时覆盖大小写
- `优化` 新增 JVM 单元测试, 覆盖选项标准名与别名, 取值简写, 输出组合, 默认值, 异常, 声调转换及运行时元数据; 新增 Android instrumentation 测试验证真实服务发现与 Binder 往返
- `优化` 新增 GitHub Actions 工作流, 自动拦截生成文档漂移, 运行单元测试, 构建 debug APK, 编译 instrumentation 测试并上传 APK 产物
- `优化` 新增 `.python/prepare_release.py`, 一键构建并验证签名 universal APK, 校验版本, 计算 CRC32 与 SHA-256, 原子生成 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
- `优化` 统一 README 版式与 Gradle 平台版本管理方式

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

构建参数集中于 `version.properties`: 最低 SDK 24 (Android 7.0), 目标 SDK 36, 当前版本 1.3.0.

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin4j/blob/master/docs/16kb.md)

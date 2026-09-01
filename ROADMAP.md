# AutoJs6 Pinyin4j 插件 Roadmap

更新日期: 2026-09-01

本文档是 Pinyin4j 插件从"轻量的逐字符拼音转换服务"逐步演进为"文档完善, 工程可靠, 能力可扩展"的拼音方案的执行清单. 每个条目只有在代码/文档与可验证的验收条件同时满足后才可勾选.

## 状态与证据规则

- `[x]`: 已完成, 且本仓库存在可复核证据 (代码, 测试, 脚本或生成产物).
- `[ ]`: 尚未完成; 括号中的 `插件` / `API` / `宿主` / `测试` / `CI` / `发布` / `依赖` 表示主要落点.
- 未勾选条目属于规划意向, 不代表当前版本能力; 标注 "宿主先行" 的条目需等待 AutoJs6 宿主先行支持, 标注 "契约升级" 的条目涉及 AIDL 契约变更, 需插件与宿主协同演进.

## 总览

| 里程碑 | 状态 | 核心结果 | 主要落点 |
|---|---|---|---|
| M0 基线插件 | 已完成 | Pinyin4j 转换服务与多语言资源 | 插件/发布 |
| M1 文档与发布体验 | 已完成 | 用户导向文档, 文档自动生成与校验, v1.0.1 | 发布 |
| M2 工程化与持续集成 | 已完成 | JVM/真机 Binder 测试, 构建与文档 CI, 可追溯发布物料 | 测试/CI/发布 |
| M3 转换能力增强 | 已完成 | Unicode/asTone, 全读音矩阵, 六体系, Rhino/Node 与新旧插件协商 | API/插件/宿主 |
| M4 依赖与生态演进 | 已完成 | 上游风险清单, 性能与体积基线, 实测选型指引 | 依赖/测试/发布 |

依赖顺序:

```text
M0 ──> M1 ──> M2 ──> M3 (v1.3.0 完成宿主协同)
        └──────────> M4 (依赖/基线项可与 M2/M3 并行)
```

## M0: 基线插件 (v1.0.0, 已完成)

- [x] (插件) Pinyin4j 插件服务与 AIDL 契约: `Pinyin4jPluginService` 响应 `org.autojs.plugin.PINYIN4J` (category `pinyin4j`), Binder 接口为 `IPinyin4jPlugin`, 提供 `getInfo()` / `of(text, options)` / `asTone(text)` 三个方法 (`app/src/main/java/io/github/supermonster003/autojs6/plugin/pinyin4j/Pinyin4jPluginService.kt`); 另提供 `WakeActivity` 供宿主唤醒插件进程.
- [x] (依赖) 直通 `com.belerweb:pinyin4j:2.5.1` 转换引擎: 逐字符转换 U+4E00-U+9FA5 范围内汉字并取首个读音, 其余字符原样保留.
- [x] (插件) 输出格式选项: caseType / toneType / vCharType / separator 及其别名 (case, tone, v, vChar, sep) 与取值简写 (MARK / NUMBER / NO, UP / LOW, U: / V / U); 第二参数为字符串时直接作为分隔符; 非法取值抛出带本地化文案的参数错误; MARK 声调下 ü 默认采用 Unicode 形式.
- [x] (插件) `PluginInfo` 完整上报: id/engine/variant, 版本名与版本号, 作者, 最低宿主版本 (versionCode 3923, 即 AutoJs6 6.7.1 Alpha4) (`app/src/main/java/io/github/supermonster003/autojs6/plugin/pinyin4j/PluginRuntimeInfo.kt`).
- [x] (发布) 轻量纯 JVM 实现, 单一 universal APK (约 312 KB), 无原生库依赖; 多语言资源: `strings.xml` 与 `plugin_instruction.md` 覆盖 10 种语言.

验收条件: 在 versionCode 不低于 3923 的 AutoJs6 中安装, 授权并启用后, 脚本可直接调用 `pinyin4j.of` 与 `pinyin4j.as` 完成拼音转换与声调还原. (已满足)

## M1: 文档与发布体验 (v1.0.1, 已完成)

- [x] (发布) README 重构为用户导向结构 (2026-08-31): 简介 / 功能亮点 / 使用方法 / 快速上手 / 选项 / 脚本 API / 快速自检 / 常见问题 / 权限与安全 / 姊妹插件对比 / 插件接口 / 开发路线图 / 构建 / 本地化与文档生成, 10 种语言全部由 JSON 源自动生成.
- [x] (发布) 修正历史文档错误: 宿主脚本方法为 `pinyin4j.as(text)`, 而非旧文档所写的 `pinyin4j.asTone(text)` (asTone 仅为 AIDL 接口内部方法名); README 与插件说明已统一为正确写法并附对应关系说明.
- [x] (发布) CHANGELOG 文案面向用户重写: 每条先讲可感知的结果, 再补技术细节, 10 种语言同步.
- [x] (发布) 文档生成脚本升级至同族插件最新实现 (`.python/generate_markdown.py`): 新增 `--check` 漂移检测, 跨语言键位与列表形状对齐校验, 全角符号拦截, 以及 `version.properties` 与最新 CHANGELOG 条目的版本对齐校验; 配套 `.python/check_markdown.bat`.
- [x] (发布) `plugin_instruction.md` 纳入生成链路: `.readme/template_plugin_instruction.md` 与同一组 10 语言 JSON 生成全部 11 份 Android 资源产物, 消除双源维护.
- [x] (发布) 新增与姊妹项目 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin) 的互链与逐项对比表, 帮助用户按需选择实现.
- [x] (发布) 新建本 ROADMAP.md 并在 README 增加 "开发路线图" 章节挂链; 版本提升至 v1.0.1 (versionBuild 10), CHANGELOG 同步记录本次文档整改.

验收条件: `.python/generate_markdown.py --check` 本地全绿; 新用户仅凭 README 即可独立完成安装, 生效确认与首次转换. (已满足)

## M2: 工程化与持续集成 (v1.1.0, 已完成)

- [x] (测试) 单元测试基础设施与首批 JVM 用例: `app/src/test/` 下 11 个用例覆盖选项标准名/别名/取值简写等价性, 非法取值, case x tone x v 代表矩阵, 默认值与 MARK 时 Unicode ü, 分隔符/非汉字边界, 声调还原及 `PluginRuntimeInfo` 字段拼装; 转换核心拆至 `Pinyin4jConverter.kt`, Binder 契约保持不变.
- [x] (测试) instrumentation 用例: `Pinyin4jPluginServiceTest` 通过 `org.autojs.plugin.PINYIN4J` + `pinyin4j` 发现并绑定真实 Service, 经 AIDL 接口断言 `getInfo()` 全部运行时字段, 对 of/asTone 往返并覆盖 null, 中英混排, 标准键/别名, 自定义分隔符和异常输入; 已在 Android 15 真机执行通过. 测试与 Service 同包同进程, 因此验证 Service/AIDL 入口但不冒充 AutoJs6 跨包 Binder 互操作.
- [x] (CI) GitHub Actions 文档工作流 `.github/workflows/markdown.yml`: push/PR/手动运行 `generate_markdown.py --check`, 阻止 JSON 源与 36 份生成产物漂移.
- [x] (CI) GitHub Actions 构建流水线 `.github/workflows/build.yml`: push/PR/手动运行 `:app:testDebugUnitTest`, `:app:assembleDebug` 与 `:app:assembleDebugAndroidTest`, 上传 debug APK, 失败时保留测试报告; 平台版本插件迁移到可从公共仓库冷启动的永久 ID `io.github.supermonster003.autojs6-platform-versions` 1.6.0.
- [x] (发布) Release 产物脚本化: `.python/prepare_release.py` 一键校验文档, 构建并经 `apksigner` 验证签名 universal APK, 对齐 `version.properties`/APK 元数据, 计算 CRC32/SHA-256, 再以同目录临时文件 + `os.replace` 原子生成 APK, `SHA256SUMS.txt` 及基于英文 CHANGELOG 的 `RELEASE_NOTES.md`; v1.1.0 物料已实跑生成并复核哈希.

验收条件: 主分支每次提交自动完成构建, 单元测试与文档校验; instrumentation 测试可在连接设备上执行; 发布产物由脚本生成, 已验证签名且哈希可追溯. (已满足)

## M3: 转换能力增强 (v1.2.0-v1.3.0, 已完成)

- [x] (插件/测试) 多音字插件侧核心 (2026-09-01): `Pinyin4jReadings` 按 Unicode code point 返回有序候选, 默认 Hanyu 候选保留数字声调以免不同读音在去调后错误合并; 非词典字符的核心候选为空, 传输行固定回退为 `[source]`. JVM 用例固定 `重` / `间` 候选顺序, 非 BMP 回退及候选传输形状, 当前公开 `of()` 仍只取第一读音且不做语境消歧.
- [x] (API/契约) 多读音公共接口 (2026-09-01): AutoJs6 `pinyin4j-api` 在 AIDL 末尾追加 `readings(text, options)` 并返回严格 JSON 二维字符串数组, 以 `pinyin4j.readings.version = 1` 完成新旧协商; 共享契约同时固定 16,384 个源 code point, 512 KiB JSON, 每行 64 个候选和每个候选 64 个 code point 的上限 (`docs/api/advanced-conversion-contract.md`).
- [x] (API/宿主/契约升级) 发布多读音接口 (v1.3.0): 插件使用新版 `pinyin4j-api.aar` 实现 Binder JSON 事务并宣告 readings v1; AutoJs6 宿主在 capability 存在时调用新事务, 旧插件仅对 Hanyu 按 code point 调用 `of()` 并包装单候选行, 非 Hanyu 明确拒绝; Rhino 公开 `pinyin4j.readings()` 并对返回矩阵执行行数, 类型, 候选数和大小校验.
- [x] (插件/测试) 六种罗马化体系核心 (2026-09-01): 已固定 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 与 Gwoyeu Romatzyh 对 `间` 的完整候选矩阵和体系别名/非法值行为; 非 Hanyu 输出忠实保留 pinyin4j 映射表正字法, Hanyu 的 case/tone/v 格式选项单独测试.
- [x] (API/宿主) 发布罗马化体系选项 (v1.3.0): `pinyin4j.readings(text, { romanization })` 及别名 `system` 公开六种体系; Hanyu 默认数字声调并支持 case/tone/v, 非 Hanyu 显式传入 Hanyu 专属格式选项会在宿主和插件两层拒绝, separator 对二维矩阵始终不适用.
- [x] (插件/测试) 字符覆盖范围核查与修复 (2026-09-01): 穷举 BMP 得到 pinyin4j 2.5.1 共 20,378 个有效映射, 其中 20,377 个位于 U+4E00-U+9FA5, 唯一范围外映射为 U+3007 `〇`; 旧范围 20,902 个 code point 中 525 个无词条, 扩展 A, 兼容区及补充平面无有效映射. `of()` 现直接查询实际词条并按 code point 回退, 因而可转换 `〇`, 不再让无词条字符消失, 也不拆 UTF-16 代理对; 穷举数量, 分区分布与语料 SHA-256 均由测试固定.
- [x] (插件/测试) `asTone` 边界行为固化 (2026-09-01): 仅转换边界完整且属于固定拼音音节集的 `0`-`4` 数字声调 token; 支持大小写和 `v` / `u:` / `ü`, 按 a/e/ou/末元音规则放置声调, `jue4` 正确得到 `juè`; 非法音节, 数字 `5` 及嵌入字母数字的片段保持原样, 不因局部失败中断整段文本.
- [x] (宿主/测试) Node.js 运行时支持 (v1.3.0): AutoJs6 注册显式 `pinyin4j` capability 和 provider, 通过公开 `autojs6:bridge.callAutoJs` 提供异步 `of` / `as` / `readings`; Node 请求复用 Android 插件宿主和同一参数归一化, 仅允许严格 JSON 值通过桥, 并由 provider 注册表, permission manifest, broker declaration 与端到端运行时测试覆盖.

验收条件: Unicode 与 `asTone` 行为由 JVM/真机 Service/AIDL 测试固定; 新版插件在 Android 9/12/13/15 真机完成 Binder capability 与 Hanyu/非 Hanyu readings 往返, 宿主在同四台设备完成原生协商, 旧插件回退, 恶意矩阵拒绝和 Node 路由定向测试; 公共文档, 离线文档与 TypeScript 声明同步. (已满足)

## M4: 依赖与生态演进 (v1.2.0, 已完成)

- [x] (依赖/测试) 上游冻结风险应对 (2026-09-01): `docs/dependency/pinyin4j-2.5.1-risk-register.md` 锁定 Maven 坐标及二进制/源码 JAR SHA-256, 记录 Maven Central 发布状态, GitHub 上游活动, POM 与源码头许可证元数据不一致, 覆盖/多音字/第三声/其他体系边界及升级或维护性分叉的七项门禁; `Pinyin4jCoverageTest` 以全部 BMP 映射语料指纹提供逐字节级回归锚点.
- [x] (测试/发布) 体积与性能基线 (2026-09-01): `benchmarkPinyin4j` 可复测首次词表初始化, 稳态单字和 832 code point 长文本吞吐; Android 15 真机 instrumentation 记录 Service 绑定, 首次 Service/AIDL 转换及稳态吞吐, 并明确 instrumentation 已启动进程且同包同进程, 不把该值冒充完整冷启动或跨包 Binder 成本. `scripts/ci/analyze_apk_size.py` 校验 release APK, 四份 pinyin4j 数据, DEX 与零原生库并生成条目级体积报告; 证据见 `docs/performance/`.
- [x] (发布) 姊妹插件选型指引维护 (2026-09-01): 10 种语言对比表同步当前能力, 实测 release 体积与可复测性能资料; Pinyin 的 5.95 MiB full 包, 分词器基准及其模式差异链接到姊妹仓库原始报告. 两套基准输入和设备不同, 因此只呈现各自数据与能力成本, 不制造不可比的速度倍数.

验收条件: 依赖制品和完整词典语料均有指纹; release 体积与 JVM/Android 性能可由仓库命令复测; 对比文档区分可比事实与测量边界. (已满足)

## 边界 (非目标)

- 不做词级分词与语境消歧: 逐字符转换是本插件的设计定位; 需要词级分词, 多音字消歧或姓氏模式请使用姊妹项目 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).
- 不提供独立界面与桌面入口: 插件仅通过 AutoJs6 插件权限被宿主调用, 不接受第三方应用访问.
- 不自定义宿主 API 形态: `pinyin4j` 全局对象的方法集由 AutoJs6 宿主定义, 插件侧忠实提供转换能力.
- 不引入网络能力: 转换始终基于内置词表在设备本地完成.

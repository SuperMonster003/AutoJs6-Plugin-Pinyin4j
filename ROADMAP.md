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
| M3 转换能力增强 | 规划中 | 多音字接口, 其他罗马化体系, 字符覆盖, 边界行为固化 | API/插件/宿主 |
| M4 依赖与生态演进 | 规划中 | 上游冻结风险应对, 性能与体积基线, 选型指引维护 | 依赖/测试/发布 |

依赖顺序:

```text
M0 ──> M1 ──> M2 ──> M3 (契约条目需与宿主协同)
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
- [x] (测试) instrumentation 用例: `Pinyin4jPluginServiceTest` 通过 `org.autojs.plugin.PINYIN4J` + `pinyin4j` 发现并绑定真实 Binder 服务, 断言 `getInfo()` 全部运行时字段, 对 of/asTone 往返并覆盖 null, 中英混排, 标准键/别名, 自定义分隔符和异常输入; 已在 Android 15 真机执行通过.
- [x] (CI) GitHub Actions 文档工作流 `.github/workflows/markdown.yml`: push/PR/手动运行 `generate_markdown.py --check`, 阻止 JSON 源与 36 份生成产物漂移.
- [x] (CI) GitHub Actions 构建流水线 `.github/workflows/build.yml`: push/PR/手动运行 `:app:testDebugUnitTest`, `:app:assembleDebug` 与 `:app:assembleDebugAndroidTest`, 上传 debug APK, 失败时保留测试报告; 平台版本插件迁移到可从公共仓库冷启动的永久 ID `io.github.supermonster003.autojs6-platform-versions` 1.6.0.
- [x] (发布) Release 产物脚本化: `.python/prepare_release.py` 一键校验文档, 构建并经 `apksigner` 验证签名 universal APK, 对齐 `version.properties`/APK 元数据, 计算 CRC32/SHA-256, 再以同目录临时文件 + `os.replace` 原子生成 APK, `SHA256SUMS.txt` 及基于英文 CHANGELOG 的 `RELEASE_NOTES.md`; v1.1.0 物料已实跑生成并复核哈希.

验收条件: 主分支每次提交自动完成构建, 单元测试与文档校验; instrumentation 测试可在连接设备上执行; 发布产物由脚本生成, 已验证签名且哈希可追溯. (已满足)

## M3: 转换能力增强 (规划中)

- [ ] (API/契约升级) 多音字读音接口评估: pinyin4j 的 `toHanyuPinyinStringArray` 本身返回全部候选读音, 当前插件仅取首个; 评估新增按字符返回候选数组的只读接口或 heteronym 选项, 先升级 AIDL 契约与宿主路由并保留旧宿主的单读音回退, 再更新文档与对比表.
- [ ] (API/契约升级) 其他罗马化体系评估: pinyin4j 原生支持通用拼音, 威妥玛 (Wade-Giles), 注音二式 (MPS2), 耶鲁 (Yale) 与国语罗马字 (Gwoyeu Romatzyh); 评估以显式体系参数暴露, 明确这些体系不适用现有 toneType/vCharType 选项时的行为与降级策略.
- [ ] (插件) 字符覆盖范围核查: 当前入口显式限定 U+4E00-U+9FA5; 核查 pinyin4j 词表对扩展区与兼容区汉字的实际覆盖, 如有数据支撑则放宽入口范围, 并为无读音字符明确回退行为; 以语料测试固定边界.
- [ ] (插件/测试) `asTone` 边界行为固化: 明确混合文本, 非法音节, u:/v 写法与大小写输入的处理预期并以测试固化; 设计意向为对无法解析的片段保持原样输出而非中断.
- [ ] (宿主先行) Node.js 运行时支持: 宿主侧 `pinyin4j` 目前为 Rhino 专属; 待宿主完成调用路由后复用同一插件能力, 并更新 FAQ.

验收条件: 每项能力先有 API 契约与旧实现回退测试, 再修改宿主与插件; 未发布的宿主能力不提前标记为插件现有功能.

## M4: 依赖与生态演进 (规划中)

- [ ] (依赖) 上游冻结风险应对: `com.belerweb:pinyin4j:2.5.1` 上游已长期停止更新; 建立已知问题清单 (读音数据勘误, 词表覆盖), 制定应对预案: 优先保持坐标锁定不动, 如需修正数据再评估维护性分叉或仓库内源码内嵌, 并保留可逐字节比对的迁移证据.
- [ ] (测试) 体积与性能基线: 记录 APK 体积, 冷绑定耗时, 单字与长文本转换吞吐, 作为后续任何依赖调整的回归防线.
- [ ] (发布) 姊妹插件选型指引维护: 随双方能力演进同步更新对比表 (词级分词, 多音字, 体积, 速度), 确保两个仓库的对比结论不过期.

验收条件: 任何依赖调整均有逐字节或语料级差分证据; 对比文档与实际能力保持同步.

## 边界 (非目标)

- 不做词级分词与语境消歧: 逐字符转换是本插件的设计定位; 需要词级分词, 多音字消歧或姓氏模式请使用姊妹项目 [AutoJs6-Plugin-Pinyin](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin).
- 不提供独立界面与桌面入口: 插件仅通过 AutoJs6 插件权限被宿主调用, 不接受第三方应用访问.
- 不自定义宿主 API 形态: `pinyin4j` 全局对象的方法集由 AutoJs6 宿主定义, 插件侧忠实提供转换能力.
- 不引入网络能力: 转换始终基于内置词表在设备本地完成.

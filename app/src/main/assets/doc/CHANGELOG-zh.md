******

### 发行历史

******

# v1.2.0

###### 2026/09/01

* `提示` 多读音与六种罗马化体系目前仅作为经过测试的插件侧核心和契约方案; 在 AutoJs6 AIDL 与宿主路由升级前, `pinyin4j.readings()` 不是公开脚本 API
* `修复` `of` 不再丢失词典空洞字符或拆分补充平面字符: 现按 Unicode code point 遍历, 转换包括 `〇` 在内的全部实际词条, 完整保留无词条输入并让分隔符与 code point 对齐
* `修复` `pinyin4j.as(text)` 现只转换完整有效的数字声调音节, 保留无效或嵌入字母数字的片段, 支持大小写及 `v` / `u:` / `ü`, 并正确处理 `jue4` -> `juè` 一类普通 `ue` 拼写
* `优化` 以穷举 BMP 测试固定词典真实覆盖: 共 20,378 个映射, 其中 20,377 个位于 U+4E00-U+9FA5, 另一个为 `〇`; 旧范围内 525 个空洞和语料 SHA-256 指纹也纳入回归
* `优化` 新增经过测试的全部候选读音核心, 覆盖 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 与 Gwoyeu Romatzyh, 并记录追加式 JSON AIDL, 能力协商和旧实现回退方案
* `优化` 新增 pinyin4j 2.5.1 风险清单, 记录二进制与源码哈希, 上游和许可证元数据问题, 已知边界及升级或分叉门禁
* `优化` 新增可复测的 JVM 与 Android Service/AIDL 入口性能基线, release APK ZIP/资源体积分析器, 并用实测数据更新姊妹插件选型对比

# v1.1.0

###### 2026/09/01

* `修复` 移除非空白分隔符导致的输出末尾残留, 并精确保留包括首尾空白在内的非汉字字符
* `修复` 将 pinyin4j 2.5.1 使用 breve 的旧式第三声元音统一为标准 caron 形式 (如 `yŭ` 转为 `yǔ`), 同时覆盖大小写
* `优化` 新增 JVM 单元测试, 覆盖选项标准名与别名, 取值简写, 输出组合, 默认值, 异常, 声调转换及运行时元数据; 新增 Android instrumentation 测试验证真实服务发现与 Binder 往返
* `优化` 新增 GitHub Actions 工作流, 自动拦截生成文档漂移, 运行单元测试, 构建 debug APK, 编译 instrumentation 测试并上传 APK 产物
* `优化` 新增 `.python/prepare_release.py`, 一键构建并验证签名 universal APK, 校验版本, 计算 CRC32 与 SHA-256, 原子生成 `SHA256SUMS.txt` 和英文 `RELEASE_NOTES.md`
* `优化` 统一 README 版式与 Gradle 平台版本管理方式

# v1.0.1

###### 2026/08/31

* `提示` 本版本仅改进文档与配套工程, 拼音转换行为与全部脚本 API 保持不变
* `修复` 修正旧版文档中错误的 `pinyin4j.asTone(text)` 写法: 宿主实际暴露的方法为 `pinyin4j.as(text)` (底层 AIDL 接口方法名仍为 `asTone`)
* `优化` 重构 10 种语言的 README: 新增使用方法, 快速上手, 选项速查表, 脚本 API, 快速自检, 常见问题, 权限与安全, 姊妹插件对比及插件接口等章节
* `优化` 文档生成脚本升级为同族插件统一实现: 支持 `--check` 漂移检测, 跨语言键位与形状对齐校验, 全角符号拦截以及版本对齐校验
* `优化` 插件中心使用说明 (`plugin_instruction.md`) 纳入同一套多语言 JSON 生成链路, 消除双源维护
* `优化` 新增 ROADMAP.md 开发路线图, 并与姊妹插件 Pinyin 建立双向互链与选型对比

# v1.0.0

###### 2026/07/15

* `新增` Pinyin4j 插件服务: 插件 ID 为 `pinyin4j`, 由 AutoJs6 通过 `org.autojs.plugin.PINYIN4J` 自动发现并调用, 封装 `com.belerweb:pinyin4j:2.5.1` 库
* `新增` 拼音转换 API: `pinyin4j.of(text, options)` 将中文逐字转换为汉语拼音, 第二参数传入字符串时直接作为分隔符
* `新增` 声调还原 API: `pinyin4j.as(text)` 将数字声调拼音 (如 `han4`) 还原为符号声调拼音 (如 `hàn`), 对应 AIDL 接口方法 `asTone`
* `新增` 灵活的选项体系: 支持 `case` / `tone` / `v` / `sep` 等别名与 `MARK` / `NUMBER` / `NO` 等取值简写, 非法取值抛出本地化错误提示
* `新增` 多语言资源: 插件信息与使用说明覆盖 10 种语言
* `新增` README 与 CHANGELOG 由 JSON 源文件与 `.python/generate_markdown.py` 生成多语言 Markdown

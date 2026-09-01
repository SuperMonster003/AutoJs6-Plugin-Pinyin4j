# pinyin4j 2.5.1 依赖风险清单

审计日期: `2026-09-01`
锁定坐标: `com.belerweb:pinyin4j:2.5.1`

## 上游与制品状态

- Maven Central 的 2.5.1 制品发布于 2016-03-15; 当前坐标没有更新版本.
- 上游 GitHub 仓库自述为 SourceForge pinyin4j 的副本并用于发布 Maven 制品; GitHub 页面没有 Release, 标签只有 `2.5.0`.
- 审计时 GitHub 最新提交为 `502f1e7628e33eb2ccdfc5be84608430f8435789` (2025-06-09, `Update README.md`). 这说明仓库并非完全无活动, 但已发布二进制和核心代码仍长期冻结.
- Maven POM 将许可证标为 BSD, 而 2.5.1 源文件头声明 GPL v2 or later; 上游仓库又没有清晰的 GitHub License 元数据. 这是许可证元数据不一致风险, 任何源码内嵌或维护性分叉前必须单独完成许可证审查.

官方位置:

- https://github.com/belerweb/pinyin4j
- https://repo1.maven.org/maven2/com/belerweb/pinyin4j/2.5.1/

## 当前制品指纹

| 制品 | 大小 | SHA-256 |
|---|---:|---|
| `pinyin4j-2.5.1.jar` | 323,843 bytes | `b8f9cf0578f6ad01acee51f48cb1e1027d3a016ad946ae298ab6e9331ac49273` |
| `pinyin4j-2.5.1-sources.jar` | 346,201 bytes | `7d9809bebd138858d8a23a48137578cb846bed3a04b0f78f0e4810db77e59a99` |

`Pinyin4jCoverageTest` 还会对所有 BMP 映射按 `CODEPOINT=reading1,reading2\n` 排序串计算语料指纹:

```text
0e839db127b9b79aac0ccddbaa30e2af8601ba9bd158a46bb35057029b8c0617
```

## 已知技术边界

| 风险 | 实测证据 | 当前处理 |
|---|---|---|
| 字符覆盖窄 | BMP 共 20,378 个有效映射; 20,377 个位于 U+4E00–U+9FA5, 另一个是 U+3007 `〇` | 对所有 code point 查询实际词条; 无词条字符原样保留 |
| 旧范围内缺词 | U+4E00–U+9FA5 共 20,902 个码点, 其中 525 个无有效词条 | 不再输出空串, 固定回退测试 |
| 扩展区缺失 | 扩展 A, 兼容区及补充平面没有有效词条 | 不声称支持; 保持完整 Unicode code point, 不拆代理对 |
| 三声符号陈旧 | MARK 输出对 `a/e/i/o/u` 使用 breve | 插件统一改为标准 caron, 大小写均有测试 |
| 多音字数据有限 | 单字 API 返回候选但不做语境消歧; 上游 README 也承认内置多音词仍不完整 | 当前 `of()` 固定第一读音; 高级候选仅作为协同方案 |
| 其他体系格式不可配置 | 非 Hanyu API 返回上游映射表的数字/拼写形式, 可能包含 Wade-Giles 反引号或 `u:` | 高级契约规定原样返回并拒绝 Hanyu 专属格式选项 |
| 许可证元数据冲突 | POM 为 BSD, 源文件头为 GPL v2+ | 禁止无审查地内嵌/分叉; 保持坐标锁定并记录来源 |

## 升级或分叉门禁

1. 默认继续锁定 2.5.1, 不因存在相似坐标或非官方 fork 自动迁移.
2. 候选制品必须记录下载位置, 版本, 文件大小, SHA-256, 源码提交和许可证.
3. 运行完整 JVM/真机 Binder 回归, 六体系候选矩阵和 `asTone` 边界测试.
4. 重新计算全部 BMP 语料指纹; 任何差异必须输出逐 code point 的新增/删除/候选顺序变化清单.
5. 重新生成 APK 体积报告, 解释词表资源和 `classes.dex` 的变化.
6. 若修改词典数据, 每个修正都必须附来源和最小回归语料; 不接受只有总映射数量相同的“等价”结论.
7. 只有插件与宿主兼容矩阵、许可证审查和发布说明均完成后才允许替换生产坐标.

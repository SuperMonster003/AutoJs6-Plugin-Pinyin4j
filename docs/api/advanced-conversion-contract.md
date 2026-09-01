# Pinyin4j 高级转换契约方案

状态: `proposal`
评估日期: `2026-09-01`

本文档定义多读音与其他罗马化体系的宿主协同方案. 当前发布的 `pinyin4j-api.aar` 仍只有 `getInfo()` / `of()` / `asTone()`; 本方案不是 v1.2.0 已公开的脚本 API.

## 已完成的插件侧证据

- `Pinyin4jReadings` 按 Unicode code point 返回 `PinyinReadingGroup(source, candidates)`.
- 默认汉语拼音候选带数字声调, 避免去掉声调后把不同读音错误合并.
- 非词典字符的 `candidates` 为空; 传输行使用 `[source]`, 与姊妹 Pinyin 插件的二维数组回退形态一致.
- 候选顺序保持 pinyin4j 2.5.1 原始顺序; 不进行词组语境消歧.
- 已固定 Hanyu, Tongyong, Wade-Giles, MPS2, Yale 与 Gwoyeu Romatzyh 六种体系的候选矩阵.

示例核心结果:

```json
[["zhong4", "chong2"], ["A"], ["𠀀"]]
```

对应输入为 `重A𠀀`.

## 建议的 AIDL 增量

在现有方法之后追加:

```aidl
String readings(String text, in Bundle options);
```

返回 UTF-8 JSON 二维字符串数组. 采用 JSON 是为了延续 `IPinyinPlugin.convert()` 已验证的跨 Binder 传输方式, 避免为嵌套字符串数组增加新的 Parcelable 类型.

建议新增选项键:

| 键 | 值 | 默认值 |
|---|---|---|
| `romanization` (`system`) | `HANYU`, `TONGYONG`, `WADE_GILES`, `MPS2`, `YALE`, `GWOYEU_ROMATZYH` | `HANYU` |
| `caseType` / `case` | 现有 Hanyu 取值 | `LOWERCASE` |
| `toneType` / `tone` | 现有 Hanyu 取值 | `WITH_TONE_NUMBER` |
| `vCharType` / `vChar` / `v` | 现有 Hanyu 取值 | `WITH_V` |

`separator` 不适用于二维候选数组. 非 Hanyu 体系由 pinyin4j 的映射表直接给出正字法; `caseType`, `toneType`, `vCharType` 不得静默生效. 宿主应在这些体系下拒绝显式传入的 Hanyu 专属格式选项, 并给出参数错误.

## 兼容与能力协商

1. 新方法必须追加在 AIDL 末尾, 保持已有 transaction 顺序.
2. 插件实现新方法后, 在 `PluginInfo.capabilities` 增加 `pinyin4j.readings.version = 1`.
3. 宿主只有在能力存在时调用新 transaction; 旧插件不得收到未知 transaction.
4. Hanyu 旧插件回退可按输入 code point 逐个调用 `of()` 并包装成单候选行; 其他体系在旧插件上明确报“不支持”, 不伪装为 Hanyu.
5. 旧宿主继续只调用 `of/asTone`, 新插件必须保持原有第一读音行为和选项默认值.
6. Rhino 与 Node 路由应共享同一 JSON 解析和参数归一化实现, 避免两套脚本 API 漂移.

## 宿主脚本形态建议

```javascript
pinyin4j.readings("重A", { tone: "NUMBER" });
// [["zhong4", "chong2"], ["A"]]

pinyin4j.readings("间", { system: "WADE_GILES" });
// [["chien1", "chien4"]]
```

不建议给现有 `of()` 增加 `heteronym` 布尔值: `of()` 的返回类型是字符串, 无法无歧义承载二维候选结果. 多读音必须使用独立只读方法.

## 尚需协同的仓库

- AutoJs6 `plugin-api/pinyin4j-api`: AIDL, option keys 与 consumer rules.
- AutoJs6 Android 宿主: `Pinyin4jPluginHost` 能力协商及 Rhino augment.
- AutoJs6 Node 宿主: 从当前 fixture/type 子集迁移到受限的真实插件路由.
- 本插件: 在新的 API AAR 发布后实现 Binder JSON 序列化与真实跨进程测试.

在上述四处合并并完成旧插件/旧宿主互操作测试之前, README 不得把 `readings()` 或其他罗马化体系列为用户可用功能.

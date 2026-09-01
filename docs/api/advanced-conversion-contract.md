# Pinyin4j 高级转换契约

状态: `implemented`
部署日期: `2026-09-01`
首次插件版本: `1.3.0`

本文档记录多读音与六种罗马化体系在 AutoJs6 宿主和 Pinyin4j 插件之间的实际公共契约. v1.2.0 中的评估方案已经在共享 API, Android 宿主, Rhino, Node.js provider 和本插件中完成部署.

## AIDL 与能力

`IPinyin4jPlugin.aidl` 在原有 transaction 顺序末尾追加:

```aidl
String readings(String text, in Bundle options);
```

返回值是 UTF-8 JSON 二维字符串数组. 插件在 `PluginInfo.capabilities` 中声明整数能力:

```text
pinyin4j.readings.version = 1
```

宿主只有在该能力值不低于 `1` 时才调用新 transaction. 旧宿主继续只调用 `getInfo` / `of` / `asTone`; 新插件保持这些 transaction 的顺序, 返回类型和既有默认值不变.

共享契约位于 AutoJs6 的 `plugin-api/pinyin4j-api`:

- `Pinyin4jPluginCapabilityKeys`: 能力键和 v1 常量.
- `Pinyin4jOptionKeys`: `romanization` 与别名 `system`.
- `Pinyin4jReadingsContract`: 传输上限.
- `Pinyin4jRomanizationSystems`: 六种规范体系名.

## 矩阵语义

每个外层行与输入的一个 Unicode code point 对齐, 因而补充平面字符的代理对只占一行. 每行包含有序且去重后的候选读音; 候选顺序保持 pinyin4j 2.5.1 原始顺序. 没有词典映射的字符以自身作为唯一候选, 不会产生空行.

示例输入 `重A𠀀`:

```json
[["zhong4", "chong2"], ["A"], ["𠀀"]]
```

`readings()` 不进行词组切分或语境消歧. 现有 `of()` 仍返回每个字符的首个候选并拼成字符串, 因此两个方法的返回类型和用途保持明确分离.

## 选项

| 键 | 值 | 默认值 |
|---|---|---|
| `romanization` (`system`) | `HANYU`, `TONGYONG`, `WADE_GILES`, `MPS2`, `YALE`, `GWOYEU_ROMATZYH` | `HANYU` |
| `caseType` / `case` | 现有 Hanyu 取值 | `LOWERCASE` |
| `toneType` / `tone` | 现有 Hanyu 取值 | `WITH_TONE_NUMBER` |
| `vCharType` / `vChar` / `v` | 现有 Hanyu 取值 | `WITH_V` |

体系名称不区分大小写, 连字符与空格按下划线归一化. Hanyu 之外的体系直接使用 pinyin4j 映射表的正字法; 显式传入 case/tone/v 会在宿主和插件两层抛出参数错误, 不会静默忽略. `separator` 不适用于二维候选数组并由插件拒绝.

## 传输上限与校验

readings v1 固定以下上限:

- 源文本最多 16,384 个 Unicode code point.
- 返回 JSON 的 UTF-8 编码最多 512 KiB.
- 每个源 code point 最多 64 个候选.
- 每个候选最多 64 个 Unicode code point, 且不得为空.

插件在序列化前验证源文本, 行数和候选; 宿主在解析后独立验证 JSON 根类型, 每行类型, 字符串元素, 行数以及全部上限. 任一层发现畸形或超限数据都会失败关闭.

## 新旧插件兼容

新宿主发现插件没有 readings v1 时:

1. Hanyu 请求在一次已绑定会话中按 Unicode code point 调用旧 `of()`.
2. 每个返回值包装为单候选行; 旧插件意外返回空字符串时保留源字符.
3. `romanization` 和 `system` 从传给旧 `of()` 的 Bundle 中移除.
4. 非 Hanyu 请求明确提示更新插件, 不伪装为 Hanyu.

能力值存在且不低于 `1` 时, 宿主只走原生 readings transaction, 不在插件错误或返回畸形矩阵后回退, 从而避免掩盖协议问题.

## 脚本入口

Rhino 同步入口:

```javascript
pinyin4j.readings("重A", { tone: "NUMBER" });
// [["zhong4", "chong2"], ["A"]]

pinyin4j.readings("间", { system: "WADE_GILES" });
// [["chien1", "chien4"]]
```

Node.js 不注入 Rhino 全局对象. 脚本通过公开 facade 和显式 capability 异步调用同一 Android provider:

```javascript
const { callAutoJs } = require("autojs6:bridge");

const matrix = await callAutoJs(
    "pinyin4j",
    "readings",
    ["重A", { system: "HANYU" }],
    { permissions: ["pinyin4j"] },
);
```

Node provider 同时公开 `of`, `as` 和 `readings`. 参数经严格 JSON 解码和归一化后复用 `Pinyin4jPluginHost`; Binder, Bundle, Context 或其他 Java 对象不会跨越 Node 桥.

## 验证证据

- 插件 JVM 测试固定六种体系, 别名, Unicode code point 和全 BMP 语料指纹.
- 插件 instrumentation 通过真实 Service 发现和 AIDL Binder 往返验证 capability, 默认矩阵, Hanyu 格式, Wade-Giles 及不兼容选项拒绝.
- 宿主 JVM 测试固定 Rhino/Node 共用选项归一化.
- 宿主 instrumentation 固定原生 capability 路径, 旧插件 Hanyu 回退, 非 Hanyu 拒绝, 畸形矩阵失败关闭及 Node dispatcher/provider 注册.
- 插件与宿主定向 instrumentation 已在 Android 9, 12, 13 与 15 真机执行通过; 未安装 Node Runtime 的设备仅跳过 Node 进程端到端用例, Android dispatcher 与权限/注册契约仍执行.

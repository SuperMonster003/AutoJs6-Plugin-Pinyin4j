# Pinyin4j 转换性能基线

测量日期: `2026-09-01`

本基线用于发现依赖, Unicode 遍历或输出格式实现的数量级退化. 它不是跨机器的硬性 SLA, 也不应直接作为 CI 的时间门禁.

## JVM 核心基线

环境:

- Windows 11
- JDK 21.0.1
- Gradle 9.5
- pinyin4j 2.5.1
- 5 个测量轮次取每次进程内中位数; 独立启动 3 次再记录范围

输入:

- 单字: `汉`, 每轮 50,000 次.
- 长文本: `汉语拼音AutoJs6〇𠀀` 重复 64 次, 共 832 个 Unicode code point, 每轮 200 次.

结果:

| 指标 | 三次独立进程结果 | 记录基线 |
|---|---|---:|
| 首次转换/词表初始化 | 85.496–93.929 ms | 87.694 ms (中位) |
| 稳态单字转换 | 1,014,553–1,123,964 ops/s | 1,079,631 ops/s (中位) |
| 稳态长文本转换 | 3,401,938–4,007,003 code points/s | 3,949,511 code points/s (中位) |

发布收口时另一次复测恰逢同机多个 AutoJs6/Gradle 构建并行运行, 连续 5 秒采样的整机 CPU 使用率为 99%–100%. 该组受争用样本按本基线的非 SLA 定位排除, 不替换上表的独立进程结果; 输出正确性仍通过, 且下方 Android 真机复测保持在原基线附近. 后续性能比较必须先确认机器空闲度相当.

复测命令:

```powershell
.\gradlew.bat :app:benchmarkPinyin4j
```

可选参数依次为测量轮次, 单字迭代数和长文本迭代数:

```powershell
.\gradlew.bat :app:benchmarkPinyin4j --args="7 100000 500"
```

## Android Service/AIDL 入口基线

设备:

- 型号 `23046RP50C`
- Android 15
- 测试入口 `Pinyin4jPluginServiceTest.aBenchmarkFirstBindAndServiceThroughput`

一次 fresh instrumentation run 的结果:

| 指标 | 结果 |
|---|---:|
| 首次 Service 绑定 | 4.750 ms |
| 首次 Service/AIDL 转换及词表初始化 | 203.177 ms |
| 稳态单字 Service/AIDL 调用 | 22,683 ops/s |
| 稳态长文本 Service/AIDL 转换 | 62,289 code points/s |

这里的“首次 Service 绑定”从 `bindService()` 到 `onServiceConnected()` 计时; instrumentation 已启动目标进程, 因此它不是完整 Android 进程冷启动时间. 此外测试与 Service 同包同进程, `IPinyin4jPlugin.Stub.asInterface()` 可返回本地接口, 所以稳态结果主要衡量 Service/AIDL 入口及插件转换成本, 不包含可保证的跨进程 Binder 编组成本. 首次转换指标包含 pinyin4j 词表初始化, 更接近用户第一次实际调用的主要成本. 真正的外部宿主冷启动和跨包往返需在 AutoJs6 仓库建立宏基准后补充, 当前数据不冒充这些指标.

复测命令:

```powershell
$env:ANDROID_SERIAL="968e9f18"
.\gradlew.bat :app:connectedDebugAndroidTest
rg "PINYIN4J_ANDROID_BENCHMARK" app/build/outputs/androidTest-results
```

## 姊妹插件比较边界

姊妹 Pinyin 插件的 [分词器实测](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/benchmarks/segmenter-reuse-2026-09-01.md) 在 Android API 36 x86_64 AVD 上, 对 34 个 UTF-16 code unit 的分词/词组/多音字输入记录了 3,123.832 ms 冷调用和 598.933 ms 热调用中位数. 其 [full release 体积报告](https://github.com/SuperMonster003/AutoJs6-Plugin-Pinyin/blob/master/docs/size/packaging-strategy-2026-09-01.md) 为 6,234,761 bytes (5.95 MiB), 其中四份单字/词组/Jieba/HMM 数据占 APK ZIP 的 97.35%.

这些数值用于说明两种方案的能力成本, 不能与本页 Pinyin4j 真机结果直接相除: 设备架构, Android 版本, 输入, 调用模式和所做工作均不同. README 对比表因此只说明 Pinyin4j 是轻量逐字路径, Pinyin 的分词与词典路径随模式变化, 不声称一个跨设备的速度倍数. 如需严格比较, 后续应在同一宿主, 同一设备, 同一输入和相同输出语义下建立双插件宏基准.

## 回归判断

- 同一机器/设备重复三次后, 中位吞吐下降超过 20% 时需要分析.
- 首次初始化超过当前中位数两倍时需要检查词表加载和 R8/资源打包变化.
- 基准必须同时校验输出正确性; 不能通过跳过未映射字符或减少候选换取更好数字.
- 性能变化不能替代 APK 体积, 字典指纹和真机功能测试.

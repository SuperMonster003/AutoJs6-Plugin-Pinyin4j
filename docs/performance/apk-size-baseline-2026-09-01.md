# Pinyin4j APK 体积基线

测量日期: `2026-09-01`
被测 release APK: `app-release.apk`
APK SHA-256: `90ff7d9c6d5a814fb7736caa284a370e4fb5c5173d235df777f6aeaa781a1111`
APK 大小: `357,327` bytes (348.95 KiB)
原生库条目: `0`

## ZIP 条目测量

| 条目 | 源大小 | APK 内大小 | APK 占比 |
|---|---:|---:|---:|
| `pinyindb/multi_pinyin.txt` | 275,015 | 112,228 | 31.41% |
| `pinyindb/pinyin_gwoyeu_mapping.xml` | 93,813 | 7,821 | 2.19% |
| `pinyindb/pinyin_mapping.xml` | 66,603 | 6,150 | 1.72% |
| `pinyindb/unicode_to_hanyu_pinyin.txt` | 265,545 | 93,699 | 26.22% |
| 四份 pinyin4j 数据合计 | — | 219,898 | 61.54% |
| `classes.dex` | 62,696 | 28,521 | 7.98% |

`packagedBytes` 使用 APK ZIP 中的 `compress_size`; APK 签名块, 对齐和中央目录不属于任何单一条目, 因此各项占比不会合计到 100%.

## 回归用途

- 依赖或 R8 配置变更后必须重新生成本报告并解释 APK 或四份词表资源的变化.
- 当前发布策略保持单一 universal APK 且不包含原生库.
- 体积门禁建议以当前 APK 大小上浮 10% 作为预警线, 不是自动接受依赖升级的依据.

复测命令:

```powershell
.\gradlew.bat :app:assembleRelease
py scripts\ci\analyze_apk_size.py app\build\outputs\apk\release\app-release.apk --report docs\performance\apk-size-baseline-2026-09-01.md
```

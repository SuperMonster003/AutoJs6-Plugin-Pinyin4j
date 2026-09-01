# Pinyin4j APK 体积基线

测量日期: `2026-09-01`
被测 release APK: `app-release.apk`
APK SHA-256: `c99ca76a315378dfce4f84620a5143773514c71fd705a7295e041b0b3d3fb1bc`
APK 大小: `385,127` bytes (376.10 KiB)
原生库条目: `0`

## ZIP 条目测量

| 条目 | 源大小 | APK 内大小 | APK 占比 |
|---|---:|---:|---:|
| `pinyindb/multi_pinyin.txt` | 275,015 | 112,228 | 29.14% |
| `pinyindb/pinyin_gwoyeu_mapping.xml` | 93,813 | 7,821 | 2.03% |
| `pinyindb/pinyin_mapping.xml` | 66,603 | 6,150 | 1.60% |
| `pinyindb/unicode_to_hanyu_pinyin.txt` | 265,545 | 93,699 | 24.33% |
| 四份 pinyin4j 数据合计 | — | 219,898 | 57.10% |
| `classes.dex` | 109,292 | 50,529 | 13.12% |

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

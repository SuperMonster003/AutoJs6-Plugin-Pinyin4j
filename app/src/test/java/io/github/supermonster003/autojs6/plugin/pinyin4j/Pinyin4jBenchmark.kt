package io.github.supermonster003.autojs6.plugin.pinyin4j

import java.util.Locale

internal object Pinyin4jBenchmark {
    @JvmStatic
    fun main(args: Array<String>) {
        val rounds = args.getOrNull(0)?.toIntOrNull()?.coerceIn(3, 15) ?: 5
        val singleIterations = args.getOrNull(1)?.toIntOrNull()?.coerceAtLeast(1_000) ?: 50_000
        val longIterations = args.getOrNull(2)?.toIntOrNull()?.coerceAtLeast(10) ?: 200
        val longText = "汉语拼音AutoJs6〇𠀀".repeat(64)
        val longCodePoints = longText.codePointCount(0, longText.length)

        val firstStarted = System.nanoTime()
        check(Pinyin4jConverter.of("汉") == "han")
        val firstConversionNanos = System.nanoTime() - firstStarted

        repeat(5_000) { Pinyin4jConverter.of("汉") }
        repeat(20) { Pinyin4jConverter.of(longText) }

        val singleRounds = LongArray(rounds) {
            measureNanos {
                repeat(singleIterations) { check(Pinyin4jConverter.of("汉") == "han") }
            }
        }
        val longRounds = LongArray(rounds) {
            measureNanos {
                repeat(longIterations) {
                    check(Pinyin4jConverter.of(longText).isNotEmpty())
                }
            }
        }

        val singleMedian = singleRounds.sorted()[rounds / 2]
        val longMedian = longRounds.sorted()[rounds / 2]
        val singleOpsPerSecond = singleIterations * 1_000_000_000.0 / singleMedian
        val longCodePointsPerSecond = longIterations * longCodePoints * 1_000_000_000.0 / longMedian

        System.out.printf(
            Locale.US,
            "PINYIN4J_BENCHMARK {\"rounds\":%d,\"firstConversionMs\":%.3f," +
                "\"singleIterations\":%d,\"singleOpsPerSecond\":%.0f," +
                "\"longIterations\":%d,\"longCodePoints\":%d,\"longCodePointsPerSecond\":%.0f}%n",
            rounds,
            firstConversionNanos / 1_000_000.0,
            singleIterations,
            singleOpsPerSecond,
            longIterations,
            longCodePoints,
            longCodePointsPerSecond,
        )
    }

    private inline fun measureNanos(block: () -> Unit): Long {
        val started = System.nanoTime()
        block()
        return System.nanoTime() - started
    }
}

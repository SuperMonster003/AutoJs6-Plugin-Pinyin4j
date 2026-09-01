package io.github.supermonster003.autojs6.plugin.pinyin4j

import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import java.util.Locale

internal enum class PinyinRomanizationSystem {
    HANYU,
    TONGYONG,
    WADE_GILES,
    MPS2,
    YALE,
    GWOYEU_ROMATZYH;

    companion object {
        fun parse(rawValue: String?): PinyinRomanizationSystem {
            val normalized = rawValue
                ?.trim()
                ?.uppercase(Locale.US)
                ?.replace('-', '_')
                ?.replace(' ', '_')
                ?.takeIf(String::isNotEmpty)
                ?: return HANYU
            return when (normalized) {
                "HANYU", "HANYU_PINYIN", "PINYIN" -> HANYU
                "TONGYONG", "TONGYONG_PINYIN" -> TONGYONG
                "WADE", "WADE_GILES", "WADEGILES", "WADE_GILES_PINYIN" -> WADE_GILES
                "MPS2", "MANDARIN_PHONETIC_SYMBOLS_2" -> MPS2
                "YALE", "YALE_PINYIN" -> YALE
                "GWOYEU", "GWOYEU_ROMATZYH", "GR" -> GWOYEU_ROMATZYH
                else -> throw InvalidPinyinRomanizationException(rawValue)
            }
        }
    }
}

internal class InvalidPinyinRomanizationException(
    val rawValue: String?,
) : IllegalArgumentException("Invalid pinyin romanization system: $rawValue")

internal data class PinyinReadingGroup(
    val source: String,
    val candidates: List<String>,
) {
    fun asTransportRow(): List<String> = candidates.ifEmpty { listOf(source) }
}

internal object Pinyin4jReadings {
    private val defaultHanyuOptions = PinyinOptions.parse(
        mapOf(PinyinOptionNames.TONE_TYPE to "WITH_TONE_NUMBER"),
    )

    fun of(
        text: String,
        system: PinyinRomanizationSystem = PinyinRomanizationSystem.HANYU,
        hanyuOptions: PinyinOptions = defaultHanyuOptions,
    ): List<PinyinReadingGroup> {
        val outputFormat = hanyuOptions.toOutputFormat().takeIf {
            system == PinyinRomanizationSystem.HANYU
        }
        return buildList {
            var offset = 0
            while (offset < text.length) {
                val codePoint = text.codePointAt(offset)
                add(
                    PinyinReadingGroup(
                        source = codePoint.asString(),
                        candidates = candidates(codePoint, system, outputFormat),
                    ),
                )
                offset += Character.charCount(codePoint)
            }
        }
    }

    fun transportRows(
        text: String,
        system: PinyinRomanizationSystem = PinyinRomanizationSystem.HANYU,
        hanyuOptions: PinyinOptions = defaultHanyuOptions,
    ): List<List<String>> = of(text, system, hanyuOptions).map(PinyinReadingGroup::asTransportRow)

    fun candidates(
        codePoint: Int,
        system: PinyinRomanizationSystem,
        hanyuOutputFormat: HanyuPinyinOutputFormat?,
    ): List<String> {
        if (!Character.isBmpCodePoint(codePoint)) return emptyList()
        val character = codePoint.toChar()
        val rawCandidates: Array<out String?>? = when (system) {
            PinyinRomanizationSystem.HANYU -> PinyinHelper.toHanyuPinyinStringArray(
                character,
                requireNotNull(hanyuOutputFormat) { "Hanyu output format is required" },
            )
            PinyinRomanizationSystem.TONGYONG -> PinyinHelper.toTongyongPinyinStringArray(character)
            PinyinRomanizationSystem.WADE_GILES -> PinyinHelper.toWadeGilesPinyinStringArray(character)
            PinyinRomanizationSystem.MPS2 -> PinyinHelper.toMPS2PinyinStringArray(character)
            PinyinRomanizationSystem.YALE -> PinyinHelper.toYalePinyinStringArray(character)
            PinyinRomanizationSystem.GWOYEU_ROMATZYH -> PinyinHelper.toGwoyeuRomatzyhStringArray(character)
        }
        return rawCandidates
            .orEmpty()
            .filterNotNull()
            .filter(String::isNotEmpty)
            .map { candidate ->
                when (system) {
                    PinyinRomanizationSystem.HANYU -> candidate.normalizeThirdToneMarks(
                        requireNotNull(hanyuOutputFormat).toneType,
                    )
                    else -> candidate
                }
            }
            .distinct()
    }

    private fun String.normalizeThirdToneMarks(toneType: HanyuPinyinToneType): String {
        if (toneType != HanyuPinyinToneType.WITH_TONE_MARK) return this
        return map { character -> THIRD_TONE_MARKS[character] ?: character }.joinToString("")
    }

    private val THIRD_TONE_MARKS = mapOf(
        'ă' to 'ǎ', 'ĕ' to 'ě', 'ĭ' to 'ǐ', 'ŏ' to 'ǒ', 'ŭ' to 'ǔ',
        'Ă' to 'Ǎ', 'Ĕ' to 'Ě', 'Ĭ' to 'Ǐ', 'Ŏ' to 'Ǒ', 'Ŭ' to 'Ǔ',
    )
}

package io.github.supermonster003.autojs6.plugin.pinyin4j

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
import org.autojs.plugin.pinyin4j.api.Pinyin4jOptionKeys
import java.util.Locale

internal object PinyinOptionNames {
    val CASE_TYPE = Pinyin4jOptionKeys.CASE_TYPE
    val TONE_TYPE = Pinyin4jOptionKeys.TONE_TYPE
    val V_CHAR_TYPE = Pinyin4jOptionKeys.V_CHAR_TYPE
    val SEPARATOR = Pinyin4jOptionKeys.SEPARATOR

    const val CASE = "case"
    const val TONE = "tone"
    const val V_CHAR = "vChar"
    const val V = "v"
    const val SEP = "sep"

    val CASE_TYPE_KEYS = listOf(CASE_TYPE, CASE)
    val TONE_TYPE_KEYS = listOf(TONE_TYPE, TONE)
    val V_CHAR_TYPE_KEYS = listOf(V_CHAR_TYPE, V_CHAR, V)
    val SEPARATOR_KEYS = listOf(SEPARATOR, SEP)
    val ALL = CASE_TYPE_KEYS + TONE_TYPE_KEYS + V_CHAR_TYPE_KEYS + SEPARATOR_KEYS
}

internal enum class PinyinOptionKind {
    CASE_TYPE,
    TONE_TYPE,
    V_CHAR_TYPE,
}

internal class InvalidPinyinOptionException(
    val kind: PinyinOptionKind,
    val rawValue: String?,
) : IllegalArgumentException("Invalid ${kind.name.lowercase(Locale.US)}: $rawValue")

internal data class PinyinOptions(
    val caseType: HanyuPinyinCaseType,
    val toneType: HanyuPinyinToneType,
    val vCharType: HanyuPinyinVCharType,
    val separator: String,
) {
    fun toOutputFormat(): HanyuPinyinOutputFormat = HanyuPinyinOutputFormat().apply {
        caseType = this@PinyinOptions.caseType
        toneType = this@PinyinOptions.toneType
        vCharType = this@PinyinOptions.vCharType
    }

    companion object {
        fun parse(values: Map<String, String?> = emptyMap()): PinyinOptions {
            val caseValue = values.firstValue(PinyinOptionNames.CASE_TYPE, PinyinOptionNames.CASE)
            val toneValue = values.firstValue(PinyinOptionNames.TONE_TYPE, PinyinOptionNames.TONE)
            val vCharValue = values.firstValue(
                PinyinOptionNames.V_CHAR_TYPE,
                PinyinOptionNames.V_CHAR,
                PinyinOptionNames.V,
            )
            val separator = values.firstValue(PinyinOptionNames.SEPARATOR, PinyinOptionNames.SEP).orEmpty()

            val caseType = when (caseValue.normalizedOr("LOWERCASE")) {
                "LOWERCASE", "LOW", "L", "0" -> HanyuPinyinCaseType.LOWERCASE
                "UPPERCASE", "UP", "U", "1" -> HanyuPinyinCaseType.UPPERCASE
                else -> throw InvalidPinyinOptionException(PinyinOptionKind.CASE_TYPE, caseValue)
            }
            val toneType = when (toneValue.normalizedOr("WITHOUT_TONE")) {
                "WITH_TONE_NUMBER", "WITH_NUMBER", "NUMBER", "NUM" -> HanyuPinyinToneType.WITH_TONE_NUMBER
                "WITHOUT_TONE", "NO_TONE", "NO", "FALSE", "0" -> HanyuPinyinToneType.WITHOUT_TONE
                "WITH_TONE_MARK", "WITH_MARK", "MARK", "TRUE", "1" -> HanyuPinyinToneType.WITH_TONE_MARK
                else -> throw InvalidPinyinOptionException(PinyinOptionKind.TONE_TYPE, toneValue)
            }
            val defaultVCharType = when (toneType) {
                HanyuPinyinToneType.WITH_TONE_MARK -> "WITH_U_UNICODE"
                else -> "WITH_V"
            }
            val vCharType = when (vCharValue.normalizedOr(defaultVCharType)) {
                "WITH_U_AND_COLON", "U_AND_COLON", "U_COLON", "U:" -> HanyuPinyinVCharType.WITH_U_AND_COLON
                "WITH_V", "V" -> HanyuPinyinVCharType.WITH_V
                "WITH_U_UNICODE", "U_UNICODE", "UNICODE", "U", "Ü" -> HanyuPinyinVCharType.WITH_U_UNICODE
                else -> throw InvalidPinyinOptionException(PinyinOptionKind.V_CHAR_TYPE, vCharValue)
            }
            return PinyinOptions(caseType, toneType, vCharType, separator)
        }

        private fun Map<String, String?>.firstValue(vararg keys: String): String? {
            keys.forEach { key -> if (containsKey(key)) return this[key] }
            return null
        }

        private fun String?.normalizedOr(defaultValue: String): String {
            return this?.trim()?.uppercase(Locale.US)?.takeIf(String::isNotEmpty) ?: defaultValue
        }
    }
}

internal object Pinyin4jConverter {
    fun of(text: String, values: Map<String, String?> = emptyMap()): String {
        return of(text, PinyinOptions.parse(values))
    }

    fun of(text: String, options: PinyinOptions): String {
        val outputFormat = options.toOutputFormat()
        return buildString {
            var offset = 0
            var codePointIndex = 0
            while (offset < text.length) {
                val codePoint = text.codePointAt(offset)
                if (codePointIndex > 0) append(options.separator)
                append(
                    Pinyin4jReadings.candidates(
                        codePoint = codePoint,
                        system = PinyinRomanizationSystem.HANYU,
                        hanyuOutputFormat = outputFormat,
                    ).firstOrNull() ?: codePoint.asString(),
                )
                offset += Character.charCount(codePoint)
                codePointIndex++
            }
        }
    }

    fun asTone(input: String): String = PinyinToneConverter.convert(input)
}

internal fun Int.asString(): String = String(Character.toChars(this))

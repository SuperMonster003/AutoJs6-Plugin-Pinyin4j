package io.github.supermonster003.autojs6.plugin.pinyin4j

import net.sourceforge.pinyin4j.PinyinHelper
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

    val ALL = listOf(CASE_TYPE, CASE, TONE_TYPE, TONE, V_CHAR_TYPE, V_CHAR, V, SEPARATOR, SEP)
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
        val format = HanyuPinyinOutputFormat().apply {
            caseType = options.caseType
            toneType = options.toneType
            vCharType = options.vCharType
        }
        return buildString {
            text.forEachIndexed { index, character ->
                if (index > 0) append(options.separator)
                append(
                    when (character) {
                        in '\u4E00'..'\u9FA5' -> PinyinHelper
                            .toHanyuPinyinStringArray(character, format)
                            ?.firstOrNull()
                            .orEmpty()
                            .normalizeThirdToneMarks(options.toneType)
                        else -> character.toString()
                    },
                )
            }
        }
    }

    fun asTone(input: String): String {
        return TONE_PATTERN.replace(input) { match ->
            PINYIN_TONE_MAP[match.groupValues[1] + match.groupValues[2]] ?: match.value
        }
    }

    private fun String.normalizeThirdToneMarks(toneType: HanyuPinyinToneType): String {
        if (toneType != HanyuPinyinToneType.WITH_TONE_MARK) return this
        return map { character -> THIRD_TONE_MARKS[character] ?: character }.joinToString("")
    }

    private val TONE_PATTERN = Regex(
        "(üe|u:e|ve|ue|ang|eng|ing|ong|ai|ei|ui|ao|ou|iu|ie|er|an|en|in|un|ün|u:n|vn|[aoeiuüv])([0-4])",
    )

    // pinyin4j 2.5.1 uses breve for these third-tone vowels. Normalize them to the
    // standard caron forms used by modern Hanyu Pinyin and by asTone().
    private val THIRD_TONE_MARKS = mapOf(
        'ă' to 'ǎ', 'ĕ' to 'ě', 'ĭ' to 'ǐ', 'ŏ' to 'ǒ', 'ŭ' to 'ǔ',
        'Ă' to 'Ǎ', 'Ĕ' to 'Ě', 'Ĭ' to 'Ǐ', 'Ŏ' to 'Ǒ', 'Ŭ' to 'Ǔ',
    )

    private val PINYIN_TONE_MAP = mapOf(
        "a1" to "ā", "a2" to "á", "a3" to "ǎ", "a4" to "à", "a0" to "a",
        "o1" to "ō", "o2" to "ó", "o3" to "ǒ", "o4" to "ò", "o0" to "o",
        "e1" to "ē", "e2" to "é", "e3" to "ě", "e4" to "è", "e0" to "e",
        "i1" to "ī", "i2" to "í", "i3" to "ǐ", "i4" to "ì", "i0" to "i",
        "u1" to "ū", "u2" to "ú", "u3" to "ǔ", "u4" to "ù", "u0" to "u",
        "ü1" to "ǖ", "ü2" to "ǘ", "ü3" to "ǚ", "ü4" to "ǜ", "ü0" to "ü",
        "v1" to "ǖ", "v2" to "ǘ", "v3" to "ǚ", "v4" to "ǜ", "v0" to "ü",
        "u:1" to "ǖ", "u:2" to "ǘ", "u:3" to "ǚ", "u:4" to "ǜ", "u:0" to "ü",
        "ai1" to "āi", "ai2" to "ái", "ai3" to "ǎi", "ai4" to "ài", "ai0" to "ai",
        "ei1" to "ēi", "ei2" to "éi", "ei3" to "ěi", "ei4" to "èi", "ei0" to "ei",
        "ui1" to "uī", "ui2" to "uí", "ui3" to "uǐ", "ui4" to "uì", "ui0" to "ui",
        "ao1" to "āo", "ao2" to "áo", "ao3" to "ǎo", "ao4" to "ào", "ao0" to "ao",
        "ou1" to "ōu", "ou2" to "óu", "ou3" to "ǒu", "ou4" to "òu", "ou0" to "ou",
        "iu1" to "iū", "iu2" to "iú", "iu3" to "iǔ", "iu4" to "iù", "iu0" to "iu",
        "ie1" to "iē", "ie2" to "ié", "ie3" to "iě", "ie4" to "iè", "ie0" to "ie",
        "üe1" to "üē", "üe2" to "üé", "üe3" to "üě", "üe4" to "üè", "üe0" to "üe",
        "u:e1" to "üē", "u:e2" to "üé", "u:e3" to "üě", "u:e4" to "üè", "u:e0" to "üe",
        "ve1" to "üē", "ve2" to "üé", "ve3" to "üě", "ve4" to "üè", "ve0" to "üe",
        "er1" to "ēr", "er2" to "ér", "er3" to "ěr", "er4" to "èr", "er0" to "er",
        "an1" to "ān", "an2" to "án", "an3" to "ǎn", "an4" to "àn", "an0" to "an",
        "en1" to "ēn", "en2" to "én", "en3" to "ěn", "en4" to "èn", "en0" to "en",
        "in1" to "īn", "in2" to "ín", "in3" to "ǐn", "in4" to "ìn", "in0" to "in",
        "un1" to "ūn", "un2" to "ún", "un3" to "ǔn", "un4" to "ùn", "un0" to "un",
        "ün1" to "ǖn", "ün2" to "ǘn", "ün3" to "ǚn", "ün4" to "ǜn", "ün0" to "ün",
        "u:n1" to "ǖn", "u:n2" to "ǘn", "u:n3" to "ǚn", "u:n4" to "ǜn", "u:n0" to "ün",
        "vn1" to "ǖn", "vn2" to "ǘn", "vn3" to "ǚn", "vn4" to "ǜn", "vn0" to "ün",
        "ang1" to "āng", "ang2" to "áng", "ang3" to "ǎng", "ang4" to "àng", "ang0" to "ang",
        "eng1" to "ēng", "eng2" to "éng", "eng3" to "ěng", "eng4" to "èng", "eng0" to "eng",
        "ing1" to "īng", "ing2" to "íng", "ing3" to "ǐng", "ing4" to "ìng", "ing0" to "ing",
        "ong1" to "ōng", "ong2" to "óng", "ong3" to "ǒng", "ong4" to "òng", "ong0" to "ong",
    )
}

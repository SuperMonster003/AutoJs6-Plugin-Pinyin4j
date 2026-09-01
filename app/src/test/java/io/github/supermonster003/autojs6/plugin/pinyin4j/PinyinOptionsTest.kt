package io.github.supermonster003.autojs6.plugin.pinyin4j

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class PinyinOptionsTest {

    @Test
    fun `canonical names and aliases produce the same options`() {
        val canonical = PinyinOptions.parse(
            mapOf(
                PinyinOptionNames.CASE_TYPE to "UPPERCASE",
                PinyinOptionNames.TONE_TYPE to "WITH_TONE_NUMBER",
                PinyinOptionNames.V_CHAR_TYPE to "WITH_U_AND_COLON",
                PinyinOptionNames.SEPARATOR to " / ",
            ),
        )

        listOf(
            mapOf("case" to "UP", "tone" to "NUMBER", "v" to "U:", "sep" to " / "),
            mapOf("case" to "1", "tone" to "NUM", "vChar" to "U_COLON", "sep" to " / "),
        ).forEach { aliases ->
            assertEquals(canonical, PinyinOptions.parse(aliases))
        }
    }

    @Test
    fun `value shortcuts are case insensitive and equivalent`() {
        listOf("UPPERCASE", "up", "U", "1").forEach { value ->
            assertEquals(
                HanyuPinyinCaseType.UPPERCASE,
                PinyinOptions.parse(mapOf(PinyinOptionNames.CASE_TYPE to value)).caseType,
            )
        }
        listOf("WITH_TONE_MARK", "with_mark", "Mark", "true", "1").forEach { value ->
            assertEquals(
                HanyuPinyinToneType.WITH_TONE_MARK,
                PinyinOptions.parse(mapOf(PinyinOptionNames.TONE_TYPE to value)).toneType,
            )
        }
        listOf("WITH_U_UNICODE", "u_unicode", "Unicode", "u", "ü").forEach { value ->
            assertEquals(
                HanyuPinyinVCharType.WITH_U_UNICODE,
                PinyinOptions.parse(mapOf(PinyinOptionNames.V_CHAR_TYPE to value)).vCharType,
            )
        }
    }

    @Test
    fun `defaults use lowercase no tone and v`() {
        assertEquals(
            PinyinOptions(
                caseType = HanyuPinyinCaseType.LOWERCASE,
                toneType = HanyuPinyinToneType.WITHOUT_TONE,
                vCharType = HanyuPinyinVCharType.WITH_V,
                separator = "",
            ),
            PinyinOptions.parse(),
        )
    }

    @Test
    fun `tone marks default to unicode u umlaut`() {
        val options = PinyinOptions.parse(mapOf(PinyinOptionNames.TONE_TYPE to "MARK"))

        assertEquals(HanyuPinyinVCharType.WITH_U_UNICODE, options.vCharType)
        assertEquals("lǚ", Pinyin4jConverter.of("旅", options))
    }

    @Test
    fun `invalid values identify their option and original input`() {
        val cases = listOf(
            Triple(PinyinOptionNames.CASE_TYPE, "sideways", PinyinOptionKind.CASE_TYPE),
            Triple(PinyinOptionNames.TONE_TYPE, "fifth", PinyinOptionKind.TONE_TYPE),
            Triple(PinyinOptionNames.V_CHAR_TYPE, "double-u", PinyinOptionKind.V_CHAR_TYPE),
        )

        cases.forEach { (key, value, expectedKind) ->
            val error = assertThrows(InvalidPinyinOptionException::class.java) {
                PinyinOptions.parse(mapOf(key to value))
            }
            assertEquals(expectedKind, error.kind)
            assertEquals(value, error.rawValue)
        }
    }
}

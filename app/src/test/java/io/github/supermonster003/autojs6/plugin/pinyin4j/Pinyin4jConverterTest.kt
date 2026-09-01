package io.github.supermonster003.autojs6.plugin.pinyin4j

import org.junit.Assert.assertEquals
import org.junit.Test

class Pinyin4jConverterTest {

    @Test
    fun `default conversion and representative output matrix remain stable`() {
        assertEquals("hanyupinyin", Pinyin4jConverter.of("汉语拼音"))

        val cases = listOf(
            Case(mapOf("case" to "LOW", "tone" to "NO", "v" to "V"), "lv"),
            Case(mapOf("case" to "UP", "tone" to "NO", "v" to "V"), "LV"),
            Case(mapOf("case" to "LOW", "tone" to "NUMBER", "v" to "V"), "lv3"),
            Case(mapOf("case" to "UP", "tone" to "NUMBER", "v" to "U:"), "LU:3"),
            Case(mapOf("case" to "LOW", "tone" to "NO", "v" to "U"), "lü"),
            Case(mapOf("case" to "LOW", "tone" to "MARK"), "lǚ"),
            Case(mapOf("case" to "UP", "tone" to "MARK"), "LǙ"),
        )

        cases.forEach { (options, expected) ->
            assertEquals(expected, Pinyin4jConverter.of("旅", options))
        }
    }

    @Test
    fun `separator is placed only between input characters`() {
        assertEquals(
            "han-A-!",
            Pinyin4jConverter.of("汉A!", mapOf(PinyinOptionNames.SEPARATOR to "-")),
        )
        assertEquals(
            "han yu pin yin",
            Pinyin4jConverter.of("汉语拼音", mapOf(PinyinOptionNames.SEPARATOR to " ")),
        )
    }

    @Test
    fun `third tone marks use standard carons in lower and upper case`() {
        assertEquals(
            "hǎo kě nǐ fǒu gǔ yǔ",
            Pinyin4jConverter.of("好可你否古语", mapOf("tone" to "MARK", "sep" to " ")),
        )
        assertEquals(
            "HǍO KĚ NǏ FǑU GǓ YǓ",
            Pinyin4jConverter.of(
                "好可你否古语",
                mapOf("case" to "UP", "tone" to "MARK", "sep" to " "),
            ),
        )
    }

    @Test
    fun `non Chinese input is preserved exactly`() {
        assertEquals(" AutoJs6! ", Pinyin4jConverter.of(" AutoJs6! "))
        assertEquals("", Pinyin4jConverter.of(""))
    }

    @Test
    fun `tone number utility supports unicode v and u colon spellings`() {
        assertEquals(
            "hàn yǔ, lǚ üè; unchanged5",
            Pinyin4jConverter.asTone("han4 yu3, lv3 u:e4; unchanged5"),
        )
    }

    private data class Case(
        val options: Map<String, String>,
        val expected: String,
    )
}

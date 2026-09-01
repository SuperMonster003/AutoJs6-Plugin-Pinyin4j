package io.github.supermonster003.autojs6.plugin.pinyin4j

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class Pinyin4jReadingsTest {

    @Test
    fun `hanyu readings retain all ordered candidates and transport fallback`() {
        val groups = Pinyin4jReadings.of("重A𠀀")

        assertEquals("重", groups[0].source)
        assertEquals(listOf("zhong4", "chong2"), groups[0].candidates)
        assertEquals("A", groups[1].source)
        assertEquals(emptyList<String>(), groups[1].candidates)
        assertEquals("𠀀", groups[2].source)
        assertEquals(emptyList<String>(), groups[2].candidates)
        assertEquals(
            listOf(listOf("zhong4", "chong2"), listOf("A"), listOf("𠀀")),
            groups.map(PinyinReadingGroup::asTransportRow),
        )
    }

    @Test
    fun `all pinyin4j romanization systems have a pinned candidate matrix`() {
        val expected = mapOf(
            PinyinRomanizationSystem.HANYU to listOf("jian1", "jian4"),
            PinyinRomanizationSystem.TONGYONG to listOf("jian1", "jian4"),
            PinyinRomanizationSystem.WADE_GILES to listOf("chien1", "chien4"),
            PinyinRomanizationSystem.MPS2 to listOf("jian1", "jian4"),
            PinyinRomanizationSystem.YALE to listOf("jyan1", "jyan4"),
            PinyinRomanizationSystem.GWOYEU_ROMATZYH to listOf("jian", "jiann"),
        )

        expected.forEach { (system, candidates) ->
            assertEquals(candidates, Pinyin4jReadings.of("间", system).single().candidates)
        }
    }

    @Test
    fun `hanyu candidate formatting remains explicit`() {
        val markedUppercase = PinyinOptions.parse(
            mapOf("case" to "UP", "tone" to "MARK"),
        )
        assertEquals(
            listOf("HǍO", "HÀO"),
            Pinyin4jReadings.of("好", hanyuOptions = markedUppercase).single().candidates,
        )
    }

    @Test
    fun `romanization parser accepts stable aliases and rejects unknown systems`() {
        assertEquals(PinyinRomanizationSystem.HANYU, PinyinRomanizationSystem.parse(null))
        assertEquals(PinyinRomanizationSystem.HANYU, PinyinRomanizationSystem.parse("pinyin"))
        assertEquals(PinyinRomanizationSystem.WADE_GILES, PinyinRomanizationSystem.parse("Wade-Giles"))
        assertEquals(PinyinRomanizationSystem.MPS2, PinyinRomanizationSystem.parse("mandarin phonetic symbols 2"))
        assertEquals(PinyinRomanizationSystem.GWOYEU_ROMATZYH, PinyinRomanizationSystem.parse("GR"))
        assertThrows(InvalidPinyinRomanizationException::class.java) {
            PinyinRomanizationSystem.parse("unknown")
        }
    }
}

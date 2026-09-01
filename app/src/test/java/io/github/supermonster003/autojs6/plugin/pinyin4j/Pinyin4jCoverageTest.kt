package io.github.supermonster003.autojs6.plugin.pinyin4j

import net.sourceforge.pinyin4j.PinyinHelper
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.Locale

class Pinyin4jCoverageTest {

    @Test
    fun `pinned dictionary has an exact BMP coverage fingerprint`() {
        var total = 0
        var unified = 0
        var outsideLegacyRange = 0
        val corpusDigest = MessageDigest.getInstance("SHA-256")
        for (codePoint in Char.MIN_VALUE.code..Char.MAX_VALUE.code) {
            val readings = PinyinHelper.toHanyuPinyinStringArray(codePoint.toChar())
            if (readings.isNullOrEmpty()) continue
            total++
            when (codePoint) {
                in 0x4E00..0x9FA5 -> unified++
                else -> outsideLegacyRange++
            }
            corpusDigest.update(
                String.format(
                    Locale.ROOT,
                    "%04X=%s\n",
                    codePoint,
                    readings.joinToString(","),
                ).toByteArray(StandardCharsets.UTF_8),
            )
        }

        assertEquals(20_378, total)
        assertEquals(20_377, unified)
        assertEquals(1, outsideLegacyRange)
        assertEquals(
            "0e839db127b9b79aac0ccddbaa30e2af8601ba9bd158a46bb35057029b8c0617",
            corpusDigest.digest().joinToString("") { byte ->
                (byte.toInt() and 0xFF).toString(16).padStart(2, '0')
            },
        )
        assertArrayEquals(arrayOf("ling2"), PinyinHelper.toHanyuPinyinStringArray('〇'))
        assertNull(PinyinHelper.toHanyuPinyinStringArray('㐀'))
        assertNull(PinyinHelper.toHanyuPinyinStringArray('\u9FA6'))
        assertNull(PinyinHelper.toHanyuPinyinStringArray('\uF900'))
    }
}

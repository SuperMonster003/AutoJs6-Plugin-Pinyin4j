package io.github.supermonster003.autojs6.plugin.pinyin4j

import org.autojs.plugin.pinyin4j.api.Pinyin4jPluginIds
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PluginRuntimeInfoTest {

    @Test
    fun `runtime fields are assembled without losing contract metadata`() {
        val info = PluginRuntimeInfo(
            name = "Pinyin4j",
            description = "Local pinyin conversion",
            author = PluginRuntimeInfo.DEFAULT_AUTHOR,
            id = Pinyin4jPluginIds.ID,
            engine = Pinyin4jPluginIds.ENGINE,
            variant = Pinyin4jPluginIds.VARIANT_DEFAULT,
            versionName = "1.1.0",
            versionCode = 11,
            versionDate = "Sep 1, 2026",
        )

        assertEquals("Pinyin4j", info.name)
        assertEquals("Local pinyin conversion", info.description)
        assertEquals("SuperMonster003", info.author)
        assertEquals(Pinyin4jPluginIds.ID, info.id)
        assertEquals(Pinyin4jPluginIds.ENGINE, info.engine)
        assertEquals(Pinyin4jPluginIds.VARIANT_DEFAULT, info.variant)
        assertEquals("1.1.0", info.versionName)
        assertEquals(11L, info.versionCode)
        assertEquals("Sep 1, 2026", info.versionDate)
        assertTrue(info.supportedAbis.isEmpty())
        assertEquals(3923, info.requiresHostVersion)
        assertEquals(PluginRuntimeInfo.REQUIRES_HOST_VERSION, info.requiresHostVersion)
    }
}

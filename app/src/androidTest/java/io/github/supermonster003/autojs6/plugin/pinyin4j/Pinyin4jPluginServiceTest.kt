package io.github.supermonster003.autojs6.plugin.pinyin4j

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.SystemClock
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.autojs.plugin.common.api.PluginCapabilityKeys
import org.autojs.plugin.pinyin4j.api.IPinyin4jPlugin
import org.autojs.plugin.pinyin4j.api.Pinyin4jPluginIds
import org.junit.After
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.util.Locale
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Pinyin4jPluginServiceTest {

    private val context: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    private lateinit var plugin: IPinyin4jPlugin
    private lateinit var connection: ServiceConnection
    private var isBound = false
    private var firstBindNanos = 0L

    @Before
    fun discoverAndBindService() {
        val discoveryIntent = Intent(DISCOVERY_ACTION)
            .addCategory(DISCOVERY_CATEGORY)
            .setPackage(context.packageName)
        @Suppress("DEPRECATION")
        val matches = context.packageManager.queryIntentServices(discoveryIntent, 0)

        assertEquals("The discovery contract must resolve exactly one service", 1, matches.size)
        val serviceInfo = matches.single().serviceInfo
        assertEquals(context.packageName, serviceInfo.packageName)
        assertEquals(Pinyin4jPluginService::class.java.name, serviceInfo.name)

        val binderReference = AtomicReference<IBinder>()
        val connected = CountDownLatch(1)
        connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                binderReference.set(service)
                connected.countDown()
            }

            override fun onServiceDisconnected(name: ComponentName) = Unit

            override fun onNullBinding(name: ComponentName) {
                connected.countDown()
            }
        }

        val explicitIntent = Intent(discoveryIntent).setComponent(
            ComponentName(serviceInfo.packageName, serviceInfo.name),
        )
        val bindStarted = SystemClock.elapsedRealtimeNanos()
        isBound = context.bindService(explicitIntent, connection, Context.BIND_AUTO_CREATE)
        assertTrue("bindService returned false", isBound)
        assertTrue("Timed out waiting for the Binder service", connected.await(10, TimeUnit.SECONDS))
        firstBindNanos = SystemClock.elapsedRealtimeNanos() - bindStarted

        val binder = binderReference.get()
        assertNotNull("The service returned a null Binder", binder)
        plugin = IPinyin4jPlugin.Stub.asInterface(binder)
        assertNotNull(plugin)
    }

    @After
    fun unbindService() {
        if (isBound) {
            context.unbindService(connection)
            isBound = false
        }
    }

    @Test
    fun aBenchmarkFirstBindAndServiceThroughput() {
        val firstConversionStarted = SystemClock.elapsedRealtimeNanos()
        assertEquals("han", plugin.of("汉", null))
        val firstConversionNanos = SystemClock.elapsedRealtimeNanos() - firstConversionStarted

        val singleIterations = 2_000
        val longIterations = 50
        val longText = "汉语拼音AutoJs6〇𠀀".repeat(64)
        val longCodePoints = longText.codePointCount(0, longText.length)
        repeat(500) { assertEquals("han", plugin.of("汉", null)) }
        repeat(5) { assertTrue(plugin.of(longText, null).isNotEmpty()) }

        val singleStarted = SystemClock.elapsedRealtimeNanos()
        repeat(singleIterations) { assertEquals("han", plugin.of("汉", null)) }
        val singleNanos = SystemClock.elapsedRealtimeNanos() - singleStarted

        val longStarted = SystemClock.elapsedRealtimeNanos()
        repeat(longIterations) { assertTrue(plugin.of(longText, null).isNotEmpty()) }
        val longNanos = SystemClock.elapsedRealtimeNanos() - longStarted

        val singleOpsPerSecond = singleIterations * 1_000_000_000.0 / singleNanos
        val longCodePointsPerSecond = longIterations * longCodePoints * 1_000_000_000.0 / longNanos
        println(
            String.format(
                Locale.US,
                "PINYIN4J_ANDROID_BENCHMARK {\"firstBindMs\":%.3f,\"firstConversionMs\":%.3f," +
                    "\"singleOpsPerSecond\":%.0f,\"longCodePoints\":%d," +
                    "\"longCodePointsPerSecond\":%.0f}",
                firstBindNanos / 1_000_000.0,
                firstConversionNanos / 1_000_000.0,
                singleOpsPerSecond,
                longCodePoints,
                longCodePointsPerSecond,
            ),
        )
    }

    @Test
    fun binderRoundTripCoversInfoConversionAndErrors() {
        val info = plugin.info
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        val expectedVersionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo.longVersionCode
        } else {
            @Suppress("DEPRECATION")
            packageInfo.versionCode.toLong()
        }

        assertEquals(context.getString(R.string.app_name), info.name)
        assertEquals(context.getString(R.string.plugin_description), info.description)
        assertEquals(PluginRuntimeInfo.DEFAULT_AUTHOR, info.author)
        assertEquals(Pinyin4jPluginIds.ID, info.id)
        assertEquals(Pinyin4jPluginIds.ENGINE, info.engine)
        assertEquals(Pinyin4jPluginIds.VARIANT_DEFAULT, info.variant)
        assertEquals(packageInfo.versionName, info.versionName)
        assertEquals(expectedVersionCode, info.versionCode)
        assertTrue(info.versionDate?.isNotBlank() == true)
        assertArrayEquals(emptyArray<String>(), info.supportedAbis)
        val capabilities = requireNotNull(info.capabilities)
        assertEquals(
            PluginRuntimeInfo.REQUIRES_HOST_VERSION,
            capabilities.getInt(PluginCapabilityKeys.REQUIRES_HOST_VERSION),
        )

        assertEquals("", plugin.of(null, null))
        assertEquals("han-A-!", plugin.of("汉A!", Bundle().apply {
            putString("separator", "-")
        }))
        assertEquals("hàn yǔ", plugin.of("汉语", Bundle().apply {
            putString("tone", "MARK")
            putString("sep", " ")
        }))
        assertEquals("hàn yǔ; nǚ", plugin.asTone("han4 yu3; nv3"))
        assertEquals("ling-㐀-𠀀", plugin.of("〇㐀𠀀", Bundle().apply {
            putString("separator", "-")
        }))
        assertEquals("HÀN; abc4", plugin.asTone("HAN4; abc4"))

        assertThrows(IllegalArgumentException::class.java) {
            plugin.of("汉", Bundle().apply { putString("toneType", "FIFTH_TONE") })
        }
    }

    private companion object {
        const val DISCOVERY_ACTION = "org.autojs.plugin.PINYIN4J"
        const val DISCOVERY_CATEGORY = "pinyin4j"
    }
}

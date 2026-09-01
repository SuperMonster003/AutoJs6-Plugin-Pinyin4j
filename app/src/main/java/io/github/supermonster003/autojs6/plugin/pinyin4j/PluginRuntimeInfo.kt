package io.github.supermonster003.autojs6.plugin.pinyin4j

import android.content.Context
import android.os.Build
import android.os.Bundle
import org.autojs.plugin.common.api.PluginCapabilityKeys
import org.autojs.plugin.common.api.PluginInfo
import org.autojs.plugin.pinyin4j.api.Pinyin4jPluginIds
import org.autojs.plugin.pinyin4j.api.Pinyin4jPluginCapabilityKeys

internal data class PluginRuntimeInfo(
    val name: String,
    val description: String,
    val author: String,
    val id: String,
    val engine: String,
    val variant: String,
    val versionName: String,
    val versionCode: Long,
    val versionDate: String,
    val supportedAbis: List<String> = emptyList(),
    val requiresHostVersion: Int = REQUIRES_HOST_VERSION,
    val readingsVersion: Int = Pinyin4jPluginCapabilityKeys.READINGS_VERSION_1,
) {
    fun toPluginInfo(): PluginInfo = PluginInfo().apply {
        name = this@PluginRuntimeInfo.name
        description = this@PluginRuntimeInfo.description
        author = this@PluginRuntimeInfo.author
        id = this@PluginRuntimeInfo.id
        engine = this@PluginRuntimeInfo.engine
        variant = this@PluginRuntimeInfo.variant
        versionName = this@PluginRuntimeInfo.versionName
        versionCode = this@PluginRuntimeInfo.versionCode
        versionDate = this@PluginRuntimeInfo.versionDate
        supportedAbis = this@PluginRuntimeInfo.supportedAbis.toTypedArray()
        capabilities = Bundle().apply {
            putInt(PluginCapabilityKeys.REQUIRES_HOST_VERSION, requiresHostVersion)
            putInt(Pinyin4jPluginCapabilityKeys.READINGS_VERSION, readingsVersion)
        }
    }

    companion object {
        const val REQUIRES_HOST_VERSION = 3923
        const val DEFAULT_AUTHOR = "SuperMonster003"
    }
}

internal fun Context.pluginInfo(name: String, description: String): PluginInfo {
    val appContext = applicationContext
    val packageInfo = appContext.packageManager.getPackageInfo(appContext.packageName, 0)
    return PluginRuntimeInfo(
        name = name,
        description = description,
        author = appContext.stringResource("plugin_author", PluginRuntimeInfo.DEFAULT_AUTHOR),
        id = appContext.stringResource("plugin_id", Pinyin4jPluginIds.ID),
        engine = appContext.stringResource("plugin_engine", Pinyin4jPluginIds.ENGINE),
        variant = appContext.stringResource("plugin_variant", Pinyin4jPluginIds.VARIANT_DEFAULT),
        versionName = packageInfo.versionName ?: "",
        versionCode = packageInfo.versionCodeCompat(),
        versionDate = appContext.stringResource("plugin_version_date", ""),
    ).toPluginInfo()
}

private fun Context.stringResource(name: String, fallback: String): String {
    val id = resources.getIdentifier(name, "string", packageName)
    return if (id != 0) resources.getString(id) else fallback
}

private fun android.content.pm.PackageInfo.versionCodeCompat(): Long {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) return longVersionCode
    @Suppress("DEPRECATION")
    return versionCode.toLong()
}

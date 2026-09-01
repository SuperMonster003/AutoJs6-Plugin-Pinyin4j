package io.github.supermonster003.autojs6.plugin.pinyin4j

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import org.autojs.plugin.pinyin4j.api.IPinyin4jPlugin

class Pinyin4jPluginService : Service() {

    override fun onBind(intent: Intent?): IBinder = binder

    private val binder = object : IPinyin4jPlugin.Stub() {
        override fun getInfo() = pluginInfo(
            name = getString(R.string.app_name),
            description = getString(R.string.plugin_description),
        )

        override fun of(text: String?, options: Bundle?): String {
            return try {
                Pinyin4jConverter.of(text.orEmpty(), options.toPinyinOptionValues())
            } catch (error: InvalidPinyinOptionException) {
                throw error.localized()
            }
        }

        override fun asTone(text: String?): String = Pinyin4jConverter.asTone(text.orEmpty())
    }

    private fun Bundle?.toPinyinOptionValues(): Map<String, String?> {
        if (this == null) return emptyMap()
        return buildMap {
            PinyinOptionNames.ALL.forEach { key ->
                if (this@toPinyinOptionValues.containsKey(key)) {
                    put(key, this@toPinyinOptionValues.getString(key))
                }
            }
        }
    }

    private fun InvalidPinyinOptionException.localized(): IllegalArgumentException {
        val messageResource = when (kind) {
            PinyinOptionKind.CASE_TYPE -> R.string.error_invalid_case_type
            PinyinOptionKind.TONE_TYPE -> R.string.error_invalid_tone_type
            PinyinOptionKind.V_CHAR_TYPE -> R.string.error_invalid_v_char_type
        }
        return IllegalArgumentException(getString(messageResource, rawValue), this)
    }
}

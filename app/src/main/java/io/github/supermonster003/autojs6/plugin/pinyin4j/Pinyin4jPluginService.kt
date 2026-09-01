package io.github.supermonster003.autojs6.plugin.pinyin4j

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import org.autojs.plugin.pinyin4j.api.IPinyin4jPlugin
import org.autojs.plugin.pinyin4j.api.Pinyin4jOptionKeys

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

        override fun readings(text: String?, options: Bundle?): String {
            return try {
                val source = text.orEmpty()
                val request = options.toReadingsRequest()
                Pinyin4jReadingsTransport.encode(
                    source,
                    Pinyin4jReadings.transportRows(source, request.system, request.hanyuOptions),
                )
            } catch (error: InvalidPinyinOptionException) {
                throw error.localized()
            }
        }
    }

    private fun Bundle?.toReadingsRequest(): Pinyin4jReadingsRequest {
        val values = toPinyinOptionValues()
        val system = PinyinRomanizationSystem.parse(
            this?.getString(Pinyin4jOptionKeys.ROMANIZATION)
                ?: this?.getString(Pinyin4jOptionKeys.SYSTEM),
        )
        require(PinyinOptionNames.SEPARATOR_KEYS.none(values::containsKey)) {
            "separator is not supported by Pinyin4j readings"
        }
        if (system != PinyinRomanizationSystem.HANYU) {
            val incompatible = buildList {
                if (PinyinOptionNames.CASE_TYPE_KEYS.any(values::containsKey)) add("case")
                if (PinyinOptionNames.TONE_TYPE_KEYS.any(values::containsKey)) add("tone")
                if (PinyinOptionNames.V_CHAR_TYPE_KEYS.any(values::containsKey)) add("v")
            }
            require(incompatible.isEmpty()) {
                "Pinyin4j ${incompatible.joinToString(", ")} options are only supported with HANYU romanization"
            }
        }
        val hanyuValues = if (PinyinOptionNames.TONE_TYPE_KEYS.none(values::containsKey)) {
            mapOf(PinyinOptionNames.TONE_TYPE to "WITH_TONE_NUMBER") + values
        } else {
            values
        }
        return Pinyin4jReadingsRequest(system, PinyinOptions.parse(hanyuValues))
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

private data class Pinyin4jReadingsRequest(
    val system: PinyinRomanizationSystem,
    val hanyuOptions: PinyinOptions,
)

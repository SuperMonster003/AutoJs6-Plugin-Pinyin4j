package io.github.supermonster003.autojs6.plugin.pinyin4j

import org.autojs.plugin.pinyin4j.api.Pinyin4jReadingsContract
import org.json.JSONArray
import java.nio.charset.StandardCharsets

internal object Pinyin4jReadingsTransport {

    fun encode(source: String, rows: List<List<String>>): String {
        require(source.codePointCount(0, source.length) <= Pinyin4jReadingsContract.MAX_SOURCE_CODE_POINTS) {
            "Pinyin4j readings source exceeds the code point limit"
        }
        val expectedRows = source.codePointCount(0, source.length)
        require(rows.size == expectedRows) {
            "Pinyin4j readings result row count ${rows.size} does not match source code point count $expectedRows"
        }
        val result = JSONArray().apply {
            rows.forEachIndexed { rowIndex, row ->
                require(row.size in 1..Pinyin4jReadingsContract.MAX_CANDIDATES_PER_CODE_POINT) {
                    "Pinyin4j readings row $rowIndex has an invalid candidate count"
                }
                row.forEachIndexed { itemIndex, value ->
                    require(
                        value.isNotEmpty() &&
                            value.codePointCount(0, value.length) <= Pinyin4jReadingsContract.MAX_READING_CODE_POINTS,
                    ) {
                        "Pinyin4j readings item [$rowIndex][$itemIndex] has an invalid length"
                    }
                }
                put(JSONArray(row))
            }
        }.toString()
        require(result.toByteArray(StandardCharsets.UTF_8).size <= Pinyin4jReadingsContract.MAX_RESULT_JSON_BYTES) {
            "Pinyin4j readings result exceeds the JSON byte limit"
        }
        return result
    }
}

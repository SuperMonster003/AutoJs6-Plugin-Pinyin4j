package io.github.supermonster003.autojs6.plugin.pinyin4j

import java.util.Locale

internal object PinyinToneConverter {
    private val numberedSyllablePattern = Regex(
        "(?<![A-Za-zÜü:0-9])([A-Za-zÜü:]+)([0-4])(?![A-Za-zÜü:0-9])",
    )

    fun convert(input: String): String {
        return numberedSyllablePattern.replace(input) { match ->
            val rawSyllable = match.groupValues[1]
            val tone = match.groupValues[2].single().digitToInt()
            if (rawSyllable.normalizedForValidation() !in validSyllables) {
                return@replace match.value
            }
            rawSyllable.withCanonicalUmlaut().applyTone(tone) ?: match.value
        }
    }

    private fun String.normalizedForValidation(): String {
        return lowercase(Locale.US)
            .replace("u:", "v")
            .replace('ü', 'v')
    }

    private fun String.withCanonicalUmlaut(): String = buildString {
        var index = 0
        while (index < this@withCanonicalUmlaut.length) {
            val character = this@withCanonicalUmlaut[index]
            when {
                character.equals('u', ignoreCase = true) &&
                    this@withCanonicalUmlaut.getOrNull(index + 1) == ':' -> {
                    append(if (character.isUpperCase()) 'Ü' else 'ü')
                    index += 2
                }
                character == 'v' -> {
                    append('ü')
                    index++
                }
                character == 'V' -> {
                    append('Ü')
                    index++
                }
                else -> {
                    append(character)
                    index++
                }
            }
        }
    }

    private fun String.applyTone(tone: Int): String? {
        if (tone == 0) return this
        val lowercase = lowercase(Locale.US)
        val toneIndex = when {
            'a' in lowercase -> lowercase.indexOf('a')
            'e' in lowercase -> lowercase.indexOf('e')
            "ou" in lowercase -> lowercase.indexOf('o')
            else -> lowercase.indexOfLast { it in "aeiouü" }
        }
        if (toneIndex < 0) return null
        val vowel = this[toneIndex]
        val marked = toneMarks[vowel.lowercaseChar()]?.getOrNull(tone - 1) ?: return null
        val caseAwareMark = if (vowel.isUpperCase()) marked.uppercaseChar() else marked
        return replaceRange(toneIndex, toneIndex + 1, caseAwareMark.toString())
    }

    private val toneMarks = mapOf(
        'a' to "āáǎà",
        'o' to "ōóǒò",
        'e' to "ēéěè",
        'i' to "īíǐì",
        'u' to "ūúǔù",
        'ü' to "ǖǘǚǜ",
    )

    private val validSyllables = buildSet {
        SYLLABLES.splitToSequence(Regex("\\s+"))
            .filter(String::isNotEmpty)
            .map { syllable -> syllable.normalizedForValidation() }
            .forEach(::add)
        // Keep the historical utility behavior for standalone finals and explicit ü spellings.
        "a o e i u v ai ei ui ao ou iu ie ve ue er an en in un vn ang eng ing ong"
            .splitToSequence(' ')
            .forEach(::add)
    }

    // Generated from all distinct unformatted syllables in pinyin4j 2.5.1's pinned dictionary.
    private const val SYLLABLES = """
        a ai an ang ao ba bai ban bang bao bei ben beng bi bian biao bie bin bing bo bu
        ca cai can cang cao ce cen ceng cha chai chan chang chao che chen cheng chi chong chou chu
        chuai chuan chuang chui chun chuo ci cong cou cu cuan cui cun cuo da dai dan dang dao de
        dei deng di dia dian diao die ding diu dong dou du duan dui dun duo e e^ ei en eng er
        fa fan fang fei fen feng fo fou fu ga gai gan gang gao ge gei gen geng gong gou gu gua
        guai guan guang gui gun guo ha hai han hang hao he hei hen heng hng hong hou hu hua huai
        huan huang hui hun huo ji jia jian jiang jiao jie jin jing jiong jiu ju juan jue jun ka
        kai kan kang kao ke ken keng kong kou ku kua kuai kuan kuang kui kun kuo la lai lan lang
        lao le lei leng li lia lian liang liao lie lin ling liu lo long lou lu lu: lu:e luan lue
        lun luo m ma mai man mang mao me mei men meng mi mian miao mie min ming miu mo mou mu n
        na nai nan nang nao ne nei nen neng ng ni nian niang niao nie nin ning niu nong nou nu
        nu: nu:e nuan nuo o ou pa pai pan pang pao pei pen peng pi pian piao pie pin ping po pou
        pu qi qia qian qiang qiao qie qin qing qiong qiu qu quan que qui qun r ran rang rao re
        ren reng ri rong rou ru ruan rui run ruo sa sai san sang sao se sen seng sha shai shan
        shang shao she shei shen sheng shi shou shu shua shuai shuan shuang shui shun shuo si song
        sou su suan sui sun suo ta tai tan tang tao te tei teng ti tian tiao tie ting tong tou tu
        tuan tui tun tuo wa wai wan wang wei wen weng wo wu xi xia xian xiang xiao xie xin xing
        xiong xiu xu xuan xue xun ya yan yang yao ye yi yiao yin ying yo yong you yu yuan yue yun
        za zai zan zang zao ze zei zen zeng zha zhai zhan zhang zhao zhe zhei zhen zheng zhi zhong
        zhou zhu zhua zhuai zhuan zhuang zhui zhun zhuo zi zong zou zu zuan zui zun zuo
    """
}

package com.seeq.proxy

import java.net.URL

class WebPageGetterProxy(val impl: WebPageGetterImpl): WebPageGetter {
    val spidersCount = hashMapOf<String, Int>()
    private val whatIsThat = """  
        <pre>
          / _ \\
        \\_\\(_)/_/
         _//o\\\\_
          /   \\
        </pre>""".trimIndent()
    private val regex = Regex("spider", RegexOption.IGNORE_CASE)

    override fun getPage(url: URL): String {
        val result = impl.getPage(url)
        val matches = regex.findAll(result)
        spidersCount[url.toString()] = matches.toList().size
        return regex.replace(result, whatIsThat)
    }
}
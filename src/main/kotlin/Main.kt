package com.seeq.proxy

import java.io.File
import java.net.URL

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val impl = WebPageGetterImpl()
        val proxy = WebPageGetterProxy(impl)

        // without the proxy
        writePage(URL("https://en.wikipedia.org/wiki/Spider"), "./no-spiders.html", impl)
        writePage(URL("https://www.pinkbike.com/"), "./pinkbike.html", impl)

        // with the proxy
        writePage(URL("https://en.wikipedia.org/wiki/Spider"), "./spiders.html", proxy)
        writePage(URL("https://www.google.com/"), "./google.html", proxy)

        proxy.spidersCount.entries.forEach {
            println("${it.key} = ${it.value}")
        }
    }

    private fun writePage(url: URL, path: String, webPageGetter: WebPageGetter) {
        File(path).writeText(webPageGetter.getPage(url))
    }
}
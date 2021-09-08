package com.seeq.proxy

import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors.toList

class WebPageGetterImpl: WebPageGetter {
    override fun getPage(url: URL): String {
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                return it.lines().collect(toList()).joinToString("")
            }
        }
    }
}
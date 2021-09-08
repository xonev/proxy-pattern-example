package com.seeq.proxy

import java.net.HttpURLConnection
import java.net.URL

interface WebPageGetter {
    fun getPage(url: URL): String
}
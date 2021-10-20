package com.module.base.ktdemo

import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import java.io.IOException
import java.util.*

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/9/5  23:43
 */
object HttpUtils {
    lateinit var userName: String
    var userPassword: String = ""

    fun countCompare() {
        val list = mutableListOf(1, 3, 6, 4, 12, 8, 9)
        var countCompare = 0
        list.sortWith(Comparator { o1, o2 ->
            countCompare++
            println("countCompare=$countCompare")
            println(list)
            o1.compareTo(o2)
        })
    }

    private val client = OkHttpClient()

    // 同步
    @Throws(Exception::class)
    fun getSync(url: String): String? {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) throw IOException("Unexpected code $response")
        val responseHeaders = response.headers()
        for (i in 0 until responseHeaders.size()) {
            println("${responseHeaders.name(i)}: ${responseHeaders.value(i)}")
        }
        return response.body()?.string()
    }

    // 异步
    @Throws(Exception::class)
    fun getAsync(url: String) {
        var result: String?
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(request: Request?, e: IOException?) {
                e?.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(response: Response?) {
                if (response == null || !response.isSuccessful) throw IOException("Unexpected code $response")
                val responseHeaders = response.headers()
                for (i in 0 until responseHeaders.size()) {
                    println("${responseHeaders.name(i)}: ${responseHeaders.value(i)}")
                }
                result = response.body()?.toString()
                println(result)
            }
        })
    }
}
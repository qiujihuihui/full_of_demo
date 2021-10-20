package com.module.base.ktdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.File

/**
 *
 *  On 2020/11/30
 *  first Kotlin demo
 *
 */
class MyMemo : AppCompatActivity() {
    private fun memoTest() = object {
        val x: String = "x"
    }

    private val user: HttpUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = user?.userName
        val password = user?.userPassword
        val home = FileUtils.userHome
        val content = FileUtils.getFileContent("test data")
        FooTest.getName(FooTest())
    }

    private fun groupByAuthor(articles: List<Article>): Map<String, List<Article>> {
        return articles.groupBy { it.author }
    }

    object FileUtils {
        val userHome = "/Users/jack/"

        fun getFileContent(file: String): String {
            var content = ""
            val f = File(file)
            f.forEachLine { content = content + it + "\n" }
            return content
        }
    }
}
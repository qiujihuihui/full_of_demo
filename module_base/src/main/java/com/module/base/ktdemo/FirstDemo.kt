package com.module.base.ktdemo

import java.util.*

/**
 *
 *  On 2020/11/30
 *
 */

fun what() {
    println("this is the reason")
    var a = 1
    a = 2
    println("a的值是：$a")
    println(a::class)
    println(a::class.java)

    var x = 5
    x += 1
    println("x = $x")
}

fun time() {
    val array = arrayOf(1, 2, 3)
    println(array)
    println(array is Array<Int>)
    println(array::class.java)
}

fun int2Long() {
    val x = 10
    val y = x.toLong()
    println(y)
}

class Sign {
    fun drive() {
        println("I want to sign")
    }
}

fun main(args: Array<String>) {
//    println("hello world!")
    int2Long()
}
package com.module.base.ktdemo

/**
 * just test the collection of list
 * @author  Shenhui
 * @version 1.0
 * @since   2021/8/10  22:41
 */

sealed class Expression

class Unit1 : Expression()
data class Const(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
data class Multiply(val e1: Expression, val e2: Expression) : Expression()
object NaN : Expression()

fun eval(expr: Expression): Double = when (expr) {
    is Unit1 -> 1.0
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Multiply -> eval(expr.e1) * eval(expr.e2)
    NaN -> Double.NaN
}

fun main() {
//    val myList = mutableListOf(1, 2, 3, 4, 7, 4, 2)
//    println("length is: ${getPosition(myList)}")
//    println("test is: ${myList.reduceRight { a, b -> a - b }}")
//    myList.forEachIndexed { _, i -> if (i > 3) println("num is: $i") }
//    myList.takeLastWhile { it > 3 }
//    val myPair = myList.partition { it > 3 }
//    println("result is: ${myPair.first}")
//    val myList1 = listOf(8, 9)
//    println("my result is: ${myList.plus(myList1)}")
//    myList1 + 12
//    val mySet = setOf(1, 1, 2, 3, 4, 4)
//    println("result is: ${myList.toSet()}")
//    val map = mutableMapOf("x" to 1, "y" to 2, "z" to 3)
//    map.entries.forEach { println("key = " + it.component1() + " value = " + it.component2()) }
//    map.entries.forEach { println(it.toPair()) }
//    println("${map.getOrElse("m", {100})}")
//    val map1 = mutableMapOf<String, Int?>()
//    println("${map1.getOrPut("x", {2})}")
//    val map: Map<Int, String> = mapOf(1 to "a", 2 to "b", 3 to "c", -1 to "d")
//    val mMap = map.mapKeys { it.key * it.key }
//    println("${mMap.entries}")
//    val north = Direction.NORTH
//    println("north name is: ${north.name}--ordinal is: ${north.ordinal}")
//    val myDirection = enumValues<Direction>().joinToString { "${it.name} : ${it.ordinal}" }
//    println(myDirection)

//    val url = "http://www.baidu.com"
//    val html1 = HttpUtils.getSync(url)
//    println("html1=${html1}")
//    HttpUtils.getAsync(url)

//    val u = eval(Unit1())
//    val a = eval(Const(1.1))
//    val b = eval(Sum(Const(1.0), Const(9.0)))
//    val c = eval(Multiply(Const(10.0), Const(10.0)))
//    println("u is $u")
//    println("a is $a")
//    println("b is $b")
//    println("c is $c")

//    val user = User("张三", "12345")
////    user.id = 12L
////    println("name is ${user.name}, id is ${user.id}")
//    val (name) = user
//    println("name is $name")
    doStop()
    doWait()
    doNotify()
    doRun()
}

fun doStop() {
    var isRunning: Boolean
    Thread {
        isRunning = false
        println("doStop: I am not running, isRunning = $isRunning")
    }.start()
}

fun doWait() {
    var isRunning: Boolean
    val wait = Runnable {
        isRunning = false
        println("doWait: I am waiting, isRunning = $isRunning")
    }
    Thread(wait).start()
}

fun doNotify() {
    var isRunning: Boolean
    val wait = {
        isRunning = true
        println("doNotify: I am notify, isRunning = $isRunning")
    }
    Thread(wait).start()
}

fun doRun() {
    var isRunning: Boolean
    Thread(Runnable {
        isRunning = true
        println("doRun: I am run, isRunning = $isRunning")
    }).start()
}

fun getPosition(list: List<Any>): Any? {
    return list.elementAtOrNull(4)
}

fun <T> Iterable<T>.myTake(n: Int): List<T> {
    require(n >= 0) { "Required element count $n is less than 0" }
    return emptyList()
}

fun checkAllScore(students: List<Student>): Int {
    var allScore = 0
    students.forEach {
        allScore += it.score
    }
    return allScore
}

fun getAllMBI(students: List<Student>): Float {
    var mbi = 0f
    students.forEach {
        mbi += it.getMBI()
    }
    return mbi
}

fun distance(x: Double, y: Double): Double {
    val paragon = object {
        var x = 0.0
        var y = 0.0
    }
    return Math.sqrt((x - paragon.x) * (y - paragon.y))
}
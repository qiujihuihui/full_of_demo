package com.module.base.ktdemo

import android.util.Log
import kotlinx.coroutines.*
import java.lang.IllegalArgumentException
import java.lang.StringBuilder

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
    println(true)
    println(array::class.java)
}

fun int2Long() {
    val x = 10
    val y = x.toLong()
    println(y)
}

class Sign {
    fun drive(carName: String? = "Das") {
        var x = 105
        x += 18
        val money = 16000
        println("I want to drive the $carName, speed is $x")
    }
}

fun getLength(obj: Any): Int? {
    var result = 0
//    val getResult = ""
    if (obj is String) {
        println(obj::class)
        result = obj.length
        println(result)
    }
    println(obj::class)
    return result
}

val <T> List<T>.getLastIndex: Int get() = size - 1

val myArr = arrayOfNulls<Int>(10)

val square = Array(10) { i -> (i * i) }

val x: IntArray = intArrayOf(1, 2, 3)

fun String.isNotEmpty(): Boolean {
    return !this.isEmpty()
}

fun max1(a: Int, b: Int): Int {
    return if (a > b) {
        println("max is a")
        a
    } else {
        println("max is b")
//        b
        val strings = mutableListOf("1", "2")
        strings.getLastIndex
    }
}

fun cases(obj: Any) {
    when (obj) {
        in 1..10 -> print("the first item")
        "hello" -> print("this is a string")
        is Long -> print("this is a long data")
        max1(12, 13) -> print("this is not a string data is: ${max1(12, 13)}")
        else -> {
            print("i don't know $obj is what")
        }
    }
}

fun testFor(persons: Array<Article>): String {
    var name = ""
    for (person in persons) {
        if (person.title == "John")
            name = person.title
    }
    for (index in persons.withIndex()) {
        if (index.value.title == "John")
            name = index.value.title
        if (index.index == 5)
            name = index.index.toString()
    }
    for (index in persons.indices) {
        if (index > 3)
            name = persons[index].title
    }

    return name
}

fun testWhile() {
    var x = 10
    while (x > 0) {
        x--
        println("x is $x")
    }

    var y = 10
    do {
        y += 1
        println("y is $y")
    } while (y < 20)
}

fun testBreakAndContinue() {
    for (i in 1..10) {
        println("current is $i")
        if (i % 2 == 0) {
//            break
            continue
        }
    }
}

val value = fun(a: Int, b: Int) = a + b
fun compare(article1: Article?, article2: Article?) = if (article1?.pageSize!! > article2?.pageSize!!) article1 else
    article2

fun testReturn() {
    val intArray = intArrayOf(1, 2, 3, 4, 5)
//    intArray.forEach {
//        if (it == 3) return
//        println("from first one is: $it")
//    }

    intArray.forEach(fun(a: Int) {
        if (a == 3) return
        println("form second one is: $a")
    })

    intArray.forEach here@{
        if (it == 3) return@here
        println("from third one is: $it")
    }

    intArray.forEach {
        if (it == 3) return@forEach
        println("from forth one is $it")
    }
}

fun testReturn1() {
/*    for (outer in 1..5) {
        println("outer is:$outer")
        for (inner in 1..10) {
            println("inner is: $inner")
            if (inner % 2 == 0) {
                break
            }
        }
    }*/

    outer@ for (outer in 1..5) {
        println("outer is:$outer")
        for (inner in 1..10) {
            println("inner is: $inner")
            if (inner % 2 == 0) {
                break@outer
            }
        }
    }
}

/**
 * use the type of Nothing when it has nothing to return.
 */
fun fail(msg: String): Nothing {
    throw IllegalArgumentException(msg)
}

val sum = fun Int.(x: Int): Int = this + x
fun getSum() {
    val getSUm = 2.sum(3)
    println("sum is $getSUm")
}

class Outer {
    val oh = "Oh!"

    inner class Inner {
        fun m() {
            val outer = this@Outer
            val inner = this@Inner
            val pThis = this
            println("outer = $outer")
            println("inner = $inner")
            println("pThis = $pThis")
            println(this@Outer.oh)

            val fun1 = hello@ fun String.() {
                val d1 = this@hello
                println("d1 = $d1")
            }

            val fun2 = { _: String ->
                val d2 = this
                println("d2 = $d2")
            }

            "abc".fun1()

            fun2("edf")
        }
    }
}

open class Father {
    open val firstName = "Shen"
    open val lastName = "Hui"

    fun ff() {
        println("ah fff")
    }
}

class Daughter(override var lastName: String) : Father() {
    override var firstName = super.firstName

    fun love() {
        super.ff()
        println("$firstName " + super.lastName + " love $firstName " + this.lastName)
    }
}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

data class Counter(var index: Int)

operator fun Counter.plus(increment: Int): Counter {
    return Counter(index + increment)
}

fun check(name: String?) {
    val displayName = name ?: "unknown"
    println("name is $displayName")
}


data class Person(val name: String, val age: Int)

infix fun Person.grow(years: Int): Person {
    return Person(name, age + years)
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

val <T> List<T>.lastIndex: Int
    get() = size - 1

fun String.notEmpty(): Boolean {
    return this.isNotEmpty()
}

fun checkList() {
    val listWithNulls: List<String?> = listOf("A", "B", null)
    listWithNulls.forEach {
        it?.let { println(it) }
    }
}

fun checkPrimitive() {
    val x = (1 shl 2) and 0x000FF000
    println("value is $x")
    val m = true::class.java
    println("m is $m")
}

fun checkString() {
    val myString = "abc"
//    return myString[0]
    for (c in myString) {
        println("my string is $c")
    }
    println("sub is ${myString.subSequence(0, 1)}")
    val demo = """hello 
        | world
    """.trimMargin()
    println("trim is ${demo.trimIndent()}")
}

fun checkArray() {
//    val arr = arrayOf(1, "2", true)
//    arr.forEach { println("value is $it") }
//    arrayOfNulls<Int>(10).forEach { println("Int value is $it") }
    val square = Array(10) { i -> (i * i) }
    square.forEach { println("square element value is $it") }
}

fun getMyLength(str: String?): Int? {
    return str?.length
}

fun checkIs(ani: Any): Int {
    when (ani) {
        is String -> {
            return ani.length
        }
        is Number -> {
            return ani.toString().length
        }
        is Char -> {
            return 1
        }
        is Boolean -> {
            return 1
        }
        else -> {
            println("not a String")
            return -1
        }
    }
}

open class Foo
class Goo : FooTest()

fun checkFoo() {
    val foo = FooTest()
    val goo = Goo()
//    println("first value is ${foo as Goo}")
    println("second value is ${foo as? Goo}")
    println("third value is ${goo as FooTest}")
}

fun getList(num: MyList): List<Int> {
    return mutableListOf(1, 2, 3)
}

val sync = lazy {
    println("lazy 3")
    println("lazy 2")
    println("lazy 1")
    "hello lazy"
}

fun isOdd(x: Int) = x % 2 != 0

fun length(str: String) = str.length

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

typealias MyList = (num: Int) -> List<Int>

// Lambda表达式
val addOneLambda = { x: Int ->
    x + 1
}

// 匿名函数
val addOneAn = (fun(x: Int): Int {
    return x + 1
})

// 函数柯里化
fun curryAdd(x: Int): (Int) -> Int {
    return { y -> x + y }
}

// 使用Lambda实现
val lambdaCurryAdd = { x: Int ->
    { y: Int ->
        {
            x + y
        }
    }
}

fun fib(x: Int): Int {
    if (x == 0) return 0
    if (x == 1 || x == 2) return 1
    return fib(x - 1) + fib(x - 2)
}

fun triple(double: (Int) -> Int): (Int) -> Int {
    return { x -> double(x) + x }
}

infix fun String.builder(str: String): String {
    return StringBuilder(this).append(str).toString()
}

inline fun <reified T> T.ktxLog(msg: String) = Log.d(T::class.java.name, msg)

fun getUser(name: String, account: String = "", sex: Int = 0): User {
    return User(name)
}

fun main(args: Array<String>) = runBlocking {
//    val myList: List<Int> = listOf(1, 2, 3)
//    val myList2 = mutableListOf(1, 2, 3)
//    myList2.add(4)
//    myList2.forEach {
//        println("every one is $it")
//    }
//    println(myList2::class)
//    val list = myList2.toMutableList()
//    list.add(5)
//    list.forEach {
//        println("list every one is $it")
//    }

//    val print = fun(x: Any) { println(x) }
//    listOf(1, 2, 3).forEach(print)

//    val oddLength = compose(::isOdd, ::length)
//    val strings = listOf("a", "ab", "abc")
//    println(strings.filter(oddLength))

//    addOneLambda(1)
//    addOneAn(2)

//    println("just only one: ${curryAdd(1)}")
//    println("just has two: ${curryAdd(1)(2)}")
//    println("use lambda one is: ${lambdaCurryAdd(1)}")
//    println("use lambda two is: ${lambdaCurryAdd(1)(3)}")

//    println("fib is: ${fib(30)}")

//    val double = fun(x: Int): Int = x + x
//    triple(double)(10)
//    println("infix" builder "builder")

//    val user = getUser("John", account = "12345")
//    firstCoroutineDemo()

}

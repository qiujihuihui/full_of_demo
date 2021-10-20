package com.module.base.ktdemo

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/8/29  20:57
 */
abstract class Student constructor(var name: String, var age: Int) {
    var weight: Float = 80.0f
    abstract var score: Int

    constructor(name: String, age: Int, weight: Float) : this(name, age) {
        this.weight = weight
    }

    fun getMBI(): Float {
        return weight * age
    }

    abstract fun getScore()

    open fun doSleep() {
        println("I am sleeping ...")
    }
}
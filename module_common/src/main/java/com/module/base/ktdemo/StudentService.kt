package com.module.base.ktdemo

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/8/29  22:54
 */
interface StudentService<T> {
    var name: String
    var owner: String
    fun getName(student: T): String
    fun print() {
        println("I am student service")
    }
}
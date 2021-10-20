package com.module.base.ktdemo

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/9/5  21:16
 */
open class FooTest @MagicConstructor constructor() {
    var index: Int = 0

    constructor(index: Int) : this() {
        this.index = index
        println("I am constructor")
    }

    companion object : StudentService<FooTest> {
        override var name: String
            get() = "张三"
            set(value) {}

        override var owner: String
            get() = "ha ha"
            set(value) {}

        override fun getName(student: FooTest): String {
            return "my demo"
        }
    }
}
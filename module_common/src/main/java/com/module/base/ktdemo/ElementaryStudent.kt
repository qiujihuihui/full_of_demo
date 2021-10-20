package com.module.base.ktdemo

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/8/29  22:12
 */
class ElementaryStudent(weight: Float, name: String, age: Int) : Student(name, age, weight), StudentService<Student> {
    override var score: Int = 90

    override fun getScore() {
        val north = Direction.NORTH
    }

    override fun doSleep() {
        super.doSleep()
        println("yeah, me too.")
    }

    override var owner: String
        get() = "my owner is $name"
        set(value) {}

    override fun getName(student: Student): String {
        owner = student.name
        return name
    }

    override fun print() {
        super.print()
        println("I am elementary student.")
    }
}
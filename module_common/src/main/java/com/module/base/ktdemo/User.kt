package com.module.base.ktdemo

import java.io.Serializable

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/9/9  23:31
 */
data class User(val name: String): Serializable {
    var account: String = ""
    var id: Long = 0

    constructor(name: String, account: String) : this(name) {
        this.account = account
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return id.toInt()
    }

    override fun toString(): String {
        return "account: $account, id: $id"
    }
}
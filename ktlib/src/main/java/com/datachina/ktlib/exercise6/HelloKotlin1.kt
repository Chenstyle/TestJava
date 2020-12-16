package com.datachina.ktlib.exercise6

/**
 *  在默认情况下，lambda表达式中最后一个表达式将隐式作为该lambda表达式的返回值
 *  我们可以通过全限定的return语法来显式从lambda表达式返回值
 */

fun main() {
    val strings = arrayOf("hello", "world", "bye")

    strings.filter {
        it.length > 3
    }

    strings.filter {
        val mayFilter = it.length > 3
        mayFilter
    }

    strings.filter {
        val mayFilter = it.length > 3
        return@filter mayFilter
    }
}
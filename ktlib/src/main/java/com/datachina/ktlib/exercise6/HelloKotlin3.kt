package com.datachina.ktlib.exercise6

/**
 * 闭包
 *
 * 闭包就是一个lambda表达式或者一个匿名函数，可以访问到它作用域外层的变量，那么这就可以称之为一个闭包
 *
 * java之中要在内部访问外部的函数，需要声明为final，但kotlin中不需要
 */

fun main() {
    var sum = ""

    val strings = arrayOf("hello", "world", "bye")
    strings.filter { it.length > 3 }.forEach {
        sum += it
    }
    println(sum)
}
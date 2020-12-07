package com.datachina.ktlib.exercise

/**
 * 集合的操作
 * 函数式编程过滤
 */
fun main() {
    val array = listOf<String>("hello", "world", "hello world", "welcome", "goodbye")

    for (item in array) {
        println(item)
    }

    println("------")

    when {
        "world" in array -> println("world in collection")
    }

    println("------")

    array.filter { it.length > 5 }
            .map { it.toUpperCase() }
            .sorted()
            .forEach(::println)
}
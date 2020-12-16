package com.datachina.ktlib.exercise5

import java.util.*

/**
 *
 */

fun main() {
    val strings = arrayOf("hello", "world", "bye", "helloWorlD", "welcome")

    strings.filter { it.contains("h") }.forEach { println(it) }
    println("----------")

    strings.filter { it.length > 4 }.forEach { println(it) }
    println("----------")

    strings.filter { it.endsWith("d", ignoreCase = true) }.map { it.toUpperCase(Locale.getDefault()) }.forEach { println(it) }
}
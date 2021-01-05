package com.datachina.ktlib.exercise8

import java.lang.Integer.parseInt

/**
 * 异常。Kotlin当中，try是一个表达式
 * Kotlin中是没有checked exception的
 */
fun main() {
    val s = "3"

    val result: Int? = try {
        parseInt(s)
    } catch (ex: NumberFormatException) {
        null
    } finally {
        println("finally invoked")
    }

    println(result)

    println("----------")

    val s1 = "a"

    val result2: Int? = try {
        parseInt(s1)
    } catch (ex: NumberFormatException) {
        null
    } finally {
        println("finally invoked")
    }

    println(result2)
}
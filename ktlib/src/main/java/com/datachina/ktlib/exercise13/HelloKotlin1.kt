package com.datachina.ktlib.exercise13

/**
 * 反射
 */
fun main() {
    val c = String::class
    println(c)

    println("--------")

    val c2 = String::class.java
    println(c2)
}
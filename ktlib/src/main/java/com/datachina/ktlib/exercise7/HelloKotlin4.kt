package com.datachina.ktlib.exercise7

/**
 * Range
 */

fun main() {
    val i = 5

    if (i in 1..5) {
        println(i)
    }
    println("----------")
    // 1到4轮循，包括4
    for (a in 1..4) {
        println(a)
    }
    println("----------")
    // 预期是4到1的轮循，但是kotlin不允许这样做，只能用downTo
    for (a in 4..1) {
        println(a)
    }
    println("----------")
    // 4到1的降序轮循
    for (a in 4 downTo 1) {
        println(a)
    }
    println("----------")
    // 1到6的轮循，但步进2，也就是1，3，5
    for (a in 1..6 step 2) {
        println(a)
    }
    println("----------")
    // 6到1的轮循，步进2， 也就是6，4，2
    for (a in 6 downTo 1 step 2) {
        println(a)
    }
    println("----------")
    // 1到6的轮循，但不包括6
    for (a in 1 until 6) {
        println(a)
    }
    println("----------")
}
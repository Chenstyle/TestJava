package com.datachina.ktlib

/**
 * Kotlin 范围
 */
fun main() {
    val a = 5
    val b = 10
    if (a in 2..b) {
        // a 在 2~b之间
        println("in the range")
    }

    println(4 in 1..20)
    println(3 !in -4..6)

    if (a !in 2..b) {
        println("out of the range")
    }

    println("------")

    for (i in 2..10) {
        // 记住开闭原则：..左右的是包含在里面的
        // 输出：2 3 4 5 6 7 8 9 10
        println(i)
    }

    println("------")

    for (i in 2.rangeTo(10)) {
        // 2..10等同于2.rangeTo(10)
        // 输出：2 3 4 5 6 7 8 9 10
        println(i)
    }

    println("------")

    for (i in 2..10 step 2) {
        // 从2到10，步长为2
        // 输出：2 4 6 8 10
        println(i)
    }

    println("------")
    for (i in 10 downTo 2 step 4) {
        // 从10到2，步长为4
        // 输出：10 6 2
        println(i)
    }
}
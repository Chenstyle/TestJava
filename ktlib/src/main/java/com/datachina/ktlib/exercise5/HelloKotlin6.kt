package com.datachina.ktlib.exercise5

/**
 *  函数式编程
 */

fun myCalculate(a: Int, b: Int, calculate: (a: Int, b: Int) -> Int): Int {
    return calculate(a, b)
}

fun main() {
    println(myCalculate(2, 3) { a, b -> a * b })
    println(myCalculate(2, 3) { a, b -> a - b })
    println(myCalculate(2, 3) { a, b -> a + b })
    println(myCalculate(2, 3) { a, b -> a / b })
}
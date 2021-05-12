package com.datachina.ktlib.kt01lambda

enum class Cal {
    ADD,
    SUB,
    MUL,
    DIV
}

fun main(args: Array<String>) {

    fun argLam(a: Int, b: (var1: String) -> Int) {
        if (a > 10) {
            b("a greater than 10")
        } else {
            b("a lower or equal 10")
        }
    }

    argLam(10) {
        println("it = $it")
        it.length
    }


    // 传入两个数和操作，返回结果
    fun lamCount(a: Int, b: Int, cal: Cal) =
            when (cal) {
                Cal.ADD -> a + b
                Cal.SUB -> a - b
                Cal.MUL -> a * b
                Cal.DIV -> a / b
            }

    println(lamCount(2, 3, Cal.ADD))
    println(lamCount(2, 3, Cal.SUB))
    println(lamCount(2, 3, Cal.MUL))
    println(lamCount(2, 3, Cal.DIV))
}
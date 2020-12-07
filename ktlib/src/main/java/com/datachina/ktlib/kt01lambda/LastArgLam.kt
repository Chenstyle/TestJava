package com.datachina.ktlib.kt01lambda

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
}
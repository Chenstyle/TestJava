package com.datachina.ktlib.coroutines

fun main() {
    test(5, {
        println("hello test")
    })
    test(5) {
        println("hello test")
    }
    test2(5, {
        println("hello test2")
    })
    test2(5) {
        println("hello test2")
    }
}

fun test(x: Int, action: () -> Unit) {
    action()
}

fun test2(x: Int, action: (Int) -> Unit) {
    action(x)
}
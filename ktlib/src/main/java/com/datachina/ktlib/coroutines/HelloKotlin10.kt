package com.datachina.ktlib.coroutines

fun main() {
    test(5) {
        println("hello test")
    }
    test2(5) {
        println("hello test2")
    }
    test(5, ::test3)
    test2(5, ::test4)
    test5(5, ::test6)

//    test5(5, action = {
//        println("A")
//    })
}

fun test(x: Int, action: () -> Unit) {}

fun test2(x: Int, action: (Int) -> Unit) {}

fun test3() {}

fun test4(x: Int) {}

fun test5(x: Int, action: (Int, Int) -> Unit) {
    action(1, 2)
}

fun test6(x: Int, y: Int) {
    println(x + y)
}
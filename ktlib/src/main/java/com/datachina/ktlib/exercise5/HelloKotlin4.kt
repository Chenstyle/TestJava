package com.datachina.ktlib.exercise5

/**
 *  内联函数（inline funtion）
 *
 *  内联函数在运行的时候会拷贝相应的函数在调用的地方，会增加字节码的开销
 *  普通函数的调用是跳转到函数的地方完成调用，即使调用多次，字节码也不会有增加
 */

inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}
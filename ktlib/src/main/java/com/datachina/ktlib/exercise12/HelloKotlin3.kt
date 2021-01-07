package com.datachina.ktlib.exercise12

/**
 *  使用 @JvmOverloads注解来让Kotlin兼容java的可选参数
 */

class MyClass2 @JvmOverloads constructor(x: Int, y: String = "hello") {

    fun myMethod(a: Int, b: String, c: Int = 2) {
        println("a: $a, b: $b, s: $c")
    }
}
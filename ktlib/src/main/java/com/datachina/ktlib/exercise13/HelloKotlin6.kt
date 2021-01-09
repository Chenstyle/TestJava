package com.datachina.ktlib.exercise13

/**
 *      要想访问一个类当中的成员属性，需要使用全限定名称
 */
fun main() {
    val values = listOf("a", "abc", "abcd")
    println(values.map(String::length))

    println("----------")

    val x = MyClass::x
    println(x.get(MyClass(10)))
}

class MyClass(val x: Int)
package com.datachina.ktlib.exercise12

class MyClass {
    val a: Int
        @JvmName("getAValue")
        get() = 20

    fun getA() = 30
}

fun main() {
    val myClass = MyClass()

    println(myClass.getA())
    println(myClass.a)
}
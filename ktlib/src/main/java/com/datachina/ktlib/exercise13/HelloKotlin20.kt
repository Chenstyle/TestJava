package com.datachina.ktlib.exercise13

import kotlin.reflect.full.companionObject

class MyTestClass8 {

    companion object {
        fun method() {
            println("hello world")
        }
    }
}

fun main() {
    var myTestClass8 = MyTestClass8::class
    var companionObj = myTestClass8.companionObject

    println(companionObj?.simpleName)

    MyTestClass8.method()
}
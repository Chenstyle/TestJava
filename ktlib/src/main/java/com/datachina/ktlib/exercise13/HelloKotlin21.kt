package com.datachina.ktlib.exercise13

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

class MyTestClass9(value: Int = 0) {
    fun printSomething() {
        println("Something")
    }

    fun printNothing() {
        println("Nothing")
    }
}

fun main() {
    val myTestClass9 = MyTestClass9::class
    val myObj = myTestClass9.createInstance()

    myTestClass9.functions.find { it.name == "printSomething" }?.call(myObj)
    myTestClass9.functions.find { it.name == "printNothing" }?.call(myObj)
}
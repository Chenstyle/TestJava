package com.datachina.ktlib.exercise13

import kotlin.reflect.KClass
import kotlin.reflect.full.functions

class MyTestClass5 {
    fun printSomething(name: String) {
        println("something: $name")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main() {
    val myTestClass5Type: KClass<out MyTestClass5> = MyTestClass5::class
    val testClass5 = MyTestClass5()

    var functionToInvoked = myTestClass5Type.functions.find { it.name == "printNothing" }
    functionToInvoked?.call(testClass5)

    var functionToInvoked2 = myTestClass5Type.functions.find { it.name == "printSomething" }
    functionToInvoked2?.call(testClass5, "error")
}
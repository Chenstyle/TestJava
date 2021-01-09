package com.datachina.ktlib.exercise13

import kotlin.reflect.full.memberProperties

class MyTestClass6 {
    var name: String = "hello world"
}

fun main() {
    val myTestCalss6 = MyTestClass6::class
    val testClass6 = MyTestClass6()

    val variableToInvoked = myTestCalss6.memberProperties.find { it.name == "name" }

    println(variableToInvoked?.get(testClass6))
    println(variableToInvoked?.call(testClass6))
}
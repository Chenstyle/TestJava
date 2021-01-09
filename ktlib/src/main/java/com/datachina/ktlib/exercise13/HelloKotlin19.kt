package com.datachina.ktlib.exercise13

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

class MyTestClass7 {
    var name: String = "hello world"
    var authorName: String = "Tom"
}

fun main() {
    val myTestCalss7 = MyTestClass7::class
    val testClass7 = MyTestClass7()

    val variableToInvoked = myTestCalss7.memberProperties.find { it.name == "name" }
    println(variableToInvoked?.get(testClass7))

    if (variableToInvoked is KMutableProperty<*>) {
        variableToInvoked.setter.call(testClass7, "welcome")
    }
    println(variableToInvoked?.get(testClass7))
}
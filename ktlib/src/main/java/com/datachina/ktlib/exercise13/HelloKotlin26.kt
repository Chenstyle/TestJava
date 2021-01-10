package com.datachina.ktlib.exercise13

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

class MyTestClass14 {
    var name = "Java"
    val price = 23.3
}

var myTest = "myTest"

fun main() {
    val topProp = ::myTest
    println(topProp.javaField)
    println(topProp.javaGetter)
    println(topProp.javaSetter)

    val n = MyTestClass14::name
    println(n.javaField)
    println(n.javaGetter)
    println(n.javaSetter)

    val m = MyTestClass14::price
    println(m.javaField)
    println(m.javaGetter)
}
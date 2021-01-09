package com.datachina.ktlib.exercise13

import kotlin.reflect.KClass

class MyTestClass4(value: Int) {
    constructor(amount: Int, color: String) : this(amount) {
        println("secondary constructor")
    }

    constructor(amount: Int, full: Boolean) : this(amount) {
        println("secondary constructor")
    }

    fun printSomething() {
        println("something")
    }
}

fun main() {
    val myTestClass4Type: KClass<in MyTestClass4> = MyTestClass4::class
    val constructors = myTestClass4Type.constructors
    constructors.forEach {
        println(it)
    }
}
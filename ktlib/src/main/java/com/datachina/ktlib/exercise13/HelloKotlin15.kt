package com.datachina.ktlib.exercise13

import kotlin.reflect.KClass
import kotlin.reflect.full.memberFunctions

class MyTestClass3 {
    fun printSomething() {
        println("printSomething")
    }

    fun printNothing() {
        println("")
    }
}

fun main() {
    val myTestClassType3: KClass<out MyTestClass3> = MyTestClass3::class
    println(myTestClassType3.memberFunctions)
}
package com.datachina.ktlib.exercise13

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

class MyTestClass2(var a: String, val flag: Boolean, var age: Int)

fun main() {
    val myTestClass2: KClass<out MyTestClass2> = MyTestClass2::class
    println(myTestClass2.memberProperties)
}
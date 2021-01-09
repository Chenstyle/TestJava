package com.datachina.ktlib.exercise13

import java.io.Serializable
import kotlin.reflect.KClass
import kotlin.reflect.full.superclasses

interface MyInterface

class MySerializable : Serializable, MyInterface

fun main() {
    val mySerializableType: KClass<out MySerializable> = MySerializable::class
    println(mySerializableType.superclasses)
}
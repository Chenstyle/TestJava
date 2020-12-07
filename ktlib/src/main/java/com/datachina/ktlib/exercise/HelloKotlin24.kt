package com.datachina.ktlib.exercise

/**
 * 扩展属性
 */
class MyExtensionProperty

val MyExtensionProperty.name: String
    get() = "hello"

fun main() {
    val myExtensionProperty = MyExtensionProperty()
    println(myExtensionProperty.name)
}
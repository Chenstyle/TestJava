package com.datachina.ktlib.exercise13

/**
 *  我们可以引用特定对象的一个实例方法
 *  也可以引用特定对象的属性
 */
fun main() {
    val str = "abc"
    val getReference = str::get
    println(getReference(1))

    println("---------")

    val myProp = "test"::length
    println(myProp.get())

    println("----------")

    val myProp2 = String::length
    println(myProp2.get("test"))
}
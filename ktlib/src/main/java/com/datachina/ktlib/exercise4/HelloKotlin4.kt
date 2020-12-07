package com.datachina.ktlib.exercise4

import kotlin.properties.Delegates

// 非空属性

/**
 * 非空委托，如果在赋值之前调用，直接抛出：IllegalStateException: Property address should be initialized before get.
 */
class MyPerson {
    var address: String by Delegates.notNull()
}

fun main() {
    val myPerson = MyPerson()
    myPerson.address = "suzhou"
    println(myPerson.address)
}
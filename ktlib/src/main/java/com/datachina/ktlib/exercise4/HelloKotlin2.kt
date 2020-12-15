package com.datachina.ktlib.exercise4

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// 委托属性（delegated property）
/**
 *  有4种情况在实际开发中比较有用：
 *
 *  1. 延迟属性
 *  2. 可观测属性
 *  3. 非空属性
 *  4. map属性
 */

class MyDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = "$thisRef, your delegate property name is ${property.name}"

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) = println("$thisRef, new value is $value")
}

class MyDelegate2 : ReadWriteProperty<MyPropertyClass, String> {
    override fun setValue(thisRef: MyPropertyClass, property: KProperty<*>, value: String) {
        println("thisRef = $thisRef, property.name = ${property.name}, value = $value")
    }

    override fun getValue(thisRef: MyPropertyClass, property: KProperty<*>): String {
        println("thisRef = $thisRef, property.name = ${property.name}")
        return property.toString()
    }

}

class MyPropertyClass {
    var str: String by MyDelegate()

    var str2: String by MyDelegate2()
}

fun main() {
    val myPropertyClass = MyPropertyClass()
    myPropertyClass.str = "hello world"
    println(myPropertyClass.str)

    println("------")

    myPropertyClass.str2 = "Hello World"
    println(myPropertyClass.str2)
}
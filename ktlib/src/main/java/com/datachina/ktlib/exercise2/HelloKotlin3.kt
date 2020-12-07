package com.datachina.ktlib.exercise2

// 泛型（generics），表示变量类型的参数化
class MyGeneric<T>(t: T) {
    var variable: T

    init {
        variable = t
    }
}

fun main() {
    // val myGeneric: MyGeneric<String> = MyGeneric<String>("hello world")
    val myGeneric = MyGeneric("hello world")

    println(myGeneric.variable)
    println("------")
    val myClass = MyClass<String, Number>("abc", 2)
    myTest(myClass)
}

// 协变（covariant）与逆变（contravariant）
// 协变：只从中读取数据，不往里面写入数据，这样的对象叫做生产者。
// 逆变：只往里面写入数据，而不从中读取数据，那么这样的对象叫做消费者。

// ====== 协变
class MyClass<out T, in M>(t: T, m: M) {
    private val t: T

    private var m: M

    init {
        this.t = t
        this.m = m
    }

    fun get(): T = t

    fun set(m: M) {
        this.m = m
    }
}

fun myTest(myClass: MyClass<String, Number>) {
    val myObject: MyClass<Any, Int> = myClass
    println(myObject.get())
}
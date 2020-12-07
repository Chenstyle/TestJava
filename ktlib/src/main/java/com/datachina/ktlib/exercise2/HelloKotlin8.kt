package com.datachina.ktlib.exercise2

class MyStorage<out T>(private var t: T) {

    fun getValue() = t

    fun setValue(t: @UnsafeVariance T) {
        this.t = t
    }
}

fun main() {
    val myStorage1: MyStorage<Int> = MyStorage(5)
    val myStorage2: MyStorage<Any> = myStorage1

    println(myStorage2.getValue())

    myStorage2.setValue("hello")

    println(myStorage2.getValue())
}
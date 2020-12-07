package com.datachina.ktlib.exercise2

/**
 * 在Kotlin当中，Consumer用out，可写不可读。Producer用in，可读不可写
 */
class ParameterizedClass<A>(private val value: A) {
    fun getValue(): A = this.value
}

class ParameterizedProducer<out T>(private val value: T) {

    fun get(): T = this.value
}

class ParameterizedConsumer<in T> {
    fun toString(value: T) = value.toString()
}

fun main() {
    val parameterizedClass = ParameterizedClass<String>("hello world")
    val result = parameterizedClass.getValue()
    println(result is String)
    println("------")

    val parameterizedProducer = ParameterizedProducer<String>("welcome")
    val myRef: ParameterizedProducer<Any> = parameterizedProducer
    println(myRef is ParameterizedProducer<Any>)
    println("------")

    val parameterizedConsumer = ParameterizedConsumer<Number>()
    val myRef2: ParameterizedConsumer<Int> = parameterizedConsumer
    println(myRef2 is ParameterizedConsumer<Int>)
}
package com.datachina.ktlib.exercise2

// 泛型函数

fun <T> getValue(item: T): T {
    return item
}

fun main() {
    val item = getValue(3)
    println(item)

//    val upperBoundsClass1 = UpperBoundsClass<List<MutableList<String>>>()

    val upperBoundsClass2 = UpperBoundsClass2<String>()

}

class UpperBoundsClass<T: List<T>>

class UpperBoundsClass2<T> where T: Comparable<T>, T: Any {

}
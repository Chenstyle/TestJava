package com.datachina.ktlib.exercise13

/**
 *  扩展属性
 */

val String.firstChar: Char
    get() = this[0]

fun main() {
    println(String::firstChar.get("xyz"))
}
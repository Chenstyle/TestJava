package com.datachina.ktlib.exercise13

/**
 * 反射
 */
fun main() {
    val son: Parent = Son()
    val daughter: Parent = Daughter()

    println(son::class)
    println(son::class.java)
    println("----------")
    println(daughter::class)
    println(daughter::class.java)

}

open class Parent

class Son : Parent()

class Daughter : Parent()
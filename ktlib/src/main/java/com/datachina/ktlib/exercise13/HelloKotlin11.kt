package com.datachina.ktlib.exercise13

import kotlin.reflect.KClass

/**
 * 无论一个类有多少个实例，这些实例所对应的KClass对象都是同一个
 */
fun main() {
    val kotlinLang = "kotlin"
    val kclass: KClass<out String> = kotlinLang::class
    println(kclass)

    println("----------")

    val kclassDataType: KClass<String> = String::class
    println(kclassDataType)

    println("----------")

    val kclass1: KClass<out String> = "kotlin"::class
    val kclass2: KClass<out String> = "java"::class
    val kclass3: KClass<out String> = "ruby"::class

    println(kclass1)
    println(kclass2)
    println(kclass3)
    println(kclass1 == kclass2)

    println("----------")

    val kclass4 = Class.forName("java.util.Date").kotlin
    println(kclass4)

    println(kclass4 == Class.forName("java.util.Date"))
    println(kclass4 == Class.forName("java.util.Date").kotlin)
}
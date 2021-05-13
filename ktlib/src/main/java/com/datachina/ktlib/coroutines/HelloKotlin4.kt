package com.datachina.ktlib.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 桥接阻塞与非阻塞的世界
 */
fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("Kotlin Coroutines")
    }

    println("Hello")
    runBlocking {
        delay(2000)
    }
    println("World")
}
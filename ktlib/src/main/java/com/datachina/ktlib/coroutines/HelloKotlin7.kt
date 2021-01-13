package com.datachina.ktlib.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *
 */
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("my job1")
    }

    println("person")

    coroutineScope {
        launch {
            delay(3000)
            println("my job2")
        }
        delay(2000)
        println("hello world")
    }
    println("welcome")
}
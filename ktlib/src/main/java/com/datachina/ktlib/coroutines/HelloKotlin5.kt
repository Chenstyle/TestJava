package com.datachina.ktlib.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val myJob: Job = GlobalScope.launch {
        delay(1000L)
        println("Kotlin Coroutines")
    }

    println("Hello")
    myJob.join()
    println("World")
}
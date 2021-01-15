package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *  Dispatchers.Unconfined
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined, thread: ${Thread.currentThread().name}")
        delay(300)
        println("Dispatchers.Unconfined, thread: ${Thread.currentThread().name}")
    }

    launch {
        println("No params, thread: ${Thread.currentThread().name}")
        delay(2000)
        println("No params, thread: ${Thread.currentThread().name}")
    }
}
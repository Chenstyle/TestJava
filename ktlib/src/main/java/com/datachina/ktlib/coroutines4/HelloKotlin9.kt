package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *  -Dkotlinx.coroutines.debug
 *
 *  coroutine plus
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("helloworld")) {
        println("thread: ${Thread.currentThread().name}")
    }
}
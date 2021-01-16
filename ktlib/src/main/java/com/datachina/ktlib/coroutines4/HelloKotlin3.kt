package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * log
 *  查看协程名，在
 *  VM options: -Dkotlinx.coroutines.debug
 */

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking {
    val a = async {
        log("hello world")
        10
    }

    val b = async {
        log("welcome")
        20
    }

    log("The result is ${a.await() + b.await()}")
}
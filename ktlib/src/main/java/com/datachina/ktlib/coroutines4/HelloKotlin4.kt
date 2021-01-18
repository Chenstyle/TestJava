package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 多个线程，一个协程
 */

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() {
    newSingleThreadContext("Context1").use { ctx1 ->
        newSingleThreadContext("Context2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started in Context1")

                withContext(ctx2) {
                    log("Working in Context2")
                }

                log("Back to Context1")
            }
        }
    }
}
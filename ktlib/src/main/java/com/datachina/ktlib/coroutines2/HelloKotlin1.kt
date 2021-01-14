package com.datachina.ktlib.coroutines2

import kotlinx.coroutines.*

fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        repeat(200) {
            println("hello: $it")
            delay(500)
        }
    }

    delay(1100)
    println("hello world")
//    myJob.cancel(CancellationException("just a try"))
//    myJob.join()
    myJob.cancelAndJoin()
    println("welcome")
}
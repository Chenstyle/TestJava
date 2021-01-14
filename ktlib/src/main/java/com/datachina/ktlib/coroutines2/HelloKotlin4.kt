package com.datachina.ktlib.coroutines2

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(100) {
                println("job: I am sleeping $it")
                delay(500)
            }
        } finally {
            println("执行了finally块")
        }
    }

    delay(1300)
    println("hello world")

    myJob.cancelAndJoin()
    println("welcome")
}
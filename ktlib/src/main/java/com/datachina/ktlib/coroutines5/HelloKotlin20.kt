package com.datachina.ktlib.coroutines5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    try {
        myMethod().collect {
            println(it)
            check(it <= 1) {
                "Collected $it"
            }
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}
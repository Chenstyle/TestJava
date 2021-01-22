package com.datachina.ktlib.coroutines5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private fun myMethod(): Flow<String> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}.map {
    check(it <= 1) { "Crash on $it" }
    "string $it"
}

fun main() = runBlocking {
    try {
        myMethod().collect { println(it) }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}
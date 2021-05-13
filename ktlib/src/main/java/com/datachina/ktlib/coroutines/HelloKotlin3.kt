package com.datachina.ktlib.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * delay函数是suspend的，所以要放在runBlocking这种函数里面执行
 */
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("Kotlin Coroutines")
    }

    println("Hello")
    runBlocking {
        println(this.coroutineContext)
        delay(2000)
    }
    println("World")
}
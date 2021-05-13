package com.datachina.ktlib.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * 协程
 *  1.协程其实就是线程
 */
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("Kotlin Coroutines")
    }

    println("Hello")
    Thread.sleep(2000)
    println("World")

//    coroutineBlock()
//    println("------")
//    threadBlock()
}

private fun coroutineBlock() {
    GlobalScope.launch {
        delay(1000L)
        println("Kotlin Coroutines")
    }
    println("Hello")
    runBlocking {
        delay(2000) // 只有在挂起（suspend）函数中才能使用
    }

    println("World")
}

private fun threadBlock() {
    thread {
        Thread.sleep(1000)
        println("Kotlin Thread")
    }
    println("Hello")
    Thread.sleep(2000)
    println("World")
}
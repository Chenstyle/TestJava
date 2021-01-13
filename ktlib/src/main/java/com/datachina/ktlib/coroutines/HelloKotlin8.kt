package com.datachina.ktlib.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 *  协程是轻量级的
 *
 *  这里并不是说创建一个协程比一个线程更省资源。本质上说，协程是线程池的运用。
 */
fun main() = runBlocking {
    repeat(100) {
        launch {
            delay(1000)
            println("A")
        }
    }
    println("Hello World")
}

/**
 * 相对于协程，线程的创建需要耗费更多的资源
 */
fun kotlin9() = runBlocking {
    repeat(100) {
        thread {
            Thread.sleep(1000)
            println("A")
        }
    }
    println("Hello World")
}
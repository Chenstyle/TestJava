package com.datachina.ktlib.coroutines

import kotlin.concurrent.thread

/**
 * 使用线程
 */
fun main() {
    thread {
        Thread.sleep(1000L)
        println("Kotlin Thread")
    }

    println("Hello")
    Thread.sleep(2000)
    println("World")
}
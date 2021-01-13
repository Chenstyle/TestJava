package com.datachina.ktlib.coroutines

import kotlin.concurrent.thread

fun main() {
    thread {
        Thread.sleep(1000L)
        println("Kotlin Thread")
    }

    println("Hello")
    Thread.sleep(2000)
    println("World")
}
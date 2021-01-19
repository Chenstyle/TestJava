package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 *  显示指定协程名
 *
 *  在VM options: -Dkotlinx.coroutines.debug
 *
 *  CoroutineName上下文元素可以让我们对协程进行命名，以便能输出可读性较好的日志信息
 */
private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking(CoroutineName("main")) {
    log("hello")

    val value1 = async(CoroutineName("coroutine1")) {
        delay(800)
        log("coroutine1 log")
        30
    }

    val value2 = async(CoroutineName("coroutine2")) {
        delay(1000)
        log("coroutine2 log")
        5
    }

    log("Result is ${value1.await() * value2.await()}")
}
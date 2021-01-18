package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * 一个线程，多个协程
 * log
 *  查看协程名方式，点击运行项目下拉框，点击Edit Configurations
 *  在VM options: 粘贴 -Dkotlinx.coroutines.debug
 */

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking {
    val a = async {
        log("hello world")
        10
    }

    val b = async {
        log("welcome")
        20
    }

    log("The result is ${a.await() + b.await()}")
}
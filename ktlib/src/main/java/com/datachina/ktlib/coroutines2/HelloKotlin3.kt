package com.datachina.ktlib.coroutines2

import kotlinx.coroutines.*

/**
 *  有两种方式可以让计算代码变为可取消的：
 *
 *  1. 周期性地调用一个挂起函数，该挂起函数会检查取消状态，比如说使用yield函数
 *  2. 显式地检查取消状态
 *
 *  如下示例将采用第二种方式
 *
 *  其中，isActive是协程的一个扩展属性，它是通过CoroutineScope对象添加的
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime

        var i = 0

        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I am sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300)
    println("hello world")

    job.cancelAndJoin()
    println("welcome")
}
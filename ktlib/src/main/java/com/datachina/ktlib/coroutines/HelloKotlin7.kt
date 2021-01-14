package com.datachina.ktlib.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *  除去不同的协程构建器所提供的协程作用域（coroutine scope）外，我们还可以通过coroutineScope builder来
 *  声明自己的协程作用域。该构建器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成。
 *
 *  runBlocking与coroutineScope之间主要的差别在于，后者在等待所有子协程完成其任务时并不会阻塞当前线程。
 */
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("my job1")
    }

    println("person")

    // 当coroutineScope没有执行完成的时候，下一行代码永远不会执行
    coroutineScope {
        launch {
            delay(3000)
            println("my job2")
        }
        delay(2000)
        println("hello world")
    }
    println("welcome")
}
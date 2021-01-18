package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *  对于父子协程来说，父协程总是会等待其所有子协程的完成。对于父协程来说，它不必显式地去追踪由它所启动的所有子协程，同时也不必调用
 *  子协程的Job.join方法来等待子协程的完成
 */
fun main() = runBlocking<Unit> {
    val request = launch {
        repeat(5) {
            launch {
                delay((it + 1) * 100L)
                println("Coroutines $it 执行完毕")
            }
        }

        println("hello")
    }

    request.join()
    println("world")
}
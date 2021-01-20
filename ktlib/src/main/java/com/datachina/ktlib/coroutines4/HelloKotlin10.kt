package com.datachina.ktlib.coroutines4

import kotlinx.coroutines.*

/**
 *  生命周期
 */
class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun destroy() {
        cancel()
    }

    fun doSomething() {
        repeat(8) {
            launch {
                delay((it + 1) * 300L)
                println("Coroutine $it is finished")
            }
        }
    }
}

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething()

    println("启动协程")
    delay(1300L)

    println("销毁Activity")
    activity.destroy()

    delay(5000L)
}
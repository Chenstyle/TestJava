package com.datachina.ktlib.coroutinesOfficial

import kotlinx.coroutines.*

/**
 * delay 是一个特殊的 挂起函数 ，它不会造成线程阻塞，但是会 挂起 协程，并且只能在协程中使用
 */
private fun firstCoroutineDemo() {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印
    }
    println("Hello,") // 协程在等待时主线程还在继续
    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证JVM存活
}

/**
 * delay函数是非阻塞的，Thread.sleep是阻塞的
 */
private fun block() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    runBlocking {
        delay(2000L)
    }
}

/**
 * 整个函数包裹在协程作用域中，方便使用delay
 */
private fun normalDelayUse() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    delay(2000L)
}

/**
 * 直接调用协程执行而非等待自动执行
 */
private fun waitWork() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // 将协程加入到主线程来，程序会等待其作用域运行完成后才退出
}

/**
 * 结构化并发
 * 作用是规避手动启动协程的join导致的出错
 */
private fun structConcurrence() = runBlocking {
    launch { // 在runBlocking作用域中启动一个新协程
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}

/**
 * 作用构建器
 *
 * runBlocking 方法会阻塞当前线程来等待， 而 coroutineScope 只是挂起，会释放底层线程用于其他用途。
 * 由于存在这点差异，runBlocking 是常规函数，而 coroutineScope 是挂起函数。
 */
private fun useStruct() = runBlocking {
    launch {
        delay(200L)
        println("Task for runBlocking")
    }

    coroutineScope { // coroutineScope会创建一个协程作用域并且在所有已启动子协程执行完毕之前不会结束。
        launch {
            delay(500L)
            println("Task for nested launch")
        }

        delay(100L)
        println("Task for coroutine scope") // 这一行在内嵌 launch 之前输出
    }

    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
}

/**
 * 挂起函数
 */
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

private fun sus() = runBlocking {
    launch { doWorld() }
    println("Hello,")
}

/**
 * 协程轻量证明
 */
private fun lightCoroutine() = runBlocking {
    repeat(100_000) {
        launch {
            delay(5000L)
            println(".")
        }
    }
}

fun main() {
//    firstCoroutineDemo() // 第一个协程demo
//    block() // delay函数非阻塞主线程
//    normalDelayUse() // 整个函数包裹在runBlock中，使用delay更加符合普通用法
//    waitWork() // 等待任务运行
//    structConcurrence() // 结构化并发
//    useStruct() // 作用构建器，主要是阻塞的runBlocking与挂起的coroutineScope
//    sus() // 挂起函数
    lightCoroutine()
}
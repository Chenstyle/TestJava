package com.datachina.ktlib.coroutinesOfficial

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印
    }
    println("Hello,") // 协程在等待时主线程还在继续
    Thread.sleep(2000) // 阻塞主线程 2 秒钟来保证JVM存活
}
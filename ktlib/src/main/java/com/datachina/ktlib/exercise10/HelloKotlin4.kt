package com.datachina.ktlib.exercise10

/**
 * 异常
 * 如果Java代码中有一个非运行时异常，那么在Kotlin调用这部分代码的时候，可以不做处理
 */
fun main() {
    val myException = MyException()
//    myException.myMethod()

    println("----------")

    // 获取一个对象所对应的Java类
    val clazz = MyException()::class.java
    println(clazz)
    println("----------")
    println(MyException().javaClass)
}
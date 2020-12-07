package com.datachina.ktlib.exercise3

/**
 * 对象声明
 *
 *  对象表达式和对象声明的区别：
 *  对象表达式是立刻就会被初始化的，而对象声明是延迟初始化的
 *  伴生对象是在其所对应的类被加载时初始化的，对应于Java的静态初始化
 */
object MyObject {
    fun method() = "hello world"
}

interface MyActionListener {
    fun myListener()
}

object MyObject2 : MyActionListener {
    override fun myListener() {
        println("myListener")
    }

}

fun main() {
    val listener = object : MyActionListener {
        override fun myListener() {
            println("base listener")
        }
    }
    listener.myListener()
    println(MyObject.method())
    MyObject2.myListener()
}
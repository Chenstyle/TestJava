package com.datachina.ktlib.exercise10

/**
 * 对于(String... args)这种传多个参数的情况
 */
fun main() {
    val myVarargs = MyVarargs()
    val stringArrays = arrayOf("hello", "world", "hello world")

    myVarargs.myMethod(*stringArrays) // spread operation *
}
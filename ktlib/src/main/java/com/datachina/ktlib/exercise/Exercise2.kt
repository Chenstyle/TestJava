package com.datachina.ktlib.exercise

fun main() {
    // 转义字符会自动生效
    val a: String = "hello \n world"
    println(a)
    // 使用三个引号，转义字符会失效，输出的内容就是三引号中原本的内容
    val b: String = """hello
        \n world
        welcome
    """
    println(b)
}
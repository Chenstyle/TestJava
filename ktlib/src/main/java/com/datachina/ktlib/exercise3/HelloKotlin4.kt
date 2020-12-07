package com.datachina.ktlib.exercise3

/**
 *
 */
class OuterClass4 {

    class NestedClass4 {
        init {
            println("Nested Class 4 construct block invoked.")
        }
    }
}

// ====== HelloKotlin5.kt

/**
 * 添加了inner关键字的内部类，其角色和外部类中的成员变量和成员方法的级别是一样的
 */
class OuterClass5{
    inner class NestedClass5(private val str: String) {
        init {
            println(str)
        }
    }
}

fun main() {
    val nestedClass4: OuterClass4.NestedClass4 = OuterClass4.NestedClass4()
    val nestedClass5: OuterClass5.NestedClass5 = OuterClass5().NestedClass5("hello world")
}
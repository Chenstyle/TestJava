package com.datachina.ktlib.exercise3

// 嵌套类 (Nested Class)

/**
 * 关于嵌套类和内部类之间的区别与联系：
 *
 *  1. 嵌套类：对应于Java的静态内部类（即有static关键字修饰的内部类），只要在一个类的内部定义了另外一个类，
 *      那么这个类就叫做嵌套类，相当于Java当中有static关键字修饰的内部类。
 *  2. 内部类：对应于Java中的非静态内部类（即没有static关键字修饰的内部类），使用inner关键字在一个类的内部
 *      所定义的另外一个类就叫做内部类，相当于Java中没有static关键字修饰的内部类。
 *
 *  嵌套类不能访问外部类的其他成员，只能访问另一个嵌套类
 *  这方面结合Java中的静态类和静态方法去理解。
 *
 */
class OuterClass {

    private val str: String = "hello world"

    class NestedClass {
        fun nestedMethod() = "welcome"
    }

    class NestedClass2 {
        val nestedClass = NestedClass()
    }
}

// ====== HelloKotlin2.kt

class OuterClass2 {
    private val str: String = "hello world"

    inner class NestedClass {
        fun nestedMethod() = str
    }

    // 局部嵌套类
    fun getName(): String {
         class LocalNestedClass {
             val name = "myTest"
         }
        return LocalNestedClass().name
    }
}

fun main() {
    println(OuterClass.NestedClass().nestedMethod())
    println(OuterClass2().NestedClass().nestedMethod())
    println("------")
    println(OuterClass2().getName())
}
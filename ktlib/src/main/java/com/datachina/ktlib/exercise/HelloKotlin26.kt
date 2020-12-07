package com.datachina.ktlib.exercise

/**
 *  扩展的作用域
 *  1. 扩展函数所定义在的类实例叫做 分发接收者（dispatch receiver）
 *  2. 扩展函数所扩展的那个类的实例叫做 扩展接收者（extension receiver）
 *  3. 当以上两个名字出现冲突时，扩展接收者的优先级最高
 */
class DD {
    fun method() {
        println("DD method")
    }
}

class EE {
    fun method2() {

    }

    fun DD.hello() {
        // 可以调用DD类中的函数
        method()
        // 也可以调用EE类中的函数
        method2()
    }

    fun world(dd: DD) {
        dd.hello()
    }

    fun DD.output() {
        // 扩展接收者优先级最高，所以是DD的toString方法
        println(toString())
        // 要调用类EE的toString方法，要加限定符
        println(this@EE.toString())
    }

    fun test() {
        var dd = DD()
        dd.output()
    }
}

fun main() {
    EE().test()
}

/**
 * 扩展可以很好的解决Java中充斥的各种辅助类问题
 * Collections.swap(list, 4, 10)
 * list.swap(4, 10)
 * Collections.binarySearch()
 * list.binarySearch(...)
 */
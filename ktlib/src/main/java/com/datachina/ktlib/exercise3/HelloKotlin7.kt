package com.datachina.ktlib.exercise3

/**
 *  匿名对象只能在局部变量范围内，
 *      或是被private修饰的成员变量范围内才能被识别出其真正的类型
 *  如果将匿名对象当做一个public方法的返回类型或是public属性的类型，
 *      那么该方法或是属性的真正类型就是该匿名对象所声明的父类型。
 *  如果没有声明任何父类型，那么该类型就是Any,
 *      在这种情况下，匿名对象中所声明的任何成员都是不可访问的。
 */

interface MyFace {
    fun killSome()
}

class MyClass {
    val myObject =  object : MyFace {
        fun output() {
            println("output invoked.")
        }

        override fun killSome() {
            println("Kill Some people")
        }
    }

    fun myTest() {
        println(myObject.javaClass)
        myObject.killSome()
    }
}

class MyClass2 {
    private fun method1() = object {
        val str = "hello"
    }

    internal fun method2() = object {
        val str = "world"
    }

    fun test() {
        val str = method1().str
//        val str2 = method2().str // not work
    }
}

fun main() {
    val myClass = MyClass()
    myClass.myTest()
}
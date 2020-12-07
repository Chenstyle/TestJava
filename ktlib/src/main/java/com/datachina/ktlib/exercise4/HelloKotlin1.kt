package com.datachina.ktlib.exercise4

// 委托（delegation）
// 类委托

interface MyInterface{
    fun myPrint()
}

class MyInterfaceImp(val str: String): MyInterface {
    override fun myPrint() {
        println("hello $str")
    }
}

/**
 *  委托原理：
 *      by关键字后面的对象实际上会被存储在类的内部，编译器则会把父接口中所有的方法实现出来，并且将
 *      实现转移给委托对象去进行
 */
class MyClass(myInterface: MyInterface): MyInterface by myInterface {
    // 如果重写了方法，优先调用
    override fun myPrint() {
        println("hello delegation")
    }
}

fun main() {
    val myInterfaceImp = MyInterfaceImp("world")
    MyClass(myInterfaceImp).myPrint()
}
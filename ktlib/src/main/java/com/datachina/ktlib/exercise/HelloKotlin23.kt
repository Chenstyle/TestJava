package com.datachina.ktlib.exercise

// 扩展：extension
/**
 * 装饰模式：不修改类的结构的情况下动态的给类添加一些功能
 * 扩展函数的解析是静态的
 *
 * 1. 扩展本身不会真正修改目标类，也就是说它并不会在目标类中插入新的属性或是方法
 * 2. 扩展函数的解析是静态分发的，而不是动态的，即不支持多态，调用只取决于对象的声明类型
 * 3. 调用是由对象声明类型所决定的，而不是由对象的实际类型决定
 */
class ExtensionTest {
    fun add(a: Int, b: Int) = a + b
    fun sub(a: Int, b: Int) = a - b
}

fun ExtensionTest.multiply(a: Int, b: Int) = a * b

fun main() {
    val extensionTest = ExtensionTest()

    println(extensionTest.add(1, 2))
    println(extensionTest.sub(1, 2))
    println(extensionTest.multiply(1, 2))

    println("----------")
    myPrint(BB()) // 调用函数是由对象的声明类型决定的，而不是实际类型
    println("----------")
    CC().foo()
    CC().foo(1)
}

open class AA

class BB : AA()

fun AA.a() = "a"

fun BB.a() = "b"

fun myPrint(aa: AA) {
    println(aa.a())
}

/**
 * 如果扩展函数和类中原有的函数重名，已有的函数优先级最高
 */
class CC {
    fun foo() {
        println("member")
    }
}

fun CC.foo(int: Int) {
    println("member2")
}

fun Any?.toString(): String {
    if (null == this) {
        return "null"
    }
    return toString()
}
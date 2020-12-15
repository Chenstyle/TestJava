package com.datachina.ktlib.exercise5

// 默认参数（default arguments）

fun test(a: Int = 0, b: Int = 1) = println(a - b)

fun main() {
    // 默认参数
    test()
    test(2)
    test(b = 2)
    test(3, 2)
    test(a = 3)
    println("----------")
    // 默认参数可继承
    println(A().method(1))
    println(B().method(2))
    println("----------")
    // 具名参数
    test2(b = 3)
    println("----------")
    // Lambda函数
    test3(2, 3, ::test)
    test3(2, 3, { a, b -> println(a - b) })
    // 如果一个函数的最后一个参数是一个Lambda表达式的话，那么调用的时候这个Lambda既可以放在参数列表中，
    // 也可以放在执行体当中
    test3(2, 3) { a, b ->
        println(a - b)
    }
    test3(2) { a, b ->
        println(a - b)
    }
    test3 { a, b ->
        println(a - b)
    }
    println("----------")

    test4(1, 2, 3, 4)
    test4(a = 1, b = 2, c = 3, d = 4)
    test4(a = 1, d = 4)
    println("----------")

    test4("a", "b", "c", "d")

    // 可变参数可以借助于spread operator以具名参数的形式传递
    // 使用*号把数组打散成一个一个的参数传递
    test4(*arrayOf("a", "b", "c", "d"))
    test4("a")

    val arrays = arrayOf("a", "b", "c", "d")
    test4(*arrays)

    /**
     * 在kotlin中调用Java方法时不能使用具名参数语法，因为Java字节码并不总是会保留方法参数名信息
     */
}

/**
 *  如果一个默认参数位于其他无默认值的参数前面，那么默认值只能通过在调用函数时使用具名参数的方式来使用
 */
fun test2(a: Int = 1, b: Int) = println(a - b)

/**
 * 如果函数的最后一个参数是一个lambda表达式，而且在调用时是位于圆括号之外，
 * 那么就可以不指定lambda表达式的具名参数名
 */
fun test3(a: Int = 1, b: Int = 2, compute: (x: Int, y: Int) -> Unit) {
    compute(a, b)
}

/**
 *  具名参数
 *
 *  在调用函数时，函数参数可以是具名的。
 *  当一个函数有大量参数或是一些参数拥有默认值时，这种调用方式是比较方便的
 */
fun test4(a: Int, b: Int = 2, c: Int = 3, d: Int) = println(a + b + c + d)

/**
 *  在调用函数时，如果同时使用了位置参数与具名参数，那么所有位置参数都必须位于第一个具名参数之前
 *  Ps: 在调用参数写满的情况下不适用此规则
 *  比如说， foo(1, b = 2)是允许的；不过foo(a = 1, 2)是不允许的
 */

fun test4(vararg strings: String) {
    println(strings.javaClass) // strings的Java类型是数组类型
    strings.forEach { println(it) }
}

open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}

class B : A() {
    override fun method(a: Int, b: Int) = a + b
}
package com.datachina.ktlib.exercise5

// 无返回值函数
fun myPrint(name: String) {
    println(name)
}

// 单表达式函数：函数的返回类型如果可以通过类型推断判断出来，那么返回类型就可以省略掉
fun add(a: Int, b: Int) = a + b

/**
 *  显示返回类型
 *
 *  拥有方法体的函数必须要显示指定返回类型，除非函数返回Unit，这时返回类型就可以省略掉。
 *  Kotlin并不会推断拥有块体的函数的返回类型，因为这种函数可能拥有非常复杂的控制流程，
 *  返回类型对于阅读代码的人来说就不是那么明显了（有时，对于编译器来说也是这样）
 */

/**
 *  一个方法中，只允许一个参数为vararg，通常作为最后一个参数。如果vararg不是最后一个参数，
 *  那么其后的参数就需要通过具名参数形式进行传递; 如果其后的参数是函数类型，那么还可以通过在圆括号外
 *  传递lambda表达式来实现。
 */

fun <T> convert2List(vararg element: T): List<T> {
    val result = ArrayList<T>()
    element.forEach { result.add(it) }
    return result
}

fun method(vararg intArr: Int, str: String) {}

fun method2(str: String, vararg intArr: Int) {}

fun main() {
//    method(1, 2, 3, "3") // compile error
    method(1, 2, 3, str = "3")
    method2("3", 1, 2, 3) // compile right
    println("----------")

    println(convert2List("hello", "world", "welcome", "hhh"))
    val element = arrayOf("hi", "bye", "go", "room")
    println(convert2List("welcome", "bye", *element))
}
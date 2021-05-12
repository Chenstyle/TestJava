package com.datachina.ktlib

fun main() {
    val method: (String, String) -> Unit = { aStr, bStr -> println("a: $aStr, b: $bStr") }
    // 调用方法 传参
    method("Chen", "style")

    val method02 = { println("Chen") }
    // 调用方法
    method02()
    // 使用方法名调用invoke()同样可以调用方法
    method02.invoke()

    val method03: (String) -> Unit = {
        println("Send argument is $it")
    }
    // 传递参数？
    method03("San")
    // when关键字使用
    val method04: (Int) -> Unit = {
        when (it) {
            1 -> println("Argument is One")
            in 20..30 -> println("Argument range is 2 ~ 30")
            else -> println("Some num else...")
        }
    }
    method04(1)
    method04(22)
    method04(5)
    println("------lambda传参")
    val method05: (Int, Int) -> Unit = { aNumber, bNumber ->
        println("First Num is $aNumber, Second Number is $bNumber.")
    }
    method05(12, 6)
    // lambda中使用下划线忽略参数
    val method06: (Int, Int) -> Unit = { aNumber, _ ->
        println("First number is $aNumber, Second number not define")
    }
    method06(33, 2)

    val method07: (String) -> String = { str -> "The param is $str" }
    val result = method07("Are you OK.")
    println(result)


    // 闭包1：携带状态
    fun test(b: Int): () -> Int {
        var a = 3
        return fun(): Int {
            a++
            return a + b
        }
    }

    val t = test(3)
    println(t())
    println(t())
    println(t())

// 闭包2：引用外部变量，并改变外部变量的值
    var sum: Int = 0
    val arr = arrayOf(1, 3, 5, 7, 9)
    arr.filter {
        // 过滤，参考RxJava的map语法
        it < 7
    }.forEach {
        // 此时只会有 1， 3， 5 传递过来
        sum += it
    }

    println(sum)
}
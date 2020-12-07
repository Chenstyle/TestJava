package com.datachina.ktlib.kt01lambda

fun main(args: Array<String>) {
//    loginAction("Chen", "Style") {
//        if (it) println("LoginSuccess ") else println("LoginFailed.")
//    }

    val lambdaT: (String, Int) -> String = { str1, in2 ->
        "$str1 added $in2"
        "$in2 $str1 added"
    }

    val lamt2 = { var1: String, var2: Int ->
        "var1 is $var1, var2 is $var2"
    }

    fun test(a: Int, b: (bb1: String, bb2: Int) -> Unit) {
        if (a > 10) b("a > 10", a) else b("a <= 10", a)
    }

    test(10) { a, b ->
        println(a)
        println(b)
    }

    // 这里举例一个语言自带的一个高阶函数filter,此函数的作用是过滤掉不满足条件的值。
    val arr = arrayOf(1, 3, 5, 7, 9)
// 过滤掉数组中元素小于2的元素，取其第一个打印。这里的it就表示每一个元素。
    println(arr.filter { it < 5 }.component1())
}

public fun loginAction(userName: String, userPwd: String, loginResponseResult: (Boolean) -> Unit) {
    // Check
    if (userName == null || userPwd == null) {
        return
    }
    loginEngine(userName, userPwd, loginResponseResult)
}

private fun loginEngine(userName: String, userPwd: String, loginResponseResult: (Boolean) -> Unit) {
    if ("Chen" == userName && "style" == userPwd) {
        loginResponseResult(true)
    } else {
        loginResponseResult(false)
    }
}
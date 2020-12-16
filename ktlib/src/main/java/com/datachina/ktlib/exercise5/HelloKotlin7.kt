package com.datachina.ktlib.exercise5

/**
 *  函数式编程 扩展方法
 */

fun String.filterTest(filterThis: (str: String) -> String): String {
    return filterThis(this)
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()

    this.forEach {
        if (predicate(it)) {
            sb.append(it)
        }
    }
    return sb.toString()
}

fun main() {
    val baseStr = "abc9cde7xy"

    val numberStr = baseStr.filterTest { it ->
        var isNumber = ""
        var notNumber = ""
        it.forEach {
            when (it.isDigit()) {
                true ->
                    isNumber += it
                else ->
                    notNumber += it
            }
        }
        isNumber
    }

    println(numberStr)

    println("----------")
    println(baseStr.filter { it.isDigit() })
    println(baseStr.filter { it.isLetter() })
}
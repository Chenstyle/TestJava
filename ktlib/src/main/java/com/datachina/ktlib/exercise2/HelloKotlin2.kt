package com.datachina.ktlib.exercise2

/**
 *  密封类（sealed class）
 *
 *  1. 密封类表示的是一种受限的类（父类和子类上的）的层次结构
 *  2. 密封类的一个子类可以有可包含状态的多个实例。
 *     虽然密封类也可以有子类，但是所有子类都必须在与密封类自身相同的文件中声明。
 *  3. 一个密封类是自身抽象的，它不能直接实例化并可以有抽象（abstract）成员。
 *  4. 密封类不允许有非-private 构造函数（其构造函数默认为 private）。
 *  5. 扩展密封类子类的类（间接继承者）可以放在任何位置，而无需在同一个文件中。
 */

// ====== official demo
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

sealed class Calculator
class Add : Calculator()
class Subtract : Calculator()
class Multiply : Calculator()

fun calculate(a: Int, b: Int, cal: Calculator) = when(cal) {
    is Add -> a + b
    is Subtract -> a - b
    is Multiply -> a * b
}

fun main() {
    println(eval(Const(0.23)))
    println(eval(Sum(Const(0.22), Const(0.44))))
    println(eval(NotANumber))

    println(calculate(2, 3, Add()))
    println(calculate(2, 3, Subtract()))
    println(calculate(2, 3, Multiply()))
}
package com.datachina.ktlib.exercise

/**
 * 延迟初始化属性
 *
 * Kotlin要求非空类型的属性必须要在构造方法中进行初始化
 * 有时，这种方法不太方便，比如可以通过依赖注入或是单元测试情况下进行属性的赋值
 *
 * 通过lateinit关键字标记属性为延迟初始化，需要满足以下3个条件
 *
 * 1. lateinit只能够用在类体中声明的var属性上，不能用在primary constructor声明的属性上
 * 2. 属性不能拥有自定义的setter与getter方法
 * 3. 属性类型需要为非空，且不能是原生数据类型（Int Float Char Byte Boolean Long Double）
 */
class TheClass {

    // 一个属性如果被标记位lateinit的话，那么Kotlin编译器就不会去检查它是否在声明时是否已经初始化
    lateinit var name: String

    fun init() {
        name = "zhangSan"
    }

    fun print() {
        println(name)
    }
}

fun main() {
    val theClass = TheClass()
    theClass.init()
    theClass.print()
}
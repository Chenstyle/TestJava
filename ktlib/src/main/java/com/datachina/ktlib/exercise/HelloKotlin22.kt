package com.datachina.ktlib.exercise

/**
 *  可见性： Visibility
 *  private 添加之后，只能在所在的文件中访问
 *  protected 继承可见，不能用于顶层
 *  internal 同一模块下可见，参考Android项目总的module
 *  public: 默认，一个函数或者类不加可见性修饰符，它就是public的
 */
open class Clazz {
    private val b = 2
    protected open val c = 3
    internal val d = 5
}

class SubClass: Clazz() {

    fun print() {
        println("subClass c = $c")
        println("subClass d = $d")
    }
}

class Class2 {
    val clazz = Clazz()

    fun print() {
        println(clazz.d)
    }
}

fun main() {
    SubClass().print()
    Class2().print()
}
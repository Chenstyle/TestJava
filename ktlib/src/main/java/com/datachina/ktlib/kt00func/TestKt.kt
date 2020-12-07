package com.datachina.ktlib.kt00func

fun main(args: Array<String>) {

    // ====== 函数参数可以指定默认值，如果要缺省调用，必须指定函数
    // 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用**具名参数**调用该函数来使用
/*    fun paramFun(num1: Int = 10, str: String) {
        println("num = $num1, str = $str")
    }

    paramFun(str = "hello")*/

    // ====== 最后一个参数是Lambda，前面是指定参数

    /*fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {}

    foo(1) { println("hello")}
    foo(qux = { println("hello") })
    foo { println("hello") }*/

    // ====== 具名参数

    /*fun reformat(str: String = "just", normalizeCase: Boolean = true, upper: Boolean = true, words: Char = '_'){}

    reformat("This is main", words = '2')*/

    // ====== 可变数量的参数
    // ：这玩意儿就跟Java的 fun(String ...args)一样

    /*fun foo(vararg str: String){}

    foo("3", "5", *arrayOf("a", "b", "c"))

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) {
            result.add(t)
        }
        return result
    }

    val a = arrayOf(1, 2, 3)
    val list = asList(-1, 0, *a, 4)

    for (var1 in list) {
        println(var1)
    }
    println("------")
    list.forEach(Consumer { println(it) })
    println("------")
    list.forEach(System.out::println)*/

    // ====== 返回到标签

    val listInt = listOf(1, 2, 3, 4, 5)

    fun foo() {
        listInt.forEach{
            if (it == 3) return // return 直接返回到函数 foo()
            print("this point is $it")
        }
    }
    foo()

    println("\n------")
    fun foo1() {
        listInt.forEach {
            if (it == 3) return@forEach // return 到forEach处，即跳过这一次下面的语句，遍历继续
            print("this point is $it")
        }
    }
    foo1()

    println("\n------")
    fun foo2() {
        listInt.forEach lit@ {
            if (it == 3) return@lit // return 到手动加的返回别名处
            // 通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名。
            print("this point is $it")
        }
    }
    foo2()

    /*println("------")
    // 测试一下goto的方法，使用return@name
    var a = 1
    var b = 2

    aPlus@ a = 10
    for (for1 in 1..10) {
//        return@aPlus // error 语法错误
        // 官方文档：注意，这种非局部的返回只支持传给内联函数的 lambda 表达式。
    }*/

    println("\n------")
    fun foo3() {
        run loop@ {
            listInt.forEach {
                if (it == 3) return@loop
                print(it)
            }
        }
        println(" done with the nested loop")
    }
    foo3()
}

// ===== 覆盖方法无法再次指定默认值

open class A {
    open fun foo(i: Int = 10) {}
}

class B : A() {
    override fun foo(i: Int) {
    }
}
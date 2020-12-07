package com.datachina.ktlib.kt02class

import jdk.nashorn.internal.ir.annotations.Ignore
import java.util.*
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator
import javax.swing.text.Position

// 1. 类
class Invoice {/*...*/ }

// 无类体类
class Empty

// 2. 构造函数
class Person01 constructor(firstName: String) {/*...*/ }

// 无注解或修饰符构造函数
class Person1(firstName: String) {/*...*/ }

// 构造初始化
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

// 构造参数使用不受限制，可以在初始化块中使用，也可以在类体内声明的属性初始化器中使用
// 如果想要在函数内使用，要在声明构造参数前面加上变量修饰符：val/var
class Customer(private val name: String) {
    private val customerKey = name.toUpperCase(Locale.ROOT)
    val length = name.length

    init {
        println(name)
        println(customerKey)
    }

    fun nameLength(): Int {
        return name.length
    }
}

// 简洁声明属性以及从主构造函数初始化属性
class Person2(val firstName: String, val lastName: String, var age: Int) {/*...*/ }

// 如果构造函数有注解或可见性修饰符，那么 constructor 关键字是必须的，并且这些修饰符都在它前面
class Customer1 public @Ignore constructor(name: String) {/*...*/ }

//fun main() {
//    var person2 = Person2("style", "Chen", 25).run {
//        println(firstName)
//        println(lastName)
//        println(age)
//    }
//}

// ====================

// 次构造函数
// 类也可以声明前缀有 constructor 的次构造函数
class Person3(val name: String) {
    var children: MutableList<Person3> = mutableListOf()

    constructor(parent: Person3) : this("Kai") {
        parent.children.add(this@Person3)
    }
}

// 构造函数委托
class Person4(val name: String) {
    var children: MutableList<Person4> = mutableListOf()

    constructor(name: String, parent: Person4) : this(name) {
        parent.children.add(this)
    }

    fun printChild() {
        children.forEach {
            println(it.name)
        }
    }

}

//fun main() {
//    val person4 = Person4("Wen")
//    Person4("Kai", person4)
//    person4.printChild()
//}

// ====== 初始化块和构造函数执行顺序
class Constructors(str1: String) {

    constructor() : this("May Second") {
        println("Primary")
    }

    init {
        println("Init block")
    }

    constructor(i: Int = 3) : this("Secondary") {
        println("Constructor")
    }

    constructor(i: Int, str2: String) : this(i) {
        println("Thirdly")
    }
}

//fun main() {
//    Constructors()
//    Constructors(122)
//    Constructors(122, "Wu")
//}

// Note: 主构造函数一定是第一时间执行的，然后是初始化块，然后才是次构造函数
// Tips: 构造函数只有主次之分

// ======公有构造函数

class DontCreateMe private constructor() {

    // 即使主构造函数没有参数，次构造函数创建的时候也必须调用主构造函数
    constructor(i: Int) : this() {
        println("Create in primary")
    }
}

//fun main() {
//    DontCreateMe(12)
//}


// ====== 继承
// 1. 首先，Kotlin有一个叫做Any的超类
class Example // 从 Any 隐式继承

// 2. 要使一个类可以被继承，使用open关键字标记它
open class Base00(p: Int) // 该类开放继承

class Derived00(p: Int) : Base00(p)

// ====== 覆盖方法

open class Shape {
    open val vertexCount: Int = 0
    open fun draw() {}
    fun fill() {}
}

// 标记open的方法可以被覆盖，必须加override关键字
class Circle : Shape() {
    override val vertexCount: Int = 0
    override fun draw() {
        super.draw()
    }
}

// 如果想让方法禁止再次被覆盖，在override前加final
open class Rectangle : Shape() {
    override val vertexCount: Int = 4
    final override fun draw() {
        super.draw()
    }
}

// 继承过来的属性可以用var来修改val，反之则不行。这是允许的，因为一个 val 属性本质上声明了一个 get 方法，
// 而将其覆盖为 var 只是在子类中额外声明一个 set 方法。
open class Polygon : Shape() {
    final override var vertexCount: Int = 0

    fun printVertexCount() {
        println(vertexCount)
    }
}

// ====== 派生类初始化顺序
// 设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
open class Base(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also {
        println("Initializing size in Base: $it")
    }
}

class Derived(name: String, val lastName: String)
    : Base(name.capitalize().also { println("Argument for Base: $it") }) {
    init {
        println("size is ${super.size}")
        println("Initializing Derived")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

//fun main() {
//    println("Constructing Derived(\"hello\", \"world\")")
//    val d = Derived("hello", "world")
//
//    val b = object : Base("obj") {
//        var x: Int = 0
//        var y: Int = 0
//    }
//    println(b.x)
//    println(b.y)
//    println(b.name)
//}

// ====== 属性与字段
// 设置了私有的属性不可访问

class PropertyAndFiled {
    var setterVisibility: String = "abc"
        private set
    var setterWithAnnotation: Any? = null
        @Ignore set
}

//fun main() {
//    val paf = PropertyAndFiled()
//    paf.setterWithAnnotation = "Fun"
//    paf.run {
//        println(setterVisibility)
//        println(setterWithAnnotation)
//    }
//}

// ====== 接口
// 接口既可以包含抽象方法的声明也可以包含实现。
// 与抽象类不同，接口无法保存状态。
// 它可以有属性，但必须声明为抽象或提供访问器实现
interface MyInterface {
    var prop: Int// 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun bar()
    fun foo() {
        // 可选的方法体
        println(prop)
    }
}

// 一个类或者对象可以实现一个或多个接口
class Child : MyInterface {
    override var prop: Int = 29
    override fun bar() {
        // 方法体
        foo()
    }
}

//fun main() {
//    Child().bar()
//}

// ===== 接口继承
interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Employee(
        // 不必实现name
        override val firstName: String,
        override val lastName: String,
        val position: Position
) : Person

// ===== 解决覆盖冲突

interface A {
    fun foo() {
        println("A")
    }

    fun bar()
}

interface B {
    fun foo() {println("B")}
    fun bar() {println("bar")}
}

class C : A {
    override fun bar() {
        println("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }

}

// ====== SAM 转换

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEvent = IntPredicate { it % 2 == 0 }

//fun main() {
//    println("Is 7 even? - ${isEvent.accept(7)}")
//}

// companion伴生对象

class Jumper {

    companion object {

        const val BASE_URL = "www.google.com"

        fun jumpA() {
            println("jump A")
        }

        fun jumpB() {
            println("jump B")
        }

        fun jumpC() {
            println("jump C")
        }
    }
}

//fun main() {
//    Jumper.jumpA()
//    Jumper.jumpB()
//    Jumper.jumpC()
//    println(Jumper.BASE_URL)
//}

// 10. 属性揭秘与延迟初始化特性

class Property {
    var param: String = "abc"
        private set
}

fun main() {
    val a = 13
    val b = 31
    for (f in IntArithmetics.values()) {
        println("$f($a, $b) = ${f.apply(a, b)}")
    }
}

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}
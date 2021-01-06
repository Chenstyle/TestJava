package com.datachina.ktlib.exercise9

/**
 * 注解也可以拥有自己的构造方法，并且构造方法也可以接收参数
 *
 * 注解构造方法所允许的参数类型：
 *
 * 1. 与Java原生类型所对应的类型（Int, Long, Short, Byte, Float, Double, Char, Boolean）
 * 2. 字符串： String
 * 3. classes (MyClass::class)
 * 4. 枚举：enums
 * 5. 其他的注解
 * 6. 上述类型的数组类型
 *
 * Kotlin的注解参数是不允许为空类型的，因为JVM不支持以null的形式存储注解属性值的。
 *
 * 如果某个注解被用作其他注解的参数，那么其名字就不需要以@字符开头
 *
 */

annotation class MyAnnotation2(val str: String)

@MyAnnotation2("hello")
class MyClass4

annotation class MyAnnotation3(val str: String, val myAnnotation: MyAnnotation2)

@MyAnnotation3("test", MyAnnotation2("welcome"))
class MyClass5

/**
 * 如果需要将某个class作为注解的参数，那么请使用Kotlin class (KClass)
 * Kotlin编译器会自动将其转换为Java Class
 * 这样，Java代码就可以正常看到注解与参数了。
 */
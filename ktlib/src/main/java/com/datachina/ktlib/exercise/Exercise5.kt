package com.datachina.ktlib.exercise

class Student(private val username: String, private val age: Int, private var address: String) {

    fun printInfo() {
        println("username: $username, age: $age, address: $address")
    }
}

/**
 * 如果构造方法拥有注解或是可见性修饰符，
 * 那么constructor关键字就不能省略，并且它位于修饰符的后面
 */
class Student2 private constructor(username: String) {

}

/**
 * 在JVM上，如果类的Primary构造方法的所有参数都拥有默认值，那么kotlin编译器就会为这个类生成一个不带参数的构造方法，
 * 这个不带参数的构造方法会使用参数的默认值，这样做的目的便于与Spring等框架更好的集成
 */
class Student3(val username: String = "Sam"){}

fun main() {
    val student = Student("Sam", 20, "hangzhou")
    student.printInfo()
//    val student2 = Student2()

    val student3 = Student3()
    println(student3.username)
}
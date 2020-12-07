package com.datachina.ktlib.exercise

class Person constructor(username: String) {
    private var username: String
    private var age: Int
    private var address: String

    init {
        println(username)
        this.username = username
        this.age = 20
        this.address = "beijing"
    }

    // 对于secondary构造方法来说，它必须直接或间接的调用primary构造方法
    // 官方文档：如果类有一个主构造函数，每个次构造函数需要委托给主构造函数，
    //      可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可：
    constructor(username: String, age: Int): this(username) {
        println("$username , $age")
        this.age = age
        this.address = "beijing"
    }

    constructor(username: String, age: Int, address: String): this(username, age) {
        println("$username , $age, $address")
        this.address = address
    }

    fun printInfo() {
        println("username: ${this.username}, age: ${this.age}, address: ${this.address}")
    }
}

fun main() {
    val person1 = Person("Adam")
    val person2 = Person("Bob", 22)
    val person3 = Person("Cake", 33, "hangzhou")

    person1.printInfo()
    person2.printInfo()
    person3.printInfo()
}
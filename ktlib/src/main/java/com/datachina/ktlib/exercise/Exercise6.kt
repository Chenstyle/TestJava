package com.datachina.ktlib.exercise

// 10. 属性揭秘与延迟初始化特性

class ParamExercise(name: String) {
    var name: String = name
        get() {
            println("get invoked")
            return field
        }
        set(value) {
            field = "set $value"
        }
}

class ThePerson(address: String, name: String) {
    val age: Int get() = 20

    var address: String = address
        get() {
            println("get invoked")
            return field
        }
        set(value) {
            println("set invoked")
            field = value
        }
}

fun main() {
    val param = ParamExercise("Judy")
    param.name = "Hello"

    var person = ThePerson("shanghai", "zhangsan")
    println(person.age)
    println(person.address)
    person.address = "hangzhou"
    println(person.address)

}
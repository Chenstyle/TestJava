package com.datachina.ktlib.exercise3

/**
 * 内部类会持有包含它的外部类的引用
 *
 * Kotlin访问外部类变量的方式：this@OutClass.property
 * Java访问外部类变量的方式：OutClass.this.property
 */
class Person {

    private val str: String = "Person Property"

    private inner class PersonFeature(var height: Int, var weight: Int) {

        private val str: String = "PersonFeature Property"

        fun getPersonFeature() {
            val str: String = "local property"
            println("person height: $height, weight: $weight")
            this@Person.method()

            // 访问外部类，使用This关键字
            println(this@Person.str)
            // 访问全局变量，直接使用this
            println(this.str)
            // 访问同作用域的变量，直接使用名称
            println(str)
        }
    }

    private fun method() {
        println("invoked person method")
    }

    fun getPerson() {
        val personFeature = PersonFeature(180, 76)
        personFeature.getPersonFeature()
    }
}

fun main() {
    val person = Person()
    person.getPerson()
}
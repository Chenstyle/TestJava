package com.datachina.ktlib.exercise

class CompanionObjectExtension {
    companion object MyObject {

    }
}

fun CompanionObjectExtension.MyObject.method() {
    println("companion object extension")
}

fun main() {
    CompanionObjectExtension.method()
}
package com.datachina.ktlib.exercise3

/**
 *  枚举
 *
 */
enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class Season2(val temperature: Int) {
    SPRING(10), SUMMER(30), AUTUMN(20), WINTER(-10)
}

// 枚举中声明方法
enum class Season3 {
    SPRING {
        override fun getSeason() = SPRING
    },
    SUMMER {
        override fun getSeason() = SUMMER
    },
    AUTUMN {
        override fun getSeason() = AUTUMN
    },
    WINTER {
        override fun getSeason() = WINTER
    };

    abstract fun getSeason(): Season3
}

enum class LockRoom(val lockStatus: String) {
    L("Lock"), N("NnLock")
}

fun main() {
    val seasons = Season.values()
    seasons.forEach { println(it) }

    println("-----")

    println(Season2.SPRING.temperature)

    println("-----")

    val season = Season.valueOf("SPRING")
    println(season.name)

    println("-----")

    println(LockRoom.L.lockStatus)
    println(LockRoom.N.lockStatus)

    println("-----")

    printLock(LockRoom.L)
    printLock(LockRoom.N)
}

/**
 * 针对有限集的传递方式可以使用枚举，具体也可以使用枚举内定义的有限常量
 */
fun printLock(status: LockRoom) {
    when (status) {
        LockRoom.L -> println("locked")
        LockRoom.N -> println("unlocked")
    }
    println(status.lockStatus)
}
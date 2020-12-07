package com.datachina.ktlib.exercise2

import com.datachina.ktlib.kt02class.Customer

/**
 *  Kotlin：声明处协变； Java：使用处协变
 *
 *  Kotlin中的out关键字叫做variance annotation，因为它是在类型参数声明处所指定的，因此我们称之为
 *      声明处协变（declaration-site variance）
 *  对于Java来说则是使用处协变（use-size variance），其中类型通配符使得类型协变成为可能。
 */

/**
 *  如果泛型类只是将泛型类型作为其方法的输出类型，那么我们就可以使用out
 *
 *  produce = output = out
 */
interface Producer<out T> {
    // 协变的类型只能用于返回值类型
    fun produce(): T
}

/**
 *  如果泛型类只是将泛型类型作为其方法的输入类型，那么我们就可以使用in
 *
 *  consume = input = in
 */
interface Consumer<in T> {
    fun consumer(item: T)
}

/**
 *  如果泛型类同时将泛型类型作为其方法的输入类型和输出类型，那么我们就不能使用out和in来修饰泛型
 */
interface ProducerConsumer<T> {
    fun produce(): T
    fun consumer(item: T)
}

open class Fruit
open class Apple : Fruit()
class ApplePear : Apple()

class FruitProducer : Producer<Fruit> {
    override fun produce(): Fruit {
        println("Producer Fruit")
        return Fruit()
    }
}

class AppleProducer : Producer<Apple> {
    override fun produce(): Apple {
        println("Producer Apple")
        return Apple()
    }
}

class ApplePearProducer : Producer<ApplePear> {
    override fun produce(): ApplePear {
        println("Producer ApplePear")
        return ApplePear()
    }
}

fun main() {
    // 对于“out”泛型来说，我们可以将子类型对象赋给父类型引用
    val producer1: Producer<Fruit> = FruitProducer()
    val producer2: Producer<Apple> = AppleProducer()
    val producer3: Producer<ApplePear> = ApplePearProducer()

    println("----------")

    // 对于“in”泛型来说，我们可以将父类型对象赋给子类型引用
    val consumer1: Consumer<ApplePear> = Human()
    val consumer2: Consumer<ApplePear> = Man()
    val consumer3: Consumer<ApplePear> = Boy()
}

class Human: Consumer<Fruit> {
    override fun consumer(item: Fruit) {
        println("Consumer Fruit")
    }
}

class Man: Consumer<Apple> {
    override fun consumer(item: Apple) {
        println("Consumer Apple")
    }
}

class Boy: Consumer<ApplePear> {
    override fun consumer(item: ApplePear) {
        println("Consumer ApplePear")
    }
}
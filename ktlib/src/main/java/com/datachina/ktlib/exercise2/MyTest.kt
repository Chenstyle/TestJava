package com.datachina.ktlib.exercise2

import java.util.*

object MyTest {
    @JvmStatic
    fun main(args: Array<String>) {
//        List<String> list = new ArrayList<String>();
//        List<Object> list2 = list;
//        list2.add(3);
//        String str = list2.get(0);

//        List<Cat> cats = new ArrayList<>();
//        List<? extends Animal> animals = cats;

//        animals.add(new Cat()); // 不允许，协变可读不可写
        val animals: MutableList<Animal> = ArrayList()
        var contravariantAnimals: MutableList<in Animal> = animals
        val list: MutableList<Any> = ArrayList()
        contravariantAnimals = list
        contravariantAnimals.add(Cat())
        contravariantAnimals.add(Dog())

//        Animal animal = contravariantAnimals.get(0); // 不允许。逆变可写不可读
//        contravariantAnimals.get(0);

        // Java中的数组天然支持协变
//        val objs: Array<Any> = arrayOf<String>("hello", "world") // 不会存在问题
//        objs[0] = Any() // 运行会出现问题，所以数组的这种协变是存在缺陷的
    }
}

internal open class Animal
internal class Cat : Animal()
internal class Dog : Animal()
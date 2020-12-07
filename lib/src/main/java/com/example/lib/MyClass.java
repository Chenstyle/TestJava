package com.example.lib;

public class MyClass {
    public static void main(String[] args) {
        A doSome = new TestParam("Something");
        doSome.doA();
        doSome.doSomething();
        B doOne = new TestParam("SomeOne");
        doOne.doB();
        doOne.doSomething();
    }
}

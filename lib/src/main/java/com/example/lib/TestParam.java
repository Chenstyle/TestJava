package com.example.lib;

public class TestParam implements A, B {

    private String mName;

    public TestParam(String name) {
        mName = name;
    }

    public int nameLength() {
        return mName.length();
    }

    @Override
    public void doA() {
        System.out.println("Do A something");
    }

    @Override
    public void doB() {
        System.out.println("Do B something");
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }
}


interface A {
    void doA();
    void doSomething();
}

interface B {
    void doB();
    void doSomething();
}
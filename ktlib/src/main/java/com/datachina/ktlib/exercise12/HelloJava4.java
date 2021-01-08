package com.datachina.ktlib.exercise12;

import java.io.FileNotFoundException;

class HelloJava4 {
    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();

        try {
            myClass3.method();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("continue running");
    }
}

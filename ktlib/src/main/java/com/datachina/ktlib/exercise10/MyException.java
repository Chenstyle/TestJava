package com.datachina.ktlib.exercise10;

import java.io.IOException;

class MyException {

    public void myMethod() throws IOException {
        throw new IOException("I/O异常");
    }
}

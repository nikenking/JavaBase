package com.dell.Day24;


interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    public void px() {
        System.out.println(new B().x);
    }
}

public class Period {
    public static void main(String[] args) {
        new C().px();
    }
}

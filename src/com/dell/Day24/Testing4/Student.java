package com.dell.Day24.Testing4;

public abstract class Student {
    String name;
    int fee;

    public Student(String name) {
        this.name = name;
    }

    abstract int getFee();

    abstract void setFee(int fee);//学费
}

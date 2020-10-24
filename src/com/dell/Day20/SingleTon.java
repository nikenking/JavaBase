package com.dell.Day20;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    private double i;
    private SingleTon(){
        i = Math.random();
    }
    public static SingleTon getInstance(){
        return singleTon;
    }
}

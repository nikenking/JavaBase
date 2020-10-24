package com.dell.Day18;

public class Cat extends Animal {
    @Override
    public void move() {
        System.out.println("CatMove");
    }
    @Override
    public void roar() {
        System.out.println("CatRoar");
    }
}

package com.dell.Day18;

public class Dog extends Animal {
    public Dog(int age){
        super(age);
    }
    @Override
    public void move() {
        System.out.println("DogMove");
    }
    @Override
    public void roar() {
        System.out.println("DogRoar");
    }
}

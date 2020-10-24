package com.dell.Day18;

public class Animal {
    private int age;

    public Animal() {
        System.out.println("animal father constructure");
    }
    public Animal(int age){
        this.age = age;
    }

    public void move(){
        System.out.println("AnimalMovee");
    }
    public void roar(){
        System.out.println("AnimalRoar");
    }
}




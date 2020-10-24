package com.dell.Day18;

public class AnimalTest {
    public static void pet(Animal animal){
        animal.move();
        animal.roar();
    }
    public static void main(String[] args) {
        Animal dog = new Dog(5);
        pet(dog);
        pet(new Cat());
        pet(new Chiken());
    }
}

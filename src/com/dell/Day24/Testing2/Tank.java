package com.dell.Day24.Testing2;

public class Tank extends Weapon {
    @Override
    void attack() {
        System.out.println("Tank attack");
    }

    @Override
    void move() {
        System.out.println("Tank move");
    }
}

package com.dell.Day19;

public class Test {
    public static void main(String[] args) {
        Monster monster = new Monster(200);
        Warrior warrior = new Warrior(100);
        Minister minister = new Minister(80);
        monster.operate(warrior);
        minister.operate(monster);
        warrior.operate(monster);
        minister.operate(warrior);
    }
}

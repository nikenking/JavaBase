package com.dell.Day24.Testing2;

public class Entrance {
    public static void main(String[] args) {
        Weapon tank = new Tank();
        Weapon warship = new WarShip();
        Weapon flighter = new Flighter();
        Army army = new Army(2);
        army.addWeapon(tank);
        army.addWeapon(warship);
        army.addWeapon(flighter);
        army.attackAll();
        army.moveAll();
    }
}

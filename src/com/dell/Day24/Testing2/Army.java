package com.dell.Day24.Testing2;

public class Army {
    Weapon[] weapons;

    public Army(int max) {
        weapons = new Weapon[max];
    }

    public void addWeapon(Weapon weapon) {
        for (int i = 0; i < this.weapons.length; i++) {
            if (weapons[i] == null) {
                weapons[i] = weapon;
                break;
            }
        }
    }

    public void attackAll(){
        for (Weapon weapon : this.weapons) {
            weapon.attack();
        }
    }
    public void moveAll(){
        for (Weapon weapon : this.weapons) {
            weapon.move();
        }
    }
}

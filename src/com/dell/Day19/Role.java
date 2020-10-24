package com.dell.Day19;

public class Role {
    private int health;


    public Role(int health) {
        this.health = health;
    }

    public Role(){
    }

    public void operate(Role role){
        System.out.println(role.health);
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}

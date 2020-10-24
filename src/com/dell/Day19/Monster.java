package com.dell.Day19;

public class Monster extends Role {
    public Monster(int health) {
        super(health);
        operate();
    }

    public void operate() {
        System.out.println("九头蛇当前血量:"+this.getHealth());
    }

    public void operate(Warrior warrior) {
        System.out.println("九头蛇对战士造成攻击");
        warrior.setHealth(warrior.getHealth()-15);
        warrior.operate();
    }
    public void operate(Minister minister) {
        System.out.println("九头蛇对牧师造成攻击");
        minister.setHealth(minister.getHealth()-15);
        minister.operate();
    }

}

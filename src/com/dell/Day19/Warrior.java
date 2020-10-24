package com.dell.Day19;

public class Warrior extends Role {
    public Warrior(int health) {
        super(health);
        operate();
    }
    public void operate() {
        System.out.println("战士当前血量:"+this.getHealth());
    }
    public void operate(Monster monster) {
        System.out.println("战士("+this.getHealth()+")攻击了九头蛇");
        monster.setHealth(monster.getHealth()-10);
        monster.operate();
        Integer aait = 5;

    }
    public void operate(Minister minister) {
        minister.operate(this);
    }
}

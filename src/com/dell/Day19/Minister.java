package com.dell.Day19;

public class Minister extends Role {
    public Minister(int health) {
        super(health);
        operate();
    }
    public void operate() {
        System.out.println("牧师当前血量:"+this.getHealth());
    }
    public void operate(Monster monster) {
        System.out.println("牧师("+this.getHealth()+")闯进了九头蛇领地,收到攻击");
        monster.operate(this);
    }
    public void operate(Warrior warrior) {
        System.out.println("牧师使用回复术为战士加血");
        warrior.setHealth(warrior.getHealth()+10);
        warrior.operate();
    }
}

package com.dell.week4.model;

public class Enemy {
    // 昵称
   private String enemyName;

    // 提供经验
   private int exp;

    // 提供金钱
    private  int money;

    // 攻击力
   private int attack;

    // 防御力
    private int defense;

    // 血量
    private int hp;

    public Enemy(String enemyName, int exp, int money, int attack, int defense, int hp) {
        this.enemyName = enemyName;
        this.exp = exp;
        this.money = money;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

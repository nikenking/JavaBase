package com.dell.week4.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家
 */
public class Player {
    // 昵称
    private String playerName;

    // 职业
    private Profession profession;

    // 等级
    private int level;

    // 经验
    private float exp;

    //最大经验
    private float maxexp;

    // 金钱
    private int money;

    // 攻击力
    private int attack;

    // 防御力
    private  int defense;

    // 当前血量
    private int hp;

    // 血量上限
    private  int maxHp;

    // 法力
    private int mana;

    // 法力上限
    private int maxMana;

    // 掌握技能
    private List<Skill> skills  = new ArrayList<Skill>();;


    public Player(String playerName, int level, float exp, float maxexp, int money, int attack, int defense, int hp, int maxHp, int mana, int maxMana) {
        this.playerName = playerName;
        this.level = level;
        this.exp = exp;
        this.money = money;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.maxHp = maxHp;
        this.mana = mana;
        this.maxMana = maxMana;
        this.maxexp = maxexp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public float getMaxexp() {
        return maxexp;
    }

    public void setMaxexp(float maxexp) {
        this.maxexp = maxexp;
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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(Skill skill) {
        this.skills.add(skill);
    }

    @Override
    public String toString() {
        return  "大侠:" + playerName + '\'' +
                ", 职业:" + profession.getProfessionName() +
                ", 等级:" + level +
                ", 当前经验:" + exp +
                ", 身家:" + money +
                ", 攻击力:" + attack +
                ", 防御力:" + defense +
                ", 当前血量:" + hp +
                ", 最大血量:" + maxHp +
                ", 当前法力值:" + mana +
                ", 最大法力值:" + maxMana +
                ", 技能有:";
    }
}

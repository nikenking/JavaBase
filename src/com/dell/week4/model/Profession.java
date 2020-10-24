package com.dell.week4.model;

import java.util.List;

/**
 * 职业
 */
public class Profession {
    // 职业名
    private String professionName;

    // 攻击成长
    private int attackGrow;

    // 防御力成长
    private int defenseGrow;

    // 血量成长
    private int hpGrow;

    // 法力成长
    private int manaGrow;

    // 职业介绍

    private String professionIntroduce;

    // 职业可学技能
    private List<Skill> skills;

    public Profession(String professionName, int attackGrow, int defenseGrow, int hpGrow, int manaGrow, String professionIntroduce) {
        this.professionName = professionName;
        this.professionIntroduce = professionIntroduce;
        this.attackGrow = attackGrow;
        this.defenseGrow = defenseGrow;
        this.hpGrow = hpGrow;
        this.manaGrow = manaGrow;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public int getAttackGrow() {
        return attackGrow;
    }

    public void setAttackGrow(int attackGrow) {
        this.attackGrow = attackGrow;
    }

    public int getDefenseGrow() {
        return defenseGrow;
    }

    public void setDefenseGrow(int defenseGrow) {
        this.defenseGrow = defenseGrow;
    }

    public int getHpGrow() {
        return hpGrow;
    }

    public void setHpGrow(int hpGrow) {
        this.hpGrow = hpGrow;
    }

    public int getManaGrow() {
        return manaGrow;
    }

    public String getProfessionIntroduce() {
        return professionIntroduce;
    }

    public void setProfessionIntroduce(String professionIntroduce) {
        this.professionIntroduce = professionIntroduce;
    }

    public void setManaGrow(int manaGrow) {
        this.manaGrow = manaGrow;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}

package com.dell.week4.data;


import com.dell.week4.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillData {
    public static List<Skill> warlockSkills = new ArrayList<Skill>();
    public static List<Skill> swordmanSkills = new ArrayList<Skill>();
    public static List<Skill> MadWarriorSkill = new ArrayList<Skill>();
    public static List<Skill> ArcherSkill = new ArrayList<Skill>();

    static {

        // 技能：火球术
        Skill warlockSkill1 = new Skill();
        warlockSkill1.setSkillName("火球术");
        warlockSkill1.setSkillMoney(150);
        warlockSkill1.setAttackAddition(2);
        warlockSkill1.setMana(10);
        warlockSkill1.setSkillInstruction("借自然之力凝聚火球杀伤敌人，造成攻击力2倍的伤害");
        // 技能：烈火流星
        Skill warlockSkill2 = new Skill();
        warlockSkill2.setSkillName("烈火流星");
        warlockSkill2.setSkillMoney(300);
        warlockSkill2.setAttackAddition(15);
        warlockSkill2.setMana(80);
        warlockSkill2.setSkillInstruction("召唤大面积的流星雨对敌人造成毁灭性打击，造成攻击力15倍的伤害");
        // 放入集合
        warlockSkills.add(warlockSkill1);
        warlockSkills.add(warlockSkill2);

        // 技能：御剑术
        Skill swordmanSkill1 = new Skill();
        swordmanSkill1.setSkillName("御剑术");
        swordmanSkill1.setSkillMoney(150);
        swordmanSkill1.setAttackAddition(3);
        swordmanSkill1.setMana(10);
        swordmanSkill1.setSkillInstruction("入门级剑法，以意念御剑远程伤敌，造成3倍攻击力的伤害");
        // 技能：万剑诀
        Skill swordmanSkill2 = new Skill();
        swordmanSkill2.setSkillName("万剑诀");
        swordmanSkill2.setSkillMoney(300);
        swordmanSkill2.setAttackAddition(10);
        swordmanSkill2.setMana(50);
        swordmanSkill2.setSkillInstruction("进阶级剑法，凭空凝结出无数剑气，聚散交错斩杀敌人，造成10倍攻击力的伤害");
        // 放入集合
        swordmanSkills.add(swordmanSkill1);
        swordmanSkills.add(swordmanSkill2);
        // 技能：御剑术
        Skill MadWarriorSkill1 = new Skill();
        MadWarriorSkill1.setSkillName("撕裂斧");
        MadWarriorSkill1.setSkillMoney(150);
        MadWarriorSkill1.setAttackAddition(4);
        MadWarriorSkill1.setMana(20);
        MadWarriorSkill1.setSkillInstruction("初级狂暴技能，将法力注入双斧，增加攻击力");
        // 技能：万剑诀
        Skill MadWarriorSkill2 = new Skill();
        MadWarriorSkill2.setSkillName("鲜血狂暴");
        MadWarriorSkill2.setSkillMoney(300);
        MadWarriorSkill2.setAttackAddition(10);
        MadWarriorSkill2.setMana(70);
        MadWarriorSkill2.setSkillInstruction("进阶狂暴技能，狂暴化，大幅增加攻击力");
        // 放入集合
        MadWarriorSkill.add(MadWarriorSkill1);
        MadWarriorSkill.add(MadWarriorSkill2);
        // 技能：御剑术
        Skill ArcherSkill1 = new Skill();
        ArcherSkill1.setSkillName("连发箭");
        ArcherSkill1.setSkillMoney(150);
        ArcherSkill1.setAttackAddition(3);
        ArcherSkill1.setMana(10);
        ArcherSkill1.setSkillInstruction("连续发射三只箭矢，让敌人避无可避");
        // 技能：万剑诀
        Skill ArcherSkill2 = new Skill();
        ArcherSkill2.setSkillName("箭雨");
        ArcherSkill2.setSkillMoney(300);
        ArcherSkill2.setAttackAddition(10);
        ArcherSkill2.setMana(50);
        ArcherSkill2.setSkillInstruction("耗费法力提高身体能力，瞬间发射数十只箭矢，洞穿敌人");
        // 放入集合
        ArcherSkill.add(ArcherSkill1);
        ArcherSkill.add(ArcherSkill2);
    }

}

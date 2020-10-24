package com.dell.week4.data;


import com.dell.week4.model.Profession;

/**
 * 保存着游戏中的职业信息
 */
public class ProfessionData {
    // 存储职业信息的数组
    public static Profession professions[] = new Profession[4];

    static{

        // 第一种职业：剑客
        Profession Profession0 = new Profession("剑客",8,9,8,5,"剑客！勇敢者的选择，直面鲜血，于江湖中行侠仗义。");
        Profession0.setSkills(SkillData.swordmanSkills);
        professions[0] = Profession0;

        // 第二种职业：术士
        Profession Profession1 = new Profession("术士",9,5,7,9,"术士！聪明人的选择,锤炼你的能力，去一探魔法的深渊");
        Profession1.setSkills(SkillData.warlockSkills);
        professions[1] = Profession1;

        //第三种职业：狂战士
        Profession Profession2 = new Profession("狂战士",13,2,10,3,"狂战士！,为战而生，致死方休");
        Profession2.setSkills(SkillData.MadWarriorSkill);
        professions[2] = Profession2;

        //第四种职业：弓箭手
        Profession Profession3 = new Profession("弓箭手",6,10,6,8,"弓箭手！,丛林的猎手！你们都是猎物");
        Profession3.setSkills(SkillData.ArcherSkill);
        professions[3] = Profession3;

        //
    }
}

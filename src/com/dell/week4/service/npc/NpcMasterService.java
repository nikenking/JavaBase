package com.dell.week4.service.npc;


import com.dell.week4.data.NpcData;
import com.dell.week4.data.SkillData;
import com.dell.week4.model.Player;
import com.dell.week4.model.Skill;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.SlowPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含技能导师npc具有的方法
 */
public class NpcMasterService extends AbstractNpcService {
    /**
     * 构造方法，在实例化技能导师npc时生效
     */
    public NpcMasterService() {

        // 给从父类继承的npc对象进行赋值
        this.npc = NpcData.npcMaster;

    }


    @Override
    public void helpPlayer(Player player) {
        List<Skill> skills;
        switch (player.getProfession().getProfessionName()){
            case "剑客":
                skills = SkillData.swordmanSkills;
                break;
            case "术士":
                skills = SkillData.warlockSkills;
                break;
            case "狂战士":
                skills = SkillData.MadWarriorSkill;
                break;
            default:
                skills = SkillData.ArcherSkill;
                break;
        }
        SlowPrint.print(npc.getNpcName() + " : " + npc.getDialogue()+"(当前家当:"+player.getMoney()+")");//台词
        for (int i = 0; i < skills.size(); i++) {//技能书演示
            SlowPrint.print((i + 1) + "." + skills.get(i).getSkillName()+"("+skills.get(i).getSkillInstruction()+")/"+
                    skills.get(i).getSkillMoney()+"两");
        }
        int choice = InputCheck.IntCheckInput(skills.size());//技能书选择
        SlowPrint.print("有眼光!这本《" + skills.get(choice - 1).getSkillName() + "》就" +
                skills.get(choice - 1).getSkillMoney() + "块卖给你了，要吗？(Y/N)");//确认
        int pay = player.getMoney() - skills.get(choice - 1).getSkillMoney();//监测家当是否足够
        if ("y".equals(InputCheck.checkInput("y Y n N").toLowerCase())) {
            if (pay >= 0) {
                player.setMoney(pay);
                for (int i = 0; i < player.getSkills().size(); i++) {
                    if (player.getSkills().get(i)==skills.get(choice-1)){//判断技能是否已存在
                        player.getSkills().get(i).setMana(Math.max(player.getSkills().get(i).getMana()-5,0));
                        SlowPrint.print("你对" + player.getSkills().get(i).getSkillName() + "的熟练度增加了,法力消耗降低为" + player.getSkills().get(i).getMana());
                        SlowPrint.print("当前家当还有：" + player.getMoney() + "两");
                        return;
                    }
                }
                player.addSkills(skills.get(choice - 1));
                SlowPrint.print("你已习得" + skills.get(choice - 1).getSkillName() + ",当前家当还有：" + player.getMoney() + "两");
                SlowPrint.print(npc.getNpcName() + ":谢谢惠顾,再见");
            } else SlowPrint.print("你  买  不  起  ！！，穷鬼告辞~~");
        } else {
            SlowPrint.print("行吧，真可惜,希望下次再来。");
        }
    }
}


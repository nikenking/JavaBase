package com.dell.week4.service;


import com.dell.week4.model.Enemy;
import com.dell.week4.model.Player;
import com.dell.week4.model.Skill;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.ScannerUtil;
import com.dell.week4.util.SlowPrint;
import com.dell.week4.view.Play;

import java.util.List;


public class PlayerService {

    public static void fight(Player player, Enemy enemy) {
        int save = enemy.getHp();
        // 1.使用do-while循环，持续进行战斗，到有一方血量扣完为止
        do {
            playerAttack(player,enemy);//玩家攻击
            if (enemy.getHp()<=0)break;
            enemyAttack(player,enemy);//敌方攻击
        }while (enemy.getHp()>0&&player.getHp()>0);
        victory(player,enemy);
        enemy.setHp(save);//敌人刷新
    }

    private static void playerAttack(Player player,Enemy enemy) {
        // 输出可选行动
        SlowPrint.print("*******************************\n" +
                "当前回合，做出你的选择：");
        SlowPrint.print("1.普通攻击\n2.法术攻击");
        while (true){
            int choice = InputCheck.IntCheckInput("1 2");
            int damage = 0;
            if (choice==1){//普通攻击
                damage = player.getAttack()-enemy.getDefense();//计算攻击量
                enemy.setHp(enemy.getHp()-Math.min(damage,enemy.getHp()));//敌人扣血
                SlowPrint.print(enemy.getEnemyName()+"遭受"+damage+"点伤害，剩余血量"+enemy.getHp());
                break;
            }else {//法术攻击
                List<Skill> skills = player.getSkills();//得到角色所有技能
                if (skills.size()>0){//有技能
                    SlowPrint.print("你的技能有：");
                    for (int i = 0; i < skills.size(); i++) {//遍历显示技能
                        SlowPrint.print((i+1)+"."+skills.get(i).getSkillName()+"(耗费"+skills.get(i).getMana()+"点法力值)");
                    }
                    SlowPrint.print("请选择技能攻击:");
                    int skiilchoice = InputCheck.IntCheckInput(skills.size());//选择技能
                    int magice =player.getMana() - skills.get(skiilchoice-1).getMana();//消耗完之后的蓝量
                    if (magice>=0){//技能耗蓝可接受
                        player.setMana(magice);
                        damage = skills.get(skiilchoice-1).getAttackAddition()*player.getAttack()-enemy.getDefense();//计算攻击量
                        SlowPrint.print("*******************************\n"+
                                skills.get(skiilchoice - 1).getSkillInstruction());//技能特效打印
                        enemy.setHp(enemy.getHp()-Math.min(damage,enemy.getHp()));//敌人扣血
                        SlowPrint.print(enemy.getEnemyName()+"遭受"+damage+"点伤害，剩余血量"+enemy.getHp());
                        SlowPrint.print(player.getPlayerName()+"剩余"+player.getHp()+"点血量，"+player.getMana()+"点法力值");
                        break;
                    }else SlowPrint.print("你的法力值不够了，请重新选择:");
                }else SlowPrint.print("暂时还未学会任何技能,请重新选择");
            }
        }
    }

    private static void enemyAttack(Player player,Enemy enemy) {
        // 输出可选行动
        int damage = Math.max(enemy.getAttack()-player.getDefense(),0);//计算攻击量
        player.setHp(player.getHp()-Math.min(player.getHp(),damage));//我受到伤害
        SlowPrint.print(enemy.getEnemyName()+"发起攻击\n"+player.getPlayerName()+"受到"+damage+"点伤害,还剩"+player.getHp()+"点生命值");
    }

    public static Player initPlayer() {
        // 1.输出欢迎信息
        SlowPrint.print("*****************************************");
        SlowPrint.print("欢迎来到大型文字角色扮演游戏《伏魔录》");
        SlowPrint.print("请问大侠尊姓大名？：");
        // 2.输出角色名
        Player player = new Player(ScannerUtil.s.next(),1,0f,20f,500,20,10,100,100,80,80);
        player.setProfession(ProfessionService.choiceProfession());
        SlowPrint.print("初始化完成，望江湖之远~"+player.getPlayerName()+",请踏上旅途");
        SlowPrint.print("****************************************");
        return player;
    }

    private static void victory(Player player, Enemy enemy) {
        if (player.getHp()<=0){
            SlowPrint.print(player.getPlayerName()+"的江湖梦终结在了" + enemy.getEnemyName() + "的手里");
        }else {
            player.setMoney(player.getMoney()+enemy.getMoney());//战利品
            player.setExp(player.getExp()+enemy.getExp());//经验
            SlowPrint.print(player.getPlayerName()+"击败了" + enemy.getEnemyName()+
                    "获得了"+enemy.getMoney()+"枚铜钱，得到"+enemy.getExp()+"点经验,当前家当："+player.getMoney()+",当前经验："+player.getExp());
            levelUp(player);
        }
    }

    private static void levelUp(Player player) {
        while (player.getExp()>player.getMaxexp()){
            player.setLevel(player.getLevel()+1);
            player.setMaxexp(player.getMaxexp()*1.8f);
            player.setAttack((player.getAttack()*5)/4+player.getProfession().getAttackGrow());
            player.setDefense((player.getDefense()*5)/4+player.getProfession().getDefenseGrow());
            player.setMaxMana((player.getMaxMana()*5)/4+player.getProfession().getManaGrow());//最大法力提升
            player.setMaxHp((player.getMaxHp()*5)/4+player.getProfession().getHpGrow());
            player.setHp(player.getMaxHp());
            player.setMana(player.getMaxMana());
            SlowPrint.print(player.getPlayerName() + "升级了！,状态恢复，当前等级" + player.getLevel());
            showStatas(player);
        }
        System.out.printf("下次升级需要%.2f点经验",(player.getMaxexp()-player.getExp()));
    }

    private static void showStatas(Player player){
        StringBuilder skillname = new StringBuilder();
        for (Skill skill : player.getSkills()) {
            skillname.append(skill.getSkillName()).append(" ");
        }
        SlowPrint.print(player.toString()+skillname);
    }
}

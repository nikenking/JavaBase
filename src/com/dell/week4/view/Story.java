package com.dell.week4.view;


import com.dell.week4.model.Enemy;
import com.dell.week4.model.Place;
import com.dell.week4.model.Player;
import com.dell.week4.service.PlaceService;
import com.dell.week4.service.PlayerService;
import com.dell.week4.service.npc.NpcDoctorService;
import com.dell.week4.service.npc.NpcMasterService;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.SlowPrint;

/**
 * 故事
 */
public class Story {
    // 故事中的玩家
    Player player;

    // 故事中的场景
    Place place;
    /**
     * 开始游戏
     */
    public void start(){
        // 初始化角色
        player = PlayerService.initPlayer();
        menu();
    }
    /**
     * 提供游戏行动菜单供玩家选择
     */
    private void menu() {
        while (player.getHp()>0){
            SlowPrint.print("你现在打算做什么？：");
            SlowPrint.print("1.打怪\n2.疗伤\n3.学习技能\n4.退出游戏");
            switch (InputCheck.checkInput("1 2 3 4")){
                case "1":
                    Enemy enemy = PlaceService.choicePlace();
                    PlayerService.fight(player,enemy);
                    break;
                case "2":
                    new NpcDoctorService().helpPlayer(player);
                    break;
                case "3":
                    new NpcMasterService().helpPlayer(player);
                    break;
                default:
                    player.setHp(0);
            }
        }

    }
    /**
     * 打怪
     */
    private void hunt(){

        // 选择要去的场景


        // 选择要打的敌人


        // 玩家与敌人进行战斗


    }
    /**
     * 疗伤
     */
    private void healing() {

    }

    /**
     * 学习技能
     */
    private void learnSkill() {

    }

}

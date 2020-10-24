package com.dell.week3;

import java.util.Random;
import java.util.Scanner;

import static com.dell.week3.Constant.*;

public class MyGame {
    //系统输入
private Scanner scanner =new Scanner(System.in);
//当前玩家
private Player player;
//电脑玩家
private Computer computer;
//回合数
private int count=1;
//游戏初始化，对玩家及电脑进行初始化
    public void initGame(){
        player = new Player();
        computer = new Computer();
        player.setName(scanner.next());
        computer.setName(computer.getComputerName());
        player.setVictoryCount(0);
        computer.setVictoryCount(0);
    }

//开始游戏
    public void startGame(){
        System.out.printf("当前对战选手为：%s\n",computer.getName());
        for (int i = 0;; i++) {
            System.out.println("--------------------");
            System.out.printf("第%d回合开始\n",i+1);
            System.out.printf("请出拳:0.%s,1.%s,2.%s\n",rules[0],rules[1],rules[2]);
            player.setValue(player.getInputValue());
            computer.setValue(computer.getInputValue());
            player.show();
            computer.show();
            updateVictoryCount(compare(player.getValue(),computer.getValue()));
            System.out.printf("第%d回合结束\n",i+1);
            if (endGame()) {
                if (ifTryAgain()){
                    player.setVictoryCount(0);
                    computer.setVictoryCount(0);
                    i=-1;
                }else return;
            }
        }
    }

    //出拳规则比较
    public int compare(int playerValue,int computerValue){
        //当玩家与电脑出拳一致时，返回0，表示平局
        if(playerValue==computerValue){
            return 0;
        }
        //当玩家出拳为石头
        else if(playerValue== Constant.STONE){
            //电脑出拳为剪刀
            if(computerValue== Constant.SCISSORS){
                //返回1，表示玩家胜利

                return 1;
            }else {
                //否则返回-1，表示电脑出拳为布，玩家失败
                return -1;
            }

        }
        //当玩家出拳为剪刀
        else if(playerValue== Constant.SCISSORS){
            //电脑出拳为石头
            if(computerValue== Constant.STONE){
               //返回-1，，玩家失败
               return  -1;
            }else{
                //返回1，玩家胜利
                return 1;
            }

        }
        //当玩家出布
        else{
                //电脑出石头时
            if(computerValue== Constant.STONE){
                //返回1，玩家胜利
                return 1;
            }else {
                //返回-1，玩家失败
                return -1;
            }
        }
    }
    //根据出拳结果，修改玩家或电脑胜场数
    private void updateVictoryCount(int result){
        switch (result){
            case 0:
                break;
            case 1:
                player.setVictoryCount(player.getVictoryCount()+1);
                break;
            case -1:
                computer.setVictoryCount(computer.getVictoryCount()+1);
        }
        showResultInfo(result);
    }
    //根据出拳结果，打印输出最后的结果及比分
    private void showResultInfo(int result){
        switch (result){
            case 0:
                System.out.println("本局:平局");
                System.out.printf("当前比分为%s vs %s  %d vs %d\n",player.getName(),computer.getName(),
                        player.getVictoryCount(),computer.getVictoryCount());
                break;
            case 1:
                System.out.printf("本局:%s 胜利\n",player.getName());
                System.out.printf("当前比分为%s vs %s  %d vs %d\n",player.getName(),computer.getName(),
                        player.getVictoryCount(),computer.getVictoryCount());
                break;
            case -1:
                System.out.printf("本局:%s 胜利\n",computer.getName());
                System.out.printf("当前比分为%s vs %s  %d vs %d\n",player.getName(),computer.getName(),
                        player.getVictoryCount(),computer.getVictoryCount());
                break;
        }
    }
    //游戏结束
    public boolean endGame(){
        if (player.getVictoryCount()>=2){
            System.out.printf("%s赢得最终胜利！游戏结束\n",player.getName());
            return true;
        }else if(computer.getVictoryCount()>=2){
            System.out.printf("%s赢得最终胜利！游戏结束\n",computer.getName());
            return true;
        }else return false;
    }
    public boolean ifTryAgain(){
        System.out.printf("是否想和%s再来一局？想请输入Y，不想随意\n",computer.getName());
        if (scanner.next().equals("y")){
            return true;
        }else return false;
    }
}

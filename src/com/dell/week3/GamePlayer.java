package com.dell.week3;

/**
 * GamePlayer类用于提供玩家及电脑公用的方法
 */
public class GamePlayer {
    //姓名
    private String name;
    //出拳数字[0,2]，用于获取出拳规则数组中的出拳
    private int value;
    //胜利场数
    private int victoryCount;

//获取玩家输入的数字，通过数字获取出拳
    //此方法需子类重写
    public int getInputValue(){
        return 0;
    }
    //显示出拳信息
    public void show(){
        System.out.println(name+"出拳：\t"+ Constant.rules[value]);
    }
    //判定是否胜利
    public  boolean isVictory(){
        return victoryCount== Constant.MAX_VICTORY_COUNT;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getVictoryCount() {
        return victoryCount;
    }

    public void setVictoryCount(int victoryCount) {
        this.victoryCount = victoryCount;
    }
}

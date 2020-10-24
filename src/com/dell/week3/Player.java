package com.dell.week3;


import java.util.Scanner;

/**
 * 玩家类
 */
public class Player extends GamePlayer {
    private Scanner sc = new Scanner(System.in);
    //需重写父类方法
    @Override
    public int getInputValue() {
       return getNumber();
    }
    public int getNumber(){
        String container = "";
        while (true){
            container = sc.nextLine();
            if (container.equals("0")||container.equals("1")||container.equals("2")){
                break;
            }else System.out.print("输入有误，请重新输入\n");
        }
        return Integer.parseInt(container);
    }
}

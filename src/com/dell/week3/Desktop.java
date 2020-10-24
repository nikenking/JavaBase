package com.dell.week3;

import java.util.Scanner;

public class Desktop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("人机大战游戏开始");
        System.out.print("请输入玩家姓名:");
        MyGame console = new MyGame();
        console.initGame();
        console.startGame();
    }
}

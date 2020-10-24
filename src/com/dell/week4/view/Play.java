package com.dell.week4.view;

/**
 * 启动游戏的类，包含main方法
 */
public class Play {
    public static void main(String[] args) {
        // 实例化Story，开启一个新故事
        Story story = new Story();
        // 开始游戏
        story.start();
    }
}

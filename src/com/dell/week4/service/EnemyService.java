package com.dell.week4.service;


import com.dell.week4.model.Enemy;
import com.dell.week4.model.Place;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.SlowPrint;

public class EnemyService {
    public static Enemy choiceEnemy(Place place) {
        // 1.从传入的场景place中拿到场景中有的敌人
        // 2.显示全部场景中的敌人
        Enemy[] enemies = place.getEnemys();
        SlowPrint.print("发现以下敌人:");
        for (int i = 0; i < enemies.length; i++) {
            SlowPrint.print((i+1)+"."+enemies[i].getEnemyName()+"(掉落金钱："+enemies[i].getMoney()+",掉落经验："+enemies[i].getExp()+")");
        }
        SlowPrint.print("你选择偷偷的靠近谁？：");
        return enemies[InputCheck.IntCheckInput("1 2 3")-1];
    }
}

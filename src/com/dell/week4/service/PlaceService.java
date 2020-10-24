package com.dell.week4.service;


import com.dell.week4.data.PlaceData;
import com.dell.week4.model.Enemy;
import com.dell.week4.model.Place;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.SlowPrint;

import java.util.List;

/**
 * 跟场景相关的方法
 */
public class PlaceService {
    /**
     * 选择场景
     *
     * @return 返回玩家选中的场景
     */
    public static Enemy choicePlace() {
        SlowPrint.print("有这些场景可供您选择：");
        Place[] places = PlaceData.places;
        for (int i = 0; i < places.length; i++) {
            SlowPrint.print((i + 1) + "." + places[i].getPlaceName()+":"+places[i].getPlaceIntroduction());
        }
        SlowPrint.print("请做出选择：");
        return EnemyService.choiceEnemy(places[InputCheck.IntCheckInput(places.length) - 1]);
    }
}

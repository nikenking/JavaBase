package com.dell.week4.service;


import com.dell.week4.data.ProfessionData;
import com.dell.week4.model.Profession;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.SlowPrint;

public class ProfessionService {

    public static Profession choiceProfession() {

        SlowPrint.print("请输入你想选择的职业：");
        // 输出游戏数据ProfessionData中存在的职业信息
        for (int i = 0; i < ProfessionData.professions.length; i++) {
            // 让每个职业以“序号.职业名”的方式输出显示
            SlowPrint.print((i + 1) + "." + ProfessionData.professions[i].getProfessionName());
        }
        // 让玩家根据数字做出选择，输入有误可以重复选择
        int choice = InputCheck.IntCheckInput(ProfessionData.professions.length) - 1;

        System.out.println(ProfessionData.professions[choice].getProfessionIntroduce());

        return ProfessionData.professions[choice];
    }
}

package com.dell.SepDay16;

import javax.crypto.spec.PSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DayTest2 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1930,"乌拉圭");
        map.put(1934,"意大利");
        map.put(1938,"意大利");
//        String team = map.get(new Scanner(System.in).nextInt());
//        if (team!=null){
//            System.out.println("冠军队伍"+team);
//        }else System.out.println("该年未举办世界杯");
        String datas = new Scanner(System.in).nextLine();
        if (map.containsValue(datas)){
            System.out.println("获得冠军的年份有:");
            for (Integer value : map.keySet()) {
                if (map.get(value).equals(datas)) System.out.println(value+"年");
            }
        }else System.out.println(datas+"队未曾获得过冠军");
    }
}

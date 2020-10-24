package com.dell.DayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RobotJump {
    public static boolean ifReach(List<Integer> list,int e){
        int i=0;
        while (i<list.size()&&e>=0){
            if (e<list.get(i)){
                e-=Math.abs(e-list.get(i));
            }else e+=Math.abs(e-list.get(i));
            if (e>=0&&i==list.size()-1){
                return true;
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            System.out.printf("行数：");
            int e = new Scanner(System.in).nextInt();
            System.out.printf("输入每列高度：");
            List<Integer> stairs = new ArrayList<>();
            for (String i:new Scanner(System.in).nextLine().split(" ")){
                stairs.add(Integer.valueOf(i));
            }
            for (int i = 0; i < 100; i++) {
                if (ifReach(stairs,i)){
                    System.out.printf("当E=%d时可以抵达终点\n",i);
                    break;
                }
            }
        }

    }
}

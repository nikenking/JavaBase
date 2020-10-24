package com.dell.DayTest;

import java.util.HashMap;
import java.util.Map;

public class NoRepetCharacter {
    public static boolean findExit(String i,Map<Integer,String> map){
        Integer ky=0;
        for (String j:map.values()){
            if (j.equals(i)){
                map.remove(ky);
                return true;
            }ky++;
        }
        return false;
    }
    public static void finFirst(String str){
        Integer ky = 0;
        String[] s = str.split("");
        Map<Integer,String> mapList =  new HashMap<Integer,String>();
        for (String i:s){
            if (!findExit(i,mapList)) {
                mapList.put(ky, i);
                ky++;
            }
        }
        for (String i:mapList.values()){
            if (i!=null){
                System.out.printf("第一个不重复的值为%s\n",i);
                break;
            }
        }
    }
    public static void main(String[] args) {
        String s1 = "google";
        String s2 = "go";
        String s3 = "googto";
        finFirst(s1);
        finFirst(s2);
        finFirst(s3);
    }
}

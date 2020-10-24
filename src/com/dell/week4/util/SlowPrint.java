package com.dell.week4.util;

public class SlowPrint {
    public static void print(String s){
        for (int i = 0; i < s.length(); i++) {
            try{
            System.out.print(s.charAt(i));
            Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

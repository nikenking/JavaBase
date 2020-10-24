package com.dell.week4.util;

import java.util.List;

public class InputCheck {
    public static String checkInput(String spl){//条件格式："a b c" 返回这三个中的输入
        String[] req = spl.split(" ");
        while (true){
            String s = ScannerUtil.s.next();
            for (String s1 : req) {
                if (s.equals(s1))return s;
            }
            System.out.println("输入不符合要求请重新输入:");
        }
    }
    public static Integer IntCheckInput(String spl){//条件格式："a b c" 返回这三个中的输入的int类型
        String[] req = spl.split(" ");
        while (true){
            String s = ScannerUtil.s.next();
            for (String s1 : req) {
                if (s.equals(s1))return Integer.parseInt(s);
            }
            System.out.println("输入不符合要求请重新输入:");
        }
    }
    public static Integer IntCheckInput(int size){//条件格式 int a,返回从1开始到size的范围的一个选择
        String[] req = new String[size];
        for (int i = 0; i < size; i++) {
            req[i] = (i+1)+"";
        }
        while (true){
            String s = ScannerUtil.s.next();
            for (String s1 : req) {
                if (s.equals(s1))return Integer.parseInt(s);
            }
            System.out.println("输入不符合要求请重新输入:");
        }
    }
}

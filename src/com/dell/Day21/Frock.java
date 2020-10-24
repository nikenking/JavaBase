package com.dell.Day21;

public class Frock {
//    public static int currentNum = 100000;
//    int seriaNumber;
//    public static int getNextNum(){
//        currentNum+=100;
//        return currentNum;
//    }
//    public int getCurrentNum(){
//        return getNextNum();
//    }
    private String name = "zhangsan";
    static int serialNumber;
    public Frock(){
    }

    {
//        System.out.println(name);//代码块初始化
    }
    public int getSerialNumber() {
        return serialNumber;
    }
    public int getNextNum(){
        serialNumber+=1;
        System.out.println(getSerialNumber());
        return serialNumber;
    }
}

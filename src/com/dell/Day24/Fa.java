package com.dell.Day24;

public class Fa implements HumanityCapable {
    int x = 1;
    static private String name;
    {
        name = "Hello";
        System.out.println("父类代码块执行");
    }
    static {
        name = "static";
        System.out.println("父类静态代码块执行");
    }

    public static void setName(String name) {
        Fa.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void sing() {

    }
}

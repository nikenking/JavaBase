package com.dell.Day24;

public class So extends Fa implements HumanityCapable,ArtificialCapable {
    public int px(){
        return x;
    }
    {
        setName("son name");
        System.out.println("子类代码块执行");

    }
    static {
        setName("son static");
        System.out.println("子类静态代码块执行");
    }
    @Override
    public void sing() {

    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void move() {
        System.out.println("son move");
    }

    @Override
    public void living() {

    }


}

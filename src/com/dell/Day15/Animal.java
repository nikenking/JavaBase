package com.dell.Day15;

public class Animal {
    public String name;
    protected int age;
    boolean Living;
    public Tiger tiger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLiving() {
        return Living;
    }

    public void setLiving(boolean living) {
        Living = living;
    }

    public void sleep(){
        System.out.print(this.name+"在睡睡睡觉");
    }

    public void eat(){
        System.out.print(this.name+"在恰饭");
    }

}

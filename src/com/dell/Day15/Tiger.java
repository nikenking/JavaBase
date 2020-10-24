package com.dell.Day15;

public class Tiger extends Animal{
    private String sex;
    private boolean meating;

    public Tiger(String name){
        this.name = name;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.print(name+"打嗝");
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    public void sexing(){
        System.out.print("%sis Sexing");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger("aMing");
//        tiger.eat();
//        tiger.sleep();
    }

}

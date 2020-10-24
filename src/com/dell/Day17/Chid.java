package com.dell.Day17;

import java.security.PublicKey;

public class Chid extends Father{
    private String school;
    public Chid(){
    }
    public Chid(int age, String name, String work, String school) {
        super(age, name, work);
        this.school = school;
        System.out.println("子类有参构造器");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.print("school="+school);
    }

}

package com.dell.Day17;

public class Father {
    private int age;
    private String name;
    private String work;

    public Father() {
        System.out.println("父类无参构造器");
    }

    public Father(int age, String name, String work) {
        System.out.println("父类有参构造");
        this.age = age;
        this.name = name;
        this.work = work;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
    public void getInfo(){
        System.out.printf("name=%s,age=%d,work=%s\n",name,age,work);
    }
}

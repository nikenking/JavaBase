package com.dell.SepDay9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class User implements Comparable{
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o;
            System.out.printf("当前对象名:%s,比较对象名:%s\n",name,user.name);
            if (user.name.equals(name)){
                if (user.age==age){
                    return 0;
                }else return Integer.compare(user.age,age);
            }else return name.compareTo(user.name);

        }else throw new RuntimeException("比较类型出错");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TreeSetComparator {
    @Test
    public void test1(){
        String[] name = {"Astudent","Bstudent","Cstudent","Cstudent2","Dstudent"};
        Integer[] age = {15,13,15,11,15};
        TreeSet<User> tree = new TreeSet<>();
        HashMap<Integer,Integer> shi = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
           tree.add(new User(name[i],age[i]));//添加四个user对象
        }
        tree.forEach(System.out::println);
    }
}





















/*
*             //自然排序是调用新添加的对象的compareto方法，去依次比较每个元素
            //添加新对象时若hashcode和equals为ture时，set选择摒弃，map选择替换*/
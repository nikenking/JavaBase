package com.dell.SepDay7;

import com.dell.SepDay2.Interator;
import org.junit.Test;

import java.net.CookieHandler;
import java.util.*;

class Person{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public Person(String name) {
        this.name = name;
        this.age = (int) (Math.random() * 200);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        else {
            Person person = (Person) o;
            if (person.getAge()>120||person.getAge()<1){
                throw new RuntimeException("年龄异常");
            }else return true;
        }
    }
}
class Worker{
    private String name;
    private int age;
    private int bonuns;

    public Worker(String name, int age, int bonuns) {
        this.name = name;
        this.age = age;
        this.bonuns = bonuns;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bonuns=" + bonuns +
                '}';
    }

    public String getName() {
        return name;
    }
}

public class Testing1 {
    @Test
    public void test1(){
        Collection a1 = new ArrayList();
        Collection a2 = new ArrayList();
        Collection a3 = new ArrayList();
        a1.add(1);
        a1.add("show time");
        a1.add(new StringBuffer("some thing"));
        a2.add(new StringBuilder("some Thing"));
        a2.add(2);
        a3.add("3");
        a2.add(a3);
        a1.add(a2);
//        a2.clear();
//        System.out.println(a1.isEmpty());
//        a1.clear();
//        System.out.println(a1.isEmpty());
        System.out.println(a1.size());
        Iterator iterator = a1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Collection list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(new Person("XiaoLi"));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(new Person(""))){
                System.out.println("包含一个正常人对象，年龄为");
            }
        }
    }
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(new Worker("zhang3",18,3000));
        list.add(new Worker("li4",25,3500));
        list.add(new Worker("wang5",22,3200));
        list.add(1,new Worker("zhao6",24,3300));
        for (Object o : list) {
            System.out.println(o.toString());
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Worker worker = (Worker) iterator.next();
            System.out.println(worker.toString());
        }
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Worker worker = (Worker) iterator2.next();
            if (worker.getName().equals("wang5")){
                iterator2.remove();
            }
        }
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

}

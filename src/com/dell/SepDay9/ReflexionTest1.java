package com.dell.SepDay9;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;


public class ReflexionTest1 {

    @Test
    public void test1(/*静态创建反射对象》》穿透效果演示*/) throws Exception {
        Class clazz = Person.class;
        Constructor con = clazz.getConstructor(String.class,int.class);//向上抛未找到该构造器的错误
        Object obj = con.newInstance("tom",15);
        Person p = (Person) obj;
        Field age = clazz.getDeclaredField("age");//找动态类的属性
        age.setAccessible(true);//将私有化属性设置可修改
        age.set(p,10);//投入该类，设置值
        Method method = clazz.getDeclaredMethod("show");
        method.invoke(p);
    }
    @Test
    public void test2() throws Exception {
        Class obj = Class.forName("com.dell.SepDay9.Person");
        Field age = Person.class.getDeclaredField("age");
        age.setAccessible(true);
//        age.set(person,20);
//        System.out.println(age);
    }
    @Test
    public void test3(){
        ClassLoader classLoader = ReflexionTest1.class.getClassLoader();
        System.out.println(classLoader);
    }
    @Test
    public void test4(){
        Class clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
                Annotation[] annotations = method.getAnnotations();//该方法可能的注解
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //获取权限修饰符,将对应的数字转化成字符串
            System.out.println(Modifier.toString(method.getModifiers()) + "\t");
            //返回值类型
            System.out.println(method.getReturnType().getName()+"\t");
            //方法名
            System.out.println(method.getName()+"\t");
        }
    }

    @Test
    public void test5() throws Exception {
        Class clazz = Class.forName("com.dell.SepDay9.Person");
        Object person = (Person) clazz.newInstance();
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person,10);
        Method method  =  clazz.getDeclaredMethod("toString");
        String s = (String) method.invoke(person);
        System.out.println(s);
    }

}

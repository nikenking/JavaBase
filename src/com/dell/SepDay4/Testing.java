package com.dell.SepDay4;

import org.junit.Test;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;


interface ReflectColor{
    public void reflect();
}

enum Week {
    MONDAY("Monday","星期一学习"),
    TUESDAY("Tuesday","星期二还是学习"),
    WEDNESDAY("Wednesday","星期三还是学习"),
    THURSDAY("Thursday","星期四还是学习"),
    FRIDAY("Friday","星期五还是学习");

    public String dayName;
    public String dayPlan;

    Week(String dayName, String dayPlan) {
        this.dayName = dayName;
        this.dayPlan = dayPlan;
    }
    }
enum Color implements ReflectColor {
    RED(1,"红色"){
        @Override
        public void reflect() {
            System.out.println("鲜艳的红色");
        }
    },
    BLUE(2,"蓝色"){
        @Override
        public void reflect() {
            System.out.println("自由的蓝色");
        }
    },
    BLACK(3,"黑色"){
        @Override
        public void reflect() {
            System.out.println("深沉的黑色");
        }
    },
    YELLOW(4,"黄色"){
        @Override
        public void reflect() {
            System.out.println("青春的黄色");
        }
    },
    GREEN(5,"绿色"){
        @Override
        public void reflect() {
            System.out.println("自然的绿色");
        }
    };

    private  Integer serial;
    private String description;

    Color(Integer serial, String description) {
        this.serial = serial;
        this.description = description;
    }
}
@Target(METHOD)
@interface myAnnotation{
    String value();
    String value2() default "Im Value Two";
}

public class Testing {
    @Test
    public void test1() {
        StringBuffer s = new StringBuffer("hijavahehejavahejava");
        Integer count = 0;
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.substring(i, i + 4).equals("java")) {
                count++;
            }
        }
        System.out.println(count);

    }

    @Test
    @myAnnotation("ValueOne")
    public void test2() {
        StringBuffer s = new StringBuffer("ddejidsEFALDFfnef2357 3ed");
        StringBuffer atoZ = new StringBuffer();
        StringBuffer atoz = new StringBuffer();
        StringBuffer other = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') atoZ.append(s.charAt(i));
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') atoz.append(s.charAt(i));
            else other.append(s.charAt(i));
        }
        System.out.println(atoZ);
        System.out.println(atoz);
        System.out.println(other);
    }

    @Test
    public void test3(){
        for (Week value : Week.values()) {
            System.out.println(value+value.dayName+value.dayPlan);
        }
        for (Color value : Color.values()) {
            value.reflect();
        }
    }
}

package com.dell.SepDay1;

import org.junit.Test;

import java.util.Scanner;

interface showTime {
    public void show();
}

public class Enum {
    @Test
    public void test1(/*枚举类拿到数组*/) {
        for (Season value : Season.values()) {
            value.show();
        }
    }
    @Test
    public void test2(){

    }
}

enum Season/*枚举类1*/ implements showTime{
    SPRING("春天", "繁殖的季节"){
        @Override
        public void show() {
            System.out.println("一去上云天");
        }
    },
    SUMMER("夏天", "繁殖的季节"){
        @Override
        public void show() {
            System.out.println("遗落万海川");
        }
    },
    AUTUMN("秋天", "繁殖的季节"){
        @Override
        public void show() {
            System.out.println("一面掌高堂");
        }
    },
    WINTER("冬天", "繁殖的季节"){
        @Override
        public void show() {
            System.out.println("曲终池塘边");
        }
    };
    private final String name;
    private final String introduce;

    Season(String name, String introduce) {
        this.name = name;
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }

    public String getIntroduce() {
        return introduce;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}

package com.dell.SepDay2;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

class BigdicimalUtil{
    public static BigDecimal add(BigDecimal a1, BigDecimal a2){
        return a1.add(a2);
    }
    public static BigDecimal mul(BigDecimal a1, BigDecimal a2){
        return a1.multiply(a2);
    }
    public static BigDecimal sub(BigDecimal a1, BigDecimal a2){
        return a1.subtract(a2);
    }
    public static BigDecimal div(BigDecimal a1, BigDecimal a2,int ramain){
        return a1.divide(a2,ramain,BigDecimal.ROUND_HALF_UP);
    }
}

class Dish {
    public String name;
    public Integer price;

    public Dish(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class DateUtil {
    @Test
    public void test1(/*利用LocalDateTime和DateTimeFormatter的互相转化*/) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//格式化工具
        TemporalAccessor mylct = dtf.parse("1999-06-03 00:00:00");
        LocalDateTime mylct2 = LocalDateTime.parse("1999-06-03 00:00:00", dtf);
        LocalDateTime lct = LocalDateTime.now();
        System.out.println(mylct2);
    }

    @Test
    public void test2(/*LocalDateTime使用parse必须精确到秒*/) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse("1990-01-01 00:00:00", dtf);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(start, now);
        if (duration.toDays() % 5 < 3) {
            System.out.println("打鱼");
        } else System.out.println("晒网");
    }

    @Test
    public void test3(/*new Comparator*/) {
        Dish dish1 = new Dish("fish", 15);
        Dish dish2 = new Dish("chiken", 8);
        Dish dish3 = new Dish("cow", 20);
        Dish dish4 = new Dish("sheep", 15);
        Dish[] dishes = {dish1, dish2, dish3, dish4};
        Arrays.sort(dishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish, Dish t1) {
                if (dish.price != t1.price) {
                    return Integer.compare(dish.price, t1.price);
                } else return dish.name.compareTo(t1.name);
            }
        });
        for (Dish dish : dishes) {
            System.out.println(dish.toString());
        }
    }

    @Test
    public void test4() {
        Object[] o1 = {1, 2, "3"};
        Object[] o2 = {1, "2", 3};
        String token = new Scanner(System.in).next();
        for (int i = 0; i < o1.length; i++) {
            if (o1[i] instanceof Integer && o2[i] instanceof Integer) {
                switch (token) {
                    case "/":
                        System.out.println((Integer) o1[i] / (Integer) o2[i]);
                        break;
                    case "*":
                        System.out.println((Integer) o1[i] * (Integer) o2[i]);
                        break;
                    case "+":
                        System.out.println((Integer) o1[i] + (Integer) o2[i]);
                        break;
                    case "-":
                        System.out.println((Integer) o1[i] - (Integer) o2[i]);
                        break;
                }
            }else if(token.equals("+")){
                System.out.println(String.valueOf(o1[i])+String.valueOf(o2[i]));
            }else{
                throw new RuntimeException("字符串只能进行相加操作");
            }
        }
    }

    @Test
    public void test5(){
        Integer remain = 10;
        BigDecimal bd = new BigDecimal("1.35");
        BigDecimal bd2 = new BigDecimal("0.57");
        System.out.println(BigdicimalUtil.div(bd,bd2,9));
    }

}

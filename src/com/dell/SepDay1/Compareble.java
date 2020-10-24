package com.dell.SepDay1;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.math.BigDecimal.TEN;

class Good implements Comparable {
    private String name;
    private int price;

    public Good(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Good){
            Good good = (Good) o;
            if (good.price!=this.price){
                return Integer.compare(this.price,good.price);
            }else {
                return -this.name.compareTo(good.name);
            }
        }
        throw new RuntimeException("传入的数据类型有误");
    }
}


public class Compareble {
    @Test
    public void test1(/*让对象继承Comparable接口实现排序*/) {
        Good g1 = new Good("Xiaomi",799);
        Good g2 = new Good("HuaWei",1399);
        Good g3 = new Good("iPhone",3999);
        Good g4 = new Good("OnePlus",1999);
        Good g5 = new Good("TnePlus",1999);
        Good[] list = new Good[]{g1,g2,g3,g4,g5};
        Arrays.sort(list);
        for (Good good : list) {
            System.out.println(good.toString());
        }
    }
    @Test
    public void compare(/*通过重写Arras.sort里的Comparator<Object>方法实现动态排序*/){
        Good g1 = new Good("Xiaomi",799);
        Good g2 = new Good("HuaWei",1399);
        Good g3 = new Good("iPhone",3999);
        Good g4 = new Good("OnePlus",1999);
        Good g5 = new Good("TnePlus",1999);
        Good[] list = new Good[]{g1,g2,g3,g4,g5};
        Arrays.sort(list, new Comparator<Good>() {
            @Override
            public int compare(Good good, Good t1) {
                if (good.getPrice()==t1.getPrice()){
                    return -good.getName().compareTo(t1.getName());
                }else return -Integer.compare(good.getPrice(),t1.getPrice());
            }
        });
        for (Good good : list) {
            System.out.println(good.toString());
        }
    }
    @Test
    public void test2(/*System调用静态一些和系统有关的静态方法*/){
        String[] msg = {"os.version","java.version","os.name"
                ,"user.home","user.dir","user.name"};
        for (String s : msg) {
            System.out.println(System.getProperty(s));
        }
    }
    @Test
    public void test3(/*Math类，基本都是静态方法*/){
        String[] functions = {"Math.abs(),Math.sqrt(),Math.random()返回0-1的随机数,Math.pow()"};
    }
    @Test
    public void test4(/*BigIntegerh和BigDecimal*/){
        BigInteger bigInteger = new BigInteger("12346488948448489498489489");
        BigDecimal bigDecimal = new BigDecimal("146.1648998984998489498");
        BigDecimal bigDecimal2 = new BigDecimal("16.254");
        System.out.println(bigDecimal.divide(bigDecimal2,2));
    }

}


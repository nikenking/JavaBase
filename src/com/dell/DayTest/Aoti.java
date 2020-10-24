package com.dell.DayTest;

import javax.sound.midi.Soundbank;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Aoti {
    public static boolean ifobove(String judge){//利用字符串位数判断大小
        String[] max = "2147483648".split("");
        String[] cmp = judge.split("");
        if (judge.length()>11){//位数过大
            return false;
        }else if (judge.length()<10){//位数过小
            return true;
        }else {
            for (int i=0;i<=9;i++){//任意位数大于边界则超界
                if (Integer.parseInt(cmp[i])>Integer.parseInt(max[i])){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("请输入： ");
        String a = new Scanner(System.in).next();
        a = a.replace(" ","");//去空
        List<String> list = Arrays.asList(a.split(""));//得到第一个非空字符
        String b = Pattern.compile("[^0-9]").matcher(a).replaceAll("");//拿到所有的数字
        if ((list.get(0).equals("+")||list.get(0).equals("-"))&&b.length()>0){//第一个字符是+或-且数字长度大于0
            if (list.get(0).equals("+")&&ifobove(b)==false){
                System.out.println("+2147483648");
            }else if(list.get(0).equals("-")&&ifobove(b)==false){
                System.out.println("-2147483648");
            }else {
                System.out.println(list.get(0)+b);
            }
        }
        else if(Pattern.compile("[^0-9]").matcher(list.get(0)).replaceAll("").equals("")){//如果第一个非空为非数字
            System.out.println("0");
        }
        else{//普通情况使用BigInteger方法
            BigInteger c = new BigInteger(b);
            BigInteger d = new BigInteger("2147483648");
            String max = "";
            int i = c.compareTo(d);
            switch (i){
                case -1:
                    System.out.println(b);//<
                    break;
                case 0:
                    System.out.println(b);//=
                    break;
                case 1:
                    System.out.println("2147483648");//>
                    break;
            }
        }
    }
}
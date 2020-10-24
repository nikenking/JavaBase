package com.dell.Day27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class abstc{
    public abstract void printfly();
}

public class MaxChildString {
    public static void main(String[] args) {
        String a = "123";
        System.out.println(a.intern());
        abstc abstc = new abstc() {
            @Override
            public void printfly() {

            }//匿名内部类if i can show time
        };
        abstc.printfly();
    }

}
//1.给定一个字符串,判断该字符串中是否包含某个子串.如果包含,求出子串的所有出现位置.
//	“abceefedbcdiubc”,字串“bc”，出现的位置是1，8，13
//    public static boolean indexOf(int start,int end,String s,String targ){
//        return targ.equals(s.substring(start,end));
//    }
//    public static void main(String[] args) {
//        String a = "abceefedbcdiubc";
//        String b = "bc";
//        int len =  b.length();
//        for (int i = 0; i <= a.length()-len; i++) {
//            if (indexOf(i,len+i,a,b)) System.out.print(i+"\t");
//        }
//    }
//2.编写程序，将控制台输入的字符串全部转为大写
//    public static void main(String[] args) {
//        String s = new Scanner(System.in).nextLine();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)<=122&&s.charAt(i)>=97){
//                System.out.print((char) (s.charAt(i)-32));
//            }
//        }
//    }
//3.将字符串“test”变为“tset”
//    public static String indexReverse(int start,int end,String s){
//        String mid = s.substring(start,end+1);
//        char[] list = mid.toCharArray();
//        for (int i = 0; i < list.length/2; i++) {
//            char tem = list[i];
//            list[i] = list[list.length-i-1];
//            list[list.length-i-1] = tem;
//        }
//        return s.substring(0,start)+new String(list)+s.substring(end+1,s.length());
//    }
//    public static void main(String[] args) {
//        String a = "123456";
//        System.out.println(indexReverse(1, 4, a));
//    }
//4.将字符串“To be or not to be”每一个单词都逆序，结果为“oT eb ro ton ot eb ”（可以用StringBuffer类，可以自学）
//    public static void main(String[] args) {
//        String[] a = "To be or not to be".split(" ");
//        for (String s : a) {
//            StringBuffer temp = new StringBuffer(s);
//            temp.reverse();
//            System.out.print(temp+" ");
//        }
//    }
//5.输入一个字符串，判断该字符串是不是邮箱地址
//    public static void main(String[] args) {
//        String text = "157562176fdfsfsdfsfdsfsdfs11@163.com";
//        if (text.split("@")[0].length()<=13){
//            String regEx = "[\\w]{5,13}@[\\w]{3,5}.[\\w]{1,}";
//            Pattern pattern = Pattern.compile(regEx);
//            Matcher matcher = pattern.matcher(text);
//            while (matcher.find()){
//                System.out.println(matcher.group(0));
//            }
//        }else{
//            System.out.println("邮箱过长");
//        }
//    }
//6.统计一个字符串中出现的大写字母的次数
//    public static void main(String[] args) {
//        String s = "SdfFDFfdfFdFD";
//        int count=0;
//        for (char c : s.toCharArray()) {
//            if (c>=65&&c<=90)count++;
//        }
//        System.out.println(count);
//    }
////7.输入一串数字字符串，计算每个数字出现的次数
//    public static Integer toInteger(char s){
//        return Integer.parseInt(String.valueOf(s));
//    }
//    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap<>();
//        String s = "1548943184511348465";
//        for (int i = 0; i < s.length(); i++) {
//            if (map.get(toInteger(s.charAt(i)))!=null){
//                map.replace(toInteger(s.charAt(i)),map.get(toInteger(s.charAt(i)))+1);
//            }else map.put(toInteger(s.charAt(i)),1);
//        }
//        System.out.println(map);
//    }

////8.public static int countC(String s){
//    int count = 0;
//    for (char c : s.toCharArray()) {
//        if (String.valueOf(c).toLowerCase().equals("c"))count++;
//    }
//    return count;
//}
//    public static void toUpCase(String s){
//        String[] list = s.split(" ");
//        int i = 0;
//        for (String s1 : list) {
//            char[] tmp = s1.toCharArray();
//            if (tmp[0]>=97&&tmp[0]<=122){
//                tmp[0] = (char) (tmp[0]-32);
//                list[i] = new String(tmp);
//            }i++;
//        }
//        for (String s1 : list) {
//            System.out.print(s1+" ");
//        }
//    }
//    public static void reverse(String s){
//        StringBuffer buffer = new StringBuffer(s);
//        buffer.reverse();
//        System.out.println("StringBuffer:\n"+buffer);
//        char[] list = s.toCharArray();
//        for (int i = 0; i < list.length/2; i++) {
//            char tem = list[i];
//            list[i] = list[list.length-i-1];
//            list[list.length-i-1] = tem;
//        }
//        s = new String(list);
//        System.out.println("For 循环:\n"+s);
//    }
//    public static void toPrivate(String s){
//        String[] list = s.split("\\s");
//        for (String s1 : list) {
//            System.out.print("["+s1+"] ");
//        }
//    }
//    public static void main(String[] args) {
//        String know = "this is a test of java";
//        countC(know);
//        toUpCase(know);
//        reverse(know);
//        toPrivate(know);
//    }
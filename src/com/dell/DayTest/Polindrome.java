package com.dell.DayTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Polindrome {
    public static void findMaxLenth(List<String> list){
        String max="";
        for (String s : list) {
            if (s.length()>max.length())max = s;
        }
        System.out.println(max);
    }
    public static boolean ifPolinDrome(StringBuilder sbuffer, List<String> buffer){
        StringBuilder s = new StringBuilder(sbuffer.toString());
        String protoType = s.toString();
        String reverse = s.reverse().toString();
        if (s.length()>2&&reverse.equals(protoType)){
            buffer.add(sbuffer.toString());
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String a = new Scanner(System.in).nextLine();
        List<String> bufferList = new ArrayList<>();//存数组
        StringBuilder builder  =  new StringBuilder(a);//暴力遍历
        for (int i = 0; i < builder.length()-1; i++) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(builder.charAt(i));
            for (int i1 = i+1; i1 < builder.length(); i1++) {
                buffer.append(builder.charAt(i1));
                ifPolinDrome(buffer,bufferList);
            }
        }
        findMaxLenth(bufferList);
    }
}

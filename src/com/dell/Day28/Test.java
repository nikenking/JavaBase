package com.dell.Day28;

import java.util.ArrayList;
import java.util.List;

class Father{

}
public class Test extends Father{
    public static void change(char[] s,String a){
        s[0] = 'n';
        a = "aaa";
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1.contains(4));
//        char[] s = new String("show time").toCharArray();
//        String a = new String(s);
//        change(s,a);
//        System.out.println(a);
    }
}

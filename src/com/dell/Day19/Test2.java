package com.dell.Day19;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a==b);
        Arrays.sort(new int[]{1,2,3});
        System.out.println(a.equals(b));
    }
}

package com.dell.Day25;

import java.net.http.WebSocket;

class Base1 {
    public void add(int a, int... arr) {
        System.out.println("base1");
//        for (int i : arr) {
//            a+=i;
//        }
//        System.out.println("base a = "+a);
    }
}

class Sub1 extends Base1 {
    public void add(int a,int[] arr){
        System.out.println("hello");
//        for (int i : arr) {
//            a+=i;
//        }
//        System.out.println("sub a = "+a);
}
}

class Sub2 extends Base1 {

//    public void add(int a, int b, int c) {
//
//        System.out.println("Sub2");
//
//    }
}

public class What {
    public static void main(String[] args) {
        Base1 base = new Sub1();
        base.add(1,2,3);

    }
}
package com.dell.Day24;

public class InterfaceTest {
    public static void main(String[] args) {
        ComparebleCircle circle1 = new ComparebleCircle();
        ComparebleCircle circle2 = new ComparebleCircle();
        circle1.setRadius(5);
        circle2.setRadius(5);
        System.out.println(circle1.compareTo(circle2.getRadius()));
    }
}

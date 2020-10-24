package com.dell.Day17;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    @Override
    public void getArea() {
        System.out.printf("圆的面积为:%.2f\n",Math.pow(radius,2)*Math.PI);
    }
}

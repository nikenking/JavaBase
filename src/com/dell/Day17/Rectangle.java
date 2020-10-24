package com.dell.Day17;

public class Rectangle extends Shape{
    private int len;
    private int width;

    public Rectangle(int len, int width) {
        this.len = len;
        this.width = width;
    }

    public void getArea() {
        System.out.println("矩形的面积为:"+len*width);
    }

    @Override
    public long getlong() {
        return super.getlong();
    }
}

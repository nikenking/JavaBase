package com.dell.Day17;

public class Trapezoid extends Shape {
    private int top;
    private int bot;
    private int high;

    public Trapezoid(int top, int bot, int high) {
        this.top = top;
        this.bot = bot;
        this.high = high;
    }

    public void getArea() {
        System.out.println("梯形的面积为:"+(top+bot)*high*0.5);
    }
}

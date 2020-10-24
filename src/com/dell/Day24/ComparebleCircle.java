package com.dell.Day24;

public class ComparebleCircle extends Circle implements CompareObject {

    //    @Override
//    public int compareTo(ComparebleCircle circle) {
//        if (getRadius() > circle.getRadius()){
//            return 1;
//        }else return getRadius()==circle.getRadius()?0:-1;
//    }
    @Override
    public int compareTo(Object o) {
        if (getRadius() > (Float) o) {
            return 1;
        } else return getRadius() == (Float) o ? 0 : -1;
    }
}

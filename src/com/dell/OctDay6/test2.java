package com.dell.OctDay6;

class	A{
    static{
        System.out.print("1");
    }
    public A(){
        System.out.print("2");
    }
}
class B extends A{
    static{
        System.out.print("a");
    }
    public B(){
        System.out.print("b");
    }
}
public class test2{
    public static void main(String[] args){
        System.out.println(2<<3);
    }
}

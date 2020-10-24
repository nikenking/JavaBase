package com.dell.Day26;

public class EcmDef {
    public static void main(String[] args){//控制台输入参数
        try{
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(divide(a,b));
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException | MyNagativeException e ){//越界,格式转化,除0,为负
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static int divide(int a,int b) throws MyNagativeException {//可以替换成父类
        if (a<0||b<0){
            throw new MyNagativeException("输入不能为负数");//自定义异常
        }else return a/b;
    }
}

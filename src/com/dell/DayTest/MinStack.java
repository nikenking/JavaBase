package com.dell.DayTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinStack {
    public static void opers(List<String> operOrder,List<String> operParameter){
        Scanner sc = new Scanner(System.in);
        String orders = sc.next();
        String parameter = sc.next();
        Pattern pattern = Pattern.compile("\\w+");//寻找操作指令
        Pattern pattern2 = Pattern.compile("[\\-|\\d]+");//寻找操作参数
        Matcher matcher = pattern.matcher(orders);
        while (matcher.find()){
            operOrder.add(matcher.group(0));//得到操作指令
        }
        matcher = pattern2.matcher(parameter);
        while (matcher.find()){
            operParameter.add(matcher.group(0));//得到操作参数
        }
    }
    public static class Stack{
        private  String[] stack;
        private  int stackSize;
        private int flag = 0;

        public Stack(int stackSize) {
            this.stackSize = stackSize;
            this.stack = new String[this.stackSize];
        }
        public String setStack(int stackSize){
            this.stack = new String[stackSize];
            return "null";
        }
        public String push(String num){
            stack[flag] = num;
            flag++;
            return "null";
        }
        public String pop(){
            for (int i=this.stack.length-1;i>=0;i--){
                if (stack[i]!=null){
                    stack[i] = null;
                    flag--;
                    return "null";
                }
            }
            return "null";
        }
        public String top(){
            for (int i=this.stack.length-1;i>=0;i--){
                if (stack[i]!=null){
                    return stack[i];
                }
            }
            return "null";
        }
        public String getMin(){
            List<String> numList = new ArrayList<>();
            for (int j=0;j<=flag&&stack[j]!=null;j++){
                numList.add(stack[j]);
            }
            if (numList.size()!=0)return finMinList(numList);
            else System.out.println("栈不能为空");
            return "null";
        }
        public static String finMinList(List<String> list){
            int min = Integer.parseInt(list.get(0));
            for (String i:list){
                if (min>Integer.parseInt(i)){
                    min = Integer.parseInt(i);
                }
            }
            return min+"";
        }
    }
    public static void main(String[] args) {
        List<String> operOrder = new ArrayList<>();//操作指令、
        List<String> operParameter = new ArrayList<>();//操作指令、
        List<String> out = new ArrayList<>();//输出
        Stack stack = new Stack(0);
        opers(operOrder,operParameter);

        int j=0;
        for (int i=0;i<operOrder.size();i++){
            switch (operOrder.get(i)){
                case "MinStack":
                    out.add(stack.setStack(operOrder.size()));
                    break;
                case "push":
                    out.add(stack.push(operParameter.get(j)));j++;
                    break;
                case "getMin":
                    out.add(stack.getMin());
                    break;
                case "top":
                    out.add(stack.top());
                    break;
                case "pop":
                    out.add(stack.pop());
                    break;
            }
        }
        for (String i:out){
            System.out.print(i+"\t");
        }
    }
}

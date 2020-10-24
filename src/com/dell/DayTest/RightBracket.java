package com.dell.DayTest;

import java.util.*;

public class RightBracket {
    public static List<Integer> initial2(){
        List<String> str = Arrays.asList("5,3,1,2,4".split(","));
        List<Integer> str2 = new ArrayList<>();
        for (String s : str) {
            str2.add(Integer.parseInt(s));
        }return str2;
    }
    public static Integer push(List<Integer> list,int check){
        Integer result = null;
        for (int i = 0; i < list.size(); i++) {
            if (check==Collections.max(list)&& Collections.max(list).equals(list.get(i))){
                result = list.get(i);
                list.remove(i);//删除掉最大的
            }
        }return result;//如果传入进来的是最大的,删除最大的，返回最大的
    }
    public static void main(String[] args) {
        List<Integer> list = initial2();
        //看看原始栈
        System.out.print("原栈:");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

        System.out.println();
        List<Integer> instack = new ArrayList<>();//存入
        List<Integer> outstack = new ArrayList<>();//输出
        int len = list.size();
        for (int i=0;i < len;i++) {//挨个往instack里存
            if (list.get(0).equals(Collections.max(list))){
                outstack.add(list.get(0));
                list.remove(0);
            }else {
                instack.add(list.get(0));
                list.remove(0);
            }
        }
        System.out.print("排序后");
        for (Integer integer : outstack) {//输出的栈
            System.out.print(integer+" ");
        }
        for (int i = (instack.size()-1); i >= 0; i--) {//还未输出的栈
            System.out.print(instack.get(i)+" ");
        }
    }
}




















































//        Map<String,String> map = initial();
//        List<String> check = Arrays.asList("{<([<<>>])>}".split(""));
//        if (check.size()%2!=0){
//            System.out.println("false");
//            return;
//        }else {
//            for (int i = 0; i < check.size() / 2; i++) {
//                if (!map.get(check.get(i)).equals(check.get(check.size() - 1 - i))){
//                    System.out.println("false");
//                    return;
//                }
//            }
//            System.out.println("true");
//        }
//    public static Map<String,String> initial(){
//        String str = "[({<>})]";
//        String[] strings = str.split("");
//        List<String> list = new ArrayList<>();
//        for (String string : strings) {//初始化赋值
//            list.add(string);
//        }
//        Map<String,String> map = new HashMap<>();
//        for (int i = 0; i < list.size() / 2; i++) {
//            map.put(list.get(i),list.get(list.size()-1-i));
//        }
//        return map;
//    }
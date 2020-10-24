package com.dell.DayTest;

import java.util.*;

public class AllSortMay {
    public static boolean repeatCheck(int i,List<Integer> list){
        for (Integer integer : list) {
            if (i==integer)return false;
        }return true;
    }
    public static boolean strRepeatCheck(String s,List<String> list){
        for (String i:list) {
            if (i.equals(s))return true;
        }return false;
    }
    public static void shouList(List<Integer> list,String s,List<String> strings){
        StringBuilder tem = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            tem.append(String.valueOf(s.charAt(list.get(i))));
        }
        if (strRepeatCheck(tem.toString(),strings)){
        }else {
            strings.add(tem.toString());
            System.out.print("["+tem+"]\t");
        }
    }
    public static void getAllMay(String s,List<Integer> list,List<String> strings){
        int k = s.length();
        for (int i = 0; i < k; i++) {
            if (repeatCheck(i,list)){//不存在，再添加
                list.add(i);//添加
                if (list.size()==k){//若长度满了，则得到一份
                    shouList(list,s,strings);
                }else{
                    getAllMay(s,list,strings);
                }
                list.remove(list.size()-1);//不管满没满移除最后一个，上一层再换新的添加
            }
        }
    }
    public static void main(String[] args) {
//        Map<Character,Integer> map = new HashMap<>();
//        String s = "abds";
        String s = new Scanner(System.in).nextLine();
        List<Integer> list = new ArrayList<>();//缓存
        List<String> strings = new ArrayList<>();//重复监测
        getAllMay(s,list,strings);
    }
}

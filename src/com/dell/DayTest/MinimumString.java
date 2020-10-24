package com.dell.DayTest;

import java.util.ArrayList;
import java.util.List;

public class MinimumString {
    public static StringBuilder findIndex(StringBuffer scopy,StringBuffer reqcopy){
        StringBuffer req = new StringBuffer(reqcopy.toString());
        StringBuffer s = new StringBuffer(scopy.toString());
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int index = req.indexOf(String.valueOf(s.charAt(i)));//要删除的req坐标
            if (index!=-1||flag){
                flag = true;
                result.append(String.valueOf(s.charAt(i)));//添加到可用数组
            }
            if (flag&&index!=-1) {
                req.deleteCharAt(index);
                if (req.length()==0)return result;
            }
        }
        return  req.length()>0?null:result;
    }
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("ajjdfcfdjdadfc");
        StringBuffer req = new StringBuffer("acvd");
        String show = s.toString();//显示用
        List<StringBuilder> list = new ArrayList<>();//储存所有可能数组
        int len = s.length()-req.length()+1;
        for (int i = 0; i < len; i++) {//添加所有可能数组
            list.add(findIndex(s,req));
            s.deleteCharAt(0);
        }
        StringBuilder min = list.get(0);
        for (StringBuilder builder : list) {//找最小
            if (builder!=null&&builder.length()<min.length())min = builder;
        }
        if (min!=null){
            System.out.printf("目标字符串%s\t查找字符串%s\t结果字符串%s",show,req,min.toString());
        }else System.out.printf("目标字符串%s\t查找字符串%s\t结果为%s",show,req,min);
    }
}

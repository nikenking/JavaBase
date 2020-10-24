package com.dell.DayTest;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

public class CutRool {
//    public static void getMaxMultiefy(int len,int split){
//        Integer[] cut = new Integer[split];
//        for (int i = 0; i < split-1; i++) {
//            cut[i] = len/split;
//        }
//        if (len%split!=0)cut[split-1] =len%split;
//        else cut[split-1] = len/split;
//    }
//    public static void getMaxMultiefy(int len,int split){
//        Integer[] cutPice = new Integer[split];
//        Integer avg = len/split;//2
//        Integer remain = len - avg*(split-1);//2
//        if (avg<remain){
//            avg = len - remain*(split-1);
//            remain = len - avg*(split-1);
//        }
//        for (int i = 0; i < cutPice.length-1; i++) {
//            cutPice[i] = avg;
//        }
//        if (remain!=0){
//            cutPice[split-1] = remain;
//        }else cutPice[split-1] = avg;
//        for (Integer integer : cutPice) {
//            System.out.print(integer+" ");
//        }
//        System.out.println();
//    }
    public static void getMaxMultiefy(int len, int split, List<Integer> list){
        Integer[] cutPice = new Integer[split];
        Integer avg = 1;
        while ((len-avg*split)>0){
            avg++;
        }
        Integer remain = len - avg*(split-1);
        while (remain<=0){
            avg--;
            remain = len - avg*(split-1);
        }
        for (int i = 0; i < split-1; i++) {
            cutPice[i] = avg;
        }
        if(remain==1){
            cutPice[split-2] = cutPice[split-2]-1;
            cutPice[split-1] = 2;
            for (Integer integer : cutPice) {
                System.out.print(integer+" ");
            }
            System.out.println("--------->"+(int) Math.pow(avg,split-2)*cutPice[split-2]*cutPice[split-1]);
            list.add((int) Math.pow(avg,split-2)*remain*remain);
        }else {
            cutPice[split-1] = remain;
            for (Integer integer : cutPice) {
                System.out.print(integer+" ");
            }
            System.out.println("--------->"+(int) Math.pow(avg,split-1)*remain);
            list.add((int) Math.pow(avg,split-1)*remain);
        }

    }
    public static void main(String[] args) {
        int len = new Scanner(System.in).nextInt();/*长度要求最少为3。。。*/
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < len; i++) {//写注释好痛苦
            if (len/i>1){
                getMaxMultiefy(len,i,result);
            }
        }
        System.out.println("存在的最大乘积是"+ Collections.max(result));
    }
}

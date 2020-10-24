package com.dell.Day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Saving{
    private List<int[]> list = new ArrayList<>();
    public void add(int[] addList){
        if (cheackRepeat(addList)){list.add(addList);}
    }
    public boolean cheackRepeat(int[] addList){
        Arrays.sort(addList);
        for (int[] integers : list) {
            if (Arrays.compare(addList,integers)==0||ifrepeat(addList)){
                return false;
            }
        }
        return true;
    }
    public boolean ifrepeat(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = i+1; i1 < arr.length; i1++) {
                if (arr[i] == arr[i1])return true;
            }
        }
        return false;
    }
    public void show(){
        for (int[] ints : list) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
//    public int[] remove(int[] origin,int rem){
//
//    }
//    public int getSuitble(int[] origin){
//
//    }
}

public class TestFrock {
    public static void bianli(int[] arr,int k,int[] pass,Saving saving){
        if (k>0){
            k--;
            for (int i = 0; i < arr.length; i++) {
                pass[k] = arr[i];
                bianli(arr,k,pass,saving);
            }
        }else{
            for (int i = 0; i < arr.length; i++) {
                int[] sav = new int[pass.length+1];
                for (int i1 = pass.length-1; i1 >=0 ; i1--) {
                    sav[i1+1] = pass[i1];
                }
                sav[0] = arr[i];
                saving.add(sav);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6};
        Saving saving = new Saving();
        for (int i = 0; i < (a.length - 1); i++) {
            int[] pass = new int[i];
            bianli(a,i,pass,saving);
        }
        saving.show();
    }
}

class 动态分配未完成{

}
/*
1 3 5 6
1 3 5 6
1 3 5 6
 */
















/*    public static void newList(List<Integer> arr,List<Integer> addlist,int k){
        if (arr.size()==0){
            return;
        }else addlist.add(arr.get(0));
        arr.remove(0);//每次用栈顶做开头依次遍历后面的
        for (int i = 0; i < arr.size()-1; i++) {
            System.out.printf("%d,%d,%d\t",addlist.get(addlist.size()-1),arr.get(i),arr.get(i+1));
            if (addlist.size()>=k-1){
                System.out.printf("%d,%d,%d\t",addlist.get(addlist.size()-2),addlist.get(addlist.size()-1),arr.get(i+1));
            }
        }
        System.out.println();
        newList(arr,addlist,k);
    }*/
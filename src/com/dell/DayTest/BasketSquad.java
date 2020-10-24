package com.dell.DayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasketSquad {
    public static void add(List<int[]> list,int[] arr){
        for (int[] ints : list) {
            if (Arrays.compare(ints,arr)==0){
                return;
            }
        }
        System.out.println("添加成功");
    }
    public static List<Integer> newList(List<Integer> arr,int k){
        List<Integer> newarr = arr;
        newarr.remove(k);
        return newarr;
    }
    public static List<List<Integer>> findSubset(List<Integer> a,int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> svg = new ArrayList<>();
        for (int start = 0; start < a.size()-k+1; start++) {
            for (int end = start+1; end<a.size()&&end+k-2<a.size(); end++){//终点为起点+1到起点+k
                System.out.print(a.get(start));
                svg.add(a.get(start));
                for (int i = end; i <= end+k-2; i++) {
                    System.out.print(a.get(i));
                    svg.add(a.get(i));
//                    if (i<=end+k-2&&i<a.size()&&a.size()>=3){
//                        findSubset(newList(a,1),k);
//                    }

                }
                System.out.println();
            }res.add(svg);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5,4,9,8,7,2};
        List<Integer> arr = new ArrayList<>();
        for (int i : a) {
            arr.add(i);
        }
        List<Integer> squad1 = new ArrayList<>();
        List<Integer> squad2 = new ArrayList<>();
        //第i轮 每次抽 i个 进 1队  add(被抽，队1，队2，个数)
        List<List<Integer>> b = findSubset(arr,6);
    }
}

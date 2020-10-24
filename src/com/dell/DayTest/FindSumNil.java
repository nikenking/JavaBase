package com.dell.DayTest;

import java.util.*;


public class FindSumNil {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-4,-3,-2,-1,0,1,2,3,4};
        Map<String,Integer> res = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            int start = i-1;
            int end = arr.length - 1;
            while (end>=i){
                if (arr[start] + arr[i] + arr[end] == 0) {
                    res.put(arr[start] + " " + arr[i] + " " + arr[end] + "",0);
                }
                end--;
            }
            end = arr.length - 1;
            while (start<=i){
                if (arr[start] + arr[i] + arr[end] == 0) {
                    res.put(arr[start] + " " + arr[i] + " " + arr[end] + "",0);
                }
                start++;
            }
        }
        Set set = res.entrySet();
        for(Iterator iter = set.iterator(); iter.hasNext();){
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println((String)entry.getKey() );
        }

    }
}

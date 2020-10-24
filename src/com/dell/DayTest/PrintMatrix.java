package com.dell.DayTest;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {
    public static List<Integer> getMatrix(Integer[][] arr,List<Integer> list){
        int len = arr.length;
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < len; i1++) {
                if (arr[i][i1] != null) {
                    list.add(arr[i][i1]);
                }
                arr[i][i1] = null;//将i 层 所有列 剥离
            }
            for (int i1 = 0; i1 < len; i1++) {
                if (arr[i1][len - i - 1] != null) {
                    list.add(arr[i1][len - i - 1]);
                }
                arr[i1][len - i - 1] = null;//将所有层第len-i-1列剥离
            }
            for (int i1 = 0; i1 < len; i1++) {
                if (arr[len - i - 1][len-i1-1] != null) {
                    list.add(arr[len - i - 1][len-i1-1]);
                }
                arr[len - i - 1][len-i1-1] = null;//将第len-i-1层所有列剥离
            }
            for (int i1 = 0; i1 < len; i1++) {
                if (arr[len-i1-1][i] != null) {
                    list.add(arr[len-i1-1][i]);
                }
                arr[len-i1-1][i] = null;//将第所有层第i列剥离
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Integer[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> list = getMatrix(arr,new ArrayList<>());
        for (Integer integer : list) {
            System.out.print(integer+"  ");
        }
    }
}

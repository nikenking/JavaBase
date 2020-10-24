package com.dell.DayTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MiniMizeCircle {
    public static int findMin(String s){
        String[] sArr = s.split(" ");
        int[] arr = new int[sArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }
        int left = 0;
        int right = arr.length-1;
        int min = 0;
        while (left<right){
            min = (left+right)/2;
            if (arr[right]>=arr[min]){//确保右边的下标一直大于等于中间数
                right-=1;/*3 4 5 1 2*/
            }else left=min+1;//left往right移动//因为while符合条件循环下left的值一定大于右边的
        }return arr[left];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new Scanner(System.in).nextLine()));
//        System.out.println(findMin(new Scanner(System.in).nextLine()));
    }


}

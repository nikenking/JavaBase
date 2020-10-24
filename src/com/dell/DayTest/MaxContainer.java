package com.dell.DayTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxContainer {
    public static void main(String[] args) {
        String[] str = new Scanner(System.in).nextLine().split(" ");
        int arr[] = new int[str.length];
        for (int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        List<String> maxArea = new ArrayList<>();
        int max = 0;
        int area = 0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                area = Math.min(arr[i],arr[j])*(j-i);
//                System.out.printf("i=%d,j=%d,area = %d\n",i,j,area);
                if (max<area){
                    maxArea.add("最大能容纳的面积是："+(Math.max(max,area))+"。起始为第"+(i+1)+"根，终止为第"+(j+1)+"根");
                    max = area;
                }
            }
        }
        System.out.println(maxArea.get(maxArea.size()-1));
    }
}

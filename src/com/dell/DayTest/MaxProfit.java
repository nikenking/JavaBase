package com.dell.DayTest;

import java.util.Scanner;

public class MaxProfit {
    public static int[] getArr(){
        String[] s = new Scanner(System.in).nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
    public static int getMaxProfit(int[] arr,int start){
        int profit = 0;
        for (int i = start+1; i < arr.length; i++) {
            profit = Math.max((arr[i] - arr[start]), profit);
        }
        return profit;
    }
    public static void main(String[] args) {
        for (int j = 0; j < 2; j++) {
            int[] stock = getArr();
            int profit = 0;
            for (int i = 0; i < stock.length-1; i++) {
                profit = Math.max(getMaxProfit(stock,i),profit);
            }
            System.out.println(profit);
        }
    }
}

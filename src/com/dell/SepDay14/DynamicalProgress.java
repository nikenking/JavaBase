package com.dell.SepDay14;

import org.junit.Test;

import java.util.Scanner;

public class DynamicalProgress {
    @Test
    public void test1(/*第一次模仿*/) {
        int[] price = {7, 1, 5, 3, 4, 6};
        int len = price.length;
        /*
         * arr[i]第i天结束后的最大收益
         * arr[i][0]:手里有股票的最大收益
         * arr[i][1]:手上没有股票，并且处于冷冻期的最大收益
         * arr[i][2]:手上没有股票，并且不处于冷冻期的最大收益*/
        int[][] arr = new int[len][3];
        arr[0][0] = -price[0];//第一日买入
        for (int i = 1; i < len; i++) {
            arr[i][0] = Math.max(arr[i - 1][0], arr[i - 1][2] - price[i]);//今天有股票的最大收益==（昨天的有股票收益和昨天股票抛出,不处于冷冻期找最大值）
            arr[i][1] = arr[i - 1][0] + price[i];              //今天股票抛出,处于冷冻期的最大收益==（昨天的手上有股票加上今天的股票出售价格）
            arr[i][2] = Math.max(arr[i - 1][1], arr[i - 1][2]);//今天股票抛出，不处于冷冻期的最大收益==（昨天抛出且不处于冷冻期,昨天抛出且处于冷冻期）
        }
        /*
        * -7 and -7
        * 0
        * 0*/
        System.out.println(arr[len - 1][1]);
        System.out.println(arr[len - 1][2]);
    }

}
































/*
*     @Test
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"There was once a king's son who had a bride whom", "he loved very much.",
                "And when he was sitting beside her and very happy", "news came that his",
                "father lay sick unto death", "and desired to see him once again before",
                "his end Then he said to his beloved I must now go and leave you",
                "give you a ring as a remembrance of me.  When I am king, I will"};
        for (String s : arr) {
            System.out.println(s);
            String tmp = sc.nextLine();
            int plus = 0;
            int len = s.length();
            for (int i = 0; i < s.length(); i++) {
                if (tmp.charAt(i) == s.charAt(i)) {
                    plus++;
                }
            }
            System.out.printf("本句正确度:%.2f\n", ((float) plus / (float) len));
        }
    }*/


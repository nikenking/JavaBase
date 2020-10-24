package com.dell.DayTest;

import java.util.ArrayList;
import java.util.List;

public class StockBarging {
    public final static List<Integer> profit = new ArrayList<>();//最大利润
    public static List<Integer> getLarger(int a, int[] arr) {
        List<Integer> result = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[a] < arr[i]) result.add(i);
        }
        return result;
    }

    public static void largestProfit(int i, int[] stocks) {
        List<Integer> largerList = getLarger(i, stocks);//得到该坐标可出售坐标
        for (Integer integer : largerList) {

        }
    }

    public static void main(String[] args) {
        int[] stocks = new int[]{1, 5, 3, 6};
    }
}

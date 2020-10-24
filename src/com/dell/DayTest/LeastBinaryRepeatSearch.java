package com.dell.DayTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeastBinaryRepeatSearch {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            List list = initial();
            System.out.println(search((int) list.get(0),(int[]) list.get(1)));
        }
    }
    public static int search(int search,int[] arr){
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start<end){
            mid = (end+start)/2;
            if (arr[mid]<search){
                start = mid+1;
            }else if(arr[mid]>=search){
                end = mid;
            }
        }
        if (arr[end]!=search)return arr.length+1;
        else return end+1;
    }
    public static List initial(){
        String nothing = new Scanner(System.in).next();
        String[] list = new Scanner(System.in).nextLine().split(" ");
        int[] arr = new int[list.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(list[i]);
        }
        int choice = new Scanner(System.in).nextInt();
        List search = new ArrayList();
        search.add(choice);
        search.add(arr);
        return search;
    }
}

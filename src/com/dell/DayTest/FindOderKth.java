package com.dell.DayTest;

import java.util.*;

public class FindOderKth {
    public static void binerysort(int[] a)  {
        int i,j;
        int low,high,mid;
        int temp;
        for(i=1;i<a.length;i++){
            temp=a[i];
            low=0;
            high=i-1;
            while(low<=high){
                mid=(low+high)/2;
                if(a[mid]>temp)
                    high=mid-1;
                else
                    low=mid+1;

            }
            for(j=i-1;j>high;j--)
                a[j+1]=a[j];
            a[high+1]=temp;
        }
    }
    public static void mergeSort(int[] data, int left, int right) {
        if (left >= right)
            return;
        //两路归并
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        mergeSort(data, left, center);
        // 对右边数组进行递归
        mergeSort(data, center + 1, right);
        // 合并
        merge(data, left, center, center + 1, right);
    }
    public static void merge(int[] data, int leftStart, int leftEnd,
                             int rightStart, int rightEnd) {
        int i = leftStart;
        int j = rightStart;
        int k = 0;
        // 临时数组
        int[] temp = new int[rightEnd - leftStart + 1]; //创建一个临时的数组来存放临时排序的数组
        // 确认分割后的两段数组是否都取到了最后一个元素
        while (i <= leftEnd && j <= rightEnd) {
            // 从两个数组中取出最小的放入临时数组
            if (data[i] > data[j]) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (i <= leftEnd) {
            temp[k++] = data[i++];
        }
        while (j <= rightEnd) {
            temp[k++] = data[j++];
        }
        k = leftStart;
        // 将临时数组中的内容拷贝回原数组中 // （原left-right范围的内容被复制回原数组）
        for (int element : temp) {
            data[k++] = element;
        }
    }
    public static int[] turnOne(int[][] arr){
        int[] oneDemesional = new int[(int) Math.pow(arr.length,2)];
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length;j++){
                oneDemesional[i*arr.length+j] = arr[i][j];
            }
        }return oneDemesional;
    }
    public static void simple(int[][] arr,int k){
        System.out.print("暴力：");
        System.out.println(turnOne(arr)[k-1]);
    }
    public static void mergesort(int[][] arr,int k){
        int result[] = turnOne(arr);
        mergeSort(result,0,result.length-1);
        System.out.print("归并：");
        System.out.println(result[k-1]);
    }
    public static void binerySort(int[][] arr,int k){
        int result[] = turnOne(arr);
        binerysort(result);
        System.out.print("二分：");
        System.out.println(result[k-1]);
    }
    public static void main(String[] args) {
        int[][] arr = {{1,5,11},{10,11,13},{12,13,15}};
        System.out.print("输入要查找的序号");
        int k = new Scanner(System.in).nextInt();
        simple(arr,k);
        mergesort(arr,k);
        binerySort(arr,k);
    }
}
/*
function mergeSort(arr) {
    var len = arr.length;
    if (len < 2) {
        return arr;
    }
    var middle = Math.floor(len / 2),
        left = arr.slice(0, middle),
        right = arr.slice(middle);
    return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
    var result = [];

    while (left.length>0 && right.length>0) {
        if (left[0] <= right[0]) {
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }

    while (left.length)
        result.push(left.shift());

    while (right.length)
        result.push(right.shift());

    return result;
}
 */
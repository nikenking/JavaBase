package com.dell.DayTest;
import javax.swing.*;
import java.util.*;

public class Hello {
    public static void quicksort(int[] a,int low,int high){
        int left = low;
        int right= high;
        if (left>=right){//当数组只剩一位
            return;
        }
        int cmp=a[left];//找对比数
        int change;//交换最大和最小值
        while(left<right){
            while(a[right]>=cmp&&left<right){//当发现右边有小于对比数的下标就退出循环
                right--;
            }
            while (a[left]<=cmp&&left<right){//当发现左边有大于对比数的下标就退出循环
                left++;
            }
            if (left<right){//将右边小的和左边大的进行交换
                change = a[left];
                a[left] = a[right];
                a[right] = change;
            }
        }
        a[low] = a[left];
        a[left] = cmp;
        //递归调用左半数组
        quicksort(a, low, right);
        //递归调用右半数组
        quicksort(a, right+1, high);
    }
    public static void mpsort(int[] a){
        for (int i=0;i<a.length;i++){
            int max = a[0];
            int flag = 0;
            for (int j=0;j<a.length-i;j++){
                if (a[j]>=max){
                    max = a[j];
                    flag = j;
                }
            }
//            System.out.println("max is "+max+"flag is "+flag+"now a is:");
            a[flag] = a[a.length-i-1];
            a[a.length-i-1] = max;
        }
    }
    public static int getmid(int max,int min){
        if ((max+min)%2==1){
//            System.out.println("中位数是："+a[(a.length+1)/2-1]);
            return (max+min)/2;
        }else{
//            System.out.println("中位数是："+a[a.length/2-1]+"和"+a[a.length/2]);
            return (max+min)/2;
        }
    }
    public static void divsearch(int[] a,int min,int max,int num){
        int mid = (min+max)/2;
        if ((min+max)<1){
            return;
        }
        if(a[mid] == num){
            System.out.println("就是这个，mid= "+mid+" a[mid]= "+a[mid]);
        }
        else if (a[mid]>num){
            System.out.println("大了,mid= "+mid);
            divsearch(a,min,mid,num);
        }else{
            System.out.println("小了,mid= "+mid);
            divsearch(a,mid+1,max,num);
        }
    }
    public static void Twoladder(int[][] b){
        for (int i=0;i<b.length;i++){
            b[i] = new int[i+1];//开空间
            for (int j=0;j<=i;j++){//每个一维复制
                if(j==0||j==i) {
                    b[i][j]=1;

                }else {
                    b[i][j]=b[i-1][j-1]+b[i-1][j];
                }
            }
        }
    }
    public static void Zarg(String s,int num){

    }
    public static void Invert(List<String> c,int star,int end){//1,2,3,4
        String change;
        if ((star+end)%2==0){//奇数个
            for (int i=star;i<end/2;i++){
                change = c.get(i);
                c.set(i,c.get(end-i));
                c.set(end-i,change);
            }
        }else{
            for (int i=star;i<=(end)/2;i++){
                change = c.get(i);
                c.set(i,c.get(end-i));
                c.set(end-i,change);
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {5,6,7,8,9,10,11,12,13,14,15};
        int n = 3;
        String[] s = "LEETCODEISHIRING".split("");
        List<String> c = new ArrayList<>();
        List<String> out = new ArrayList<>();
        for (int i=0;i<s.length;i++){//将空白处填充空格存入新列表
            int round = 0;
            while (round<n&&i<s.length){
                c.add(s[i]);
                i++;round++;
            }
            c.add(" ");
            round = 0;
            while (round<n-2&&i<s.length){
                c.add(s[i]);
                i++;round++;
            }
            i--;//去掉未利用的下标
            c.add(" ");
        }
//        3 9 15
        for(int i=-n;i<c.size();i+=6){
            int round = i+2*n;//3 9 15 -3 3 9
            Invert(c,round,round+n-1);
        }
        //将新列表横向添加到结果列表
        for (int i=0;i<n;i++){//循环每一行
            for (int j=0;j<c.size()/n;j++){//循环每一列
                out.add(c.get(i+j*3));
            }
        }
        //输出结果
        for (String i:out){
            if (i!=" "){
                System.out.print(i);
            }
        }
    }
}


/*

        for (int i=0;i<s.length;i++){
            int round = 0;
            int index = i;
            while (round<n && i<s.length){
                b[i] = s[i];
                round++;i++;
            }
            b[round] = "*";
            round = 0;
            while (round<n-2 && i<s.length){
                b[i] = s[i];
                round++;i++;
            }
            System.out.print("a star");
            b[i] = "*";
        }
 */

/*
//        for (int i=0;i<s.length;i+=2*n-2){
//            for(int j=i;j<i+n;j++){
//                System.out.println("b[i+j]="+b[i+j]+"i="+i+"j="+j);
//                b[i+j] = s[i+j];
//            }
//            b[i+n] = " ";
//            for(int j=i+n+1;j<i+2*n-2;j++){
//                b[i+j] = s[i+j];
//            }
//            b[i+2*n-2] = " ";
//        }
 */

/*
//      for (int i=0;i<s.length/n;i+=2*n-2){
//            for (int j=0;j<n;j++){
//
//            }
//        }
 */

/*
杨氏三角
{
        for (int i=0;i<b.length;i++){
            b[i] = new int[i+1];//开空间
            for (int j=0;j<=i;j++){//每个一维复制
                if(j==0||j==i) {
                    b[i][j]=1;

                }else {
                    b[i][j]=b[i-1][j-1]+b[i-1][j];
                }
            }
        }
//        for (int[] i:b){
//            for (int j:i){
//                System.out.print(j);
//            }
//            System.out.println();
//        }
    }
 */

/*二分法迭代
        System.out.println("min= "+min+" max= "+max);
        if (a[(max+min)/2]>num){
            System.out.println("小于二分之一，划分点为"+(max+min)/2+"值为"+a[(min+max)/2]);
            divsearch(a,min,max/2,num);
        }else if(a[(max+min)/2]<num){
            System.out.println("大于二分之一，划分点为"+(max+min)/2+"值为"+a[(max+min)/2]);
            divsearch(a,max/2+1,max,num);
        }else{
            System.out.println("所在坐标为"+(max+min)/2+"值为："+a[(max+min)/2]);
            return;
        }
 */

/*中位数计算
        if (a.length%2==1){
            System.out.println("中位数是："+a[(a.length+1)/2-1]);
        }else{
            System.out.println("中位数是："+a[a.length/2-1]+"和"+a[a.length/2]);
        }

 */

/*有序插入
Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");//将匹配方式设置为只接受换行
        int[] a = {1,2,3,4,5,7,8,9,9};
        int[] b = new int[a.length+1];
        System.out.print("输入要插入的数字:");
        int num = scanner.nextInt();
        int index = a.length;
        for(int i=0;i<a.length;i++){
            if (num<a[i]){
                index = i;
                System.out.println("插入位置为："+index);
                break;
            }
        }
        for(int i=0;i<a.length;i++){
            if (index!=0&&index!=a.length-1&&index==i){
                System.out.print("找到了");
                b[i] = num;
                for (int j=i;j<a.length;j++){
                    b[j+1] = a[j];
                }
                break;
            }else if(index==0){
                b[0] = num;
                b[i+1] = a[i];
            }else if(index==a.length){
                b[a.length] = num;
                b[i] = a[i];
            }else{
                b[i] = a[i];
            }
        }
        for (int i:b){
            System.out.print(i);
        }
*/


/* 空格分割
String inp = scanner.next();
        String[] a = new String[inp.length()];//定义数组，长度为我输入的字符串
        a = inp.split("\\s+");
        List<String> list = Arrays.asList(a);*/


/*  随机数
//            Random rd = new Random();
//            String rds = (rd.nextInt(5))+"";
//            a[i] = rds;
 */

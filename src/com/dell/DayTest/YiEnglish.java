package com.dell.DayTest;
import java.util.Scanner;

public class YiEnglish {
    public static void show(double[]score){
        System.out.println();
        for (double i:score){
            System.out.println(i);
        }
    }
    public  static  double[] getarray(String str){
        String show[] = str.split(" ");
        double doublearr[] = new double[show.length];
        for (int i=0;i<show.length;i++){
            doublearr[i] = (double)Integer.parseInt(show[i]);
        }
        return  doublearr;
    }
    public static void quicksort(double[] a,int low,int high){
            int left = low;
            int right= high;
            if (left>=right){//当数组只剩一位
                return;
            }
            double cmp=a[left];//找对比数
            double change;//交换最大和最小值
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
    public static double findsubscripts(double n,double[] all){
        int pos = 0;
        while (n>all[pos]){
            pos++;
        }
        return ((double)pos/all.length)*100;
    }
    public static void main(String[] args) {
            Scanner scanner  =  new Scanner(System.in);
            scanner.useDelimiter("\\n");
            System.out.print("输入总人数:");
            int n = scanner.nextInt();
            double[] score = new double[n];
            System.out.printf("输入这%d个同学的成绩:",n);
        String scorebystr = scanner.next();
        score = getarray(scorebystr);
        double [] scoresorted = new double[score.length];
        for (int i=0;i<score.length;i++){
            scoresorted[i] = score[i];
        }
        System.out.print("询问次数为:");
        int q = scanner.nextInt();
        System.out.print("请输入查找序号:");
        String searching = scanner.next();
        double[] asking = getarray(searching);
        quicksort(scoresorted,0,scoresorted.length-1);//快排
        for (double i:asking){
            System.out.printf("第%f位同学的成绩是%f",i,score[(int)i-1]);
            System.out.printf(",超过的人数为%f\n",findsubscripts(score[(int)i-1],scoresorted));
        }
    }
}

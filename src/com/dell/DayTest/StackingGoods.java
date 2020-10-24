package com.dell.DayTest;

import javafx.geometry.HPos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//面向过程强调过程
//面向对象强调执行者
public class StackingGoods {
    public static List<int[]> getCoverpoints(int startx,int starty,int endx,int endy){//输入起始和终点，得到中间需要遍历的点
        List<int[]> points = new ArrayList<>();
        for (int i=startx+1;i<endx;i++){
            for (int j=starty+1;j<endy;j++){
                int[] pos = {i,j};
                points.add(pos);
            }
        }
        return  points;
    }
    public static boolean ifcovered(List<int[]> points,List<int[]> coverpoint){
        for (int[] i:points){
            for (int[]j:coverpoint){
                int[] jld = {j[0]-1,j[1]};
                int[] jlu = {j[0]-1,j[1]-1};
                int[] jru = {j[0],j[1]-1};
//                System.out.printf("jlu=%d,%d,jld=%d,%d,jru=%d,%d,i=%d,%d\n",jlu[0],jlu[1],jld[0],jld[1],jru[0],jru[1],i[0],i[1]);
                if (Arrays.equals(i,j)==true||Arrays.equals(i,jld)==true||Arrays.equals(i,jlu)==true||Arrays.equals(i,jru)==true){
//                    System.out.printf("点%d,%d的空间被点%d,%d占用\n",i[0],i[1],j[0],j[1]);
                    return false;
                }
            }
        }
        return  true;
    }
    public static int[] getIntArray(String str){
        String[] StrArray = str.split(" ");
        int[] backArray =new int[StrArray.length];
        for (int i=0;i<StrArray.length;i++){
            backArray[i] =Integer.parseInt(StrArray[i]);
        }
        return  backArray;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请问有几个广场需要判断？:");
        int[] groundnum = getIntArray(scanner.nextLine());
        List<String> answer = new ArrayList<>();
        for (int num=0;num<groundnum[0];num++){
            System.out.printf("请输入广场%d的大小及障碍物数量：",num+1);
            int[] array1 = getIntArray(scanner.nextLine());
            List<int[]> coverpoints = new ArrayList<>();//障碍物坐标数组列表
            int[] start = {0,0};//广场起点
            int[] end = {array1[0],array1[1]};//广场终点
            for (int i=0;i<array1[2];i++){
                System.out.printf("请输入第%d个障碍物的坐标:",i+1);
                int[] point = getIntArray(scanner.nextLine());
                coverpoints.add(point);
            }
            System.out.print("请输入箱子尺寸：");
            int[] boxsize = getIntArray(scanner.nextLine());
            //开始遍历是否存在箱子可以放下的坐标
            boolean flag = false;
            for (int i=0;i<=end[0]-boxsize[0];i++){
                for (int j=0;j<=end[1]-boxsize[1];j++){
                    List<int[]> points = getCoverpoints(i,j,i+boxsize[0],j+boxsize[1]);//起点为i,j,终点为加上箱子横纵尺寸
                    if (ifcovered(points,coverpoints)){
                        answer.add("当箱子的起点为"+i+","+j+"时,可以存放");
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
            if (flag == false){
                answer.add("该箱子无法存放");
            }
        }
        for (String i:answer){
            System.out.println(i);
        }
    }
}
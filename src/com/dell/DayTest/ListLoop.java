package com.dell.DayTest;

import com.dell.Day24.Circle;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CircleList{
    String value;
    CircleList next;
    CircleList root;

    public CircleList(String value) {
        this.value = value;
    }

    public void creatCircle(String[] datas){
        CircleList[] circleLists = new CircleList[datas.length];

        for (int i = 0; i < datas.length; i++) {
            circleLists[i] = new CircleList(datas[i]);
        }
        root = circleLists[0];
        for (int i = 0; i < circleLists.length-1; i++) {
            circleLists[i].next = circleLists[i+1];
        }
    }
}

public class ListLoop {
    public static void showAllPoins(CircleList head,CircleList node,int count){
        if (count>0){
            if (node.next!=null){
                System.out.print(node.value+"->");
            }else System.out.print(node.value);
            count--;
            showAllPoins(head,node.next,count);
        }else System.out.println("\n是否是一个环？："+(node==head.root));
    }
    public static void CircleReverse(CircleList node, List<String> list){
        if (node!=null){
            list.add(node.value);
            CircleReverse(node.next,list);
        }
    }
    public static CircleList getReverseCircleList(CircleList node){
        List<String> list = new ArrayList<>();
        CircleReverse(node,list);
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[list.size()-i-1] = list.get(i);
        }
        CircleList reverse = new CircleList(strings[0]);
        reverse.creatCircle(strings);
        return reverse;
    }
    public static void main(String[] args) {
        System.out.print("请输入一个链表:");
        String[] inputLis = new Scanner(System.in).nextLine().split(" ");
        CircleList root = new CircleList(inputLis[0]);
        root.creatCircle(inputLis);
        showAllPoins(root,root.root,inputLis.length);
        CircleList reverse = getReverseCircleList(root.root);
        System.out.println("翻转：");
        showAllPoins(reverse,reverse.root,inputLis.length);
    }
}

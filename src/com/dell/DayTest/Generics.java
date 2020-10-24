package com.dell.DayTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Generics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i:new Integer[]{1,2,3,1,3}){
            list.add(i);
        }
        list.set(3,4);
        list.set(4,5);
        for (Iterator<Integer> iterator=list.iterator();iterator.hasNext();){
            int i = iterator.next();
            System.out.print(i+" ");
        }
        System.out.println();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        linkedList.add(0,10);
        linkedList.add(3,30);
        for (Iterator<Integer> iterator=linkedList.iterator();iterator.hasNext();){
            int i = iterator.next();
            if (i<4){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        for (Iterator<Integer> iterator=linkedList.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

    }
}

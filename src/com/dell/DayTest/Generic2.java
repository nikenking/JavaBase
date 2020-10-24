package com.dell.DayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Generic2 {
        public static void main(String[] args) {
            ArrayList<Integer> arrayList = new ArrayList<>(5);
            arrayList.addAll(Arrays.asList(1, 2, 3, 1, 3));
            for (Iterator<Integer> iter = arrayList.iterator(); iter.hasNext();){
                System.out.print(iter.next()+"\t");
            }
            System.out.println();
            arrayList.set(3, 4);
            arrayList.set(4, 5);
            for (Iterator<Integer> iter = arrayList.iterator(); iter.hasNext();){
                System.out.print(iter.next()+"\t");
            }
            System.out.println();
            LinkedList<Integer> arr = new LinkedList<Integer>(arrayList.size());//泛型类容器arr，盛放arrayList
            arr.setArrayList(arrayList);
            arr.setValue(0, 10);
            arr.setValue(3, 30);
            arr.show(4);
            arr.show();

        }
    }

    class LinkedList<T extends Number> {//重写一个泛型的LinkedList
        ArrayList<T> arrayList;//泛型类ArrayList
        public void setArrayList(ArrayList<T> arrayList) {//泛型属性添加值
            this.arrayList = arrayList;
        }
        public LinkedList(int len){
            arrayList = new ArrayList<T>(len);//初始化
        }
        public void setValue(int index, T value){//ArrayList 插入
            arrayList.add(index, value);
        }
        public void show(){
            for(Iterator<T> iter = arrayList.iterator(); iter.hasNext(); ){
                System.out.print(iter.next());
                System.out.print("\t");
            }
            System.out.println();
        }
        public void show(T maxValue){
            for(Iterator<T> iter = arrayList.iterator(); iter.hasNext(); ){
                T temp = iter.next();
                if(temp.doubleValue() < maxValue.doubleValue()){
                    System.out.print(temp);
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

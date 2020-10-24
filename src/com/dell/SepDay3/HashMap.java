package com.dell.SepDay3;

import org.junit.Test;

import java.util.*;

public class HashMap {
    @Test
    public void test1(/*map无法直接遍历，用keySet.interator遍历*/){
        /*
        * HashMap 常用方法：
        * Map.put(key,value)
        * map.containsKey()
        * map.containsValue()
        * map.isEmpty()
        * map.equals(Onject obj)判断当前map是否为空
        * map.addAll(anotherMap)
        * */
    }
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("郑创");
        list.add("刘宇航");
        list.add("杨锐");
        list.add("张永涛");
        list.add("姚永晴");
        list.add("李元芳");
        /*
         * copy必须是一个长度大小比前者大或等的才能copy常用方法：*/
        List list1 = Arrays.asList(new Object[list.size()]);
        Collections.copy(list1,list);
        Collections.shuffle(list);//随机分布
        Collections.sort(list);//排序
        Collections.swap(list,1,2);//交换位置
        Collections.reverse(list);//翻转
        for (Object o : list1) {
            System.out.println(o);
        }
        Iterator<String> iterator = list.iterator();
        int i =0;
        while (iterator.hasNext()) {
            System.out.println((i+1)+"位置"+iterator.next());
            i+=1;
        }
    }
}

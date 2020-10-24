package com.dell.SepDay2;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Interator {
    @Test
    public void test1(){
        String[] arr = {"aa","bb","cc"};
        List<Integer> arr3 = Arrays.asList(1,2,3,4,5);
        int[] arr2 = {1,2,3,4,5,6};
        Iterator<Integer> interator = arr3.iterator();
//        for (Object o:arr){
//            System.out.println(o.getClass());
//        }
        Collection coll = new ArrayList(10);
        coll.add(1);
        Iterator interator1 = coll.iterator();
        while (interator1.hasNext()){
            System.out.println(interator1.next());
        }
    }
    @Test
    public void test2(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusDays(873);
        System.out.println(localDateTime1);
    }
}

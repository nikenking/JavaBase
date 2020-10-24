package com.dell.SepDay7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    @Test
    public void test1(/*通过<E> List<E>的方式让该方法类型变为泛型*/){
        Integer[] arr = {1,2,3,4,5,6};
        List<Integer> list = arrToList(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        list.forEach(System.out::print);

    }
    public <E> List<E> arrToList(E[] arr){
        List<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}

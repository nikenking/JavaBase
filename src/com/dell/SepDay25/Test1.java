package com.dell.SepDay25;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test1 {

    @Test
    public void test(/**/)throws IOException, InterruptedException{
        List<Map<String, List<String>>> list = Service.getMsg("show.txt");
        Map<String, List<String>> classRoom = list.get(0);
        Map<String, List<String>> teacher = list.get(1);
        Map<String, List<String>> student = list.get(2);
        for (Map.Entry<String, List<String>> set : classRoom.entrySet()) {
            System.out.println(set);
        }
        for (Map.Entry<String, List<String>> set : teacher.entrySet()) {
            System.out.println(set);
        }
        for (Map.Entry<String, List<String>> set : student.entrySet()) {
            System.out.println(set);
        }

    }
}
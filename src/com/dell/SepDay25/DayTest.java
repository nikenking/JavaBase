package com.dell.SepDay25;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class DayTest {
    @Test
    public void test1(/**/)throws IOException, InterruptedException{
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(i,i);
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            System.out.println(set);
        }
    }
    @Test
    public void test2(/**/)throws IOException, InterruptedException{
        File file = new File("D:\\OneDrive.mp4");//被复制
        File file2 = new File("D:\\OneDrive2.mp4");//复制
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file2));
        int len;
        byte[] chars = new byte[1024];
        while ((len = br.read(chars)) != -1) {
            bw.write(chars,0,len);
        }
        br.close();
        bw.close();
    }
    @Test
    public void test3(/**/)throws IOException, InterruptedException{
        File file = new File("D:\\ServerReading.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int len;
        Map<String,Integer> map = new HashMap<>();
        char[] chars = new char[1];
        while ((len = br.read(chars)) != -1) {
            if (!map.containsKey(String.valueOf(chars[0]))){
                map.put(String.valueOf(chars[0]),0);
            }else map.put(String.valueOf(chars[0]),map.get(String.valueOf(chars[0]))+1);
        }
        br.close();
        Integer times = new Scanner(System.in).nextInt();
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            if (set.getValue().equals(times)) System.out.println(set.getKey());
        }
    }
    @Test
    public void test4(/**/)throws IOException, InterruptedException{
        Map<String,Integer> map = new HashMap<>();
        String[] times = new Scanner(System.in).nextLine().split(" ");
        List<String> s = new ArrayList<>(Arrays.asList(times[0].split("")));
        for (String s1 : s) {
            if (map.containsKey(s1)){
                map.put(s1,map.get(s1)+1);
            }else map.put(s1,0);
        }
        System.out.println("time  = "+times[1]);
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            if (set.getValue().equals(Integer.parseInt(times[1]))) System.out.println(set.getKey());
        }
    }
    @Test
    public void test5(/**/)throws IOException, InterruptedException{
        File file = new File("D:\\numberwithout7.txt");
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        for (int i = 1; i < 100; i++) {
            if ((i+"").contains("7")){
                br.write("\n");
            }else br.write((i+" "));
        }
        br.close();
    }
    @Test
    public void test6(/**/)throws IOException, InterruptedException{
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3","4"));
        List<String> list2 = new ArrayList<>(Arrays.asList("1","2","5","4"));
        for (String s : list2) {
            if (list.contains(s)){
                System.out.println(s);
            }
        }
    }
}

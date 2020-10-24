package com.dell.SepDay16;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Student{
    private String name;
    private int age;
    private float score;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getScore() {
        return score;
    }

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class DayTest {
    @Test
    public void test() {
        Integer[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > 0) {
                System.out.printf("当前数字为%d，前一位是%d,和他相加有利润,当前值变为:%d\n", arr[i], arr[i - 1], arr[i] + arr[i - 1]);
                arr[i] += arr[i - 1];
            } else System.out.printf("当前数字为%d，前一位是%d,和他相加无利润,当前值不变\n", arr[i], arr[i - 1]);
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
    }

    @Test
    public void test2() {
        Integer[] arr = {6, 3, 2, 7, 15, 1, 11, 2, 2};
        for (int i = 0; i < arr.length; i++) {
            Integer[] tmp = arr;
            int max = tmp[0];
            for (int i1 = i; i1 < arr.length; i1++) {

            }
        }
    }

    @Test
    public void test3() throws IOException {
        File file1 = new File("D:\\temp");
        File file2 = new File("D:\\temp2");
        File file3 = new File("D:\\temp3");
        if (!file1.exists() && !file2.exists() && !file3.exists()) {
            file1.mkdir();
            file2.mkdir();
            file3.mkdir();
        }
        File file1_child = new File(file1.getAbsolutePath() + "\\" + "1.txt");
        File file1_child2 = new File(file1.getAbsolutePath() + "\\" + "Hello.java");
        File file2_child = new File(file2.getAbsolutePath() + "\\" + "1.txt");
        File file2_child2 = new File(file2.getAbsolutePath() + "\\" + "Hello.java");
        File file2_child3 = new File(file2.getAbsolutePath() + "\\" + "2.txt");
//        FileWriter fw = new FileWriter(file1_child);
//        FileWriter fw2 = new FileWriter(file2_child);
//        fw.write("hello");
//        fw.close();
//        fw = new FileWriter(file1_child2);
//        fw.write("public static void main(String[] args){}");
//        fw.close();
//        fw2.write("hello");
//        fw2.close();
//        fw2 = new FileWriter(file2_child2);
//        fw2.write("public static void main(String[] args){}");
//        fw2.close();
//        File[] files = file1.listFiles();
//        for (File file : files) {
//            if (file.isFile()){
//                String[] tmp = file.toString().split("\\\\");
//                if (tmp[tmp.length-1].split("\\.")[1].equals("java")){
//                    System.out.println(file.toString());
//                }
//            }
//        }
//        FileReader fr = new FileReader(file1_child);
//        FileWriter fw3 = new FileWriter(file2_child3);
//        int len=0;
//        char[] buf = new char[10];
//        while ((len = fr.read(buf)) != -1) {
//            fw3.write(buf,0,len);
//        }
//        fr.close();
//        fw3.close();

    }

    @Test
    public void test4(){
        Comparator cmp = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                Student s1 = (Student) o;
                Student s2 = (Student) t1;
                if (s1.getScore()!=s2.getScore()){
                    return -Float.compare(s1.getScore(),s2.getScore());
                }else return Integer.compare(s1.getAge(),s2.getAge());
            }
        };
        TreeSet set = new TreeSet(cmp);
        set.add(new Student("liusan",20,90.0F));
        set.add(new Student("lisi",20,90.0F));
        set.add(new Student("wangwu",22,99.0F));
        set.add(new Student("zhaoliu",21,100.0F));
        set.add(new Student("zhengqi",25,99.0F));
        for (Object s : set) {
            System.out.println(s);
        }
    }

    @Test
    public void test5(/*夺冠队伍*/){

    }
}


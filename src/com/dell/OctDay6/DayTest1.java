package com.dell.OctDay6;

import com.dell.Day18.Dog;
import org.junit.Test;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.*;
import java.util.regex.Pattern;

import static com.dell.SepDay22.HowToSort.traverFolder;

class User {
    private String name;
    private Integer weight;

    public User(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

class Student {
    private String name;
    private Integer id;
    private Integer[] score;
    private int avg;

    public Student(String name, Integer id, Integer[] score) {
        this.name = name;
        this.id = id;
        this.score = score;
        avg = 0;
        for (Integer integer : score) {
            this.avg += integer;
        }
        avg = (int) (avg / score.length);

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + Arrays.toString(score) +
                ", avg=" + avg;
    }
}

public class DayTest1 {
    public static void traverFolder(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    traverFolder(file1);
                } else if (Pattern.matches(".*\\.java", file1.toString())) {
                    System.out.println(file1);
                }
            }
        }
    }

    @Test
    public void test1(/**/) throws IOException, InterruptedException {//平均成绩计算
        List<String> list = Arrays.asList("小张", "小刘", "小郑", "小王", "小李");
        Integer initialID = 1001;
        Integer[][] score = new Integer[list.size()][3];
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                Integer rand = ((int) (Math.random() * 50) + 50);
                score[i][i1] = rand;
            }
            students.add(new Student(list.get(i), initialID++, score[i]));
        }
        BufferedWriter br = new BufferedWriter(new FileWriter(new File("d:\\stud.txt")));
        for (Student student : students) {
            br.write(student.toString() + "\n");
        }
        br.close();
    }

    @Test
    public void test2(/**/) throws IOException, InterruptedException {
        traverFolder(new File("D:\\project\\untitled"));
    }

    @Test
    public void test3(/**/) throws IOException, InterruptedException {
        File file = new File("D:\\pic.jpg");
        File file1 = new File("E:\\pic.jpg");
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file1));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = br.read(bytes)) != -1) {
            bw.write(bytes, 0, len);
        }
        br.close();
        bw.close();
    }

    @Test
    public void test(/**/) throws IOException, InterruptedException {
        File file = new File("work3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int len;
        char[] chars = new char[1024];
        StringBuilder buffer = new StringBuilder("");
        while ((len = br.read(chars)) != -1) {
            buffer.append(chars, 0, len);
        }
        br.close();
        int count = 0;
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == 'a' || buffer.charAt(i) == 'A') {
                System.out.println(++count);
            }
        }
    }

    @Test
    public void test5(/**/) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8002);
        InetAddress inetAddress = serverSocket.getInetAddress();
        System.out.println(inetAddress);
        System.out.println(inetAddress.getClass());
    }

    @Test
    public void test6(/**/) throws IOException, InterruptedException {
        List<User> list = new ArrayList<User>();
        list.add(new User("a", 1));
        list.add(new User("b", 9));
        list.add(new User("c", 1));
        list.add(new User("d", 1));
        list.add(new User("e", 1));
        int count = 0;
        for (User user : list) {
            count += user.getWeight();
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int choice = (int) (Math.random() * count)+1;
            for (User user : list) {
                choice-=user.getWeight();
                if (choice<=0){
                    if (map.get(user.getName())!=null){
                        map.put(user.getName(),map.get(user.getName())+1);
                    }else map.put(user.getName(),1);
                    break;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }


    @Test
    public void test7(/**/)throws IOException, InterruptedException{
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; list.size()<10; i++) {
            int choice = (int) (Math.random() * 10) + 1;
            if (!list.contains(choice)){
                list.add(choice);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
//        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
//            System.out.println(en.getKey());
//        }
    }
}

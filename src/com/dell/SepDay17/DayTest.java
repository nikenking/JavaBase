package com.dell.SepDay17;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class DayTest {
    public static void showChild(File file, List<String> list) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        list.add(file1.toString());//子文件夹
                        showChild(file1, list);
                    } else list.add(file1.toString() + "\t" + file1.length() / 1024 / 1024 + "mb");//子文件
                }
            }
        } else list.add(file.toString());//本身是文件？本身是文件怎么可能传进来
    }

    @Test
    public void test(/*D盘所有文件,注意空文件*/) throws IOException {
        File file = new File("D:\\");
        List<String> list = new ArrayList<>();
        showChild(file, list);
        File file1 = new File("D:\\allFiles.txt");
        FileWriter fr = new FileWriter(file1);
        for (String s : list) {
            fr.write(s + "\n");
        }
        fr.close();
    }

    @Test
    public void test5() throws IOException {
        Scanner sc = new Scanner(System.in);
//        String s = "姓名:郑创,年龄:21,班级:软工17203";
        String s = sc.nextLine();
        File file = new File("D:\\Mydata.txt");
        FileWriter fw = new FileWriter(file);
        for (String s1 : s.split(",")) {
            String s2 = s1.split(":")[1];
            fw.write(s2 + " ");
        }
        fw.write("\n");
        fw.close();
        FileReader fr = new FileReader(file);
        int len;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        fr.close();
        boolean delete = file.delete();
    }

    @Test
    public void test2(/*读取输入文本*/) throws IOException {
        String[] str = new Scanner(System.in).nextLine().split(" ");
        FileWriter fw = new FileWriter(new File("D:\\inputFile.txt"));
        for (String s : str) {
            fw.write(s + " ");
        }
        fw.close();
        FileReader fr = new FileReader(new File("D:\\inputFile.txt"));
        int len = 0;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            String[] s = new String(chars).split(" ");
            for (String s1 : s) {
                System.out.println("one block:" + s1);
            }
        }
        fr.close();
    }

    @Test
    public void test3(/*复制mp3*/) throws Exception {
        File file1 = new File("D:\\歌曲.mp3");
        File file2 = new File("E:\\歌曲.mp3");
        if (!file1.exists()) {
            boolean newFile = file1.createNewFile();
            if (newFile) {
                FileInputStream fi = new FileInputStream(file1);
                FileOutputStream fo = new FileOutputStream(file2);
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = fi.read(bytes)) != -1) {
                    fo.write(bytes, 0, len);
                }
                fi.close();
                fo.close();
            }
        }
    }

    @Test
    public void test4(/*站点*/) {
        Scanner sc = new Scanner(System.in);
        String[] stations = {"西站", "朱辛庄", "育知路", "平西府", "回龙观东大街", "霍营", "北站", "关庙村", "东站"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < stations.length; i++) {
            map.put(stations[i], i + 1);
        }
        String start;
        String end;
        while (true) {
            System.out.print("输入起点站:");
            start = sc.next();
            if (map.containsKey(start)) break;
            System.out.println("该站点不存在，请重新输入");
        }
        while (true) {
            System.out.print("输入终点站:");
            end = sc.next();
            if (map.containsKey(end) && !end.equals(start)) break;
            System.out.println("站点输入有误，请重新输入");
        }
        int gap = Math.abs(map.get(start) - map.get(end));
        System.out.println("从" + start + "到" + end + "共经过" + gap + "站收费" + (gap <= 3 ? 3 : gap <= 5 ? 4 : gap <= 7 ? (gap - 5) * 2 + 4 : 10) + "元，大约需要" + gap * 2 + "分钟");
    }
}

package com.dell.SepDay18;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchLines {
    public static List<String> readLine(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        String buf;
        while ((buf = br.readLine()) != null) {
        if (!Pattern.matches("import.*?|package.*?",buf)&&Pattern.matches(".*?[^\\s].*?[{};]",buf)){
            System.out.println("符合"+list.size());
            list.add(buf);
        }
        }
        br.close();
        return list;
    }
    public static boolean checkLine(File file,String target) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        String buf;
        while ((buf = br.readLine()) != null) {
            if (Pattern.matches(".*?"+target+".*?",buf)){
                System.out.print(buf.replaceAll("\\s{2,}(?=\\S+)",""));
                return true;
            }
        }
        br.close();
        return false;
    }
    public static void findChild(File file,List<String> list) throws IOException {
            File[] files = file.listFiles();
            if (files!=null){
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        findChild(file1,list);
                    }else{
                        list.addAll(readLine(file1));
                    }
                }
            }
    }
    public static void findTarget(File file,String target) throws Exception {
        File[] files = file.listFiles();
        if (files!=null){
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    findTarget(file1,target);
                }else{
                    if (checkLine(file1,target)) System.out.println("\n"+file1.toString());
                }
            }
        }
    }
    @Test
    public void test1(/*找到所有子文件,统计其内长度*/) throws Exception{
        File file = new File("D:\\project\\untitled\\src\\com\\dell");
        List<String> list = new ArrayList<>();
        findChild(file,list);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
    @Test
    public void test2(/*找到所有子文件,读取其内容,若符合条件则打印该行,和所在文件名*/) throws Exception {
        File file = new File("D:\\project\\untitled");
        String target = new Scanner(System.in).nextLine();
        System.out.println("target is "+target+"start searching!~");
        findTarget(file,target);
    }
    @Test
    public void test3() throws IOException {
        File file = new File("C:\\Users\\15756\\Desktop\\8-19.docx");
        FileReader fr = new FileReader(file);
        int len;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars,0,len));
        }
    }
}

package com.dell.SepDay22;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class HowToSort {
    public static boolean reading(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int len;
        char[] chars = new char[1024];
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("enum")){
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }
    public static void traverFolder(File file) throws IOException {
        File[] files = file.listFiles();
        if (files!=null){
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    traverFolder(file1);
                }else {
                    if (file1.isFile()&&reading(file1)){
                        System.out.println(file1.toString());
                    }
                }
            }
        }else System.out.println(file.toString() + "is empty");
    }
    @Test
    public void test1(/**/) throws IOException, InterruptedException {
        File file = new File("D:\\FictionStore");
        int i = 0;
        File[] fs = file.listFiles();
            for (File li : fs) {
                System.out.println(li.toString());
                if (li.isFile()&& 1 == new Scanner(System.in).nextInt()){
                    BufferedReader br = new BufferedReader(new FileReader(li));
                    int len;
                    char[] chars = new char[8069];
                    while ((len = br.read(chars)) != -1) {
                        System.out.println(new String(chars, 0, len).replaceAll("<br><br>","\n")
                                .replaceAll("(?<=.{30,})(，)","$1\n"));
                    }
                    br.close();
                }
            }
    }
    @Test
    public void test2(/**/)throws IOException, InterruptedException{
        traverFolder(new File("D:\\project\\untitled\\src\\com\\dell"));
    }
}

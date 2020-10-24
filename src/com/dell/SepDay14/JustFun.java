package com.dell.SepDay14;

import org.junit.Test;

import java.io.*;

public class JustFun {
    public static void getBuffer(StringBuffer buffer){//模拟输入流
        int len = buffer.length() % 3;
        for (int i = 0; i < len; i++) {
            System.out.println(buffer.charAt(buffer.length()-1-i));
        }
        for (int i = (buffer.length() / 3); i > 0; i--) {
            System.out.println(buffer.substring(i*3-3,i*3));
        }
    }
    @Test
    public void test1(/*客户加密添加,与读取*/) throws Exception {
//        BufferedInputStream bfi = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\15756\\Desktop\\阿创客户加密文档.txt")));
//        BufferedReader bfr = new BufferedReader(new FileReader(new File("C:\\Users\\15756\\Desktop\\阿创客户加密文档.txt")));
//        BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("C:\\Users\\15756\\Desktop\\阿创客户加密文档.txt")));
//        char[] buf = new char[1024];
//        int len = 0;
//        StringBuffer buffer = new StringBuffer();
//        while ((len = bfr.read(buf))!=-1){
//            buffer.append(buf,0,len);
//            System.out.println(String.valueOf(buf,0,len));
//        }
//        bfr.close();
        StringBuffer buffer = new StringBuffer("12349812");
        getBuffer(buffer);
    }
    @Test
    public void test2(){
        File f1 = new File("show2.txt");
        File f2 = new File("D:\\show2.txt");
        boolean b = f1.renameTo(f2);
        System.out.println(b);
    }
}

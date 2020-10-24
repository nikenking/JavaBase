package com.dell.SepDay19;


import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealWithFiles {
    public static void appendFlie(String in,String out) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\FictionStore\\"+in+".txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\FictionStore\\"+out+".txt"),true));
        String buf = null;
        while ((buf = br.readLine()) != null) {
            if (buf.length()>100){
                buf = "\"<h2>"+in+"</h2><br/>"+buf.replaceAll("。","。\n")//基本句号换行
                        .replaceAll("[\\t]+","")//去空格
                        .replaceAll("(?<=.{30,})，(?=.{30,})","，\n")//过长句子换行
                        .replaceAll("(?<=\\s)(.{1,10})\\n","$1")//过短上收
                        .replaceAll("(，)(?=[^，]{10,}\\n)","$1\n")//完善
                        .replaceAll("(?<![^\\s])(.)","&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp$1")//首行缩进
                        .replaceAll("\n","<br/>")+"\",\n";//变成一行,加标签
                bw.write(buf);
            }
        }
        br.close();
        bw.close();
    }
    public static void appendFlie2(String in,String out/*处理格式2*/) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\FictionStore\\"+in+".txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\FictionStore\\"+out+".txt"),true));
        String buf = null;
        while ((buf = br.readLine()) != null) {
            if (buf.length()>100){
                buf = "\"<h2>"+in+"</h2><br/>"+buf.replaceAll(
                        "(?!<[^\\s])([\\u4e00-\\u9fa5]{5,20}\\s*[\\u4e00-\\u9fa5]{5,20})(?=\\n)","<h2>$1</h2><br>")
                        .replaceAll("(?<=<br>)\\n","")
                        .replaceAll("(?<=<br>)\\n","")
                        +"\",\n";//变成一行,加标签
                bw.write(buf);
            }
        }
        br.close();
        bw.close();
    }
    public static void forReading(File file) throws IOException {
        System.out.println(file.length());
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        StringBuffer buffer = new StringBuffer();
        String littlebuf;
        while ((littlebuf = br.readLine()) != null) {
            System.out.println(littlebuf);
            buffer.append(littlebuf).append("\n");
        }
        buffer = new StringBuffer(String.valueOf(buffer).replaceAll("<br><br>","\n"));
        buffer = new StringBuffer(String.valueOf(buffer).replaceAll("(?<![^\\s]).*?(?=[“|\\u4e00-\\u9fa5|…])",""));
        br.close();
        bw.write(String.valueOf(buffer));
        bw.close();
    }
    @Test
    public void test(/*将爬取到的数据进行处理，可以在放入js数组最终在html上显示完整*/) throws IOException {
        File[] files = new File("d:\\FictionStore").listFiles();
        if (files!=null){
            for (File li : files) {
                /*文本处理覆盖*/
                System.out.println("开始处理文件："+li.toString());
                Matcher m = Pattern.compile("(第.*?)\\.txt").matcher(li.toString());
                while (m.find()){
                    appendFlie(m.group(1),"a");
                }
            }
        }
    }
    @Test
    public void test2() throws IOException {
        File file = new File("D:\\FictionStore\\第三十八章 你们想要杀我.txt");
        int len;
        char[] chars = new char[1024];
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((len = br.read(chars)) != -1) {
            System.out.println(new String(chars,0,len));
        }
//        forReading(file);
        br.close();
    }

}

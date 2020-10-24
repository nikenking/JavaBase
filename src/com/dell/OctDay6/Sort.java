package com.dell.OctDay6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sort {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\15756\\Desktop\\1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int len;
        char[] chars = new char[1024];
        String msg="";
        while ((len = br.read(chars)) != -1) {
            msg = new String(chars, 0, len);
        }
        br.close();
        System.out.println("获取到文本:\n"+msg);
        String s = msg.replaceAll(".*?\r\n", "g");
        System.out.println("转化之后:\n"+s);
    }
}

package com.dell.informationMannagerProject.figure;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String stuID;
    private String stuName;
    private int stuAge;
    private String stuSex;
    private String stuPass;
    private int score;//期末总分

    public void delete(String stuID) throws IOException {
        File file = new File("D:\\project\\untitled\\student.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder buffer = new StringBuilder();
        while ((line = br.readLine()) != null) {
            Matcher m = Pattern.compile(stuID+".*").matcher(line);
            if (!m.find()) {
                buffer.append(line).append("\n");
                System.out.println("append!!");
            } else System.out.println("find！！");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(String.valueOf(buffer));
        bw.close();
    }
}

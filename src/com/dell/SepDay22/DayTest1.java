package com.dell.SepDay22;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayTest1 {
    @Test
    public void test(/**/) throws IOException, InterruptedException {
        File file = new File("C:\\Users\\15756\\Desktop\\题目.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int len;
        char[] chars = new char[1024];
        String line = "";
        List<String> ans = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (!line.contains("*")) {
                System.out.println(line);
            }else {
                System.out.print("输入选择的答案(A、B、C、D):");
                ans.add(new Scanner(System.in).next());
            }
        }
        br.close();
        for (java.lang.String s : Arrays.asList("A", "C", "D", "D")) {
            System.out.printf("\n第%d题%s",5-ans.size(),ans.get(0).equals(s)?"正确":"错误");
            ans.remove(0);
        }
    }
}
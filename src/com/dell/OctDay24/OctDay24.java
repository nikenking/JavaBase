package com.dell.OctDay24;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OctDay24 {
    //水仙花
    @Test
    public void test1(/**/)throws IOException, InterruptedException{
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 100; i < 1000; i++) {
            p1 = i / 100;//百
            p2 = (i % 100) / 10;//十
            p3 = (i % 100) % 10;//个
            if (p1 * p1 * p1 + p2 * p2 * p2+ p3 * p3 * p3 == i) {
                System.out.print(i + " ");
            }
        }
    }

    @Test
    public void test2(/**/)throws IOException, InterruptedException{
        File file = new File("C:\\Users\\15756\\Desktop\\一班-第十一周测验");
        List<String> list = Arrays.asList("一", "二", "三", "四", "五", "六", "七", "八", "九", "十");
        for (File listFile : file.listFiles()) {
            File file1 = new File(listFile.toString() + "\\前端");
            File file2 = new File(listFile.toString() + "\\后端");
            file1.mkdir();
            file2.mkdir();
        }
    }
}


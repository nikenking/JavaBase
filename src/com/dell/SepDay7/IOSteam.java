package com.dell.SepDay7;

import org.junit.Test;

import java.io.File;

public class IOSteam {
    @Test
    public void test1(){
        File file = new File("d:\\project\\untitled\\src\\com\\dell\\SepDay7\\show.txt");
        System.out.println(file);
        System.out.println(file.isFile());
        System.out.println(file.exists());
    }
}

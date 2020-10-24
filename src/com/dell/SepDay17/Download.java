package com.dell.SepDay17;

import jdk.net.Sockets;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class Download {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\ImgStore\\show.txt");
        FileReader fr = new FileReader(file);
        int len;
        char[] chars = new char[100];
        while ((len = fr.read(chars)) != -1) {

        }
    }
}

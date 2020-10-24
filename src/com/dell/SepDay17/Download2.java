package com.dell.SepDay17;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Download2 {
public static void download(String urllink,String  path) throws Exception {
    URL url = new URL(urllink);
    File file = new File(path);
    DataInputStream di = new DataInputStream(url.openStream());
    FileOutputStream fo = new FileOutputStream(file);
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    int len;
    byte[] buf = new byte[1024];
    while ((len = di.read(buf)) > 0) {
        bo.write(buf,0,len);
    }
    fo.write(bo.toByteArray());
    System.out.println(path+"下载完成");
    di.close();
    fo.close();
    bo.close();
}
}

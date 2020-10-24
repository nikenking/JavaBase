package com.dell.SepDay8;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class IntePrograme {
    @Test
    public void test1() throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8900);
            os = socket.getOutputStream();
            os.write("这里是客户端发送的消息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();

            }
            if (os != null) {
                os.close();
            }
        }
    }

    @Test
    public void test2() {
        InputStream is = null;
        Socket socket = null;
        ServerSocket accept = null;
        ByteArrayOutputStream bai = null;
        try {
            accept = new ServerSocket(8900);
            socket = accept.accept();
            is = socket.getInputStream();
            bai = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                bai.write(buf, 0, len);
            }
            System.out.println(bai.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bai != null) {
                try {
                    bai.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() throws IOException {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fos = null;
        InputStream is = null;
        ByteArrayOutputStream bot = null;
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");//拿地址
        socket = new Socket(inetAddress, 8900);//定义客户端socket
        os = socket.getOutputStream();//拿输出流，发送文件
        fos = new FileInputStream(new File("show.txt"));//获取本地文件
        int len;
        byte[] buf = new byte[1024];
        while ((len = fos.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        socket.shutdownOutput();//发送完成，终止发送
        is = socket.getInputStream();//开始接受消息
        bot = new ByteArrayOutputStream();//将接受到的字节数组转字符
        byte[] rec = new byte[1024];
        while ((len = is.read(rec)) != -1) {
            bot.write(rec, 0, len);
        }
        System.out.println(bot.toString());
        if (socket != null) {
            socket.close();
        }
        if (os != null) {
            os.close();
        }
        if (fos != null) {
            fos.close();
        }
        if (is != null) {
            is.close();
        }
    }
    @Test
    public void test4() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8900);
        Socket socket = null;
        OutputStream os = null;
        FileOutputStream fos = null;
        InputStream is = null;
        ByteArrayOutputStream bot = null;
        socket = serverSocket.accept();//定义服务端socket
        is = socket.getInputStream();//获取客户端传来的文件字节流
        fos = new FileOutputStream(new File("show2.txt"));//输出，复制
        int len;
        byte[] buf = new byte[1024];
        while ((len = is.read(buf)) != -1) {//写入本地完成，开始返回信息
            fos.write(buf, 0, len);
        }
        os = socket.getOutputStream();//开始发送消息
        os.write("已收到文件".getBytes());
        if (socket != null) {
            socket.close();
        }
        if (os != null) {
            os.close();
        }
        if (fos != null) {
            fos.close();
        }
        if (is != null) {
            is.close();
        }
    }
}

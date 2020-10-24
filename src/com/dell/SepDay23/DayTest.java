package com.dell.SepDay23;

import org.apache.http.util.ByteArrayBuffer;
import org.junit.Test;
import java.io.*;
import java.net.*;

class Server {

    ServerSocket serverSocket;
    {
        try {
            System.out.println("服务端socket初始化start");
            serverSocket = new ServerSocket(8900);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accept() throws IOException {
        System.out.println("开始调用接收方法");
        Socket socket = null;
        socket = serverSocket.accept();
        System.out.println("服务端开始接受");
        InputStream is = socket.getInputStream();
        File file = new File("D:\\ServerReading.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        ByteArrayBuffer buffer = new ByteArrayBuffer(50);
        int len;
        byte[] chars = new byte[1024];
        System.out.println("开始读取信息到缓存中");
        while ((len = is.read(chars)) != -1) {
            buffer.append(chars, 0, len);
        }
        is.close();
        bw.write(new String(buffer.toByteArray()));
        System.out.println("写入完成，完毕socket");
        bw.close();
        socket.close();
        serverSocket.close();
    }
}

class Client {
    InetAddress address = null;
    Socket socket = null;

    {
        try {
            address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address, 8900);
            System.out.println("socket初始化完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String s) throws IOException {
        System.out.println("sendMsg");
        OutputStream os = socket.getOutputStream();
        os.write(s.getBytes());
        socket.shutdownOutput();
        System.out.println("写入完成,停止发送");
    }
}

class ServerThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("启动");
            Server server = new Server();
            server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread extends Thread {
    @Override
    public void run() {
        Client client = new Client();
        try {
            client.sendMsg("接收我的消息吧!\n这是我的时代！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class DayTest {

    public String readInputStream(InputStream is) throws IOException {
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(50);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            byteArrayBuffer.append(bytes, 0, len);
        }
        return new String(byteArrayBuffer.toByteArray());
    }

    @Test
    public void test9(/**/) throws IOException, InterruptedException {
        new ServerThread().start();
        Thread.sleep(1000);
        new ClientThread().start();
    }

//    @Test
//    public void test7(/*服务端。将本地ip和端口发送给客户端*/) throws IOException, InterruptedException {
//        DatagramSocket socket = new DatagramSocket();
//        String s = String.valueOf(InetAddress.getLocalHost()).split("/")[1] + "," + "8900";
//        byte[] bytes = s.getBytes();
//        InetAddress address = InetAddress.getLocalHost();
//        DatagramPacket dp_s = new DatagramPacket(bytes, 0, bytes.length, address, 8900);//将ip和端口打包发送
//        socket.send(dp_s);
//        socket.close();
//        System.out.println("receive start");
//        ServerSocket serverSocket = new ServerSocket(8900);
//        Socket socket1 = serverSocket.accept();
//        InputStream is = socket1.getInputStream();
//        System.out.println("reveiceved");
//        System.out.println(readInputStream(is));
//    }
//
//    @Test
//    public void test8(/**/) throws IOException, InterruptedException {
//        byte[] bytes = new byte[100];
//        DatagramSocket socket = new DatagramSocket(8900);
//        DatagramPacket rec = new DatagramPacket(bytes, 0, bytes.length);
//        socket.receive(rec);
//        String[] s = new String(rec.getData(), 0, rec.getLength()).split(",");//收到ip和端口了
//        socket.close();
//        //利用已知端口ip创建tcp链接
//        System.out.println("已收到ip和端口" + s[0] + "," + s[1]);
//        InetAddress address = InetAddress.getByName(s[0]);
//        Socket socket1 = new Socket(address, Integer.parseInt(s[1]));
//        OutputStream os = socket1.getOutputStream();
//        System.out.println("start send");
//        os.write("我已收到ip和端口，很满意，下次还来".getBytes());
//        System.out.println("send end");
//        socket1.close();
//    }
    //    @Test
//    public void test5(/*客户端发送账号和密码给服务端*/) throws IOException, InterruptedException {
//        InetAddress address = null;
//        Socket socket = null;
//        address = InetAddress.getByName("127.0.0.1");
//        socket = new Socket(address, 8900);
//        System.out.println("socket初始化完毕");
//        OutputStream os = socket.getOutputStream();
//        os.write(new Scanner(System.in).nextLine().getBytes());
//        socket.shutdownOutput();
//        System.out.println("写入完成,停止发送");
//    }
//
//    @Test
//    public void test6(/**/) throws IOException, InterruptedException {
//        ServerSocket serverSocket = new ServerSocket(8900);
//        System.out.println("开始调用接收方法");
//        Socket socket = null;
//        socket = serverSocket.accept();
//        System.out.println("服务端开始接受");
//        InputStream is = socket.getInputStream();
//        File file = new File("D:\\ServerReading.txt");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//        ByteArrayBuffer buffer = new ByteArrayBuffer(50);
//        int len;
//        byte[] chars = new byte[1024];
//        System.out.println("开始读取信息到缓存中");
//        while ((len = is.read(chars)) != -1) {
//            buffer.append(chars, 0, len);
//        }
//        is.close();
//        bw.write(new String(buffer.toByteArray()));
//        System.out.println("写入完成，完毕socket");
//        bw.close();
//        socket.close();
//        serverSocket.close();
//    }
//    @Test
//    public void test3(/*客户端发送账号和密码给服务端*/) throws IOException, InterruptedException {
//        String msg = new Scanner(System.in).nextLine();
//        InetAddress address = InetAddress.getByName("127.0.0.1");
//        Socket socket = new Socket(address, 8900);
//        OutputStream os = socket.getOutputStream();
//        os.write(msg.getBytes(StandardCharsets.UTF_8));//拿到字节数组
//        socket.shutdownOutput();
//        System.out.println(readInputStream(socket.getInputStream()));
//    }
//    @Test
//    public void test4(/*服务端接收消息，并返回登录结果*/) throws IOException, InterruptedException {
//        ServerSocket serverSocket = new ServerSocket(8900);
//        Socket socket = serverSocket.accept();
//        InputStream is = socket.getInputStream();
//        String[] msg = readInputStream(is).split(",");
//        //模拟匹配服务器的账号密码校验
//        Map<String, String> map = new HashMap<>();
//        map.put("zhangsan", "123456");
//        map.put("wangwu", "654321");
//        map.put("zhaoliu", "111111");
//        socket.getOutputStream().write((map.get(msg[0]) == null ?
//                "无此用户" : map.get(msg[0]).equals(msg[1]) ? "欢迎你" + msg[0] : "密码错误").getBytes());
//        socket.shutdownOutput();
//    }
//    @Test
//    public void test1(/*客户端发送东西给服务端*/) throws IOException, InterruptedException {
//        String msg = new Scanner(System.in).nextLine();
//        InetAddress address = InetAddress.getByName("127.0.0.1");
//        Socket socket = new Socket(address, 8900);
//        OutputStream os = socket.getOutputStream();
//        os.write(msg.getBytes(StandardCharsets.UTF_8));//拿到字节数组
//        socket.shutdownOutput();
//        System.out.println(readInputStream(socket.getInputStream()));
//    }
//    @Test
//    public void test2(/*服务端接收消息*/) throws IOException, InterruptedException {
//        ServerSocket serverSocket = new ServerSocket(8900);
//        Socket socket = serverSocket.accept();
//        InputStream is = socket.getInputStream();
//        System.out.println(readInputStream(is));
//        socket.getOutputStream().write("I'm Server!".getBytes());
//        socket.shutdownOutput();
//    }
}

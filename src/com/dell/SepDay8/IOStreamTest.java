package com.dell.SepDay8;

import org.junit.Test;

import java.io.*;

public class IOStreamTest {
    /*文件复制*/
    public static void copyByfileStream(File file, File file2) {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream(file);
            fw = new FileOutputStream(file2, true);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*缓冲套接水管加快速度*/
    public static void copyBybufferStream(File file, File file2) {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        BufferedInputStream br = null;
        BufferedOutputStream bw = null;
        try {
            fr = new FileInputStream(file);
            fw = new FileOutputStream(file2, true);
            br = new BufferedInputStream(fr);
            bw = new BufferedOutputStream(fw);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = br.read(buf)) != -1) {
                bw.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyBybufferStreamSecrate(File file, File file2) {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        BufferedInputStream br = null;
        BufferedOutputStream bw = null;
        try {
            fr = new FileInputStream(file);
            fw = new FileOutputStream(file2, true);
            br = new BufferedInputStream(fr);
            bw = new BufferedOutputStream(fw);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = br.read(buf)) != -1) {
                for (int i = 0; i < buf.length; i++) {
                    buf[i] = (byte) (buf[i] ^ 5);
                }
                bw.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1(/*不同流效率对比*/) {
        File file = new File("E:\\恢复文件2\\网课相关\\WangGame\\王靖组-赛车游戏.mp4");
        File file2 = new File("E:\\恢复文件2\\网课相关\\WangGame\\copy.mp4");
        File file3 = new File("E:\\恢复文件2\\网课相关\\WangGame\\decode.mp4");
        long start = System.currentTimeMillis();
        copyBybufferStreamSecrate(file2, file3);
        long end = System.currentTimeMillis();
        System.out.println("复制完成，耗时" + (end - start));
    }
    @Test
    public void test2(/*Object流储存*/) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("show.dat"));
            oos.writeObject(new String("这是一条隐藏的角色介绍"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test3(/*Object流读取，并转化打印，自定义类型需要实现接口Serializable,并确定唯一标识符，确保类更变能确定唯一表示*/){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("show.dat"));
            String s;
            s = (String) ois.readObject();
            System.out.println(s);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test4(/*RandomAccessFile//可读可插入，全能流*/) throws IOException {
        RandomAccessFile rda = new RandomAccessFile("show.txt","rw");//读写操作
        int len = (int) (new File("show.txt")).length();
        System.out.println("长度为" + len);//实现插入
        rda.seek(len);
        rda.write("abc".getBytes());
        rda.close();
    }
    @Test
    public void test5(){

    }

}

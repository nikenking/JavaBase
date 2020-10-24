package com.dell.SepDay4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class SayHello extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i%2==0) System.out.print(i);
        }
    }
}

class SellTicket implements Runnable{
    private Integer remain = 100;
    Object dog = new Object();
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (dog){
                if (remain>0){
                    remain--;
                    System.out.println(Thread.currentThread().getName()+"售出一张票,剩余："+remain);
                }
            }
        }
    }
}

public class MultyThread {
    public static void main(String[] args) throws InterruptedException {
        SayHello hello = new SayHello();
        SellTicket ticket = new SellTicket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.setName("一号售票窗口");
        t2.setName("二号售票窗口");
        t3.setName("三号售票窗口");
//        t1.start();
//        t2.start();
//        t3.start();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            Date date1 = dtf.parse("2020-09-04");
            System.out.println(dtf.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

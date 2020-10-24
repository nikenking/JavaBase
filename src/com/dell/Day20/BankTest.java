package com.dell.Day20;

import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {
//        Acount acount = new Acount(111111,2000);
//        Acount acount2 = new Acount(222222,2000);
//        Acount acount3 = new Acount(333333,2000);
//        System.out.println(acount.toString());
//        System.out.println(acount2.toString());
//        System.out.println(acount3.toString());

        for (int i = 0; i < 3; i++) {
            System.out.printf("请输入第%d个用户的密码和余额:",i+1);
            String[] mesg = new Scanner(System.in).nextLine().split(" ");
            Acount acount = new Acount(mesg[0],mesg[1]);
            System.out.println(acount.toString());
        }
    }
}

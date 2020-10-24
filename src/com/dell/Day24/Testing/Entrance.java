package com.dell.Day24.Testing;

import java.util.Scanner;

public class Entrance {
    public static void main(String[] args) {
        System.out.print("输入要喝的类型(1,咖啡;2,啤酒;3,牛奶):");
        Drink drink = Drink.getDrink(new Scanner(System.in).nextInt());
        drink.taste();
    }
}

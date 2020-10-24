package com.dell.DayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StackPopUpOder {
    public static void showlist(List<String> list){
        for (String i:list){
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static boolean findnum(List<String> list,String num){
        for (String i:list) {
            if (i.equals(num)) {
                return true;
            }
        }return false;
    }
    public static class Stack{
        List<String> list = new ArrayList<>();
        public List<String> getList() {
            return list;
        }
        public void push(String p){
            list.add(p);
            showlist(list);
        }
        public boolean pop(String p){
            List<String> copy = this.list;
            if (copy.size()!=0){
                for (int i = copy.size()-1; i>=0&& !list.get(i).equals(p); i--){
                    list.remove(i);
                    showlist(list);
                }
                return true;
            }
            System.out.println("栈已空");
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> oder1 = new ArrayList<String>(Arrays.asList(sc.nextLine().split(" ")));
        List<String> oder2 = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        List<String> copylist = new ArrayList<>();
        Stack stack = new Stack();
        for (String i:oder2){
            copylist = oder1;
            for (String j:copylist){
                if (findnum(oder1,i)){
                    stack.push(j);
                }else continue;
            }
            copylist = stack.getList();
            for (String k:copylist){
                if (findnum(stack.getList(),i)){
                    stack.pop(i);
                }else continue;
            }
        }
    }
}

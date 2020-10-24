package com.dell.DayTest;

import java.util.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.reverse;

class ListNode {
    ListNode next;
    int value;

    public ListNode(int value) {
        this.value = value;
    }
}

public class LinkListAdd {
    public static void ShouList(ListNode listNode){
        String list = "";
        while (listNode!=null){
            list+=listNode.value;
            listNode = listNode.next;
        }
        Pattern pattern = Pattern.compile("[1-9]\\d+[1-9]");
        Matcher matcher = pattern.matcher("0008070");
        while (matcher.find()){
            list = (matcher.group(0));
        }
        for (int i = 0; i < list.length()-1; i++) {
            System.out.print(list.charAt(i)+"->");
        }
        System.out.println(list.charAt(list.length()-1));
    }

    public static ListNode TurnList(String str) {
        ListNode root = new ListNode(0);
        ListNode tem = root;
        for (int i = 0; i < str.length(); i++) {
            tem.next = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))));
            tem = tem.next;
        }
        return root;
    }

    public static ListNode ListReverse(ListNode listNode) {
        ListNode result = new ListNode(0);
        ListNode root = result;
        List<Integer> reverselist = new ArrayList<>();
        while (listNode != null) {
            reverselist.add(listNode.value);
            listNode = listNode.next;
        }
        for (int i = reverselist.size() - 1; i >= 0; i--) {
            root.next = new ListNode(0);
            root = root.next;
            root.value = reverselist.get(i);
        }
        return result;
    }

    public static ListNode AddList(ListNode listNode, ListNode listNode2) {
        listNode = ListReverse(listNode);
        listNode2 = ListReverse(listNode2);
        ListNode resultroot = new ListNode(0);
        ListNode result = resultroot;
        int ramain = 0;
        while (listNode != null || listNode2 != null) {
            int x = (listNode != null) ? listNode.value : 0;
            int y = (listNode2 != null) ? listNode2.value : 0;
            if (x + y < 10) {
                result.value += x + y;
                result.next = new ListNode(0);
                result = result.next;
            } else {
                ramain = (x + y) % 10;
                result.value += ramain;
                result.next = new ListNode(1);
                result = result.next;
            }
            listNode = listNode.next;
            listNode2 = listNode2.next;
        }
        return resultroot;
    }

    public static void main(String[] args) {
        System.out.print("请输入：");
        String str = new Scanner(System.in).nextLine();
        String[] list = str.split("\\+");
        String strs[] = new String[list.length];
        for (int i=0;i<list.length;i++) {
            strs[i] = list[i].replaceAll("[^0-9]","");
        }
        ListNode listNode = TurnList("243");
        ListNode listNode1 = TurnList("564");
        listNode = ListReverse(AddList(listNode, listNode1));
        ShouList(listNode);
    }
}


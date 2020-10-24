package com.dell.DayTest;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree {
    public Tree left;
    public Tree right;
    public int value;
    public Tree root;
    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public void createTree(int[] arr) {
        Tree[] lists = new Tree[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = new Tree(arr[i]);
        }
        root = lists[0];
        for (int i = 0; i < arr.length / 2; i++) {
            lists[i].left = lists[i * 2 + 1];
            if (i * 2 + 2 < lists.length) {//避下标越界
                lists[i].right = lists[i * 2 + 2];
            }
        }
    }

}

public class TeeDeep {
    static public void getDeep(int a){
        int count = 0;
        for (int i = 0;; i++) {
            count+=Math.pow(2,i);
            if (count>=a){
                System.out.println("\n"+(i+1)+"层");
                return;
            }
        }
    }
    static public void inorder(Tree root, List<Integer> list) {
        if (root != null) {
            if (root.left!=null||root.right!=null){
                if (root.left!=null&&root.left.value!=-1) System.out.print(root.left.value+"\t");
                else System.out.print("null\t");
                list.add(0);
                if (root.right!=null&&root.right.value!=-1) System.out.print(root.right.value+"\t");
                else System.out.print("null\t");
                list.add(0);
                inorder(root.left,list);
                inorder(root.right,list);
            }
        }
    }
    static public int[] getAList(){
        String[] list = new Scanner(System.in).nextLine().split(",");
        int[] result = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals("null")){
                result[i] = Integer.parseInt(list[i]);
            }else result[i] = -1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = getAList();
        String head = (a[0]==-1)?"null":String.valueOf(a[0]);
        List<Integer> list = new ArrayList<>();
        Tree tree = new Tree(a[0]);
        tree.createTree(a);
        System.out.print("中序遍历:\n"+head+"\t");
        inorder(tree.root,list);
        getDeep(list.size()+1);
    }
}

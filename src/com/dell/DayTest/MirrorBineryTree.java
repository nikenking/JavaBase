package com.dell.DayTest;


import java.util.*;

public class MirrorBineryTree {
    public static void listCut(List<Object> oldList, List<Object> list, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            list.add(oldList.get(i));
        }
    }
    public static boolean listCompare(List<Object> list,List<Object> list2){
        if (list.size()!=list2.size())return false;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }
    public static Bintree showReverseTree(String head, Object[] arr) {
        List<Object> oldlist = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            oldlist.add(arr[i]);
        }
        List<Object> list = new ArrayList<>();//用来存翻转后的对象列表
        int end = 0;
        list.add(head);//加入头部
        for (int i = 1; ; i++) {
            int start = end;//起始头部
            end = (int) (start + Math.pow(2, i));//终止尾部，不包括end
            if (end > oldlist.size()) {//当长度不够理论长度时
                listCut(oldlist, list, start, oldlist.size());
                break;
            } else {
                listCut(oldlist, list, start, end);
            }
        }
        Iterator<Object> interator = oldlist.iterator();
        while (interator.hasNext()) {
            System.out.print(interator.next() + " ");
        }
        Object[] newTree = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newTree[i] = list.get(i);
        }
        Bintree result = new Bintree();
        result.creat(newTree);
        return result;
    }
    public static boolean compareTree(Bintree tree,Bintree tree2,List<Object> judge){
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        getShowTree(tree,list1);
        getShowTree(tree2,list2);
        judge.add(listCompare(list1,list2));
        if (tree.left != null && tree.right != null) {
            compareTree(tree.left,tree2,judge);
            compareTree(tree.right,tree2,judge);
        } else {
            if (tree.left != null) {
                compareTree(tree.left,tree2,judge);
            } else if (tree.right != null) {
                compareTree(tree.right,tree2,judge);
            }
        }
        return true;
    }
    public static void reverse(Bintree bintree) {
        if (bintree.left != null && bintree.right != null) {
            Bintree temp = bintree.left;
            bintree.left = bintree.right;
            bintree.right = temp;
            reverse(bintree.left);
            reverse(bintree.right);
        }
    }
    public static void showTree(Bintree root) {
        System.out.print(root.data);
        if (root.left != null && root.right != null) {
            showTree(root.left);
            showTree(root.right);
        } else {
            if (root.left != null) {
                showTree(root.left);
            } else if (root.right != null) {
                showTree(root.right);
            }
        }
    }
    public static void getShowTree(Bintree root,List<Object> o) {
        o.add(root.data);
        if (root.left != null && root.right != null) {
            getShowTree(root.left,o);
            getShowTree(root.right,o);
        } else {
            if (root.left != null) {
                getShowTree(root.left,o);
            } else if (root.right != null) {
                getShowTree(root.right,o);
            }
        }
    }

    public static void main(String[] args) {
//        Object[] arr = new Scanner(System.in).nextLine().split(" ");
        Object[] arr = "1 2 3 4 5 6 7 8 9".split(" ");
        Bintree bintree = new Bintree();
        bintree.creat(arr);
        System.out.println("原二叉树（深度优先）:");
        showTree(bintree.root);
        System.out.println();
        System.out.println("镜像叉树（深度优先）:");
        reverse(bintree.root);
        showTree(bintree.root);
        System.out.println("\n输入对比子二叉树");
        Object[] arr2 = new Scanner(System.in).nextLine().split(" ");
        Bintree bintree1 = new Bintree();
        bintree1.creat(arr2);
        List<Object> juedge = new ArrayList<>();
        compareTree(bintree.root,bintree1.root,juedge);
        if (juedge.contains(true)) System.out.println("该二叉树是一个子树");
        else System.out.println("不是");
    }
}
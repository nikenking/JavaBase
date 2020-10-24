package com.dell.DayTest;

import java.util.*;

class Bintree {
    public Bintree left;
    public Bintree right;
    public Bintree root;
    public Object data;//每个节点存放的数
    public List<Bintree> datas;//根节点使用的属性

    public Bintree(Bintree left, Bintree right, Object data) {//除了根节点的节点初始化
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Bintree(Object data) {//初始化
        this(null, null, data);
    }

    public Bintree() {

    }

    //创建节点
    public void creat(Object[] objs) {
        datas = new ArrayList<Bintree>();
        for (Object obj : objs) {
            datas.add(new Bintree(obj));
        }
        root = datas.get(0);//定义根节点
        for (int i = 0; i < objs.length / 2; i++) {
            datas.get(i).left = datas.get(i * 2 + 1);
            if (i * 2 + 2 < datas.size()) {//避下标越界
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }
    }

    public void showTree(){
        System.out.print(this.root.data+" ");
        for (Object o : inorder(this.root, new ArrayList<>())) {
            System.out.print(o+" ");
        }
        System.out.println();
    }

    public List<Object> inorder(Bintree root, List<Object> buffer) {
        if (root != null) {
        if (root.left != null && root.right != null) {
            buffer.add((String) root.left.data);
            buffer.add((String) root.right.data);
            inorder(root.left, buffer);
            inorder(root.right, buffer);
        } else {
            if (root.left != null) {
                buffer.add((String) root.left.data);
                inorder(root.left, buffer);
            }
            if (root.right != null) {
                buffer.add((String) root.right.data);
                inorder(root.right, buffer);
            }
        }
    }
        return buffer;
}
    /*

     * */
//    中序遍历
//    public boolean inorder(Bintree root) {
//        if (root != null) {
//            if (root.left != null && root.right != null && root.left.data != null && root.right.data != null &&
//                    ((Integer) root.left.data > (Integer) root.data || (Integer) root.right.data < (Integer) root.data)) {
//                return false;
//            }
//            inorder(root.left);
//            inorder(root.right);
//        }
//        return true;
//    }
}

public class Btree {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new Scanner(System.in).nextLine().split(" "));
        Object[] a = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("null")) {
                a[i] = null;
            } else a[i] = (Object) Integer.parseInt(list.get(i));
        }
        Bintree Bintree = new Bintree();
        Bintree.creat(a);
//        System.out.println(Bintree.inorder(Bintree.root));
    }
}

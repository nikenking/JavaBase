package com.dell.SepDay8;

import org.junit.Test;

import java.util.*;

class News {
    private String title;
    private String containt;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public News() {
    }

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContaint() {
        return containt;
    }

    public void setContaint(String containt) {
        this.containt = containt;
    }
}

public class DayTest {
    public void traversal(List list) {
        Iterator iterator = list.iterator();
        System.out.println("这是一次遍历的开始");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("这是一次遍历的结束");
    }

    @Test
    public void test1() {
        List list = new ArrayList(15);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        traversal(list);
        list.add(1, "二号位插入的元素");
        traversal(list);
        System.out.println(list.get(4));
        list.remove(5);
        traversal(list);
        list.set(6, "这是更改后的七号位元素");
        traversal(list);
    }

    @Test
    public void test2(/*List object*/) {
        News news1 = new News("中国多地遭雾霾笼罩，空气质量再成热议话题");
        News news2 = new News("春节临近，北京“卖房热”");
        List list = new ArrayList();
        list.add(news1);
        list.add(news2);
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        while (listIterator.hasPrevious()) {
            Object obj = listIterator.previous();
            if (obj instanceof News) {
                News news = (News) obj;
                System.out.println(news.getTitle().length() > 15 ?
                        news.getTitle().substring(0, 14) + "..." : news.getTitle());
            }
        }

    }

    @Test
    public void test3(/*hashSet*/) {
        /*
         * 创建Set接口的实现类，实现添加单个元素，添加另一个集合，删除元素，
         * 判断集合中是否包含一个元素，判断是否为空，清除集合，返回集合里元素的个数等常用操作。
         * 通过Iterator遍历此集合元素，通过foreach遍历此集合元素。*/
        Set set = new HashSet();
        Set set2 = new HashSet();
        set.add(1);
        set.add(2);
        set2.add("111");
        set2.add("222");
        set.addAll(set2);
        set.remove(1);
        System.out.println(set.contains("222"));
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        set.forEach(System.out::println);
    }
}

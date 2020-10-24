package com.dell.SepDay9;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.*;

class News implements Comparable {
    public String title;
    public String author;
    public String container;
    public Date date;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("using equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        if (title.equals(news.title)) {
            return true;
        } else {
            return author != null && Objects.equals(author, news.author) && container != null &&
                    Objects.equals(container, news.container) && date != null &&
                    Objects.equals(date, news.date);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, container, date);
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("using compare");
        News news = (News) o;
        if (title.equals(news.title)) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class DayTest {
    public static boolean myContains(List list,String str){
        return list.contains(str);
    }
    @Test
    public void test1(/*对list排序*/) {
        Set set = new HashSet();
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * 200);
            rand = rand > 100 ? rand : rand + 100;
            set.add(rand);
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return Integer.compare(integer, t1);
            }
        });
        list.forEach(System.out::println);
    }

    @Test
    public void test2(/*set对对象的对比还要重写hashcode方法*/) throws Exception {
        Class clazz = Class.forName("com.dell.SepDay9.News");
        Constructor constructor = clazz.getConstructor(String.class);
        News news1 = (News) constructor.newInstance("中国多地遭雾霾笼罩空气质量再成热议话题");
        News news2 = (News) constructor.newInstance("民进党台北举行“火大游行”");
        News news3 = (News) constructor.newInstance("春节临近北京“卖房热”");
        News news4 = (News) constructor.newInstance("春节临近北京“卖房热”");
//        System.out.println(news1.equals(news2));
//        System.out.println(news3.equals(news4));
        Set set = new HashSet();
        set.add(news1);
        set.add(news2);
        set.add(news3);
        set.add(news4);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(set.size());
    }

    @Test
    public void test3(){
        String[] s = {"abc","def", "efg", "def", "def", "qwe", "def", "def", "swd", "wwe", "def", "def"};
        List<String> list1 = Arrays.asList(s);
        for (String s1 : list1) {
            System.out.println(s1);
        }
        List<String> list = new ArrayList<>();
        int count = 0;
        for (String s1 : s) {
            list.add(s1);
        }
        //判断数量
        for (int i = 0; i < list.size(); i++) {
            if (myContains(list.subList(i,i+1),"def")){
                count++;
            }
        }
        System.out.println(count);
        //移除
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (temp.equals("def")){
                iterator.remove();
            }
        }
        //转大写
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).toUpperCase());
        }
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}

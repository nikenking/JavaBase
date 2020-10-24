package com.dell.SepDay11;

import org.junit.Test;

import java.util.*;

class Student {
    private String name;
    private int age;
    private int score;
    private String classNum;

    public Student(String name, int age, int score, String classNum) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.classNum = classNum;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}

class Car {
    private String name;
    private Float speed;
    private int price;

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Car(String name, Float speed) {
        this.name = name;
        this.speed = speed;
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Clark {
    private String name;
    private int bunons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clark clark = (Clark) o;
        return bunons == clark.bunons &&
                Objects.equals(name, clark.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bunons);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBunons() {
        return bunons;
    }

    public void setBunons(int bunons) {
        this.bunons = bunons;
    }

    public Clark(String name, int bunons) {
        this.name = name;
        this.bunons = bunons;
    }
}

class Person{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hashCode=}"+this.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
public class DayTest1 {
    public static List<String> getChaoticTeam(List<String> list) {
        Collections.shuffle(list);
        List<String> result = new ArrayList<>(list.subList(list.size() - 4, list.size()));
        for (int i = 0; i < 4; i++) {
            list.remove(list.size() - 1);
        }
        return result;
    }
    @Test
    public void test1(/*球队分组*/) {
        List<String> teams = new ArrayList<>(Arrays.asList("科特迪瓦", "阿根廷", "澳大利亚", "塞尔维亚", "荷兰", "尼日利亚", "日本", "美国"
                , "中国", "新西兰", "巴西", "比利时", "韩国", "喀麦隆", "洪都拉斯", "意大利"));
        List<String> team1 = getChaoticTeam(teams);
        List<String> team2 = getChaoticTeam(teams);
        List<String> team3 = getChaoticTeam(teams);
        List<String> team4 = getChaoticTeam(teams);

    }

    @Test
    public void test2(/*平均年龄*/) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Tom", 18, 100, "class05"));
        list.add(new Student("Jerry", 22, 70, "class04"));
        list.add(new Student("Owen", 25, 90, "class05"));
        list.add(new Student("Jim", 30, 80, "class05"));
        list.add(new Student("Steve", 28, 66, "class06"));
        list.add(new Student("Kevin", 24, 100, "class04"));
        float avgAge = 0L;
        float avgScore = 0L;
        for (Student student : list) {
            avgAge += student.getAge();
            avgScore += student.getScore();
        }
        System.out.printf("平均年龄为:%.2f,平均分数为:%.2f", avgAge / list.size(), avgScore / list.size());
    }

    @Test
    public void test3() {
        Set set = new HashSet();
        set.add(new Car("F4", 150000));
        set.add(new Car("F5", 150000));
        set.add(new Car("F4", 160000));
        set.add(new Car("F4", 150000));
        set.add(new Car("F5", 150000));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test4() {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("张三", 800);
        m1.put("李四", 1200);
        m1.put("王五", 3000);
        for (String s : m1.keySet()) {
            m1.put(s, m1.get(s) + 100);
        }
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    @Test
    public void test5(/*Map 进阶操作*/) {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("Zhang", 800);
        m1.put("Li", 1200);
        m1.put("Wang", 3000);
        m1.put("Tom", 1500);
        m1.put("Jack", 1500);
        m1.remove("Tom");
        m1.put("Jack", m1.get("Jack") + 1000);
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            if (entry.getValue() < 2000) m1.put(entry.getKey(), (int) (entry.getValue() * 1.2));
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Map<String, Integer> m2 = new TreeMap<>(m1);
        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            if (entry.getValue() < 2000) m1.put(entry.getKey(), (int) (entry.getValue() * 1.2));
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void test6() {
        Car c1 = new Car("奥拓", (float) 150L);
        Car c2 = new Car("宝马", (float) 170L);
        Car c3 = new Car("大众", (float) 120L);
        Map<String, Integer> m1 = new HashMap<>();
        m1.put(c1.getName(), 500000);
        m1.put(c2.getName(), 300000);
        m1.put(c3.getName(), 100000);
        System.out.println("宝马的价格为" + m1.get("宝马"));
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            m1.put(entry.getKey(), (int) (entry.getValue() * 0.8));
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void test7(){
        Person p1 = new Person("x1",111);
        Person p2 = new Person("x2",111);
        Set set = new HashSet();
        set.add(p1);
        set.add(p2);
        p1.setName("x3");
        set.remove(p1);
        set.add(new Person("x3",111));
        System.out.println(set);
    }
}























/*
*     public static List<Integer> getATeam(List<String> list){
        int len = list.size();
        List<Integer> choice = new ArrayList<>();
        while (choice.size()<4){//得到四个随机数
            int a = ((int) (Math.random() * 4));
            if (!choice.contains(a))choice.add(a);
        }
        choice.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return -Integer.compare(integer, t1);
            }
        });//从大到小排一下方便删除
        for (Integer integer : choice) {

        }
        return choice;
    }*/

package com.dell.SepDay14;
/*
* @2020/09/15
* 郑创*/
import org.junit.Test;
import java.util.*;

class Apple<T> {
    private T weight;

    public Apple(T weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
class MyDate{
    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public String getAll(){
        return year+""+month+""+day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
class Employee implements Comparable{
    private String name;
    private Integer age;
    private MyDate birthday;
    public String getBirth(){
        return birthday.getAll();
    }
    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee) o;
            if (!e.name.equals(name)){
                return name.compareTo(e.name);
            }else if (!e.age.equals(age)){
                return Integer.compare(age,e.age);
            }else return getBirth().compareTo(e.getBirth());
        }else throw new RuntimeException("类型不匹配");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + getBirth() +
                '}';
    }
}
public class DayTest {
    @Test
    public void test1(/*第一题*/) {
        /*
        * 因为在程序中，有些结果有些数据可能会返回空值，
        * 转化为基本数据类型比如 int 就会发生异常，因为类似于
        *  int 这些是没有 null 值可言的。但是基本数据类型对应的如 Integer
        * 这些包装类类型就不会，因为对象可以为 null 值。
        原来如此，但是 KK 又好奇了，接着问？
        那，有包装类就好了呀！正所谓，Java 一切皆是对象，
        * 干嘛还需要基本数据类型呢？咋全部创建个对象不行吗？
        KK童鞋，你给我坐下。
        是呀，这又是为什么？这主要是基于程序性能的考量的，
        * 基本数据类型的定义是存放在栈中的，但是我们创建对象而引出来的实际数值则是放在堆里的，
        * 堆的速度远远不如栈。而且基本数据类型变量的创建和销毁都非常快
        * ，而类定义的变量还需要 JVM 去销毁。没错，就是因为考量了程序性能的问题。*/
        Apple<String> a1 = new Apple<>("500g");
        Apple<Integer> a2 = new Apple<>(500);
        Apple<Double> a3 = new Apple<>(500.0);
        System.out.println(a1 + "\n" + a2 + "\n" + a3 + "\n");
    }

    @Test
    public void test2(/*第二题*/) {
        /*
        * 你也可以直接使用Arrays.asList(的输出，将其当作List，但是在这种情况下，其底层表示
        的是数组，因此不能调整尺寸。如果你试图用add(或delete(方法在这种列表中添加或删除元素，
        就有可能会引发去改变数组尺寸的尝试，因此你将在运行时获得“Unsupported Operation(不支
        持的操作)错误。
*/
        String[] arr = {"AA", "BB", "EE", "CC", "GG", "HH", "FF", "ZZ"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        List<String> list2 = Arrays.asList(arr);//返回的是一个Arrays的下的ArrayList
        System.out.println(list2.getClass()+"\n"+list.getClass());
//        list.remove("AA");//数组不支持此操作
        list.remove(0);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    @Test
    public void test3(/*第三题*/){
        Employee e1 = new Employee("e1",11,new MyDate(1999,6,3));
        Employee e2 = new Employee("e2",11,new MyDate(1999,6,3));
        Employee e3 = new Employee("e2",11,new MyDate(2000,6,3));
        Employee e4 = new Employee("e4",11,new MyDate(2000,6,3));
        Employee e5 = new Employee("e4",12,new MyDate(1999,6,3));
        Comparator<Employee> cmp = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (!e1.getBirth().equals(e2.getBirth())){
                    return e1.getBirth().compareTo(e2.getBirth());
                }else if (!e1.getAge().equals(e2.getAge())){
                    return e1.getAge().compareTo(e2.getAge());
                }else return e1.getName().compareTo(e2.getName());
            }
        };
        TreeSet<Employee> treeSet = new TreeSet<>(cmp);
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);
        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

package com.dell.OctDay3;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class DayTest {
    @Test
    public void test1(/**/) throws IOException, InterruptedException {
        List<String> list = new ArrayList<>();
        //apple,grape,banana,pear
        list.add("apple");
        list.add("grape");
        list.add("banana");
        list.add("pear");
        System.out.println("max=" + Collections.max(list) + "min=" + Collections.min(list));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test2(/**/) throws IOException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 10) {
            int rand = (int) (Math.random() * 20);
            if (!list.contains(rand)) {
                list.add(rand);
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
//        TreeSet<Integer> set = new TreeSet<Integer>();
//        while (set.size()<10){
//            int rand = (int) (Math.random()*20);
//            set.add(rand);
//        }
//        System.out.println(set);
    }

    @Test
    public void test3(/**/) throws IOException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        List<String> list = Arrays.asList("王老师", "java", "李老师", "JDBC", "张老师", "BootStrap", "刘老师", "MySql",
                "邓老师", "java", "Lucy", "Python");
        for (int i = 0; i < list.size() / 2; i++) {
            map.put(list.get(i * 2), list.get(i * 2 + 1));
        }
        map.put("Allen", "JDBC");
        map.put("Lucy", "CoreJava");
        System.out.println("所有老师及其课程");
        System.out.println(map);
        System.out.println("所有教java的老师有：");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("java")) System.out.println(entry.getKey());
        }
    }

    @Test
    public void test4(/*sql语句*/) throws IOException, InterruptedException {
//        int times = 5;
//        for (int i = 0; i < times; i++) {
//            System.out.printf("INSERT INTO classToCourse (classId, courseId) VALUES ('17202', %d);\n",i+1);
//        }

//        String[] cl = {"17203","17202"};
//        List<String> list = Arrays.asList("李媛媛", "魏子超", "许向南", "王怀", "刘欣程", "俞俊", "张敏", "唐伟", "钦程", "李子钰", "张羽铖",
//                "谭钊全", "贺缙殷", "白宏禹", "林祥", "郎金刚", "尚含溪", "郭永明", "曾蕊", "陈俊杰", "寇佳军", "郭波",
//                "陈林", "高斌", "李远芳", "郑创", "杨锐", "刘宇航", "张永涛", "姚永晴", "潘雯", "杨为茗", "姜佳伟", "张磊",
//                "彭然", "汪伟鹏", "付惠玲", "于敏亮", "吴凤岐", "李长茂", "陈亚", "何鑫", "官睿", "叶陈锋", "李佳澳", "彭涛",
//                "付文飞", "买春生", "姜雯婷", "张培杰", "冯春", "雷职菱", "胡博", "李耀坤", "黎俊杰", "任万林", "秦超", "张金辉", "孟贤洁");
//        int[] cl1 = {0,0};
//        for (int i = 0; i < list.size(); i++) {
//            int gender = (int) (Math.random()*2);
//            int realgender = (int) (Math.random()*2);
//            System.out.printf("INSERT INTO student (sId, sName, sGender, sClassId, sPass) " +
//                    "VALUES ('17310320%s%s%d', '%s', %s, %s, '123456');\n",String.valueOf(cl[gender].charAt(4)),cl1[gender]<9?"0":"",
//                    ++cl1[gender],list.get(i),realgender,cl[gender]);
//        }
        String[] sId = {"17310320301", "17310320201", "17310320302", "17310320303", "17310320304", "17310320305",
                "17310320202", "17310320203", "17310320204", "17310320205", "17310320206", "17310320207", "17310320208"
                , "17310320209", "17310320306", "17310320307", "17310320308", "17310320309", "17310320310", "17310320311",
                "17310320312", "17310320210", "17310320313", "17310320211", "17310320212", "17310320314", "17310320213"
                , "17310320214", "17310320215", "17310320216", "17310320315", "17310320316", "17310320317", "17310320318",
                "17310320319", "17310320217", "17310320320", "17310320321", "17310320322", "17310320218", "17310320323",
                "17310320219", "17310320324", "17310320220", "17310320325", "17310320221", "17310320222", "17310320326",
                "17310320223", "17310320224", "17310320225", "17310320226", "17310320227", "17310320228", "17310320327",
                "17310320229", "17310320328", "17310320329", "17310320230"};
        int[] class3 = {1, 2, 3, 4, 6};
        int[] class2 = {1, 2, 3, 4, 5, 7};
        String sql = "INSERT INTO studentToCourse (sId, courseId, score) VALUES ('%s', %d, %d);\n";
        for (String s : sId) {
            if (Pattern.matches("173103202.*?", s)) {
                for (int i : class2) {
                    System.out.printf(sql, s, i, (int) (Math.random() * 50 + 50));
                }
            } else {
                for (int i : class3) {
                    System.out.printf(sql, s, i, (int) (Math.random() * 50 + 50));
                }
            }
        }

    }

    @Test
    public void test5(/*老师对课程和对班级*/) throws IOException, InterruptedException {
        int[] courseid = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] name = {"唐老师", "高老师", "李老师", "邓老师", "刘老师", "郑老师", "王老师", "王老师", "高老师"};
        int tid = 1001;
        for (int i = 0; i < courseid.length; i++) {
            System.out.printf("INSERT INTO teacher (tId, tName, tPass, courseId) VALUES (%d, '%s', '123456', %d);\n", tid++, name[i], courseid[i]);
        }
    }

    @Test
    public void test6(/**/) throws IOException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map.put("1001", "1");
        map.put("1002", "2");
        map.put("1003", "3");
        map.put("1004", "4");
        map.put("1005", "5");
        map.put("1006", "6");
        map.put("1007", "7");
        map.put("1008", "8");
        map.put("1009", "9");
        map1.put("1","17203");
        map1.put("2","17203");
        map1.put("3","17203");
        map1.put("4","17203");
        map1.put("6","17203");
        map2.put("1","17202");
        map2.put("2","17202");
        map2.put("3","17202");
        map2.put("4","17202");
        map2.put("5","17202");
        map2.put("7","17202");
        String sql = "INSERT INTO teacherToClass (tId, classId) VALUES (%s, %s);\n";
        for (Map.Entry<String, String> en : map.entrySet()) {
            if (map1.containsKey(en.getValue())){
                System.out.printf(sql,en.getKey(),map1.get(en.getValue()));
                map1.remove(en.getValue());
            }
            if (map2.containsKey(en.getValue())){
                System.out.printf(sql,en.getKey(),map2.get(en.getValue()));
                map2.remove(en.getValue());
            }
        }
    }
}

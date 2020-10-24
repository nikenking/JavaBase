package com.dell.SepDay25;

import java.io.*;
import java.util.*;

public class Service {
    public static List<Map<String,List<String>>> getMsg(String Url) throws IOException {//返回三张Map(教室->教师，教师->学生，学生->课程)
        File file = new File(Url);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        List<Map<String, List<String>>> list = new ArrayList<>();
        Map<String, List<String>> classRoom = new HashMap<>();//每个教室对应的老师
        Map<String,List<String>> teacher = new HashMap<>();//每个教师对应的学生
        Map<String,List<String>> student = new HashMap<>();//每个学生对应的课程
        while ((line = br.readLine()) != null) {
            String[] buf = line.split(" ");
            if (!classRoom.containsKey(buf[0])){//若已存有该班级
                classRoom.put(buf[0],new ArrayList<String>(Collections.singletonList(buf[1])));//创建新班级
            }else if(!classRoom.get(buf[0]).contains(buf[1])){//已存在该班级,且不存在该老师
                classRoom.get(buf[0]).add(buf[1]);//班级加个新老师
            }
            if (!teacher.containsKey(buf[1])){//若已存有该教师
                teacher.put(buf[1],new ArrayList<String>(Collections.singletonList(buf[2])));//创建新班级
            }else if(!teacher.get(buf[1]).contains(buf[2])){//已存在该教师,且不存在该学生
                teacher.get(buf[1]).add(buf[2]);//教师加个新学生
            }
            if (!student.containsKey(buf[2])){//学生添加课程
                student.put(buf[2],new ArrayList<>(Arrays.asList(buf[3].split(","))));
            }
        }
        list.add(classRoom);
        list.add(teacher);
        list.add(student);
        br.close();
        return list;
    }
}

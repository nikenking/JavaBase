package com.dell.SepDay14;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.*;


public class DayTest2 {
    @Test
    public void test1(/*字符统计*/){
        String str = "fjiosdnfoudfhnwjdfbhuisabfdfisbfiusdf";
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        Map<String,Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s)){
                map.put(s,1);
            }else map.put(s,map.get(s)+1);
        }
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            buffer.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        buffer.deleteCharAt(buffer.length()-1);
        System.out.println(buffer);
    }
    @Test
    public void test2(/*新建map*/){
        List<String> list1 = new ArrayList<>(Arrays.asList("黑龙江省,浙江省,江西省,广东省,福建省".split(",")));
        List<String> list2 = new ArrayList<>(Arrays.asList("哈尔滨,杭州,南昌,广州,福州".split(",")));
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i),list2.get(i));
        }
        for (Map.Entry<String, String> en : map.entrySet()) {
            System.out.println(en.getKey() + ":" + en.getValue());
        }
    }
    @Test
    public void test3(/*当前java文件下的所有class文件名*/) throws IOException {
        File f1 = new File("E:\\扬州戴尔\\jdk-9_汉化版.CHM");
//        System.out.println(f1.length()/1024/1024);
        File f2 = new File(this.getClass().getResource("").getPath());
        File[] files = f2.listFiles();
        for (File file : files) {
            String[] temp = file.getAbsolutePath().split("\\\\");
            System.out.println(temp[temp.length-1].split("\\.")[0]);
        }
    }
}

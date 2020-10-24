package com.dell.SepDay15;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;


public class DayTest {
    @Test
    public void test1(/*字符统计*/) {
        String str = "fjiosdnfoudfhnwjdfbhuisabfdfisbfiusdf";
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else map.put(s, map.get(s) + 1);
        }
        StringBuffer buffer = new StringBuffer();
        for (Entry<String, Integer> entry : map.entrySet()) {
            buffer.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        System.out.println(buffer);
    }

    @Test
    public void test2(/*新建map*/) {
        List<String> list1 = new ArrayList<>(Arrays.asList("黑龙江省,浙江省,江西省,广东省,福建省".split(",")));
        List<String> list2 = new ArrayList<>(Arrays.asList("哈尔滨,杭州,南昌,广州,福州".split(",")));
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), list2.get(i));
        }
        for (Entry<String, String> en : map.entrySet()) {
            System.out.println(en.getKey() + ":" + en.getValue());
        }
    }

    @Test
    public void test3(/*当前java文件下的所有class文件名*/) throws IOException {
        File f1 = new File("E:\\扬州戴尔\\jdk-9_汉化版.CHM");
//        System.out.println(f1.length()/1024/1024);
        File f2 = new File(this.getClass().getResource("").getPath());
        File[] files = f2.listFiles();
        assert files != null;
        for (File file : files) {
            String[] temp = file.getAbsolutePath().split("\\\\");
            System.out.println(temp[temp.length - 1].split("\\.")[0]);
        }
    }

    @Test
    public void test4(/*File的一些基本操作*/) {
        File f1 = new File("E:\\扬州戴尔\\jdk-9_汉化版.CHM");
        System.out.println(f1.isFile());
        System.out.println(f1.getName());
        System.out.println(f1.getPath());
        System.out.println(f1.getParent());
        System.out.println(f1.getParentFile());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.length());
        System.out.println(f1.toString());
    }

    @Test
    public void test5() throws Exception {
        File file = new File("C:\\Users\\15756\\Desktop\\买卖股票的最佳时机问题整合-本周题量.txt");
        File file2 = new File("C:\\Users\\15756\\Desktop\\买卖股票的最佳时机问题整合-本周题量2.txt");
        if (!file2.exists()) {
            boolean newFile = file2.createNewFile();
            boolean delete = file2.delete();
        }
    }

    @Test
    public void test6(/*文本字数统计*/) throws IOException {
        Comparator cmp = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                Entry entry1 = (Entry) o;
                Entry entry2 = (Entry) t1;
                if (entry1.getValue() != entry2.getValue()) {
                    return -Integer.compare((Integer) entry1.getValue(), (Integer) entry2.getValue());
                } else return -String.valueOf(entry1.getKey()).compareTo(String.valueOf(entry2.getKey()));
            }
        };
        FileReader fr = new FileReader(new File("C:\\Users\\15756\\Desktop\\买卖股票的最佳时机问题整合-本周题量.txt"));
        String path = this.getClass().getResource("").getPath()+"account.txt";
        System.out.println(path);
        File outer = new File(path);
        if (!outer.exists()) {
            boolean newFile = outer.createNewFile();
        }
        FileWriter rw = new FileWriter(outer);
        int len;
        char[] buf = new char[1];
        Map<String, Integer> map = new HashMap<>();
        while ((len = fr.read(buf)) != -1) {
            String s = String.valueOf(buf[0]);
//            System.out.println(s);
            if (Pattern.matches("[\\u4e00-\\u9fa5|\\w]{0,}", s)) {
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else map.put(s, map.get(s) + 1);
            }
        }
        Set result = new TreeSet(cmp);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            result.add(entry);
        }
        for (Object o : result) {
            rw.write(String.valueOf(o)+"\n");
            System.out.println(o);
        }
        try {
            String[] cmd = new String[5];
            StringBuffer buffer  = new StringBuffer(path.replaceAll("\\\\","/"));
            buffer.deleteCharAt(0);
            path = String.valueOf(buffer);
            cmd[0] = "cmd";
            cmd[1] = "/c";
            cmd[2] = "start";
            cmd[3] = " ";
            cmd[4] = path;
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fr.close();
        rw.close();
    }


}

package com.dell.OctDay26;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class 运动会抽人 {
    @Test
    public void test1() throws IOException {
        List<String> list = Arrays.asList("李媛媛", "魏子超", "许向南", "王怀", "刘欣程", "俞俊",
                "张敏", "唐伟", "钦程", "李子钰", "张羽铖", "谭钊全", "贺缙殷", "白宏禹", "林祥",
                "郎金刚", "尚含溪", "郭永明", "曾蕊", "陈俊杰", "寇佳军", "郭波", "陈林", "高斌",
                "李远芳", "郑创", "杨锐", "刘宇航", "张永涛", "姚永晴", "潘雯", "杨为茗", "姜佳伟",
                "张磊", "彭然", "汪伟鹏", "付惠玲", "于敏亮", "吴凤岐", "李长茂", "陈亚", "何鑫",
                "官睿", "叶陈锋", "李佳澳", "彭涛", "付文飞", "买春生", "姜雯婷", "张培杰", "冯春",
                "雷职菱", "胡博", "九组替补", "黎俊杰", "任万林", "秦超", "张金辉", "孟贤洁", "徐阳");
        List<List<String>> group = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (String s : list) {
            temp.add(s);
            if (temp.size()==6){
                group.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        StringBuilder result = new StringBuilder();
        while (true){
            System.out.println("你想抽取几组?(一组十个人)");
            int i = new Scanner(System.in).nextInt();
            for (int k = 0; k < i; k++) {
                for (int g = 0; g < 10; g++) {
                    if (group.get(9).size()==0){
                        System.out.println("人已经抽完了");
                        File file = new File("C:\\Users\\15756\\Desktop\\运动会抽人结果.txt");
                        if (file.exists()){
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                            String format = df.format(new Date());
                            file = new File("C:\\Users\\15756\\Desktop\\运动会抽人结果"+format+".txt");
                        }
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        bw.write(result.toString());
                        bw.close();
                        return;
                    }
                    List<String> team = group.get(g);
                    Collections.shuffle(team);
                    System.out.printf("%s(%d组)\t",team.get(0),g+1);
                    result.append(team.get(0)).append("(").append(g + 1).append("组)");
                    team.remove(0);
                }
                System.out.println();
                result.append("\n");
            }
        }
    }
}

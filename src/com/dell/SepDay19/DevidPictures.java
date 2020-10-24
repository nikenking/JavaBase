package com.dell.SepDay19;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*图片分类*/
public class DevidPictures {
    public static void changeName(File file){
        for (File listFile : file.listFiles()) {//遍历目录下所有以正则命名的文件改名
            if (listFile.isDirectory())changeName(listFile);
            else {
                Matcher m = Pattern.compile("(.*?)(\\d+)鸡").matcher(listFile.toString());
                while (m.find()) {
                    listFile.renameTo(new File(m.group(1)+"\\"+(Integer.parseInt(m.group(2)))+"鸡.png"));
                }
            }
        }
    }
    @Test
    public void test1(/*将图片根据qq的截图名称分类进对应的文件夹*/) throws IOException {
        String path = "C:\\Users\\15756\\Pictures";
        String desktop = "C:\\Users\\15756\\Desktop";
        File file = new File(desktop);
        for (File li : file.listFiles()) {
            Matcher m = Pattern.compile("截图(\\d{4})(\\d{2})(\\d{2})").matcher(li.toString());
            while (m.find()) {
                String year = m.group(1);
                String month = m.group(2);
                String day = m.group(3);
                File mother = new File(path + "\\" + year + "年" + month + "月" + day + "日");
                if (!mother.exists()) mother.mkdir();
                li.renameTo(new File(path + "\\" + year + "年" + month + "月" + day + "日\\" +
                        (mother.listFiles() == null ? 1 : mother.listFiles().length + 1) + "鸡.png"));
            }
        }
        java.awt.Desktop.getDesktop().open(new File(path));
//        changeName(file);
    }
}

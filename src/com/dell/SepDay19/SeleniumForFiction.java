package com.dell.SepDay19;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumForFiction {
    public static boolean writeDown(/*提取标题，不成功返回，成功，写入到特定路劲，按标题命名*/WebDriver driver, int page) throws IOException {
        driver.get("https://m.lyreader.com/r/11061/" + page + ".html");
        Matcher contain = Pattern.compile("(?<=<p>).*?(?=</p>)").matcher(driver.getPageSource());
        Matcher title = Pattern.compile("第\\d+章\\s*[\\u4e00-\\u9fa5]+").matcher(driver.getPageSource());
        while (title.find()) {
            StringBuffer buffer = new StringBuffer();
            while (contain.find()) {
                buffer.append(contain.group().replaceAll("&.*?;", "\t")
                        .replaceAll("（.*?）", "").replaceAll("<.*?>", ""));
            }
            String Title = title.group();
            FileWriter fw = new FileWriter(new File("D:\\FictionStore\\" + Title + ".txt"));
            fw.write(Title + "\n");
            fw.write(String.valueOf(buffer));
            fw.close();
            return true;
        }
        return false;
    }

    public static String writeDown2(/*提取标题和下一页链接，都成功则写入，按标题命名*/WebDriver driver) throws IOException {
        Matcher contain = Pattern.compile("(?<=<div id=\"content\">)[\\s|\\S]*?(?=<script>)").matcher(driver.getPageSource());/*([\u4e00-\u9fa5|“].*?)(?=<br>)*/
        Matcher title = Pattern.compile("第.*?章.*?[\\u4e00-\\u9fa5]+").matcher(driver.getPageSource());
        Matcher next = Pattern.compile("(?<=章节列表</a> → <a href=\")(.*?)(?=\" target=\"_top\" class=\"next\">下一章)").matcher(driver.getPageSource());//加上开头
        while (title.find() && next.find() && contain.find()) {
            String Title = title.group();
            String Next = "https://www.dingdiann.com" + next.group(1);
            FileWriter fw = new FileWriter(new File("D:\\FictionStore\\" + Title + ".txt"));
            fw.write(Title + "\n");
            fw.write(contain.group());
            fw.close();
            return Next;
        }
        return null;
    }

    @Test
    public void test1(/*简单的遍历链接数量，开窗口，找标题，下数据*/) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        int page = 15160;
        WebDriver driver = new ChromeDriver();
        while (true) {
            while (!writeDown(driver, ++page)) {
                Thread.sleep(200);
                page--;
            }
        }
    }

    @Test
    public void test2(/*找下一页链接，找标题，下数据*/) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String link = "https://www.dingdiann.com/ddk69464/3828609.html";
        driver.get(link);
        do {
            while ((link = writeDown2(driver)) == null) {
                Thread.sleep(200);
            }
            System.out.println("得到非空链接：" + link + "开始链入");
            driver.get(link);
        } while (true);

    }

    @Test
    public void test3(/*网易云某歌单前二十首歌地址*/) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/#/playlist?id=4901511925");
        driver.switchTo().frame("g_iframe");
        Matcher m = Pattern.compile("/song\\?id=(.*?)").matcher(driver.getPageSource());
        String head = "http://music.163.com";
        while (m.find()) {
            System.out.println(head + m.group());
        }
        driver.close();
    }

    @Test
    public void test4(/**/) throws IOException, InterruptedException {
        File file = new File("C:\\Users\\15756\\Desktop\\show.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int len;
        StringBuilder buf = new StringBuilder();
        String line;
        int index = 1;
        char[] chars = new char[1024];
        while ((line = br.readLine()) != null) {
            buf.append(index).append(line).append("\n");
            index++;
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\15756\\Desktop\\show2.txt")));
        bw.write(String.valueOf(buf));
        bw.close();
    }

    @Test
    public void test5(/**/) throws IOException, InterruptedException {
        File file = new File("C:\\Users\\15756\\Desktop\\show.txt");
        RandomAccessFile rac = new RandomAccessFile(file, "r");
        StringBuffer buffer = new StringBuffer("");
        long len = file.length();
        while (len > 3) {
            len--;
            rac.seek(len);
            int len1 = (char) rac.readByte();
            if (len1 <= 128 && len1 >= 0) {
                buffer.append((char) (len1) + "");
            } else {
                len--;
                rac.seek(--len);
                byte[] bytes = new byte[3];
                // bytes被复制为连续3个字节
                rac.readFully(bytes);
                buffer.append(new String(bytes));
            }
        }
        System.out.println(buffer);
        rac.close();
    }


}

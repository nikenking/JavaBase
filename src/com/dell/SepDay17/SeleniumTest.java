package com.dell.SepDay17;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        String keyword = new Scanner(System.in).nextLine();
        WebDriver driver = new ChromeDriver();
        driver.get("https://pic.sogou.com/pics?query="+keyword+"&w=05009900");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0;i<5; i++) {
            List<WebElement> img = driver.findElements(By.tagName("img"));
            for (WebElement item : img) {
                String src = item.getAttribute("src");
                if (!map.containsKey(src)){
                    map.put(src,map.size()+1);
                    System.out.println(src);
                }
            }
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(100);
        }
        System.out.println("图片链接收集完成，准备开始下载");
        Thread.sleep(1000);
        for (String s : map.keySet()) {
            try {
                Download2.download(s,"D:\\ImgStore\\"+map.get(s) + keyword + ".jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.close();
    }
}

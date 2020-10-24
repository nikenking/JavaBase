package com.dell.Day31;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

public class DataTesting {
    public static void useDate() throws ParseException /*Date和SimpleDateFormat的基本使用*/{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String simple = sdf.format(date);
        String simple2 = "1999-06-03";
        String simple3 = "2000-01-16";
        Date now = sdf.parse(simple);
        Date birth = sdf.parse(simple2);
        Date Tbirth = sdf.parse(simple3);
        long len = now.getTime()-birth.getTime();
        long len2 = now.getTime() - Tbirth.getTime();
        long div = 1000L * 3600L * 24L * 365L;
        long day = (1000L*3600L*24L);
        System.out.println("你已经活了"+(len/div)+"年，总计"+(len)/day+"天"+"和第二位相差"+(len-len2)/day+"天");
    }
    public static void main(String[] args) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(date));
        System.out.println(localDateTime);
//        System.out.println(localDateTime);
//        System.out.println(localDateTime.getDayOfYear());//一年多少天
//        LocalDateTime localDateTime1 = localDateTime.plusMonths(10);//超范围自动往后移动
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
//        DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);//只能解析SHORT的。LONG要报错，耗费20分钟查出来。。。
//        String s1 = dtf3.format(localDateTime);

    }
}

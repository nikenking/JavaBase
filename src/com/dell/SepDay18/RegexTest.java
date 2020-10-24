package com.dell.SepDay18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String text = "dadwdfd@163.com fds fafa sdfw e;ff w regex.java <i class=\"fa fa-cogs\"></i>e; f  ,f we. regex2.java";
//        一：String reg = "<(\\w+).*?\\1>";//分组(适用于寻找标签)
//        二：String reg = ".*?(?=.java)";//断言---以什么结尾的(适用于寻找以特定标识结尾的文件名)/*(?!\\d+)-
//        👆不以数字结尾的||(?<=\\d+)-以数字开头的||(?<!\\d+)前面不以数字开头的!!!写在匹配字符串前面！！！,写在前面长度范围只能使用{}来表示*/
//        三：String reg = "(?<!\\w)[a-z]{3,5}@\\w+.\\w+";//邮箱运用
//        四：System.out.println("liusan 20 90.0F".replaceAll("([^\\s]+(?=\\s|))", "\"$1\""));//将以空格或无东西结尾的非空字符串打上双引号,运用$符号得到序号对象
//        mathcer.find()表示指针往下移动,若存在则mathcer.group()匹配内容也存在，可以往group里赛参数，细分分组，0表示所有,1表示第一个

//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }
    }
}


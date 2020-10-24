package com.dell.UserManager.Util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    //    public static boolean nameCheck(String s){
//        String[] arr = s.split("");
//        Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(s);
//        if (matcher.find()){
//            return  matcher.group(0).length()==arr.length;
//        }
//        return false;
//    }
//    public static boolean emailCheck(String s){
//        Matcher matcher = Pattern.compile(".*[\\d|\\w]{2,15}@[\\d|\\w]+\\.\\w+").matcher(s);
//        if (matcher.find()){
//            System.out.println(matcher.group(0));
//            return true;
//        }return false;
//    }
    public boolean genderCheck(String sex){

        if("m".equals(sex)|| "M".equals(sex) || "F".equals(sex) || "f".equals(sex) ){
            return true;
        }else {
            return false;
        }
    }
    public boolean nameCheck(String word) {//名字格式判断
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) || word.length() > 10 || word.length() < 2) {
                return false;
            }
        }
        return true;
    }

    public boolean emailCheck(String email) {//邮箱格式判断
        String emailPattern = "[0-9a-zA-Z_\\-]+@[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+){1,}";
        return email.matches(emailPattern) && email.length() <= 18;
    }

    public boolean telCheck(String str) {
        boolean flag = false;
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57) {
                System.out.println("请输入纯数字");
                return flag;
            } else {
                flag = true;
            }
        }
        if (str.length() != 11) {
            flag = false;
            return false;
        }
        return flag;
    }

    public boolean ageCheck(String age) {
        boolean flag = false;
        for (int i = age.length(); --i >= 0; ) {
            int chr = age.charAt(i);
            if (chr < 48 || chr > 57) {
                return flag;
            } else {
                flag = true;
            }
        }
        int i = Integer.valueOf(age);
        if (i < 0 || i > 130) {
            flag = false;
            return flag;
        }
        return flag;
    }

    public boolean numCheck(String num) {
        for (int i = num.length(); --i >= 0; ) {
            int chr = num.charAt(i);
            if (chr < 48 || chr > 57) {
                System.out.println("请输入㊣整数");
                return false;
            }
        }
        return true;
    }
}

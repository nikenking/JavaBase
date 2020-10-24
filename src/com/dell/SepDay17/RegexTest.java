package com.dell.SepDay17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String text    =  "John writes about this, and John wri \n \t tes about that," +
                " and John writes aabout everything . fsffsfthing";
//        String patternString1 = "[^\\w|^\\s]";
        String patternString1 = "fsf{2}thing";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            System.out.println("found: " + matcher.group(0));
        }
    }
}

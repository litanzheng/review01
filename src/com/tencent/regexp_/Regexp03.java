package com.tencent.regexp_;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示限定符的使用
public class Regexp03 {
    public static void main(String[] args) {
//        String content="a111111aaahello";
        String content="abc-123";
//        String regStr="\\d{2}";
//        String regStr="\\d{2,5}";
//        String regStr="1+";
//        String regStr="(a1)?";
        String regStr="^[a-z]+\\-[0-9]+";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}

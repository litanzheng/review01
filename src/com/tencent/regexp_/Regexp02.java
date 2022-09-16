package com.tencent.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp02 {
    public static void main(String[] args) {
        String content="a11c8ab  _c@ABC";
//        String regStr="[a-z]";
//        String regStr="\\D";
//        String regStr="\\W";
//        String regStr="\\S";
        String regStr="\\s";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}

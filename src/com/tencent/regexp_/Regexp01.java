package com.tencent.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp01 {
    public static void main(String[] args) {
        String content="你好呀  hello  你好 ";
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(content);
        System.out.println(matcher.find());
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
//        }

    }
}

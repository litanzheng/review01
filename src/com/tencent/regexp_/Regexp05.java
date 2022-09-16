package com.tencent.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp05 {
    public static void main(String[] args) {
        String content="helloagda hsp edu jack";
        String regStr="hello.*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}

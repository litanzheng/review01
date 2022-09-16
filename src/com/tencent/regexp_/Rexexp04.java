package com.tencent.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式应用
public class Rexexp04 {
    public static void main(String[] args) {
//        String content="http://www.baidu.com";
        String content="http://";
        //验证汉字
//        String regStr="^[\u0391-\uffe5]*";

//        String regStr="^((http|https)://)([\\w-]+\\.)+[\\w-]+$";
//        String regStr="^([http]://)";
        String regStr="^([http]://)";


        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        }else {
            System.out.println("不满足格式");
        }
    }
}

package com.tencent.wrapper;

public class String02 {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s.toUpperCase());
        String S = "HELLO";
        System.out.println(S.toLowerCase());
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("宝钗");
//        s1.concat("林黛玉").concat("宝钗");
        System.out.println(s1);
        //分隔符使用 split返回的是String数组
        String poem ="E:\\aaa\\bbb";
        String[] split = poem.split("\\\\");
        for (String value : split) {
            System.out.println(value);
        }
        //toCharArray字符串转成字符数组
        char[] chars = s.toCharArray();
        byte[] bytes = s.getBytes();
        for (char v : chars) {
            System.out.println(v);
        }
    }
}

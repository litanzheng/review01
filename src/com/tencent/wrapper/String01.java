package com.tencent.wrapper;

public class String01 {
    public static void main(String[] args) {
        String name = "hello,jack";
        String str = name.substring(5);
        System.out.println(str);
        int index = name.indexOf("ja");
        System.out.println(index);
    }
}

package com.tencent.wrapper;
//练习题
public class StringBuffer02 {
    public static void main(String[] args) {
        String price = "14545646872345.45";
        StringBuffer buffer = new StringBuffer(price);

        for (int i = buffer.lastIndexOf(".")-3; i >0 ; i-=3) {
            buffer.insert(i,",");
        }
//        int index = buffer.lastIndexOf(".");
//        buffer.insert(index-3,",");
        System.out.println(buffer);

        int h = buffer.indexOf("4");
        System.out.println(h);
    }
}

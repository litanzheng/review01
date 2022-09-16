package com.tencent.wrapper.homework;

public class StringReverse {
    public static void main(String[] args) {
        String str = "abcde";
        str = reverseString(str, 0, str.length() - 1);
        System.out.println(str);
    }

    public static String reverseString(String str,int start,int end){
        char[] chars = str.toCharArray();
        char temp=' ';
        for (int i = start, j = end; j>i ; i++,j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}

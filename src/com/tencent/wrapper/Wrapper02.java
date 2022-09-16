package com.tencent.wrapper;

/*
  包装类转为String
  String转为包装类
 */
public class Wrapper02 {
    public static void main(String[] args) {
        Integer i = 100;
        String str = i + "";
        String str2 = i.toString();
        String str3 = String.valueOf(i);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);

        String str4 = "123";
        Integer i2 = Integer.parseInt(str4);
        Double d = Double.parseDouble(str4);
        System.out.println(i2);
        System.out.println(d);
    }
}

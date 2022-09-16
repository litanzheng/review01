package com.tencent.wrapper;


// 基本类型转为包装类  包装类转为基本类型
public class Wrapper01 {
    public static void main(String[] args) {
        int i = 100;
        Integer i2 = Integer.valueOf(i);
        Integer i3 = new Integer(i);

        Integer i4 = 200;
        int i5 = i4.intValue();
    }
}

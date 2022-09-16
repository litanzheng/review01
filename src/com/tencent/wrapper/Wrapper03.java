package com.tencent.wrapper;

//练习题
public class Wrapper03 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);
        //  integer 小于 127会直接从常量池获取 大于 这个数会直接new 出来
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);
    }
}

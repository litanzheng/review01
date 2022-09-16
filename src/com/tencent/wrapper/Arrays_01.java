package com.tencent.wrapper;

import java.util.Arrays;

public class Arrays_01 {
    public static void main(String[] args) {
        //Arrays 遍历
        Integer[] integers ={10,20,30};
        int[] ints ={60,50,40};
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(ints));
        //Arrays 排序
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

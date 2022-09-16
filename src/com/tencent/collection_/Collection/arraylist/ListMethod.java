package com.tencent.collection_.Collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//list方法和其特点
public class ListMethod {
    public static void main(String[] args) {

        List list = new ArrayList<>();
        list.add("tom");
        list.add("jack");
        list.add("lucy");
        list.add("tom");

        System.out.println(list.get(0));

        //数组中默认值为0;
        int[] arrays = new int[10];
        System.out.println(Arrays.toString(arrays));
    }
}

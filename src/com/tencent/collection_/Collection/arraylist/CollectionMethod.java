package com.tencent.collection_.Collection.arraylist;

import java.util.ArrayList;
import java.util.List;
//collection实现类特有的方法
public class CollectionMethod {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("Joey");
        list.add(213);
        list.add(true);
        System.out.println(list.toString());
    }
}

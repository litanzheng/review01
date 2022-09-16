package com.tencent.collection_.collections;

import java.util.ArrayList;

//工具类
public class Collections {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("jack");
        arrayList.add("john");
        arrayList.add("smith");
        java.util.Collections.reverse(arrayList);
        System.out.println(arrayList);
        java.util.Collections.sort(arrayList);
    }
}

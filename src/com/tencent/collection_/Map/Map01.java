package com.tencent.collection_.Map;

import java.util.HashMap;
import java.util.Hashtable;

//Map接口实现类特点
public class Map01 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(null,123);
        hashMap.put(null,456);
        System.out.println(hashMap);
        Hashtable hashtable = new Hashtable();
        hashtable.put(123,null);
    }
}

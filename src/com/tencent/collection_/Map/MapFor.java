package com.tencent.collection_.Map;

import java.util.*;

//Map遍历 共六种
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("John","lucy");
        map.put("Joey","Robin");
        map.put("Jack","Smith");
        map.put(null,"刘亦菲");
        map.put("John","Alice");//key 相同 value会替换 不同于set

        //第一组 先取出所有key 再得到value
        //(1)增强for
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key +" "+map.get(key));
        }
        System.out.println("====================");
        //(2)迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key +" "+map.get(key));
        }
        System.out.println("=========第二组===========");
        //第二组 把所有value取出来
        //这里可以使用所有Collection的方法
        Collection values = map.values();
        //增强for
        for (Object value : values) {
            System.out.println(value);
        }
        //迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value2 =  iterator1.next();
            System.out.println(value2);
        }
        System.out.println("=======第三组=============");
        //第三组 通过EntrySet 来获取 k-v
        Set entrySet = map.entrySet();
        //增强for
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey()+" "+m.getValue());
//            System.out.println(entry);
        }
        //迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry =  iterator2.next();
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}

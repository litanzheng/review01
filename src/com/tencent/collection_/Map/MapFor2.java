package com.tencent.collection_.Map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapFor2 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }

        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(map.get(key));
        }
    }

    @Test
    public void mapfor(){
        Map<String,String> map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue()+" "+entry);
        }

        System.out.println("=================");
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }
        iterator.remove();
        iterator = entries.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }
    }
}

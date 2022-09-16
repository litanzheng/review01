package com.tencent.internet.qq.qqserver.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ManageClientThreads {
    private static Map<String,ServerConnectClientThread> hm = new HashMap<>();

    public static Map<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    public static void addServerConnectClientThread(String uid, ServerConnectClientThread serverConnectClientThread){
        hm.put(uid,serverConnectClientThread);
    }
    public static void removeServerConnectClientThread(String uid){
        hm.remove(uid);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String uid){
        return hm.get(uid);
    }

    public static String getOnlineFriend(){
        Set<Map.Entry<String, ServerConnectClientThread>> entries = hm.entrySet();
        String onlineUserList="";
        for (Map.Entry<String, ServerConnectClientThread> entry : entries) {
           onlineUserList +=entry.getKey()+" ";
        }
        return onlineUserList;
//        Set<String> strings = hm.keySet();
//        for (String string : strings) {
//
//        }
    }
}

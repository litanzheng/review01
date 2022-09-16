package com.tencent.internet.qq.qqclient.service;

import java.util.HashMap;
import java.util.Map;

public class ManageClientConnectServerThread {
    private static Map<String,ClientConnectServerThread> hm = new HashMap<>();

    public static void addClientConnectServerThread(String uid,ClientConnectServerThread clientConnectServerThread){
        hm.put(uid,clientConnectServerThread);
    }

    public static ClientConnectServerThread getClientConnectServerThread(String uid){
        return hm.get(uid);
    }


}

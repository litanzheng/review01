package com.tencent.internet.qq.qqserver.service;

import com.tencent.internet.qq.qqclient.utils.Utils;
import com.tencent.internet.qq.qqserver.qqcommon.Message;
import com.tencent.internet.qq.qqserver.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class SendNewsToAll implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("请输入服务器要推送的内容");
            String news = Utils.readString();
            if ("exit".equals(news)){
                break;
            }
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_TOALL_MES);
            message.setSender("服务器");
            message.setConttent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器对所有人说:"+news);

            Map<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()){
                String onlineUserId = iterator.next();
                ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(onlineUserId);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }}

    }
}

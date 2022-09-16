package com.tencent.internet.qq.qqclient.service;

import com.tencent.internet.qq.qqserver.qqcommon.Message;
import com.tencent.internet.qq.qqclient.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MessageClientService {

    public void sendMessageToOne(String content,String uid,String getterid){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setConttent(content);
        message.setSender(uid);
        message.setGetter(getterid);
        message.setSendTime(new Date().toString());
        System.out.println(uid+" 对 "+getterid+" 说 "+content);

        try {
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(uid);
            ObjectOutputStream oos = new ObjectOutputStream(clientConnectServerThread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageToAll(String content,String uid){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TOALL_MES);
        message.setConttent(content);
        message.setSender(uid);
        message.setSendTime(new Date().toString());
        System.out.println(uid+" 对大家说 "+content);

        try {
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(uid);
            ObjectOutputStream oos = new ObjectOutputStream(clientConnectServerThread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

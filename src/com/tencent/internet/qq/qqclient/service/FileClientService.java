package com.tencent.internet.qq.qqclient.service;

import com.tencent.internet.qq.qqserver.qqcommon.Message;
import com.tencent.internet.qq.qqserver.qqcommon.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileClientService {


    public void sendFileToOne(String src,String desc,String senderId,String getterid){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSrc(src);
        message.setDesc(desc);
        message.setSender(senderId);
        message.setGetter(getterid);

        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);

            fileInputStream.read(fileBytes);
            message.setBytes(fileBytes);
            System.out.println("\n"+senderId+"给"+getterid+"发送文件:"+src+"到对方电脑目录:"+desc);
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(senderId);
            ObjectOutputStream oos = new ObjectOutputStream(clientConnectServerThread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

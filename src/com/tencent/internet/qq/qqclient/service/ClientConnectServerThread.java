package com.tencent.internet.qq.qqclient.service;

import com.tencent.internet.qq.qqserver.qqcommon.Message;
import com.tencent.internet.qq.qqserver.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    //该线程需要持有socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //因为这里需要和服务端通信 所以这里做成 无限循环
        while (true){
            System.out.println("客户端等待读取服务器端发来的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    String[] onlineUsers = message.getConttent().split(" ");
                    System.out.println("======当前在线用户列表=====");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println(onlineUsers[i]);
                    }

                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    System.out.println("\n"+message.getSender()+
                            "对"+message.getGetter()+"说"+message.getConttent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_TOALL_MES)){
                    System.out.println(message.getSender()+"对大家说"+message.getConttent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    System.out.println("\n"+message.getSender()+"给"+message.getGetter()+
                            "发文件:"+message.getSrc()+"到我的电脑目录"+message.getDesc());
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDesc());
                    fileOutputStream.write(message.getBytes());
                    fileOutputStream.close();
                    System.out.println("保存文件成功");
                }
                else {
                    System.out.println("其他类型的message 暂时不处理");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package com.tencent.internet.qq.qqclient.service;

import com.tencent.internet.qq.qqclient.qqcommon.MessageType;
import com.tencent.internet.qq.qqclient.qqcommon.User;
import com.tencent.internet.qq.qqserver.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {
    private User u = new User();
    private Socket socket;

    public boolean checkUser(String uid,String pwd){
        boolean b = false;
        u.setUserId(uid);
        u.setPassword(pwd);

        try {
            socket = new Socket(InetAddress.getLocalHost(),9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
//            socket.shutdownOutput();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){

                //创建一个线程和服务器保持通讯
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                ManageClientConnectServerThread.addClientConnectServerThread(uid,clientConnectServerThread);
                b = true;
            }else {
                //登陆失败  关闭资源
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return b;

    }
    public void getOnlineFriend(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        try {
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            Socket socket1 = clientConnectServerThread.getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.exit(0);//关闭进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

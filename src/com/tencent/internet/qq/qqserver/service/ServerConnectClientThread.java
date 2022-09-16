package com.tencent.internet.qq.qqserver.service;


import com.tencent.internet.qq.qqserver.qqcommon.Message;
import com.tencent.internet.qq.qqserver.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

public class ServerConnectClientThread extends Thread{
    private Socket socket;

    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("服务器和客户端"+userId+"保持通讯");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender()+"要在线用户列表");
                    String onlineFriend = ManageClientThreads.getOnlineFriend();
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setGetter(message.getSender());
                    message2.setConttent(onlineFriend);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender()+"退出");
                    ManageClientThreads.removeServerConnectClientThread(userId);
                    socket.close();
                    break;//跳出while循环使线程结束 这里不能忘记
                }else if (message.getMesType().equals(MessageType.MESSAGE_TOALL_MES)){
                    Map<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()){
                        String onlineUserid = iterator.next();
                        if (!onlineUserid.equals(message.getSender())){
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onlineUserid).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getSender());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                }
                else {
                    System.out.println("其他类型message服务器暂时不处理");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

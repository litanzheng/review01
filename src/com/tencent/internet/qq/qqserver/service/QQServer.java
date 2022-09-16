package com.tencent.internet.qq.qqserver.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.tencent.internet.qq.qqserver.qqcommon.Message;
import com.tencent.internet.qq.qqserver.qqcommon.MessageType;
import com.tencent.internet.qq.qqclient.qqcommon.User;

//这是服务端 在监听9999端口 等待服务
public class QQServer {
    private ServerSocket ss = null;

    private static HashMap<String, com.tencent.internet.qq.qqserver.qqcommon.User> hm = new HashMap<>();
    static {
        hm.put("100",new com.tencent.internet.qq.qqserver.qqcommon.User("100","123456"));
        hm.put("200",new com.tencent.internet.qq.qqserver.qqcommon.User("200","123456"));
        hm.put("300",new com.tencent.internet.qq.qqserver.qqcommon.User("300","123456"));
        hm.put("至尊宝",new com.tencent.internet.qq.qqserver.qqcommon.User("至尊宝","123456"));
        hm.put("紫霞仙子",new com.tencent.internet.qq.qqserver.qqcommon.User("紫霞仙子","123456"));
        hm.put("菩提老祖",new com.tencent.internet.qq.qqserver.qqcommon.User("菩提老祖","123456"));
    }

    public boolean checkUser(String uid,String pwd){
        com.tencent.internet.qq.qqserver.qqcommon.User user = hm.get(uid);
        if (user == null){
            return false;
        }
        if (!user.getPassword().equals(pwd)){
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            System.out.println("服务器端在9999端口监听");
            new Thread(new SendNewsToAll()).start();
            ss = new ServerSocket(9999);
            while (true){
                Socket socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//                Object o = ois.readObject();
//                User u = (User) o;
                User u = (User) ois.readObject();
                Message message = new Message();
                if (checkUser(u.getUserId(), u.getPassword())){
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复给客户端
                    oos.writeObject(message);
                    //启动线程和客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start();
                    //把该线程对象放在集合里方便统一管理
                    ManageClientThreads.addServerConnectClientThread(u.getUserId(),serverConnectClientThread);

                }else {
                    System.out.println("用户="+u.getUserId()+"密码="+u.getPassword()+"登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            throw new RuntimeException(e);
        }finally {
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

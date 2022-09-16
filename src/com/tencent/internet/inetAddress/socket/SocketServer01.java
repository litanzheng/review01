package com.tencent.internet.inetAddress.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer01 {
    public static void main(String[] args) throws IOException {
        //要求本机没有其他服务监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听 等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("socket="+socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen=inputStream.read(bytes))!=-1){
//            System.out.println(bytes)错误;
            System.out.println(new String(bytes,0,readLen));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

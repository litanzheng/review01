package com.tencent.internet.inetAddress.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端启动");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}

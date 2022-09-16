package com.tencent.internet.inetAddress.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.125.116",9999);
        System.out.println("客户端 socket返回="+socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        String str = "hello 你好";
        outputStream.write(str.getBytes());
        outputStream.close();
        socket.close();
        System.out.println("客户端退出程序");
    }
}

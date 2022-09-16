package com.tencent.internet.inetAddress.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//字符流
public class SocketServer03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端已经启动 在9999监听");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("hello client 字符流");
        bw.flush();//如果使用的是字符流 需要手动刷新,否则数据不会写入通道
        socket.shutdownOutput();//设置结束标记

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}

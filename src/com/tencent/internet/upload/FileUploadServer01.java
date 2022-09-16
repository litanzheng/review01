package com.tencent.internet.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器 server 01启动");
        Socket socket = serverSocket.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        String path = "d:\\仙女.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write(bytes);
//        socket.shutdownOutput();


        //回复收到图片
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.newLine();
//        socket.shutdownOutput();

        bw.flush();

        bw.close();
        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();

    }
}

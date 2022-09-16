package com.tencent.internet.homework;

import com.tencent.internet.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len=0;
        String name = "";
        while ((len = inputStream.read(bytes))!=-1){
            name+=new String(bytes,0,len);
        }
        System.out.println("客户端希望下载文件名"+name);

        String fileName="";
        if ("高山流水.png".equals(name)){
            fileName="e:\\高山流水.png";
        }else {
            fileName="e:\\小仙女.jpg";
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] data = StreamUtils.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        socket.shutdownOutput();

        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

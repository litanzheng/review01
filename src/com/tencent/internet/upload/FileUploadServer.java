package com.tencent.internet.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动在9999端口监听");
//        Socket socket = serverSocket.accept();
//        InputStream inputStream = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        int readLen=0;
//        while ((readLen=inputStream.read(bytes))!=-1){}
//        OutputStream outputStream = socket.getOutputStream();
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);

        String path="d:\\小可爱.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write(bytes);
//        socket.shutdownOutput();

        //向客户端回复收到图片
        //以字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
//        socket.shutdownOutput();

        bw.newLine();
        bw.flush();
//        socket.shutdownOutput();  //  如果用socket.shutdownOutput()它要放后面


        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}

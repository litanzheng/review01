package com.tencent.internet.homework;

import com.tencent.internet.upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Homework02Client {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入要下载的文件名");
        Scanner scanner = new Scanner(System.in);
        String downloadFileName= scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        //读取返回的文件
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        String downloadPath="d:\\"+downloadFileName+".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(downloadPath));
        bos.write(bytes);

        bos.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}

package com.tencent.internet.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端启动");
//        FileInputStream fileInputStream = null;
//        fileInputStream = new FileInputStream("e:\\小仙女.jpg");
//        byte[] bytes = new byte[1024];
//        int readLen=0;
//        while ((readLen = fileInputStream.read(bytes))!=-1){}
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write(bytes);
//        socket.shutdownOutput();
        String path= "e:\\小仙女.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);
//        outputStream.write(bytes);
        socket.shutdownOutput();//设置结束标记

        //读取服务器回复
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
//        InputStream inputStream = socket.getInputStream();
//        String s = StreamUtils.streamToString(inputStream);
//        System.out.println(s);
//        inputStream.close();


        bis.close();
        bos.close();
        br.close();
        socket.close();
    }
}

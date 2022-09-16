package com.tencent.internet.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileUploadClient01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        String path="e:\\小仙女.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));

        byte[] bytes = StreamUtils.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();
        bis.close();

        //获取服务器发来的消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

        bos.close();
        socket.close();

    }
}

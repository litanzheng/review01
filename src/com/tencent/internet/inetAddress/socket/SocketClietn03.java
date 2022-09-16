package com.tencent.internet.inetAddress.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//字符流
public class SocketClietn03 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回="+socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter ops = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(ops);
        bufferedWriter.write("hello server 字符流");
        //这句话一定要有
        bufferedWriter.flush();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }

        br.close();
        bufferedWriter.close();
        socket.close();
    }
}

package com.tencent.internet.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

        System.out.println("接收端等待接收数据");
        socket.receive(datagramPacket);

        //拆包数据
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data,0,length));

        bytes = "好的明天见".getBytes();
        datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9998);
        socket.send(datagramPacket);

        //关闭资源
        socket.close();
    }
}

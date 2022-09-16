package com.tencent.internet.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] data= "Hello 明天吃火锅".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),9999);
        socket.send(packet);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        data = datagramPacket.getData();
        System.out.println(new String(data,0, length));
        socket.close();

    }
}

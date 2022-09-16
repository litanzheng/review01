package com.tencent.internet.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Api {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress ling = InetAddress.getByName("ling");
        System.out.println(ling);

        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);

        String hostName = byName.getHostName();
        System.out.println(hostName);
    }
}

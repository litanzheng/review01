package com.tencent.internet.qq.qqclient.utils;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(){
        String str = scanner.next();
        return str;
    }
}

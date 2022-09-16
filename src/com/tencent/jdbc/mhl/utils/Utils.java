package com.tencent.jdbc.mhl.utils;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(){
        String str = scanner.next();
        return str;
    }

    public static int readInt(){
        int i = scanner.nextInt();
        return i;
    }

    public static char readChar(){
        System.out.println("请确认是否预定[Y/N]");
        String str = scanner.next();
        return str.toUpperCase().charAt(0);
    }
}

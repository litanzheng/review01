package com.tencent.io.file;

import java.io.File;

public class FileMethod {
    public static void main(String[] args) {
        File file = new File("e:\\news.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getParent());
        System.out.println(file.length());

    }
}

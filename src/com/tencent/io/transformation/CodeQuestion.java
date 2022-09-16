package com.tencent.io.transformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String path = "e:\\news3.txt";
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String s = bf.readLine();
        System.out.println(s);
        bf.close();
    }
}

package com.tencent.io.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter01 {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\news4.txt"));
        printWriter.println("hhh 腾讯教育");
        printWriter.close();
    }
}

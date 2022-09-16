package com.tencent.io.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStream01 {
    public static void main(String[] args) throws IOException {
//        PrintStream printStream = new PrintStream(new FileOutputStream("e:\\news.txt"));
        PrintStream printStream = System.out;
        printStream.print("hello,printStream");
        printStream.write(12345674);
        printStream.close();
        System.setOut(new PrintStream("e:\\news.txt"));
        System.out.println("hello 韩顺平教育");
    }
}

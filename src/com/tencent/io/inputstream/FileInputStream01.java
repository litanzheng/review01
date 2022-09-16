package com.tencent.io.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\news2.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((readData = fileInputStream.read()) != -1){
                System.out.println((char) readData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            fileInputStream.close();
        }
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "e:\\news2.txt";
        int readLen = 0;
        byte[] buf = new byte[1024];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((readLen = fileInputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            fileInputStream.close();
        }
    }
}

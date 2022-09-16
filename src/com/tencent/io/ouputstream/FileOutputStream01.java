package com.tencent.io.ouputstream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() throws IOException {
        String filePath = "e:\\hello.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
//            fileOutputStream.write('a');
            String str = "hello,world";
//            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(),0,str.length());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            fileOutputStream.close();
        }
    }
}

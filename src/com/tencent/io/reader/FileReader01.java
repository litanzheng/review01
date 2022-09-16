package com.tencent.io.reader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader01 {
    public static void main(String[] args) {

    }

    @Test
    public void readFile() throws IOException {
        String pathName = "e:\\story.txt";
        FileReader fileReader = null;
        int data = ' ';
        try {
            fileReader = new FileReader(pathName);
            while ((data = fileReader.read())!= -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null){
                fileReader.close();
            }
        }
    }


    @Test
    public void readFile02() throws IOException {
        String pathName = "e:\\story.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] chars = new char[1024];
        try {
            fileReader = new FileReader(pathName);
            while ((readLen = fileReader.read(chars))!= -1){
                System.out.print(new String(chars,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null){
                fileReader.close();
            }
        }
    }
}

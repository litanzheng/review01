package com.tencent.io.writer;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter01 {
    public static void main(String[] args) {

    }
    @Test
    public void writeFile() throws IOException {
        String filePath = "e:\\hhh.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);
            fileWriter.write('H');
            fileWriter.write("hello,Robin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null){
                //必须要写的
                fileWriter.close();
            }
        }
    }
}

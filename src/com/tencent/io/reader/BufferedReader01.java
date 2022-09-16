package com.tencent.io.reader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader01 {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\story.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine())!= null){
            System.out.println(line);
        }
        bufferedReader.close();

    }
}

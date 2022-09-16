package com.tencent.io.writer;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter01 {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile01() throws IOException {
        String pathName = "e:\\news3.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathName));
        bufferedWriter.write("腾讯教育");
        //包装流关闭外层流就可
        bufferedWriter.close();
    }
}

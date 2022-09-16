package com.tencent.io.writer;

import org.junit.jupiter.api.Test;

import java.io.*;

//使用 bufferedReader bufferedWriter进行文件的复制
public class BufferedCopy {
    public static void main(String[] args) {

    }

    @Test
    public void bufferedCopy() throws IOException {
        String srcFilePath = "d:\\story.txt";
//        String srcFilePath = "d:\\小仙女.jpg";  不能用
        String descFilePath = "e:\\storyCopy.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(descFilePath));
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("拷贝完毕");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader !=null){
                bufferedReader.close();
            }
            if (bufferedWriter !=null){
                bufferedWriter.close();
            }
        }
    }
}

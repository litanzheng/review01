package com.tencent.io.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    //new File(String pathName)
    public void file01(){
//        String filePath = "e://news.txt";
        String filePath = "e:\\news2.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    //方式2 new File(File parent,String )
    public void file02() throws IOException {
        File parentFile = new File("e:\\");
        String fileName = "news3.txt";
        File file = new File(parentFile, fileName);
        file.createNewFile();
    }

    @Test
    public void file03() throws IOException {
        String parentPath = "e:\\";
        String fileName = "news4.txt";
        File file = new File(parentPath, fileName);
        file.createNewFile();
    }
}

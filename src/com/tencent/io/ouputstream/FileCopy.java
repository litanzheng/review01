package com.tencent.io.ouputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {

    }

    @Test
    public void CopyFile() throws IOException {
        String srcFilePath = "d:\\小仙女.jpg";
        String destFilePath = "e:\\小可爱.jpg";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf))!= -1){
                fileOutputStream.write(buf,0, buf.length);
//                fileInputStream.write(buf);
//                不能用这个方法  会多写入数据 比如文件为1039  剩下的会再输入1024
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null){
                fileInputStream.close();
            }
            if (fileOutputStream != null){
                fileOutputStream.close();
            }
        }

    }
}

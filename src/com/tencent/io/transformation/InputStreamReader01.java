package com.tencent.io.transformation;

import java.io.*;

//转换流解决乱码  将字节流转为字符流 指定编码集
//FileInputStream 字节流转成字符流 InputStreamReader
public class InputStreamReader01 {
    public static void main(String[] args) throws IOException {
        String path = "e:\\news3.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"GBK");
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());
//        isr.close();
        //关闭外层流即可
        br.close();

    }
}

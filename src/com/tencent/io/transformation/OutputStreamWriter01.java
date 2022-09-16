package com.tencent.io.transformation;


import java.io.*;

//FileOutputStream 字节流 转成字符流 OutputStreamWriter  同时设定编码格式
public class OutputStreamWriter01 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\hsp.txt";
        OutputStreamWriter ows = new OutputStreamWriter(new FileOutputStream(filePath),"gbk");
//        BufferedWriter bw = new BufferedWriter(ows);
        ows.write("hspyyds");
        ows.close();
    }
}

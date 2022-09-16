package com.tencent.io.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//properties 读取mysql.properties文件
public class Properties01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //把指定文件加载到properties属性里
        properties.load(new FileReader("src\\mysql.properties"));
        properties.list(System.out);
        String ip = properties.getProperty("ip");
        String pwd = properties.getProperty("pwd");
        System.out.println(ip);
        System.out.println(pwd);
    }


}

package com.tencent.io.properties_;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//properties创建配置文件 修改文件属性
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset","utf-8");
        properties.setProperty("username","john");
        properties.setProperty("password", String.valueOf(78));
        properties.store(new FileWriter("src\\mysql2.properties"),null);
    }
}

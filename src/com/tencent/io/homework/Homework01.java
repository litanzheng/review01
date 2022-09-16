package com.tencent.io.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if (!file.exists()){
            if (file.mkdirs()){
                System.out.println(directoryPath+"创建成功");
            }else {
                System.out.println(directoryPath+"创建失败");
            }
        }
        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);
        if (!file.exists()){
            if (file.createNewFile()){
                System.out.println(filePath + "创建成功");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("hello homework01");
                bw.close();
            }else {
                System.out.println("创建失败");
            }
        }else {
            System.out.println("文件已经存在 不再重复创建");
        }
    }
}

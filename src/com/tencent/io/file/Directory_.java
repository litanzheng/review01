package com.tencent.io.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory_ {
    public static void main(String[] args) {

    }
    @Test
    //删除文件
    public void m1(){
        String filePath = "e:\\news.txt";
        File file = new File(filePath);
        if (file.exists()){
            if(file.delete()){
                //file.delete()返回boolean值
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("文件不存在");
        }
    }

    //删除目录
    @Test
    public void m2(){
        String filePath = "e:\\demo02";
        File file = new File(filePath);
        if (file.exists()){
            if(file.delete()){
                //file.delete()返回boolean值
                System.out.println("删除成功");
            }
        }else {
            System.out.println("文件不存在");
        }
    }

    @Test
    public void m3(){
        String directoryPath = "e:\\demo\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()){
            System.out.println(directoryPath+"存在");
        }else {
            if (file.mkdirs()){
                System.out.println(directoryPath+"文件目录创建成功");
            }else {
                System.out.println(directoryPath+"创建失败");
            }
        }
    }
}

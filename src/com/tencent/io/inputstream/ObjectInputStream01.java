package com.tencent.io.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream01 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\data.dat";
        ObjectInputStream oos = null;
        try {
            oos = new ObjectInputStream(new FileInputStream(filePath));

            //这里 读取顺序必须和输出顺序一致
            System.out.println(oos.readInt());
            System.out.println(oos.readUTF());
            Object dog2 = oos.readObject();
//            dog2 = (Dog) dog2;
            System.out.println(dog2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            oos.close();
        }
    }
}

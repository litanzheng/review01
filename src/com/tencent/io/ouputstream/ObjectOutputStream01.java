package com.tencent.io.ouputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStream01 {
    public static void main(String[] args) throws IOException {
        //序列化后保存的文件格式按照它的格式保存
        String filePath = "e:\\data.dat";
        ObjectOutputStream oop = null;
        try {
            oop = new ObjectOutputStream(new FileOutputStream(filePath));
            oop.writeInt(100);
            //这里不能为oop.write(100);
            oop.writeUTF("腾讯教育"); //字符串用这个
            oop.writeObject(new Dog("大黄",8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            oop.close();
            System.out.println("序列化保存完毕");
        }
    }

}



//如果需要序列化某个类 需要实现 Serializable接口
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
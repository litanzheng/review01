package com.tencent.io.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

//这个类也要实现序列化
public class HomeWork02 implements Serializable{
    public static void main(String[] args) throws IOException {


    }

    @Test
    public void m1() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
        properties.list(System.out);
        String name = properties.getProperty("name")+"";
        int age = Integer.parseInt(properties.getProperty("age")+"");
        String color = properties.getProperty("color")+"";
        Dog dog = new Dog(name,age,color);
        System.out.println(dog);

        String path = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(dog);
        oos.close();
    }

    @Test
    public void m2() throws IOException, ClassNotFoundException {
        String path = "e:\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Dog dog = (Dog)ois.readObject();
        System.out.println(dog);
    }

    class Dog implements Serializable {
        private String name;
        private Integer age;
        private String color;

        public Dog(String name, Integer age, String color) {
            this.name = name;
            this.age = age;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}

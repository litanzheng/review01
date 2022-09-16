package com.tencent.generic_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericExercise01 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("jack",20));
        students.add(new Student("john",22));
        students.add(new Student("jim",21));

        for (Student student : students) {
            System.out.println(student);
        }

        HashMap<String, Student> hm = new HashMap<>();
        hm.put("jack",new Student("jack",20));
        hm.put("john",new Student("john",21));
        hm.put("jim",new Student("jim",22));
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
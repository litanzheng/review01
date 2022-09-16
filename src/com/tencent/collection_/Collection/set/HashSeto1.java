package com.tencent.collection_.Collection.set;

import java.util.HashSet;
import java.util.Objects;

public class HashSeto1 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee jack = new Employee("Jack", 21);
        Employee john = new Employee("John", 22);
        Employee Lucy = new Employee("Lucy", 24);
        System.out.println(hashSet.add(new Employee("Jack", 21)));
        System.out.println(hashSet.add(new Employee("Jack", 21)));
        System.out.println(hashSet.add(new Employee("Jack", 22)));
        System.out.println(hashSet.add(jack));
        hashSet.add(john);
        hashSet.add(Lucy);
        System.out.println(hashSet);

    }
}

class Employee{
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
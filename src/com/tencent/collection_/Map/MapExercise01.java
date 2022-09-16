package com.tencent.collection_.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise01 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put(1,new Employee("jack",3000.0,1));
        hashMap.put(2,new Employee("john",40000.0,2));
        hashMap.put(3,new Employee("smith",60000.0,3));

        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            Employee emp = (Employee) hashMap.get(key);
            if (emp.getSalary()> 18000){
                System.out.println(emp);
            }
        }

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object entry =  iterator.next();
            Map.Entry m = (Map.Entry)entry;
            Employee emp = (Employee) m.getValue();
            if (emp.getSalary()> 18000){
                System.out.println(emp);
            }
        }
    }
}

class Employee{
    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
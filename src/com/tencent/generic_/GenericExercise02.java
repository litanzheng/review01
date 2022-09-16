package com.tencent.generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack",20000,new Mydate(1995,10,10)));
        employees.add(new Employee("tom",30000,new Mydate(1996,10,10)));
        employees.add(new Employee("tom",40000,new Mydate(1996,2,30)));
        System.out.println(employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    return 0;
                }
                //比较name
                int i = emp1.getName().compareTo(emp2.getName());
                if (i != 0){
                    return i;
                }
                //把方法写在Mydate类里面 方便使用
                //比较年
//                int yearMinus = o1.getDate().getYear() - o2.getDate().getYear();
//                if (yearMinus != 0){
//                    return yearMinus;
//                }
//                //比较月份
//                int monthMinus = o1.getDate().getMonth() - o2.getDate().getMonth();
//                if (monthMinus != 0){
//                    return monthMinus;
//                }
//                //比较天
//                return o1.getDate().getDay() - o2.getDate().getMonth();
               return emp1.getDate().compareTo(emp2.getDate());
            }
        });
        System.out.println(employees);
    }
}

class Employee{
    private String name;
    private int sal;
    private Mydate date;

    public Employee(String name, int sal, Mydate date) {
        this.name = name;
        this.sal = sal;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public Mydate getDate() {
        return date;
    }

    public void setDate(Mydate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", date=" + date +
                '}';
    }
}

class Mydate implements Comparable<Mydate>{
    private int year;
    private int month;
    private int day;

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Mydate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }




    @Override
    public int compareTo(Mydate o) {
        int yearMinus = year - o.getYear();
        if (yearMinus != 0){
            return yearMinus;
        }

        int monthMinus = month - o.getMonth();
        if (monthMinus != 0){
            return monthMinus;
        }

        return day - o.getMonth();
    }
}
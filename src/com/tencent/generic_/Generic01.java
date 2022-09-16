package com.tencent.generic_;

public class Generic01 {
    public static void main(String[] args) {
        Person<String> stringPerson = new Person<String>("jack");
        Person<Integer> integerPerson = new Person<Integer>(100);
    }
}

class Person<E>{
    E s;

    public Person(E s) {
        this.s = s;
    }

    public E f(){
        return s;
    }
}
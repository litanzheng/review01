package com.tencent.reflection;

public class Cat {

    private String name ="招财猫";
    public int age=6;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi(){
        System.out.println("hi"+name);
    }

//    public Cat(String name) {
//        this.name = name;
//    }
}

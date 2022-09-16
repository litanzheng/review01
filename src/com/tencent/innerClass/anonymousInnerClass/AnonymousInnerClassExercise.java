package com.tencent.innerClass.anonymousInnerClass;

public class AnonymousInnerClassExercise {
    public static void main(String[] args) {

        //这里匿名内部类  class AnonymousInnerClassExercise$1 implements Il
        f1(new Il() {
            @Override
            public void show() {
                System.out.println("这是一个名画");
            }
        });
        f1(new Picture());
    }
    
    public static void f1(Il il){
        il.show();
    }
}

interface Il{
    void show();
}

class Picture implements Il{
    @Override
    public void show() {
        System.out.println("这是一个名画");
    }
}
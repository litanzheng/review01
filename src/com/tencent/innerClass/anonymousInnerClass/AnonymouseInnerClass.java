package com.tencent.innerClass.anonymousInnerClass;

public class AnonymouseInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer{
    private int n1 = 10;
    public void method(){
//        IA tiger = new Tiger();
//        tiger.cry();

        // new IA() 相当于 class Outer$1 implements IA
        IA tiger = new IA(){
            @Override
            public void cry() {
                System.out.println("老虎嗷嗷叫");
            }
        };
        tiger.cry();

        Animal animal = new Animal(){

            @Override
            void eat() {

            }
        };
    }
}

interface IA{
    public void cry();
}

abstract class Animal{
    abstract void eat();
}

//class Tiger implements IA{
//    @Override
//    public void cry() {
//        System.out.println("老虎嗷嗷叫");
//    }
//}



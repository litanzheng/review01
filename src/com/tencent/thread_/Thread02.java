package com.tencent.thread_;

//通过 runnable实现线程
//
public class Thread02 {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        //dog.start() 这里不能调用start();
//        Thread thread = new Thread(dog);
//        thread.start();
        Tiger tiger = new Tiger();
        TreadProxy treadProxy = new TreadProxy(tiger);
        treadProxy.start();
    }
}

class Animal{}

class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫");
    }
}

//静态代理  模拟一个Thread线程
class TreadProxy implements Runnable{

    private Runnable target = null;
    @Override
    public void run() {
        if (target != null){
            target.run();
        }
    }

    public TreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();  //这个方法是真正实现多线程的方法
    }

    public void start0(){
        run();
    }
}

class Dog implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("小狗汪汪叫"+(++count)+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10){
                break;
            }
        }
    }
}
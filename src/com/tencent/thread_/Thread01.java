package com.tencent.thread_;

//继承 Thread来开发线程
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
//        cat.run();//这里启动的是主线程
        cat.start();//启动线程
    }
}

class Cat extends Thread {
    //重写run方法 实现自己的业务逻辑
    int times = 0;

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("我是一只小喵喵" + (++times) + Thread.currentThread().getName());//打印当前线程名
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 8){
                break;
            }
        }
    }
}

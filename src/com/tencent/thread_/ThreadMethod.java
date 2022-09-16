package com.tencent.thread_;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("任春燕");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        for (int i = 0; i < 5; i++) {
                Thread.sleep(5);
                System.out.println("hi" + i);
            }
        System.out.println(t.getName() + " "+t.getPriority());
        t.interrupt();//中断t线程的休眠
    }
}

class T extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()
                        + "吃包子"+ i);
            }
            try {
                System.out.println(Thread.currentThread().getName()+"休眠中");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被interrupt了");
            }
        }
    }
}

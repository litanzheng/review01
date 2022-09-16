package com.tencent.thread_;

public class SellTicket {
    public static void main(String[] args) {
//        BB bb = new BB();
//        bb.run();


//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

//        SellTicket02 sellTicket02 = new SellTicket02();
//        Thread thread1 = new Thread(sellTicket02);
//        Thread thread2 = new Thread(sellTicket02);
//        Thread thread3 = new Thread(sellTicket02);
//        thread1.start();
//        thread2.start();
//        thread3.start();

        SellTicket03 sellTicket03 = new SellTicket03();
        Thread thread1 = new Thread(sellTicket03);
        Thread thread2 = new Thread(sellTicket03);
        Thread thread3 = new Thread(sellTicket03);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class SellTicket01 extends Thread {
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //这里要放在休眠后面才可以
            System.out.println(Thread.currentThread().getName()
                    +"窗口"+"售出一张票,剩余票数:"+(--ticketNum));
        }
    }
}


class SellTicket02 implements Runnable {
    private  int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //这里要放在休眠后面才可以
            System.out.println(Thread.currentThread().getName()
                    +"窗口"+"售出一张票,剩余票数:"+(--ticketNum));
        }
    }
}


class SellTicket03 implements Runnable {
    private  static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if (ticketNum <= 0) {
                    System.out.println("售票结束");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()
                            +"窗口"+"售出一张票,剩余票数:"+(--ticketNum));
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //这里要放在休眠后面才可以

        }
    }
}


class AA {
    static {
        System.out.println("父类被加载");
    }

    void run() {
        System.out.println("父类方法被调用");
    }
}

class BB extends AA {

    @Override
    void run() {
        System.out.println("子类方法被调用");
    }
}
package com.tencent.codeblock;

public class Practice {
    public static void main(String[] args) {
        HH hh = new HH(10);
//        HH hh1 = new HH();
//        hh = new HH();
//        System.out.println(HH.n1);
    }
}

class HH extends CC{
    int n2;
    public static int n1 = 10;
    {
        System.out.println("HH子类普通代码块");
    }

    static {
        System.out.println("HH子类静态代码块");
    }

    public HH(int n2) {
        this.n2 = n2;
        System.out.println("HH子类有参构造器");
    }

    public HH() {
        System.out.println("HH子类无参数构造器");
    }
}

class CC{
    int i = 88;
    static {
        System.out.println("父类静态代码块");
    }



    public CC() {
        System.out.println("父类无参数构造器");
    }
    {
        System.out.println("父类普通代码块");
    }
    public CC(int i) {
        this.i = i;
        System.out.println("父类有参数构造器");
    }
}
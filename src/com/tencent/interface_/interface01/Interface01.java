package com.tencent.interface_.interface01;

public class Interface01 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Iphone iphone = new Iphone();
        Camera camera = new Camera();
        computer.work(iphone);
        computer.work(camera);
    }
}

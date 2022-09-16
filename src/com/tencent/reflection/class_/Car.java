package com.tencent.reflection.class_;

public class Car {

    public String brand="宝马";
    public int price=500000;
    public String color="blue";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}

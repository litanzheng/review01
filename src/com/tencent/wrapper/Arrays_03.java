package com.tencent.wrapper;

import java.util.Arrays;
import java.util.Comparator;

//练习题
public class Arrays_03 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("水浒传",50.0);
        books[1] = new Book("水浒传",55.0);
        books[2] = new Book("水浒传",60.0);
        books[3] = new Book("水浒传",65.0);
        sortBookByPrice(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Double D1 = (Double)o1;
                Double D2 = (Double)o2;
                return (int) (D2-D1);
            }
        });
        System.out.println(Arrays.toString(books));

    }
    public static void sortBookByPrice(Book[] arr, Comparator c){
        Book temp=null;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (c.compare(arr[j].getPrice(),arr[j+1].getPrice())>0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

class Book{
    private String name;
    private Double price;

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
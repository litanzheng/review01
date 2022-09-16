package com.tencent.collection_.Collection.arraylist;

import java.util.*;

//迭代器
public class CollectionIterator {
    public static void main(String[] args) {
        List col = new ArrayList<>();
        col.add(new book("红楼梦","曹雪芹",62.5));
        col.add(new book("西游记","曹雪芹",52.5));
        col.add(new book("三国义","曹雪芹",42.5));
        col.add(new book("水浒传","曹雪芹",32.5));

        sort(col);
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        //重置迭代器
        iterator = col.iterator();

    }

    public static void sort(List list){
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                book book1 = (book)list.get(j);
                book book2 = (book)list.get(j+1);
                if (book1.getPrice()>book2.getPrice()){
                    //集合进行交换
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}

class book{
    private String name;
    private String author;
    private double price;

    public book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
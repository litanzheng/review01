package com.tencent.collection_.Collection.arraylist;

public class LinkedList01 {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node joey = new Node("joey");
        Node john = new Node("john");

        jack.next = joey;
        joey.next = john;

        john.prep = joey;
        joey.prep = jack;

        Node first = jack;
        Node last = john;
        //遍历节点
        while (true){
            if (first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //添加节点
        Node smith = new Node("smith");
        smith.next = john;
        smith.prep = joey;

        joey.next = smith;
        john.prep = smith;
        while (true){
            if (last == null){
                break;
            }
            System.out.println(last);
            last = last.prep;
        }

        System.out.println("===============");
        first = jack; //重新指向
        while (true){
            if (first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

class Node{
    public Object item;
    public Node next;
    public Node prep;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "NodeName=" + item;
    }
}
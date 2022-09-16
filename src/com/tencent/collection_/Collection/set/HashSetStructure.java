package com.tencent.collection_.Collection.set;

import java.util.HashSet;

public class HashSetStructure {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        Node john = new Node("john", null);
        table[2] = john;

        Node jack = new Node("jack",null);
        john.next = jack;

    }
}
class Node{
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}

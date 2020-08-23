package com.learning.java.algorithm.list;

public class BaseList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isEmptyOrOnlyOne(Node head) {
        return head == null || head.next == null;
    }

    public static Node createSortedList() {
        BaseList baseList = new BaseList();
        Node head, temp;
        head = temp = baseList.new Node(0);
        for (int i = 1; i < 10; i++) {
            Node node = baseList.new Node(i);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static Node createCycledList() {
        BaseList baseList = new BaseList();
        Node p1 = baseList.new Node(5);
        Node p2 = baseList.new Node(3);
        Node p3 = baseList.new Node(7);
        Node p4 = baseList.new Node(2);
        Node p5 = baseList.new Node(6);
        Node p6 = baseList.new Node(4);
        Node p7 = baseList.new Node(1);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p4;
        return p1;
    }

    public static void print(Node head) {
        print(head, null);
    }

    public static void print(Node head, Node end) {
        Node temp = head;
        int meetCount = 0;
        while (temp != null) {
            if (end != null && temp == end) meetCount++;
            System.out.print(temp.data + ", ");
            temp = temp.next;
            if (meetCount > 1) break;
        }
        System.out.println();
    }
}

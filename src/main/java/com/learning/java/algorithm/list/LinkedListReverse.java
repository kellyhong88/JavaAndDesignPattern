package com.learning.java.algorithm.list;

/**
 * 单向链表的逆序算法
 * Reverse Linked List
 */
public class LinkedListReverse {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p1 = head;
        Node p2 = head.next;
        Node p3;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        head.next = null;
        head = p1;

        return head;
    }

    public static void main(String[] args) {

        LinkedListReverse listReverse = new LinkedListReverse();
        Node head, temp;
        head = temp = listReverse.new Node(0);
        for (int i = 1; i < 10; i++) {
            Node node = listReverse.new Node(i);
            temp.next = node;
            temp = node;
        }

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();

        head = reverse(head); //将单向链表逆序

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

    }

}

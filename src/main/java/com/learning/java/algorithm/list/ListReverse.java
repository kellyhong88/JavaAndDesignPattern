package com.learning.java.algorithm.list;

/**
 * 单向链表的逆序算法
 * Reverse Linked List
 */
public class ListReverse extends BaseList {

    public static Node reverse(Node head) {
        if (isEmptyOrOnlyOne(head)) return head;

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

    public static Node reverseRecursively(Node head) {
        if (isEmptyOrOnlyOne(head)) return head;

        Node last = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        Node head = createSortedList();
        print(head);

        print(reverse(head));

        head = createSortedList();
        print(reverseRecursively(head));

    }

}

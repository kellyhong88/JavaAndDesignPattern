package com.learning.java.algorithm.list;

public class ListCycle extends BaseList {

    static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return true;
        }
        return false;
    }

    static Node firstMeet(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return p1;
        }
        return null;
    }

    static Node cycleEntry(Node head) {
        if (isEmptyOrOnlyOne(head)) return null;
        Node p1 = head;
        Node p2 = firstMeet(head);
        if (p2 == null) return null;
        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) return p1;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head1 = BaseList.createSortedList();
        print(head1);
        System.out.println("whether this link is a cycled list: " + isCycle(head1));
        Node head2 = BaseList.createCycledList();
        print(head2, cycleEntry(head2));
        System.out.println("whether this link is a cycled list: " + isCycle(head2));
    }

}

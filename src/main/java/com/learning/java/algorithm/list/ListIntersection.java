package com.learning.java.algorithm.list;

/**
 * 两条list，在某个节点处交汇为1条list
 * a1->a2->c1->c2->c3 如：4->1->8->7->5
 * b1->b2->b3->c1->c2->c3 如：3->6->2->8->7->5
 * 其中：c1->c2->c3（即：8->7->5）为共有节点
 * 如何获取交汇节点？
 *
 * */
public class ListIntersection extends BaseList {

    public static Node findIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        if (head1 == head2) return head1;

        Node p1 = head1;
        Node p2 = head2;
        boolean change1 = false, change2 = false;
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            if (p1 == null && !change1) {
                p1 = head2;
                change1 = true;
            }
            p2 = p2.next;
            if (p2 == null && !change2) {
                p2 = head1;
                change2 = true;
            }
        }

        return (p1 == null || p2 == null) ? null : p1;
    }

    public static Node findIntersectionNode2(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        if (head1 == head2) return head1;

        Node p1 = head1;
        Node p2 = head2;
        int length1 = 1, length2 = 1;
        while (p1.next != null) {
            length1++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            length2++;
            p2 = p2.next;
        }

        if (p1 != p2) return null;

        p1 = head1;
        p2 = head2;
        if (length1 > length2) {
            int diff = length1 - length2;
            while (diff > 0 && p1 != null) {
                p1 = p1.next;
                diff--;
            }
        }
        if (length2 > length1) {
            int diff = length2 - length1;
            while (diff > 0 && p2 != null) {
                p2 = p2.next;
                diff--;
            }
        }

        if (p1 == p2) return p1;

        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        BaseList baseList = new BaseList();
        Node head1, head2, temp1, temp2;
        head1 = temp1 = baseList.new Node(4);
        temp2 = baseList.new Node(1);
        temp1.next = temp2;
        temp1 = temp2;
        temp2 = baseList.new Node(8);
        temp1.next = temp2;
        temp1 = temp2;
        temp2 = baseList.new Node(7);
        temp1.next = temp2;
        temp1 = temp2;
        temp2 = baseList.new Node(5);
        temp1.next = temp2;

        head2 = temp1 = baseList.new Node(3);
        temp2 = baseList.new Node(6);
        temp1.next = temp2;
        temp1 = temp2;
        temp2 = baseList.new Node(2);
        temp1.next = temp2;
        temp2.next = head1.next.next;

        Node intersectionNode = findIntersectionNode(head1, head2);
        System.out.println("Intersection Node: " + (intersectionNode != null ? intersectionNode.data : "no"));
        intersectionNode = findIntersectionNode2(head1, head2);
        System.out.println("Intersection Node: " + (intersectionNode != null ? intersectionNode.data : "no"));

        head1 = createSortedList();
        head2 = createSortedList2();
        intersectionNode = findIntersectionNode(head1, head2);
        System.out.println("Intersection Node: " + (intersectionNode != null ? intersectionNode.data : "no"));
        intersectionNode = findIntersectionNode2(head1, head2);
        System.out.println("Intersection Node: " + (intersectionNode != null ? intersectionNode.data : "no"));

    }

}

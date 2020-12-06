package com.learning.java.algorithm.list;

/**
 * 将2条有序list，合并为1条有序list
 * */
public class ListMerge extends BaseList {

    public static Node merge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        BaseList baseList = new BaseList();
        Node pre, head;
        pre = head = baseList.new Node(-1);

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                pre.next = h1;
                h1 = h1.next;
            } else {
                pre.next = h2;
                h2 = h2.next;
            }
            pre = pre.next;
        }
        pre.next = h1 == null ? h2 : h1;

        return head.next;
    }

    public static void main(String[] args) {
        Node h1 = createSortedList();
        print(h1);
        Node h2 = createSortedList2();
        print(h2);

        print(merge(h1, h2));
    }

}

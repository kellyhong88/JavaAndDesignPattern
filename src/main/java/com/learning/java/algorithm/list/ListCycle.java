package com.learning.java.algorithm.list;

/**
 * 有环list：5->3->7->2->6->4->1->2->...
 * 1.如何判断list中是否有环？
 * 运用数学中的追及问题：环形跑道上两个运动员，跑得快的人势必会追上跑得慢的人
 * 第1次追上是超前1圈，第2次追上是超前2圈...第n次追上是超前n圈
 * 因此，两个指针，p1每次前进1个节点，p2每次前进2个节点，若list有环，则两个指针迟早会相遇
 * 2.如何求出有环list的环长？
 * 两个指针首次相遇，证明list有环
 * 两个指针从相遇点继续循环前进，直到两个指针第二次相遇，p2比p1又多走了一圈
 * p2对p1的速度差是1步，因此 环长 = 1步速度差 * 前进次数
 * 注：相遇点未必是入环节点
 * 3.如何求出有环list的入环节点？
 * 首次相遇点必定在环上的某个节点处
 * 假设list头节点到入环点的距离是D，入环点到首次相遇点的距离是S1，首次相遇点回到入环点的距离是S2
 * 当p1、p2首次相遇时，p1走的距离是D+S1，p2走的距离是D+S1+S2+S1=D+2S1+S2
 * p2的速度是p1的2倍，因此首次相遇时，p2走的距离也是p1的2倍
 * 则：D+2S1+S2 = 2(D+S1)
 * 得：D = S2
 * 即：头节点到入环点的距离 = 首次相遇点到入环点的距离
 * 若1个指针从头节点开始走，另1个指针从首次相遇点开始走，每次都向前1步，
 * 则两个指针相遇的节点，就是入环节点
 * */
public class ListCycle extends BaseList {

    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return true;
        }
        return false;
    }

    public static int getCycleLength(Node head) {
        Node firstMeet = firstMeet(head);
        if (firstMeet == null) return 0;
        Node p1 = firstMeet;
        Node p2 = firstMeet;
        int len = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            len++;
            if (p1 == p2) break;
        }
        return len;
    }

    public static Node firstMeet(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return p1;
        }
        return null;
    }

    public static Node cycleEntry(Node head) {
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
        Node head1 = createSortedList();
        print(head1);
        System.out.println("whether this link is a cycled list: " + isCycle(head1));
        Node head2 = createCycledList();
        print(head2, cycleEntry(head2));
        System.out.println("whether this link is a cycled list: " + isCycle(head2));
        System.out.println("the cycle length of this cycled list is " + getCycleLength(head2));
    }

}

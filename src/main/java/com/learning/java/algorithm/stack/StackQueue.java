package com.learning.java.algorithm.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 * 即：底层用栈的数据结构，对上实现队列的特性
 * 注意：
 * 栈：先进后出/后进先出
 * 队列：先进先出
 * */
public class StackQueue {

    public Stack<Integer> enQueueStack = new Stack<>();
    public Stack<Integer> deQueueStack = new Stack<>();

    /**
     * 元素进队：
     * en栈中push入元素
     * */
    public void enQueue(Integer element) {
        enQueueStack.push(element);
    }

    /**
     * 元素出队：
     * 若de栈为空，则en栈中弹出所有元素，依次放入de栈中，然后de栈弹出栈顶元素
     * 若de栈不为空，则de栈还有剩余元素，直接弹出栈顶元素即可
     * */
    public Integer deQueue() {
        if (deQueueStack.empty()) {
            if (enQueueStack.empty()) return null;
            transfer();
        }
        return deQueueStack.pop();
    }

    public void transfer() {
        while (!enQueueStack.empty()) {
            deQueueStack.push(enQueueStack.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }

}

package com.learning.java.algorithm.stack;

import java.util.Stack;

public class StackQueue {

    public Stack<Integer> enQueueStack = new Stack<>();
    public Stack<Integer> deQueueStack = new Stack<>();

    public void enQueue(Integer element) {
        enQueueStack.push(element);
    }

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

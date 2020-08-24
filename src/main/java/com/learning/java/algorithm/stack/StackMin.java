package com.learning.java.algorithm.stack;

import java.util.Stack;

public class StackMin {

    public Stack<Integer> mainStack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    public void pushMy(Integer element) {
        mainStack.push(element);
        if (minStack.empty() || minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    public Integer popMy() {
        if (mainStack.empty()) return null;
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() {
        if (mainStack.empty() || minStack.empty()) return null;
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.pushMy(4);
        stackMin.pushMy(9);
        stackMin.pushMy(7);
        stackMin.pushMy(3);
        stackMin.pushMy(8);
        stackMin.pushMy(5);
        System.out.println("min element of this stack: " + stackMin.getMin());
        stackMin.popMy();
        stackMin.popMy();
        stackMin.popMy();
        System.out.println("min element of this stack: " + stackMin.getMin());
    }

}

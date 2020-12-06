package com.learning.java.algorithm.stack;

import java.util.Stack;

/**
 * 获取栈中的最小元素
 * */
public class StackMin {

    public Stack<Integer> mainStack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    /**
     * 主栈mainStack中一直正常push所有元素
     * 最小栈minStack中只push更小的元素
     * */
    public void pushElement(Integer element) {
        mainStack.push(element);
        if (minStack.empty() || minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    /**
     * 如果主栈mainStack的栈顶元素与最小栈minStack的栈顶元素相同，
     * 则minStack需弹出栈顶元素
     * mainStack则一直正常弹出栈顶元素
     * */
    public Integer popElement() {
        if (mainStack.empty()) return null;
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 最小栈minStack的栈顶元素一直保持为主栈mainStack中的最小元素
     * 注：pop为弹出栈顶元素，peek为获取栈顶元素但不从栈中实际弹出
     * */
    public Integer getMinElement() {
        if (mainStack.empty() || minStack.empty()) return null;
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.pushElement(4);
        stackMin.pushElement(9);
        stackMin.pushElement(7);
        stackMin.pushElement(3);
        stackMin.pushElement(8);
        stackMin.pushElement(5);
        System.out.println("min element of this stack: " + stackMin.getMinElement());
        stackMin.popElement();
        stackMin.popElement();
        stackMin.popElement();
        System.out.println("min element of this stack: " + stackMin.getMinElement());
    }

}

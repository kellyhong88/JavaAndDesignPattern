package com.learning.java.algorithm.stack;

import java.util.Stack;

/**
 * 栈排序
 * 用另一个栈来实现当前栈的排序
 * */
public class StackSort {

    /**
     * 当前栈元素依次出栈，打算有序地进去另一个新栈
     * 若新栈为空，则原栈元素直接入新栈
     * 若新栈不为空，则暂存一下原栈出栈元素
     * while 新栈栈顶元素 > 原栈出栈元素，then 新栈元素出栈入原栈
     * until 新栈栈顶元素 < 原栈出栈元素，then 原栈出栈元素入新栈
     * */
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!stack.empty()) {
            Integer temp = stack.pop();
            while (!sortedStack.empty() && sortedStack.peek() > temp) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    public static void print(Stack<Integer> stack) {
        while (!stack.empty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }

    public static void init(Stack<Integer> stack) {
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(23);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        init(stack);
        print(stack);

        init(stack);
        print(sort(stack));
    }

}

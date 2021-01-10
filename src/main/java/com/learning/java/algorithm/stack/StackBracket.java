package com.learning.java.algorithm.stack;

import java.util.Stack;

/**
 * 如何判断表达式中的括号是成双成对的？
 * 如：[()]{}{[()()]()} is paired
 * [(]) is not paired
 */
public class StackBracket {

    /**
     * 用栈实现
     * 遍历表达式中的每个括号
     * if 左括号，如‘(‘ or ‘{‘ or ‘[‘，then 入栈
     * if 右括号，如‘)’ or ‘}’ or ‘]’，then 出栈栈顶元素，判断是否可配对
     * 若可配对，则ok，继续遍历
     * 若不可配对，则not balanced，结束遍历
     */
    public static boolean isPaired(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char half = expression.charAt(i);
            if (half == '(' || half == '[' || half == '{') {
                stack.push(half);
            } else {
                if (stack.empty()) return false;
                char previousHalf = stack.pop();
                switch (half) {
                    case ')':
                        if (previousHalf != '(') return false;
                        break;
                    case ']':
                        if (previousHalf != '[') return false;
                        break;
                    case '}':
                        if (previousHalf != '{') return false;
                        break;
                }
            }
        }
        // stack should be empty if expression is paired or balanced
        return stack.empty();
    }

    public static void main(String[] args) {
        String expression1 = "()[]{}";
        String expression2 = "[()]{}{[()()]()}";
        String expression3 = "[(])";
        String expression4 = "{[()]";
        System.out.println(expression1 + (isPaired(expression1) ? " is paired" : " is not balanced"));
        System.out.println(expression2 + (isPaired(expression2) ? " is paired" : " is not balanced"));
        System.out.println(expression3 + (isPaired(expression3) ? " is paired" : " is not balanced"));
        System.out.println(expression4 + (isPaired(expression4) ? " is paired" : " is not balanced"));
    }
}

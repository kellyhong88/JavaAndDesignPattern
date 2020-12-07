package com.learning.java.algorithm.array;

/**
 * 逆转字符串
 * 两种诉求：
 * 1.逆转字符串中的每个字符 如：leetcode is fun 逆转为 nuf si edocteel
 * 2.逆转字符串中的单词顺序，但不逆转单词本身 如：leetcode is fun 逆转为 fun is leetcode
 * 注：字符串（String）可认为是字符（char）数组
 * */
public class StringReverse {

    /**
     * 逆转字符串中的每个字符
     * */
    public static void reverseWhole(char[] s, int left, int right) {
        if (s == null || left >= right) return;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    /**
     * 逆转字符串中的每个单词
     * */
    public static void reverseEachWord(char[] s) {
        if (s == null) return;
        int start = 0, end = 0;
        while (start < s.length) {
            while (end < s.length && s[end] != ' ') end++;
            reverseWhole(s, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    public static void print(char[] s) {
        if (s == null) return;
        int i = 0;
        while (i < s.length) {
            System.out.print(s[i++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'l', 'e', 'e', 't', 'c', 'o', 'd', 'e', ' ', 'i', 's', ' ', 'f', 'u', 'n'};
        print(s);

        reverseWhole(s, 0, s.length - 1);
        System.out.println("reverse every char in the string: ");
        print(s);

        reverseEachWord(s);
        System.out.println("reverse the order of the words occurred in the string without reversing each word itself");
        print(s);
    }

}

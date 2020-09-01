package com.learning.java.algorithm.array;

public class StringReverse {

    public static void reverseWhole(char[] s, int left, int right) {
        if (s == null || left >= right) return;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

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

    public static void reverse(char[] s) {
        reverseWhole(s, 0, s.length - 1);
        reverseEachWord(s);
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

        reverse(s);
        print(s);
    }

}

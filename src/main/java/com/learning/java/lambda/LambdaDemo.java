package com.learning.java.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {

    public static void main(String[] args) {
        lambda1();
        lambda2();
    }

    private static void lambda1() {
        String[] names1 = {"Justin", "caterpillar", "Bush"};
        String[] names2 = {"abcde", "abc", "abcdefg"};

        Comparator<String> byLength1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        Comparator<String> byLength2 = (o1, o2) -> o1.length() - o2.length();

        Arrays.sort(names1, byLength1);
        print(names1);

        Arrays.sort(names2, byLength2);
        print(names2);
    }

    private static void lambda2() {
        String[] names = {"Justin", "caterpillar", "Bush"};

        Arrays.sort(names, (n1, n2) -> StringOrder.byLength(n1, n2));
        print(names);

        Arrays.sort(names, StringOrder::byLength);
        print(names);

        Arrays.sort(names, StringOrder::byGraphy);
        print(names);

        Arrays.sort(names, String::compareTo);
        print(names);

        Arrays.sort(names, StringOrder::byGraphyIngoreCase);
        print(names);

        Arrays.sort(names, String::compareToIgnoreCase);
        print(names);
    }

    private static void print(String[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

}

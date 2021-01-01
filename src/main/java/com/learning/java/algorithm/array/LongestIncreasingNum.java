package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 找出数组中最长的一串有序序列，返回有序序列的长度
 * 注：构成有序序列的元素在原数组中可以连续或不连续
 * */
public class LongestIncreasingNum {

    public static int findLongestIncreasingNum(int[] array) {
        if (emptyArray(array)) return 0;

        int[] dp = new int[array.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        print(Array9);
        System.out.println("Longest increasing number of figures: " + findLongestIncreasingNum(Array9));
        print(Array10);
        System.out.println("Longest increasing number of figures: " + findLongestIncreasingNum(Array10));
    }

}

package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 找出数组中最长的一串有序序列，返回有序序列的长度
 * 注：构成有序序列的元素在原数组中可以连续或不连续
 * */
public class LongestIncreasingNum {

    public static int findLongestIncreasingNum(int[] array) {
        if (emptyArray(array)) return 0;

        /**
         * dp[i] 表示长度为i的数组中最长有序序列的长度
         *
         * 状态转移方程：
         * dp[i] = max(dp[i], dp[j] + 1) while j < i and array[j] < array[i]
         *
         * base case:
         * dp[i] = 1
         *
         * 目标解：
         * max(dp[i]) i = 0,1,2,...,len-1
         * */
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

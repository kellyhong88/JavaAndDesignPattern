package com.learning.java.algorithm.array;

import com.learning.java.algorithm.sort.ArrayUtils;

public class LongestIncreasingNum {

    public static int findLongestIncreasingNum(int[] array) {
        if (ArrayUtils.emptyArray(array)) return 0;

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
        ArrayUtils.print(ArrayUtils.array9);
        System.out.println("Longest increasing number of fingers: " + findLongestIncreasingNum(ArrayUtils.array9));
        ArrayUtils.print(ArrayUtils.array10);
        System.out.println("Longest increasing number of fingers: " + findLongestIncreasingNum(ArrayUtils.array10));
    }

}

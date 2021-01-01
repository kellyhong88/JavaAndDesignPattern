package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 找出数组中元素值之和最大的子数组，返回子数组的元素和
 * */
public class MaxSubSum {

    /**
     * 递归思想
     * */
    public static int calculateMaxSum(int[] array, int left, int right) {
        if (emptyArray(array)) return Integer.MIN_VALUE;
        if (left == right) return array[left];

        int mid = (left + right) / 2;
        /**
         * 计算出左半边数组的子数组的最大元素和
         * */
        int leftMaxSum = calculateMaxSum(array, left, mid);
        /**
         * 计算出右半边数组的子数组的最大元素和
         * */
        int rightMaxSum = calculateMaxSum(array, mid + 1, right);
        /**
         * 计算出必须包含中间元素的子数组的最大元素和
         * */
        int crossMaxSum = calculateCrossMaxSum(array, left, right, mid);

        /**
         * 原数组中的最大元素和的子数组，要么出现在左半边数组中，要么出现在右半边数组中，
         * 要么横跨左右半边（包含中间元素）的数组中
         * */
        return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
    }

    /**
     * 计算数组中下标为cross的元素的前后连续or不连续的元素值之和最大的子数组
     * */
    private static int calculateCrossMaxSum(int[] array, int left, int right, int cross) {
        if (emptyArray(array)) return Integer.MIN_VALUE;
        if (left == right) return array[left];

        int i = cross - 1, maxSum = array[cross], currentSum = array[cross];
        while (i >= left) {
            currentSum += array[i--];
            maxSum = Math.max(maxSum, currentSum);
        }
        i = cross + 1;
        currentSum = maxSum;
        while (i <= right) {
            currentSum += array[i++];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    /**
     * 状态转移思想
     * */
    public static int calculateMaxSum(int[] array) {
        if (emptyArray(array)) return Integer.MIN_VALUE;
        if (array.length == 1) return array[0];

        int lastMaxSum = array[0], maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            /**
             * 计算必须包含该元素的情况下的最大元素值之和
             * 每增加1个元素，可能该元素自己就是最大元素值之和，也可能需和"前辈"相加后才是最大元素值之和
             * */
            lastMaxSum = Math.max(array[i], lastMaxSum + array[i]);
            /**
             * 整个数组中的最大元素和，可能包含该元素后可达到，也可能不包含该元素后才可达到
             * */
            maxSum = Math.max(maxSum, lastMaxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        print(Array8);
        System.out.println("Max sum of subArray: " + calculateMaxSum(Array8, 0, Array8.length - 1));
        System.out.println("Max sum of subArray: " + calculateMaxSum(Array8));
    }

}

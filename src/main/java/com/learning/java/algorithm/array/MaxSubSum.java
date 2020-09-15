package com.learning.java.algorithm.array;

import com.learning.java.algorithm.sort.ArrayUtils;

public class MaxSubSum {

    public static int calculateMaxSum(int[] array, int left, int right) {
        if (ArrayUtils.emptyArray(array)) return Integer.MIN_VALUE;
        if (left == right) return array[left];

        int mid = (left + right) / 2;
        int leftMaxSum = calculateMaxSum(array, left, mid);
        int rightMaxSum = calculateMaxSum(array, mid + 1, right);
        int crossMaxSum = calculateCrossMaxSum(array, left, right, mid);

        return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
    }

    private static int calculateCrossMaxSum(int[] array, int left, int right, int cross) {
        if (ArrayUtils.emptyArray(array)) return Integer.MIN_VALUE;
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

    public static int calculateMaxSum(int[] array) {
        if (ArrayUtils.emptyArray(array)) return Integer.MIN_VALUE;
        if (array.length == 1) return array[0];

        int lastMaxSum = array[0], maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            lastMaxSum = Math.max(array[i], lastMaxSum + array[i]);
            maxSum = Math.max(maxSum, lastMaxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ArrayUtils.print(ArrayUtils.array8);
        System.out.println("Max sum of subArray: " + calculateMaxSum(ArrayUtils.array8, 0, ArrayUtils.array8.length - 1));
        System.out.println("Max sum of subArray: " + calculateMaxSum(ArrayUtils.array8));
    }

}

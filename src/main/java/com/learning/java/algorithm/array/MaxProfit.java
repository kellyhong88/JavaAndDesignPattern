package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

public class MaxProfit {

    public static int calculateMaxProfit(int[] array) {
        if (noNeedOperation(array)) return 0;

        int minIdx = 0, maxProfit = 0;
        for (int i = 1; i < array.length; i++) {
            if (maxProfit < array[i] - array[minIdx]) {
                maxProfit = array[i] - array[minIdx];
            }
            if (array[minIdx] > array[i]) {
                minIdx = i;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        print(Array7);
        System.out.println("MaxProfit: " + calculateMaxProfit(Array7));
    }

}

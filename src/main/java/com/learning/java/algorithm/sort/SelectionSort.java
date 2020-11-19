package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 选择排序
 * */
public class SelectionSort {

    public static void sort(int[] array) {
        if (noNeedOperation(array)) return;

        int maxIdx;
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            maxIdx = 0;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[maxIdx];
            array[maxIdx] = temp;
        }
    }

    public static void main(String[] args) {
        print(Array1);
        sort(Array1);
        print(Array1);
    }

}

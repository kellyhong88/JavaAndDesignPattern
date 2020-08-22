package com.learning.java.algorithm.sort;

public class SelectionSort {

    public static void sort(int[] array) {
        if (ArrayUtils.noNeedSort(array)) return;

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
        ArrayUtils.print();
        SelectionSort.sort(ArrayUtils.array);
        ArrayUtils.print();
    }

}

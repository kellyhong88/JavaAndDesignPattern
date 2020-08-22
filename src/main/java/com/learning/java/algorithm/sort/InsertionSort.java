package com.learning.java.algorithm.sort;

public class InsertionSort {

    public static void sort(int[] array) {
        if (ArrayUtils.noNeedSort(array)) return;

        int temp;
        for (int i = 1; i < array.length; i++) {
            while (i >= 1 && array[i - 1] > array[i]) {
                temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayUtils.print();
        InsertionSort.sort(ArrayUtils.array);
        ArrayUtils.print();
    }

}

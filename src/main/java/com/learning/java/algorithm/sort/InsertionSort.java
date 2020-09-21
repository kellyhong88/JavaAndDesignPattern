package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

public class InsertionSort {

    public static void sort(int[] array) {
        if (noNeedOperation(array)) return;

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
        print(Array1);
        sort(Array1);
        print(Array1);
    }

}

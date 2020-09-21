package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * In Bubble Sort, each element is compared with the next element.
 * If the front element is bigger than the back element, then the positions of the elements will be interchanged,
 * otherwise it will not be changed.
 * Then the front/smaller element is compared with its pre element,
 * and the same process will be repeated for all the elements in the Array1 until we get a sorted Array1.
 * Bubble Sort is sometimes also referred as Sinking Sort as instead of bubbling up the smallest element to the left side,
 * we can also sink the largest element to the right side.
 */
public class BubbleSort {

    /**
     * Time complexity is O(N^2) because timeTotal = timePerComparison * (N-1 + N-2 + ... + 2 + 1) = N(N-1)/2
     * Space complexity is O(1) as all operations are almost in space and only ONE single variable is used in loop for holding value temporarily.
     * Bubble Sort is efficient when data set is small,
     * but it is not efficient for large data set as time grows exponentially.
     * Bubble Sort is memory efficient and easy to implement.
     */
    static void sort(int[] array) {
        if (noNeedOperation(array)) return;

        int temp;
        boolean isChange = false;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isChange = true;
                }
            }
            if (!isChange) break;
        }
    }

    static void sortRecursively(int[] array, int L, int R) {
        if (noNeedOperation(array)) return;
        if (L == R) return;

        int temp;
        for (int i = L; i < R; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        sortRecursively(array, L, R - 1);

    }

    public static void main(String[] args) {
        print(Array1);
        sort(Array1);
        print(Array1);
        int[] array2 = {8, 5, 6, 2, 0, 9, 3, 1, 4, 7};
        sortRecursively(array2, 0, array2.length - 1);
        print(array2);
    }

}

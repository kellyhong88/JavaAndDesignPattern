package com.learning.java.algorithm.sort;

/**
 * In Bubble Sort, each element is compared with the next element.
 * If the front element is bigger than the back element, then the positions of the elements will be interchanged,
 * otherwise it will not be changed.
 * Then the front/smaller element is compared with its pre element,
 * and the same process will be repeated for all the elements in the array until we get a sorted array.
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
        if (array == null || array.length == 1) {
            return;
        }
        int len = array.length;
        int i, j, temp;
        for (i = 0; i < len - 1; i++) {
            for (j = len - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyArray.print();
        BubbleSort.sort(MyArray.array);
        MyArray.print();
    }

}
package com.learning.java.algorithm.array;

import com.learning.java.algorithm.sort.ArrayUtils;

public class ArrayRotate {

    public static int findMin(int[] array) {
        if (array == null || array.length == 0) return -1;
        if (array.length == 1) return array[0];

        int left = 0, right = array.length - 1;
        while (array[left] > array[right]) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[left] < array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        ArrayUtils.print(ArrayUtils.array5);
        System.out.println("Min of this array: " + findMin(ArrayUtils.array5));
        ArrayUtils.print(ArrayUtils.array4);
        System.out.println("Min of this array: " + findMin(ArrayUtils.array4));
    }

}

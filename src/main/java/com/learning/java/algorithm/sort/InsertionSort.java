package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 插入排序
 * 第1轮排序：第1个元素
 * 第2轮排序：第2个元素插入到第1轮排序后数组的后面，若第2个元素比前面相邻的元素更小，则依次往前冒，直到遇到更小的停下来，则第2轮排序后的数组为有序数组
 * 第3轮排序：第3个元素插入到第2轮排序后数组的后面，若第3个元素比前面相邻的元素更小，则依次往前冒，直到遇到更小的停下来，则第3轮排序后的数组为有序数组
 * ...
 * 插入排序的思想是，每次都是将一个新元素，插入到一个已经有序的数组中
 * */
public class InsertionSort {

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * */
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

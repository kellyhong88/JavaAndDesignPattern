package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 选择排序
 * 第1轮：找到当前未排序数组中的最小元素，放到新数组的起始位置，且从未排序数组中去掉该元素
 * 第2轮：找到剩下未排序数组中的最小元素，放到已排序数组的末尾，且从未排序数组中去掉该元素
 * ...
 * 选择排序每次都是找到未排序数组中的最小（大）元素，放在已排序数组的末尾（起始）
 * */
public class SelectionSort {

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * */
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

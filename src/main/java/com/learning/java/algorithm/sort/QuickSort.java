package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 快速排序
 * 在每次排序时，会设置一个基准点（一般取第一个数），将小于基准点的数全部放到基准点的左边，将大于基准点的数全部放到基准点的右边。
 * 这样在每次交换的时候，就不会像冒泡排序一样只能在相邻的数之间进行交换，即快排每次交换的距离比冒泡大多了。
 * 所以，快速排序之所以较快，是因为相比冒泡排序，快排的每次交换是跳跃式的。
 * 当然，在最坏的情况下，仍可能是相邻的两个数进行了交换。
 * 因此，快速排序的最差时间复杂度和冒泡排序一样，都是 O(N^2)，但其平均时间复杂度为 O(NlgN)。
 * 快速排序用到了两种思想：二分思想/分治法 和 递归思想。
 */
public class QuickSort {

    public static void quickSort(int[] array, int start, int end) {
        if (noNeedOperation(array)) return;
        if (start >= end) return;

        int left = start, right = end, pivot = array[left]; // 取第一个数为基准数，暂存下基准数

        while (left < right) {
            // 先从右边开始找，找比基准数小的数
            while (left < right && array[right] >= pivot) right--;
            // 找到后把这个数赋值给当前left指向的位置（即将这个数移至基准数的左边）
            array[left] = array[right];
            // 再从左边开始找，找比基准数大的数
            while (left < right && array[left] <= pivot) left++;
            // 找到后把这个数赋值给当前right指向的位置（即将这个数移至基准数的右边）
            array[right] = array[left];
        }

        // 跳出循环时low与high相等，此时的low或high就是pivot的正确位置
        array[left] = pivot;

        //递归处理基准数左边的数组
        quickSort(array, start, left - 1);

        //递归处理基准数右边的数组
        quickSort(array, left + 1, end);

    }

    public static void main(String[] args) {
        print(Array1);
        quickSort(Array1, 0, Array1.length - 1);
        print(Array1);

        print(Array5);
        quickSort(Array5, 0, Array5.length - 1);
        print(Array5);
    }

}

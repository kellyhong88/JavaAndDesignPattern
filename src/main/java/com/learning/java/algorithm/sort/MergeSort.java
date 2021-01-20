package com.learning.java.algorithm.sort;

import static com.learning.java.algorithm.sort.ArrayUtils.*;
import static com.learning.java.algorithm.sort.ArrayUtils.Array5;

/**
 * 归并排序
 * 归并排序用到了两种思想：二分思想/分治法 和 递归思想
 * 归并排序速度仅次于快速排序
 * 归并排序是一种稳定的排序算法
 * 时间复杂度：O(NlgN)
 * 空间复杂度：O(N)
 * */
public class MergeSort {

    /**
     * 分治法（Divide and Conquer）
     * 1.把一个未排序的序列从中间分成2部分
     * 2.再把2部分各自分割，分成4部分...依次分割下去，直到分割成一个一个的数据
     * 3.再把这些数据两两归并到一起，使之有序
     * 4.不停地归并，最后得到一个排好序的序列
     * */
    public static void mergeSort(int[] array, int[] sortedArray, int left, int right) {
        if (noNeedOperation(array)) return;
        if (left >= right) return;

        int mid = (left + right) / 2;

        // 递归分割数组
        mergeSort(array, sortedArray, left, mid);
        mergeSort(array, sortedArray,mid + 1, right);

        // 分割成一个个的元素后，开始归并
        merge(array, sortedArray, left, right, mid);
    }

    public static void merge(int[] array, int[] sortedArray, int left, int right, int mid) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right && k <= right) {
            sortedArray[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid && k <= right) {
            sortedArray[k++] = array[i++];
        }
        while (j <= right && k <= right) {
            sortedArray[k++] = array[j++];
        }

        /**
         * assign sortedArray to the original array
         * 因为归并也是递归的，当下轮次只需赋值left到right部分
         * */
        for (k = left; k <= right; k++){
            array[k] = sortedArray[k];
        }
    }

    public static void main(String[] args) {
        print(Array1);
        mergeSort(Array1, new int[Array1.length],0, Array1.length - 1);
        print(Array1);

        print(Array5);
        mergeSort(Array5, new int[Array5.length], 0, Array5.length - 1);
        print(Array5);
    }

}

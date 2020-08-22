package com.learning.java.algorithm.sort;

/**
 * 快速排序在每次排序时，会设置一个基准点（一般取第一个数），将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
 * 这样在每次交换的时候，就不会像冒泡排序一样只能在相邻的数之间进行交换，即快排每次交换的距离比冒泡大多了。
 * 所以，快速排序之所以较快，是因为相比冒泡排序，快排的每次交换是跳跃式的。
 * 当然，在最坏的情况下，仍可能是相邻的两个数进行了交换。
 * 因此，快速排序的最差时间复杂度和冒泡排序一样，都是 O(N^2)，但其平均时间复杂度为 O(NlgN)。
 * 快速排序用到了两种思想："二分"思想 和 递归思想。
 */
public class QuickSort {

    static void sort(int[] array, int left, int right) {
        if (ArrayUtils.noNeedSort(array)) return;
        if (left >= right) return;

        int i = left, j = right, temp1, temp2;
        temp1 = array[left]; //取第一个数为基准数，暂存下基准数

        while (i != j) {
            //再从左边开始找，找比基准数大的数（找到后需把这个数移至基准数的右边）
            while (array[i] <= temp1 && i < j) {
                i++;
            }

            //先从右边开始找，找比基准数小的数（找到后需把这个数移至基准数的左边）
            while (array[j] >= temp1 && i < j) {
                j--;
            }

            //交换两个数的位置
            if (i < j) {
                temp2 = array[i];
                array[i] = array[j];
                array[j] = temp2;
            }
        }

        //最后需将基准数归位
        array[left] = array[i];
        array[i] = temp1;

        //递归处理基准数左边的数组
        sort(array, left, i - 1);

        //递归处理基准数右边的数组
        sort(array, i, right);
    }

    public static void sort2(int[] array, int L, int R) {
        if (ArrayUtils.noNeedSort(array)) return;
        if (L >= R) return;

        int i = L, j = R, mid = (L + R) / 2, temp;
        int pivot = array[mid];
        while (i < j && j < array.length) {
            while (array[i] <= pivot) {
                i++;
                if (i >= (array.length - 1)) break;
            }
            while (array[j] >= pivot) {
                j--;
                if (j <= 0) break;
            }
            if (i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        sort2(array, L, mid);
        sort2(array, mid + 1, R);
    }

    public static void main(String[] args) {
        ArrayUtils.print();
        QuickSort.sort(ArrayUtils.array, 0, ArrayUtils.array.length - 1);
        ArrayUtils.print();
        int[] array2 = {8, 5, 6, 2, 0, 9, 3, 1, 4, 7};
        QuickSort.sort2(array2, 0, array2.length - 1);
        ArrayUtils.print(array2);
    }

}

package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 数组特点：
 * 1.数组中包含1个或2个有序序列
 * 2.若为2个有序序列，则2个有序序列串联在一起
 * 如：{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
 *    {4, 5, 6, 7, 8, 9, 0, 1, 2, 3}
 *    {4, 4, 5, 6, 7, 7, 0, 0, 1, 3}
 * */
public class ArrayRotate {

    /**
     * 找出数组中的旋转点（第2个有序序列的首元素）
     * */
    public static int findRotateIndex(int[] array) {
        if (emptyArray(array)) return -1;
        if (array.length == 1) return 0;

        int left = 0, right = array.length - 1;
        while (array[left] > array[right]) {
            int mid = (left + right) / 2;
            /**
             * 找到了第1个有序序列的末尾
             * 则已命中目标，返回后一个元素，即为旋转点
             * */
            if (array[mid] > array[mid + 1]) {
                return mid + 1;
            }
            /**
             * 依旧在第1个有序序列中
             * */
            if (array[left] <= array[mid]) {
                left = mid;
            }
            /**
             * 跑到了第2个有序序列中
             * */
            else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 在这样的单有序序列数组/双有序序列串联数组中
     * 根据目标元素值，找到其下标
     * 若不存在，返回-1
     * */
    public static int searchTargetIndex(int[] array, int target) {
        if (emptyArray(array)) return -1;
        if (array.length == 1) return array[0] == target ? 0 : -1;

        int rotateIndex = findRotateIndex(array);
        /**
         * 该数组为单有序序列数组
         * */
        if (rotateIndex == 0) {
            return searchTargetIndexSorted(array, target, 0, array.length - 1);
        }
        /**
         * 该数组为双有序序列串联数组
         * */
        if (array[0] == target) {
            return 0;
        }
        /**
         * 目标元素在第1个有序序列中
         * */
        else if (array[0] < target) {
            return searchTargetIndexSorted(array, target, 0, rotateIndex - 1);
        }
        /**
         * 目标元素在第2个有序序列中
         * */
        else {
            return searchTargetIndexSorted(array, target, rotateIndex, array.length - 1);
        }
    }

    /**
     * 在单有序序列数组中
     * 根据目标元素值，找到其下标
     * 若不存在，返回-1
     * */
    public static int searchTargetIndexSorted(int[] array, int target, int left, int right) {
        if (emptyArray(array)) return -1;
        if (array.length == 1) return array[0] == target ? 0 : -1;

        /**
         * 二分法查询
         * */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (array[pivot] < target) {
                left = pivot + 1;
            } else if (array[pivot] > target) {
                right = pivot - 1;
            } else {
                return pivot;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        print(Array4);
        System.out.println("Rotate element of this Array: " + Array4[findRotateIndex(Array4)]);
        print(Array5);
        System.out.println("Rotate element of this Array: " + Array5[findRotateIndex(Array5)]);
        System.out.println("Index of target 7: " + searchTargetIndex(Array5, 7));
        System.out.println("Index of target 9: " + searchTargetIndex(Array5, 9));
        print(Array6);
        System.out.println("Rotate element of this Array: " + Array6[findRotateIndex(Array6)]);
        System.out.println("Index of target 2: " + searchTargetIndex(Array6, 2));
        System.out.println("Index of target 4: " + searchTargetIndex(Array6, 4));
        System.out.println("Index of target 6: " + searchTargetIndex(Array6, 6));
    }

}

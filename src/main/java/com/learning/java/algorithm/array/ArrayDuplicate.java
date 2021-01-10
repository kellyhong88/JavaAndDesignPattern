package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 去除数组中的重复数字
 * */
public class ArrayDuplicate {

    /**
     * 数组特点：
     * 1.有重复数字
     * 2.重复数字是在一起的
     * 如：{8, 8, 6, 6, 6, 9, 3, 1, 4, 4}
     * */
    public static int[] removeDuplicatesWhileTogether(int[] array) {
        if (noNeedOperation(array)) return array;

        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                i++;
                array[i] = array[j];
            }
        }

        if (i < array.length - 1) {
            int[] array2 = new int[i + 1];
            int k = 0;
            while (k <= i) {
                array2[k] = array[k];
                k++;
            }
            return array2;
        } else {
            return array;
        }
    }

    /**
     * 数组特点：
     * 1.有重复数字
     * 2.重复数字不一定在一起
     * 如：{3, 5, 4, 0, 2, 4, 5, 2, 2, 0}
     * */
    public static int[] removeDuplicatesNotTogether(int[] array) {
        if (noNeedOperation(array)) return array;

        boolean[] flag = new boolean[array.length * 2];

        for (int i = 0; i < array.length * 2; i++) {
            flag[i] = false;
        }

        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (!flag[array[i]]) {
                flag[array[i]] = true;
                length++;
            }
        }

        int[] array2 = new int[length];
        int j = 0;
        for (int i = 0; i < array.length * 2; i++) {
            if (flag[i]) {
                array2[j++] = i;
            }
        }

        return array2;
    }

    public static void main(String[] args) {
        int[] array = Array2;
        print(array);
        print(removeDuplicatesWhileTogether(array));

        array = Array12;
        print(array);
        print(removeDuplicatesNotTogether(array));

        array = Array15;
        print(array);
        print(removeDuplicatesNotTogether(array));
    }

}

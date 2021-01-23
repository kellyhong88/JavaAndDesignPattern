package com.learning.java.algorithm.sort;

public class ArrayUtils {

    public static int[] Array1 = {8, 5, 6, 2, 0, 9, 3, 1, 4, 7};
    public static int[] Array2 = {8, 8, 6, 6, 6, 9, 3, 1, 4, 4};
    public static int[] Array3 = {2, 0, 1, 1, 0, 2, 1, 1, 0, 2};
    public static int[] Array4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] Array5 = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
    public static int[] Array6 = {4, 4, 5, 6, 7, 7, 0, 0, 1, 3};
    public static int[] Array7 = {7, 1, 5, 3, 6, 4};
    public static int[] Array8 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    public static int[] Array9 = {10, 9, 2, 5, 3, 7, 101, 18};
    public static int[] Array10 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    public static int[] Array11 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    public static int[] Array12 = {3, 5, 4, 0, 2, 4, 5, 2, 2, 0};
    public static int[] Array13 = {8, 5, 6, 0, 9, 1, 4, 7};
    public static int[] Array14 = {8, 5, 6, 2, 9, 3, 1, 4, 7};
    public static int[] Array15 = {3, 15, 4, 0, 12, 4, 15, 12, 2, 0};
    public static int[] Array16 = {3, 1, 2, 2, 5, 3, 4, 5, 6};
    public static int[] Array17 = {9, 1, 2, 4, 3, 6, 8, 5, 7};

    public static void print(int[] array) {
        if (emptyArray(array)) return;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        if (noNeedOperation(array)) return;
        if (i < 0 || i >= array.length || j < 0 || j >= array.length) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean emptyArray(int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean noNeedOperation(int[] array) {
        return emptyArray(array) || array.length == 1;
    }

}

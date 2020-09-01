package com.learning.java.algorithm.sort;

public class ArrayUtils {

    public static int[] array = {8, 5, 6, 2, 0, 9, 3, 1, 4, 7};
    public static int[] array2 = {8, 8, 6, 6, 6, 9, 3, 1, 4, 4};

    public static void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void print(int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + ", ");
        }
        System.out.println();
    }

    public static boolean noNeedOperation(int[] array) {
        return array == null || array.length == 0 || array.length == 1;
    }

}

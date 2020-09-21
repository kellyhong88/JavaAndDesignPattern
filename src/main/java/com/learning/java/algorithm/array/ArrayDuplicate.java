package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

public class ArrayDuplicate {

    public static int[] removeDuplicates(int[] array) {
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

    public static void main(String[] args) {
        int[] array = Array2;
        print(array);
        print(removeDuplicates(array));
    }

}

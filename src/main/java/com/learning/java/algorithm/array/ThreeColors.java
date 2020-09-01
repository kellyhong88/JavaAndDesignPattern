package com.learning.java.algorithm.array;

import com.learning.java.algorithm.sort.ArrayUtils;

public class ThreeColors {

    public static void sortColors(int[] array) {
        if (ArrayUtils.noNeedOperation(array)) return;

        int p0, p, p2;
        p0 = p = 0;
        p2 = array.length - 1;

        while (p < p2) {
            if (array[p] == 0) {
                ArrayUtils.swap(array, p0++, p++);
            } else if (array[p] == 2) {
                ArrayUtils.swap(array, p, p2--);
            } else {
                p++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayUtils.print(ArrayUtils.array3);
        sortColors(ArrayUtils.array3);
        ArrayUtils.print(ArrayUtils.array3);
    }

}

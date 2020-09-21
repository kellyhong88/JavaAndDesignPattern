package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

public class RainWater {

    public static int calculateRainWater(int[] array) {
        if (emptyArray(array) || array.length == 1) return 0;

        int i, rainWater = 0;
        int[] leftArray = new int[array.length], rightArray = new int[array.length];
        leftArray[0] = array[0];
        rightArray[array.length - 1] = array[array.length - 1];

        for (i = 1; i < array.length; i++) {
            leftArray[i] = Math.max(leftArray[i - 1], array[i]);
        }

        for (i = array.length - 2; i >= 0; i--) {
            rightArray[i] = Math.max(rightArray[i + 1], array[i]);
        }

        for (i = 0; i < array.length; i++) {
            rainWater += (Math.min(leftArray[i], rightArray[i]) - array[i]);
        }

        return rainWater;
    }

    public static void main(String[] args) {
        System.out.println("Volume of rain water: " + calculateRainWater(Array11));
    }

}

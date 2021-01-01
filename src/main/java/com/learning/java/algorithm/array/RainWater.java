package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 数组的值代表柱子的高度
 * 请问：数组中的所有柱子，最多能储蓄多少水呢？
 * 示例图见：resources/photos下的rain_water.png
 * */
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

    public static int calculateRainWater2(int[] array) {
        if (emptyArray(array) || array.length == 1) return 0;

        int left = 0, right = array.length - 1,
                leftMax = 0, rightMax = 0,
                rainWater = 0;
        while (left < right) {
            if (array[left] < array[right]) {
                if (array[left] > leftMax) {
                    leftMax = array[left];
                } else {
                    rainWater += (leftMax - array[left]);
                }
                left++;
            } else {
                if (array[right] > rightMax) {
                    rightMax = array[right];
                } else {
                    rainWater += (rightMax - array[right]);
                }
                right--;
            }
        }

        return rainWater;
    }

    public static void main(String[] args) {
        System.out.println("Volume of rain water: " + calculateRainWater(Array11));
        System.out.println("Volume of rain water: " + calculateRainWater2(Array11));
    }

}

package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 数组的值代表柱子的高度
 * 请问：数组中的所有柱子，最多能储蓄多少水呢？
 * 示例图见：resources/photos下的rain_water.png
 * */
public class RainWater {

    /**
     * 数组从最左边开始一路向右上阶梯，只往上不往下
     * 再从最右边开始也一路向左上阶梯，只往上不往下
     * 如此一来：左右阶梯图重叠的部分 = 原数组的部分 + 可蓄水的部分
     * */
    public static int calculateRainWater(int[] array) {
        if (noNeedOperation(array)) return 0;

        int i, rainWater = 0;

        int[] leftArray = new int[array.length];
        leftArray[0] = array[0];
        for (i = 1; i < array.length; i++) {
            leftArray[i] = Math.max(leftArray[i - 1], array[i]);
        }

        int[] rightArray = new int[array.length];
        rightArray[array.length - 1] = array[array.length - 1];
        for (i = array.length - 2; i >= 0; i--) {
            rightArray[i] = Math.max(rightArray[i + 1], array[i]);
        }

        for (i = 0; i < array.length; i++) {
            rainWater += (Math.min(leftArray[i], rightArray[i]) - array[i]);
        }

        return rainWater;
    }

    /**
     * 从数组/柱子两侧往中间走
     * 当左边柱子低于/等于右边柱子时，要么更新左边柱子最大值，要么增加蓄水 = 左边柱子目前最大值 - 左边当前值，然后左边接着往右移
     * 当右边柱子高于左边柱子时，要么更新右边柱子最大值，要么增加蓄水 = 右边柱子目前最大值 - 右边当前值，然后接着右边接着往左移
     * */
    public static int calculateRainWater2(int[] array) {
        if (noNeedOperation(array)) return 0;

        int left = 0, right = array.length - 1,
                leftMax = 0, rightMax = 0,
                rainWater = 0;
        while (left < right) {
            if (array[left] <= array[right]) {
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

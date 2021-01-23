package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 把数组排序成波浪数组
 * 波浪数组：a1 < a2 > a3, a3 < a4 > a5, a5 < a6 > a7, ...
 * 即：偶数位元素 > 前一奇数位元素，奇数位元素 < 前一偶数位元素
 * 如：1, 3, 2, 5, 4, 6, 3, 5, 2, ...
 * */
public class ArrayWave {

    public static int[] sortWave(int[] array) {
        if (noNeedOperation(array)) return array;

        /**
         * 插入法实现波浪数组
         * 每插1个新元素，与当下波浪数组中的尾部元素比较
         * 1.当插入偶数位数组时：
         * 若插入元素比前一奇数位元素大，则直接插入，延续波浪数组
         * 若插入元素比前一奇数位元素小，则与前一奇数位元素交换，交换后便又是波浪数组了
         * 2.当插入奇数位数组时：
         * 若插入元素比前一偶数位元素小，则直接插入，延续波浪数组
         * 若插入元素比前一偶数位元素大，则与前一偶数位元素交换，交换后便又是波浪数组了
         * */
        int[] waveArray = new int[array.length];
        waveArray[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            /**
             * 注：偶数位元素的索引是奇数，奇数位元素的索引是偶数
             * */
            if (i % 2 == 1) {
               if (array[i] > waveArray[i - 1]) {
                   waveArray[i] = array[i];
               } else {
                   waveArray[i] = waveArray[i - 1];
                   waveArray[i - 1] = array[i];
               }
            } else {
                if (array[i] < waveArray[i - 1]) {
                    waveArray[i] = array[i];
                } else {
                    waveArray[i] = waveArray[i - 1];
                    waveArray[i - 1] = array[i];
                }
            }
        }
        return waveArray;
    }

    public static void main(String[] args) {
        print(Array16);
        System.out.println("After wave sort: ");
        print(sortWave(Array16));
        System.out.println("*****************");

        print(Array17);
        System.out.println("After wave sort: ");
        print(sortWave(Array17));
    }

}

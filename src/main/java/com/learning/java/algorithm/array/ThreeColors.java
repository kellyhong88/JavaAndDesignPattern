package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 有3种颜色，即：数组中有3种值
 * 对3种颜色分组和排序，即：对数组中的3个值分组并排序
 */
public class ThreeColors {

    /**
     * 设3个指针，p0找寻颜色0，p1找寻颜色1，p2找寻颜色2
     * p0指向第一个元素，期待机会往尾部移动，p2指向最后一个元素，期待机会往头部移动
     * p1从第一个元素开始，每一轮比较中采取相应动作，并再往前移动一步
     * 若p1为0，与p0交换颜色/元素，p0得机会前进一步，p1正常前进一步
     * 若p1为1，p1正常前进一步
     * 若p1为2，与p2交换颜色/元素，p2得机会前进一步
     * */
    public static void sortColors(int[] array) {
        if (noNeedOperation(array)) return;

        int p0, p1, p2;
        p0 = p1 = 0;
        p2 = array.length - 1;

        while (p1 < p2) {
            if (array[p1] == 0) {
                if (p0 != p1 && array[p0] != array[p1]) {
                    swap(array, p0, p1);
                }
                p0++;
                p1++;
            } else if (array[p1] == 2) {
                if (array[p1] != array[p2]) {
                    swap(array, p1, p2);
                }
                p2--;
            } else {
                p1++;
            }
        }
    }

    public static void main(String[] args) {
        print(Array3);
        sortColors(Array3);
        print(Array3);
    }

}

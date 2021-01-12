package com.learning.java.algorithm.array;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 中位数：一组有序数据中居于中间位置的数
 *
 * 查找一个数组的中位数（即对数组排序后位于中间位置的数）
 * 可以利用快速排序的partition思想
 *
 * partition算法（分割算法）
 * 先选定一个枢轴元素
 * 然后把比枢轴元素小的部分都移至枢轴元素左边，把比枢轴元素大的部分都移到枢轴元素右边
 * 此时，枢轴元素在数组中的位置就被"永久地确定"下来了
 * 之后即使还需将整个数组排序，该枢轴元素的位置不会变化
 *
 * 另外，枢轴元素的选取对分割算法至关重要
 * 一般而言，终极追求的是：将数组平分
 * 因此，尽可能地让枢轴元素的选取随机化和靠近中位数
 * 例如，"三数取中"算法选取枢轴元素
 * */
public class MedianNumber {

    /**
     * 中位数是有序数组的中间位置的数
     * 即数组中第"数组长度/2"小的数
     * （第1小，第2小，...，第n/2小，...，第n小）
     *
     * 1.抽取数组的第一个元素作为枢纽
     * 用快速排序的思想进行一次调整
     * 即比枢纽值小的放在枢纽的左边
     * 比枢纽值大的放在枢纽的右边
     *
     * 2.如果枢纽的索引正好等于"数组长度/2"
     * midIndex = length/2 if 偶数数组
     *          = length/2-1 if 奇数数组
     * 那么恭喜你，枢纽就是中位数
     *
     * 3.如果枢纽的索引比数组长度的一半大
     * 那么中位数是从数组首到枢纽的这段内第"数组长度/2"小的数
     *
     * 4.如果枢纽的索引比数组长度的一半小
     * 那么中间数是从枢纽到数组尾的这段内第"数组长度/2"大的数
     * 即：第"数组长度/2 - 枢纽索引"小的数
     *
     * 5.递归调用上面几步，就可以找到中位数了
     * */

    public static int queryMedian(int[] array) {
        if (emptyArray(array)) return -1;
        return query(array, 0, array.length - 1, array.length/2);
    }

    public static int query(int[] array, int start, int end, int targetPos) {
        if (start > end) return -1;

        // 快速排序的partition算法
        int l = start, r = end, pivot = array[l];
        while (l < r) {
            while (l < r && array[r] >= pivot) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] <= pivot) {
                l++;
            }
            array[r] = array[l];
        }

        // 因为递归性质，所以不是简单的left与targetPos比较，而是(left - start)与targetPos比较
        if ((l - start) == targetPos) {
            return array[l];
        } else if ((l - start) > targetPos) {
            return query(array, start, l - 1, targetPos);
        } else {
            return query(array, l + 1, end, targetPos - (l - start) - 1);
        }
    }

    public static void main(String[] args) {
        print(Array1);
        System.out.println("Median of this array: " + queryMedian(Array1));
        print(Array14);
        System.out.println("Median of this array: " + queryMedian(Array14));
    }

}

package com.learning.java.algorithm.matrix;

import java.util.PriorityQueue;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

/**
 * 查找行列有序矩阵中第k小的元素
 * 行列有序矩阵的特点：
 * 1.矩阵的行有序
 * 2.矩阵的列有序
 * 3.矩阵未必整体有序
 */
public class MatrixKSmallest {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            /**
             * 从小到大排序：this - parameter
             * 从大到小排序：parameter - this
             * */
            return node.value - this.value;
        }
    }

    /**
     * 最大堆法
     * 遍历矩阵中所有元素，构建一个最大堆
     * 当堆中元素个数大于k时，将最大堆首元素去掉
     * 从而确保是一个最多只有k个元素的最大堆
     * 遍历结束，该最大堆就是矩阵前k小的元素集
     * 最大堆中的首元素即为矩阵第k小的元素
     */
    public static int kSmallestByHeap(int[][] matrix, int k) {
        if (emptyMatrix(matrix) || k > matrix.length * matrix[0].length) return Integer.MAX_VALUE;

        // 用优先队列模拟最大堆/最小堆
        PriorityQueue<Node> heap = new PriorityQueue<>();

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix);
        for (int i = 0; i < ROW_LEN; i++) {
            for (int j = 0; j < COLUMN_LEN; j++) {
                heap.offer(new Node(i, j, matrix[i][j]));
                if (heap.size() > k) heap.poll();
            }
        }

        return heap.peek() == null ? Integer.MAX_VALUE : heap.peek().value;
    }

    /**
     * 二分法
     * 行列有序矩阵的左上角的数字一定是最小的，右下角的数字一定是最大的
     * 但因为不一定是整体有序，所以矩阵中跨行之间的元素并不是严格有序的
     * 所以我们可以根据搜索范围，计算出中间值midValue，运用二分查找法
     * */
    public static int kSmallestByDivision(int[][] matrix, int k) {
        if (emptyMatrix(matrix)) return Integer.MAX_VALUE;

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix);
        int low = matrix[0][0], high = matrix[ROW_LEN - 1][COLUMN_LEN - 1];

        while (low < high) {
            // midValue = lowValue + half of the diff between lowValue and highValue
            int midValue = low + (high - low) / 2;
            int count = 0, j = COLUMN_LEN - 1;
            for (int i = 0; i < ROW_LEN; i++) {
                while (j >= 0 && matrix[i][j] > midValue) j--;
                count += (j + 1);
            }
            if (count < k) low = midValue + 1;
            else high = midValue;
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println("Print 7 smallest element in MatrixB: " + kSmallestByHeap(MatrixB, 7));
        System.out.println("Print 12 smallest element in MatrixB: " + kSmallestByHeap(MatrixB, 12));
        System.out.println("Print 7 smallest element in MatrixB: " + kSmallestByDivision(MatrixB, 7));
        System.out.println("Print 12 smallest element in MatrixB: " + kSmallestByDivision(MatrixB, 12));
    }

}

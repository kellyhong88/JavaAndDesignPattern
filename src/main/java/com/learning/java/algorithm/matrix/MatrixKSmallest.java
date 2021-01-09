package com.learning.java.algorithm.matrix;

import java.util.PriorityQueue;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

/**
 * 查找行列有序矩阵中第k小的元素
 * 行列有序矩阵的特点：
 * 1.矩阵的行有序
 * 2.矩阵的列有序
 * 3.矩阵未必是蛇形有序（即未必整体有序）
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
     * 最大堆方法
     * 遍历矩阵中所有元素，构建一个最大堆
     * 当堆中元素大于k时，将最大堆首元素去掉
     * 遍历结束，堆中首元素即为矩阵第k小的元素
     */
    public static int kSmallest(int[][] matrix, int k) {
        if (emptyMatrix(matrix)) return Integer.MAX_VALUE;

        // 用优先队列模拟最大堆/最小堆
        PriorityQueue<Node> heap = new PriorityQueue<>();

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix);
        for (int i = 0; i < ROW_LEN; i++) {
            for (int j = 0; j < COLUMN_LEN; j++) {
                heap.offer(new Node(i, j, matrix[i][j]));
                if (heap.size() > k) heap.poll();
            }
        }

        return heap.peek().value;
    }

    public static void main(String[] args) {
        System.out.println("Print 7 smallest element in MatrixB: " + kSmallest(MatrixB, 7));
        System.out.println("Print 12 smallest element in MatrixB: " + kSmallest(MatrixB, 12));
    }

}

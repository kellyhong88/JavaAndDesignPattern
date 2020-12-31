package com.learning.java.algorithm.matrix;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

/**
 * 矩阵（二维数组）中元素的查找
 * */
public class MatrixSearch {

    /**
     * MatrixA 特点：
     * 1. 二维数组中的每行都是递增序列
     * 2. 二维数组中的每列都是递增序列
     * 3. 整个二维数组是递增序列
     * */
    public static boolean existedInMatrixA(int[][] matrix, int target) {
        if (emptyMatrix(matrix)) return false;

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix);
        int left = 0, right = ROW_LEN * COLUMN_LEN - 1;
        int pivotIdx, pivot;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivot = matrix[pivotIdx / COLUMN_LEN][pivotIdx % COLUMN_LEN];
            if (target == pivot) return true;
            else if (target < pivot) {
                right = pivotIdx - 1;
            } else {
                left = pivotIdx + 1;
            }
        }
        return false;
    }

    public static boolean existedInMatrixA2(int[][] matrix, int target) {
        if (emptyMatrix(matrix)) return false;

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix);
        int row = 0, column = COLUMN_LEN - 1;
        while (row < ROW_LEN && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    /**
     * MatrixB 特点：
     * 1. 二维数组中的每行都是递增序列
     * 2. 二维数组中的每列都是递增序列
     * 3. 整个二维数组不是递增序列
     * */
    public static boolean existedInMatrixB(int[][] matrix, int target) {
        if (emptyMatrix(matrix)) return false;

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix);
        int row = ROW_LEN - 1, column = 0;
        while (row >= 0 && column < COLUMN_LEN) {
            if (matrix[row][column] < target) {
                column++;
            } else if (matrix[row][column] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Does 3 exist in the MatrixA: " + existedInMatrixA(MatrixA, 3));
        System.out.println("Does 13 exist in the MatrixA: " + existedInMatrixA(MatrixA, 13));
        System.out.println("Does 3 exist in the MatrixA: " + existedInMatrixA2(MatrixA, 3));
        System.out.println("Does 13 exist in the MatrixA: " + existedInMatrixA2(MatrixA, 13));
        System.out.println("Does 8 exist in the MatrixB: " + existedInMatrixB(MatrixB, 8));
        System.out.println("Does 17 exist in the MatrixB: " + existedInMatrixB(MatrixB, 17));
        System.out.println("Does 19 exist in the MatrixB: " + existedInMatrixB(MatrixB, 19));
        System.out.println("Does 24 exist in the MatrixB: " + existedInMatrixB(MatrixB, 24));
    }

}

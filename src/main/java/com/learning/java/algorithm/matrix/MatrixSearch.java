package com.learning.java.algorithm.matrix;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

public class MatrixSearch {

    public static boolean existedInMatrixA(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = getRowLength(matrix), n = getColumnLength(matrix);
        int left = 0, right = m * n - 1;
        int pivotIdx, pivot;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivot = matrix[pivotIdx / m][pivotIdx % m];
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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0, column = getColumnLength(matrix) - 1;
        while (row < matrix.length && column >= 0) {
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

    public static boolean existedInMatrixB(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = getRowLength(matrix) - 1, column = 0;
        while (row >= 0 && column < matrix[0].length) {
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

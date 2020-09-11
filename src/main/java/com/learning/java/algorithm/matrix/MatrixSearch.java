package com.learning.java.algorithm.matrix;

public class MatrixSearch {

    public static int[][] MatrixA = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    public static int[][] MatrixB = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22}
    };

    public static boolean existedInMatrixA(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
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

        int row = 0, column = matrix[0].length - 1;
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

        int row = matrix.length - 1, column = 0;
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

package com.learning.java.algorithm.matrix;

public class MatrixSearch {

    public static int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

    public static boolean existed(int[][] matrix, int target) {
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

    public static boolean existed2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) return true;
            else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Does 3 exist in the matrix: " + existed(matrix, 3));
        System.out.println("Does 13 exist in the matrix: " + existed(matrix, 13));
        System.out.println("Does 3 exist in the matrix: " + existed2(matrix, 3));
        System.out.println("Does 13 exist in the matrix: " + existed2(matrix, 13));
    }

}

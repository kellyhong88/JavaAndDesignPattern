package com.learning.java.algorithm.matrix;

public class MatrixUtils {

    public static int[][] MatrixA = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    };

    public static int[][] MatrixB = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22}
    };

    public static int[][] MatrixC = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
    };

    public static int[][] MatrixD = {
            {1, 2, 3, 4},
            {16, 17, 18, 5},
            {15, 24, 19, 6},
            {14, 23, 20, 7},
            {13, 22, 21, 8},
            {12, 11, 10, 9}
    };

    public static boolean emptyMatrix(int[][] matrix) {
        return matrix == null || matrix.length == 0 || matrix[0].length == 0;
    }

    public static int getRowLength(int[][] matrix) {
        if (emptyMatrix(matrix)) return 0;
        else return matrix.length;
    }

    public static int getColumnLength(int[][] matrix) {
        if (emptyMatrix(matrix)) return 0;
        else return matrix[0].length;
    }

}

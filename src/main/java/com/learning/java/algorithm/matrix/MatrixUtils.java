package com.learning.java.algorithm.matrix;

public class MatrixUtils {

    public static int[][] MatrixA = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}};

    public static int[][] MatrixB = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22}
    };

    public static int[][] MatrixC = {
            { 1, 2, 3, 4, 5},
            { 1, 2, 3, 4, 5},
            { 1, 2, 3, 4, 5},
            { 1, 2, 3, 4, 5},
            { 1, 2, 3, 4, 5}
    };

    public static int[][] MatrixD = {
            { 1, 2, 3, 4},
            { 1, 2, 3, 4},
            { 1, 2, 3, 4},
            { 1, 2, 3, 4},
            { 1, 2, 3, 4},
            { 1, 2, 3, 4}
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

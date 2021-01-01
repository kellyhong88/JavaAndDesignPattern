package com.learning.java.algorithm.matrix;

import com.learning.java.algorithm.list.BaseList;

import java.util.ArrayList;
import java.util.List;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

/**
 * 矩阵（二维数组）的螺旋遍历
 * */
public class MatrixSpiral {

    public static List<Integer> spiralTravel(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (emptyMatrix(matrix)) return list;

        int ROW_LEN = getRowLength(matrix), COLUMN_LEN = getColumnLength(matrix),
                ROUNDS = (int) Math.ceil(Math.min(ROW_LEN, COLUMN_LEN) / 2.0),
                TOTAL = ROW_LEN * COLUMN_LEN;
        for (int round = 0; round < ROUNDS; round++) {
            /**
             * travel the upper line
             * startIdx: 0 + round
             * endIdx: (COLUMN_LEN - 1) - round
             * */
            for (int i = round; i <= COLUMN_LEN - 1 - round; i++) {
                list.add(matrix[round][i]);
            }
            if (list.size() == TOTAL) break;

            /**
             * travel the right line without the first one of the current line
             * startIdx: 1 + round
             * endIdx: (ROW_LEN - 1) - round
             * */
            for (int i = 1 + round; i <= ROW_LEN - 1 - round; i++) {
                list.add(matrix[i][COLUMN_LEN - 1 - round]);
            }
            if (list.size() == TOTAL) break;

            /**
             * travel the down line without the last one of the current line
             * startIdx: (COLUMN_LEN - 1) - 1 - round
             * endIdx: 0 + round
             * */
            for (int i = (COLUMN_LEN - 1) - 1 - round; i >= round; i--) {
                list.add(matrix[ROW_LEN - 1 - round][i]);
            }
            if (list.size() == TOTAL) break;

            /**
             * travel the left line without the first one and the last one of the current line
             * startIdx: (ROW_LEN - 1) - 1 - round
             * endIdx: 0 + 1 + round
             * */
            for (int i = (ROW_LEN - 1) - 1 - round; i >= 1 + round; i--) {
                list.add(matrix[i][round]);
            }
            if (list.size() == TOTAL) break;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println("Spiral travelling results of MatrixA: ");
        BaseList.printList(spiralTravel(MatrixA));

        System.out.println("Spiral travelling results of MatrixB: ");
        BaseList.printList(spiralTravel(MatrixB));

        System.out.println("Spiral travelling results of MatrixC: ");
        BaseList.printList(spiralTravel(MatrixC));

        System.out.println("Spiral travelling results of MatrixD: ");
        BaseList.printList(spiralTravel(MatrixD));
    }

}

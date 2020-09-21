package com.learning.java.algorithm.matrix;

import com.learning.java.algorithm.list.BaseList;

import java.util.ArrayList;
import java.util.List;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

public class MatrixSpiral {

    public static List<Integer> spiralTravel(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (emptyMatrix(matrix)) return list;

        int row = getRowLength(matrix), column = getColumnLength(matrix),
                rounds = Math.min(row, column) / 2 + 1,
                total = row * column;
        for (int round = 0; round < rounds; round++) {
            /**
             * travel the upper line
             * startIdx: 0 + round
             * endIdx: (columnLength - 1) - round
             * */
            for (int i = round; i <= column - 1 - round; i++) {
                list.add(matrix[round][i]);
            }
            if (list.size() == total) break;

            /**
             * travel the right line without the first one of current line
             * startIdx: 1 + round
             * endIdx: (rowLength - 1) - round
             * */
            for (int i = 1 + round; i <= row - 1 - round; i++) {
                list.add(matrix[i][column - 1 - round]);
            }
            if (list.size() == total) break;

            /**
             * travel the down line without the last one of current line
             * startIdx: (columnLength - 1) - 1 - round
             * endIdx: 0 + round
             * */
            for (int i = (column - 1) - 1 - round; i >= round; i--) {
                list.add(matrix[row - 1 - round][i]);
            }
            if (list.size() == total) break;

            /**
             * travel the left line without the first one and the last one of current line
             * startIdx: (rowLength - 1) - 1 - round
             * endIdx: 0 + 1 + round
             * */
            for (int i = (row - 1) - 1 - round; i >= 1 + round; i--) {
                list.add(matrix[i][round]);
            }
            if (list.size() == total) break;
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

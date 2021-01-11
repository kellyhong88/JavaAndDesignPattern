package com.learning.java.algorithm.matrix;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

/**
 * 深度优先遍历：DFS (Depth First Search)
 * 广度优先遍历：BFS (Breadth First Search)
 * 参考：https://zhuanlan.zhihu.com/p/133390668
 * */
public class MatrixIsland {

    public static int calculateIslands(int[][] matrix) {
        if (emptyMatrix(matrix)) return 0;

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
        if (matrix[i][j] != 1) return;

        // 标记已经遍历过
        matrix[i][j] = 2;

        // 递归遍历当前元素的四个方向
        dfs(matrix, i - 1, j);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
    }

    public static void main(String[]  args) {
        System.out.println("Islands number of MatrixE: " + calculateIslands(MatrixE));
        System.out.println("Islands number of MatrixF: " + calculateIslands(MatrixF));
    }

}

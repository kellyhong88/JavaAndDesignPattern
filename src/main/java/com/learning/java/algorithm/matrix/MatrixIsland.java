package com.learning.java.algorithm.matrix;

import static com.learning.java.algorithm.matrix.MatrixUtils.*;

/**
 * 深度优先遍历：DFS (Depth First Search)
 * 广度优先遍历：BFS (Breadth First Search)
 * 参考：https://zhuanlan.zhihu.com/p/133390668
 * */
public class MatrixIsland {

    /**
     * 只有1和0两种元素的矩阵/二维数组
     * 1：岛域
     * 0：水域
     * 一片连成片的1 + 四周都是0 -> 构成一个孤岛
     * 计算矩阵中孤岛的个数
     * */
    public static int calculateIslands(int[][] matrix) {
        if (emptyMatrix(matrix)) return 0;

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                /**
                 * 遇到1则开始遍历/探索当前的孤岛域
                 * 遍历完则孤岛数count加1
                 * */
                if (matrix[i][j] == 1) {
                    /**
                     * 用深度优先遍历DFS来遍历出孤岛的岛域/范围
                     * */
                    dfs(matrix, i, j);
                    /**
                     * 遍历完孤岛数+1
                     * */
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 深度优先遍历
     * */
    public static void dfs(int[][] matrix, int i, int j) {
        /**
         * 边界情况判断（corner cases）
         * 同时也是递归的终止条件（递归一定要有终止条件，不然就是无限循环）
         * */
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;

        /**
         * 如果是0(水域) 或 2(元素已被遍历过)，则结束遍历
         * 是递归的另一个终止条件
         * */
        if (matrix[i][j] != 1) return;

        /**
         * 标记当前的1元素(岛域)已经被遍历过
         * */
        matrix[i][j] = 2;

        /**
         * 递归遍历当前元素/岛域的四个方向
         * 从而探索孤岛的范围
         * */
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

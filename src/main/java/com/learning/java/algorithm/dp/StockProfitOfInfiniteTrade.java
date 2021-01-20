package com.learning.java.algorithm.dp;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

/**
 * 第i天的股票价格是price[i]
 * 交易次数为不超过K次
 * 每天只能3种动作之一：买入、卖出、不动
 * 求最大利润
 *
 * 动态规划（Dynamic Programming）
 *
 * dp[i][k][s]：第i+1天，经过最多k次交易（1买1卖为1次交易）后，持仓情况为s（1：持仓，0：空仓）的状态
 * dp[N-1][K][0]：第N天，经过最多K次交易后，持仓情况为空仓的状态（本题想求的就是该状态下的最大利润）
 *
 * 状态转移方程
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
 *
 * base case
 * dp[-1][k][0] = 0
 * dp[-1][k][1] = impossible
 * dp[0][k][0] = 0
 * dp[0][k][1] = -price[0]
 * dp[i][0][0] = 0
 * dp[i][0][1] = impossible
 * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + price[i])
 * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - price[i])
 *
 * 参考：https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md
 * */
public class StockProfitOfInfiniteTrade {

    /**
     * 交易次数为无限多次（K=infinity）
     *
     * 状态转移方程
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
     *             = max(dp[i-1][k][1], dp[i-1][k][0] - price[i])
     * k可以是k-1、k+1或任何数，因此状态转移方程中可以去掉k
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - price[i])
     *
     * base case
     * dp[-1][0] = 0
     * dp[-1][1] = Integer.MIN_VALUE
     * dp[0][0] = 0
     * dp[0][1] = -price[0]
     * */
    public static int calculateMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int N = prices.length;
        int[][] profits = new int[N][2];

        //base case
        profits[0][0] = 0;
        profits[0][1] = -prices[0];

        //状态转移方程
        for (int i = 1; i < N; i++) {
            profits[i][0] = Math.max(profits[i - 1][0], profits[i - 1][1] + prices[i]);
            profits[i][1] = Math.max(profits[i - 1][1], profits[i - 1][0] - prices[i]);
        }

        return profits[N - 1][0];
    }

    public static int calculateMaxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int N = prices.length;

        //base case
        int profits_0 = 0;
        int profits_1 = -prices[0];

        //状态转移方程
        for (int i = 1; i < N; i++) {
            profits_0 = Math.max(profits_0, profits_1 + prices[i]);
            profits_1 = Math.max(profits_1, profits_0 - prices[i]);
        }

        return profits_0;
    }

    /**
     * Restrictions:
     * you can sell the stock whenever you want after you buy the stock,
     * but you cannot buy the stock JUST the day after you sell the stock
     * in other words, you can only buy the stock at least 2 days after the day you sell the stock
     *
     * So this restriction makes 2 statuses grow to 3 statuses:
     * 0: I have no stock and I can buy the stock today
     * 1: I have the stock and I can sell the stock today
     * 2: I have no stock and I cannot buy the stock today
     *
     * State transition:
     * 0 -> 0, 1
     * 1 -> 1, 2
     * 2 -> 0
     *
     * 0, 2 -> 0
     * 0, 1 -> 1
     * 1 -> 2
     * */
    public static int calculateMaxProfitWithRestriction(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int N = prices.length;
        int[][] profits = new int[N][3];

        //base case
        profits[0][0] = 0;
        profits[0][1] = -prices[0];
        profits[0][2] = Integer.MIN_VALUE;

        //状态转移方程
        for (int i = 1; i < N; i++) {
            profits[i][0] = Math.max(profits[i - 1][0], profits[i - 1][2]);
            profits[i][1] = Math.max(profits[i - 1][1], profits[i - 1][0] - prices[i]);
            profits[i][2] = profits[i - 1][1] + prices[i];
        }

        /**
         * the last day with max profit can be either status 0 (have no stock) or status 2 (have no stock and cannot buy the stock)
         * */
        return Math.max(profits[N - 1][0], profits[N - 1][2]);
    }

    public static void main(String[] args) {
        System.out.print("Prices of " + Array7.length + " days: ");
        print(Array7);
        System.out.println("You can trade as many times as you want");
        System.out.println("Maximum profit: " + calculateMaxProfit(Array7));
        System.out.println("--------------------------");
        System.out.print("Prices of " + Array1.length + " days: ");
        print(Array1);
        System.out.println("You can trade as many times as you want");
        System.out.println("Maximum profit: " + calculateMaxProfit2(Array1));
        System.out.println("--------------------------");
        print(Array13);
        System.out.println("You can trade as many times as you want");
        System.out.println("Maximum profit: " + calculateMaxProfit2(Array13));
        System.out.println("You can trade as many times as you want but there is one restriction: ");
        System.out.println("you cannot buy the stock JUST the day after you sell the stock");
        System.out.println("Maximum profit: " + calculateMaxProfitWithRestriction(Array13));
    }

}

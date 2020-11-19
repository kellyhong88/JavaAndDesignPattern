package com.learning.java.algorithm.dp;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

public class StockProfitOfOneTrade {

    /**
     * 交易次数为1次（K=1）
     *
     * 状态转移方程
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + price[i])
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - price[i])
     *             = max(dp[i-1][1][1], - price[i])
     * k都是1，不会改变，因此对状态转移方程没有影响了
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
     * dp[i][1] = max(dp[i-1][1], - price[i])
     *
     * base case
     * dp[-1][k][0] = 0
     * dp[-1][k][1] = Integer.MIN_VALUE
     * dp[0][0][0] = 0
     * dp[0][0][1] = Integer.MIN_VALUE
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
            profits[i][1] = Math.max(profits[i - 1][1], - prices[i]);
        }

        return profits[N - 1][0];
    }

    public static int calculateMaxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int N = prices.length;
        // base case
        int profits_0 = 0, profits_1 = -prices[0];

        //状态转移方程
        for (int i = 1; i < N; i++) {
            profits_0 = Math.max(profits_0, profits_1 + prices[i]);
            profits_1 = Math.max(profits_1, - prices[i]);
        }

        return profits_0;
    }

    public static void main(String[] args) {
        System.out.print("Prices of " + Array7.length + " days: ");
        print(Array7);
        System.out.println("You can only trade once");
        System.out.println("Maximum profit: " + calculateMaxProfit(Array7));
        System.out.println("--------------------------");
        System.out.print("Prices of " + Array1.length + " days: ");
        print(Array1);
        System.out.println("You can only trade once");
        System.out.println("Maximum profit: " + calculateMaxProfit2(Array1));
    }

}

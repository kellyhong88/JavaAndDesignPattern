package com.learning.java.algorithm.dp;

import static com.learning.java.algorithm.sort.ArrayUtils.*;

public class StockProfitOfThreeTrades {

    /**
     * 交易次数不超过3次（K=3）
     *
     * 状态转移方程
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
     *
     * base case
     * dp[-1][k][0] = 0
     * dp[-1][k][1] = Integer.MIN_VALUE
     * dp[0][k][0] = 0
     * dp[0][k][1] = -price[0]
     * dp[i][0][0] = 0
     * dp[i][0][1] = Integer.MIN_VALUE
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + price[i])
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - price[i])
     * */
    public static int calculateMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int N = prices.length;
        int profits[][][] = new int[N][4][2];

        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= 3; k++) {
                if (i == 0) {
                    profits[0][k][0] = 0;
                    profits[0][k][1] = 0 - prices[0];
                } else {
                    profits[i][k][0] = Math.max(profits[i - 1][k][0], profits[i - 1][k][1] + prices[i]);
                    profits[i][k][1] = Math.max(profits[i - 1][k][1], profits[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return profits[N - 1][3][0];
    }

    public static void main(String[] args) {
        System.out.print("Prices of " + Array7.length + " days: ");
        print(Array7);
        System.out.println("You can trade three times at most");
        System.out.println("Maximum profit: " + calculateMaxProfit(Array7));
        System.out.println("--------------------------");
        System.out.print("Prices of " + Array1.length + " days: ");
        print(Array1);
        System.out.println("You can trade three times at most");
        System.out.println("Maximum profit: " + calculateMaxProfit(Array1));
    }

}

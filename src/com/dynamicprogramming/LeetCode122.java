package com.dynamicprogramming;

public class LeetCode122 {
    public static void main(String[] args) {

    }

    /**
     * dp[i][0]: i天手上持有股票的最大收益
     * dp[i][1]: i天手上没有股票的最大收益
     * dp[i+1][0] = max(dp[i][1] - prices[i], dp[i][0])
     * dp[i+1][1] = max(dp[i][0] + prices[i+1], dp[i][1] )
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[][] dp = new int[len+1][2];
        dp[1][0] = -1 * prices[0];
        dp[1][1] = 0;
        int max = 0;
        for(int i = 1; i < len; i++){
            dp[i+1][0] = Math.max(dp[i][1] - prices[i], dp[i][0]);
            dp[i+1][1] = Math.max(dp[i][0] + prices[i], dp[i][1]);
            max = Math.max(max, dp[i+1][0]);
            max = Math.max(max, dp[i+1][1]);
        }
        return max;
    }
}

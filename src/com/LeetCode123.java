package com;

import java.util.Arrays;

public class LeetCode123 {
    public static void main(String[] args) {
        int[] prices = {2,1,4,5,2,9,7};
        int i = new LeetCode123().maxProfit(prices);
        System.out.println(i);
    }
    //dp[i][j] + dp[m][n]

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][len];//dp[i][j] 从 i天到 j天的最大收益

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 0;
            int minPrice = prices[i];
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = prices[j] - minPrice;
                minPrice = Math.min(minPrice, prices[j]);
            }
        }
        for(int[] d: dp){
            System.out.println(Arrays.toString(d));
        }
        int maxProfit = 0;


        return maxProfit;
    }
}

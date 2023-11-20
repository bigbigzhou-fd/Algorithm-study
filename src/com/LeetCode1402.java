package com;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode1402 {
    //怎么确定前面选择几个 选择哪几个

    public int maxSatisfaction3(int[] satisfaction){
        Arrays.sort(satisfaction);
//        int max = 0;
        int ans = 0;
        int temp = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            temp += satisfaction[i];
            ans += temp;
        }
        return ans;
    }

    public int maxSatisfaction1(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        int[][] dp = new int[len + 1][len + 1];
        //dp[i][j] = dp[i-1][j-1]， dp[i-1][j-1] + satisfaction[i] * j; //i个菜里面选 j
        int max = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + satisfaction[i - 1] * j, dp[i - 1][j]);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int maxSatisfaction2(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        int[][] dp = new int[len + 1][len + 1];
        //dp[i][j] = dp[i-1][j-1]， dp[i-1][j-1] + satisfaction[i] * j; //i个菜里面选 j
        int max = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j;
                if (j < i) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] satisfaction ={-1,-8,0,5,-7};
        int res1 = new LeetCode1402().maxSatisfaction1(satisfaction);
        int res2 = new LeetCode1402().maxSatisfaction1(satisfaction);
        System.out.println(res1);
        System.out.println(res2);
    }
}

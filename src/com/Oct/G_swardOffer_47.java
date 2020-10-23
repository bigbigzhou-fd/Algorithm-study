package com.Oct;

import java.util.Arrays;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/23 13:34
 */
public class G_swardOffer_47 {
    //每次只能向右边或者下边走,对于当前格子来说，只能是左边或者上面的格子过来的
    public static int maxValue(int[][] grid) {
        int len = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[len][col];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < col; j++) {
                if (i - 1 < 0 && j - 1 < 0) {//grid[0][0]的情况
                    dp[i][j] = grid[i][j];
                } else {//至少是有一个不是0的了
                    if (i - 1 < 0) {//j-1 >=0
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {

                        int max = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                        dp[i][j] = max + grid[i][j];
                    }

                }
            }
        }
//        for(int i = 0;i<len;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[len - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue(grid));


    }
}

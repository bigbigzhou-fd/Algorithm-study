package com.Oct;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/23 14:07
 */
public class G_lee_53 {
    //给你一个数组，求一个最大的连续的子序列的和
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}

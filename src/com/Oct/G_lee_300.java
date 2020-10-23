package com.Oct;

import java.util.Arrays;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/23 14:22
 */
public class G_lee_300 {

    //改进版其实我还是不会！
    //https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }


    //最长上升子序列
    public static int lengthofLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1)
            return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = -1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = (dp[j] + 1) > dp[i] ? (dp[j] + 1) : dp[i];
                }
                max = dp[i] > max ? dp[i] : max;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(lengthofLIS(nums));
    }
}

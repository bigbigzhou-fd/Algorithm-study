package com.Nov;

import java.util.Arrays;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-07 13:06
 * @description 区间和的个数
 * 给定一个数组，从i到j区间内的连续和在[lower,upper]之间
 */
public class D_lee_327 {

    public static int  countRangeSum(int[] nums,int lower,int upper){
        long[][] a = new long[nums.length][nums.length];
        for(int i = 0;i<nums.length;i++){

            for(int j=i;j<nums.length;j++){

                if(i==j){
                    a[i][j] = nums[i];
                    continue;
                }

                if(j>i ){
                    a[i][j] = a[i][j-1]+nums[j];
                }
            }
        }
        for (long[] t:a
             ) {
            System.out.println(Arrays.toString(t));
        }
        int result = 0;

        for(int i =0;i<nums.length;i++){
            for(int j =i;j<nums.length;j++){
                if(a[i][j] >= lower &&a[i][j] <= upper)
                    result++;
            }
        }

        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        int lower = -564;
        int upper = 3864;
        countRangeSum(nums,lower,upper);

    }
}

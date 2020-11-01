package com.Oct;

import java.util.Arrays;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/25 15:02
 */
public class I_lee_845 {

    //求数组中拿出左边上升，右边下降
    public static int longestMountain(int[] A){
        if(A.length <=2 ){
            return 0;
        }
        //dp[i][0]代表：左边比它小的元素的个数
        //dp[i][1]代表：右边比它小的元素的个数
        int[][] dp=new int[A.length][2];
//        dp[0][0] = 0;//最左边的元素比它小的元素个数是0
//        Arrays.fill(dp,0);
        for (int[] dp1:
             dp) {
            Arrays.fill(dp1,0);
        }
        for(int i = 1;i<A.length;i++){
            if(A[i] > A[i-1]){
                dp[i][0] = dp[i-1][0]+1;
            }
        }
        for(int i=A.length-2;i>=0;i--){
            if(A[i]>A[i+1]){
                dp[i][1] = dp[i+1][1]+1;
            }
        }
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(dp[i][0] == 0 || dp[i][1] == 0){
                continue;//这个元素不满足山顶的特性
            }
            max = Math.max(max,dp[i][0]+dp[i][1]);
        }
//        for (int[] dp1:dp
//             ) {
//            System.out.println( Arrays.toString(dp1));
//        }
        if(max == 0){
            return 0;
        }else{
            return max+1;
        }
    }

    public static void main(String[] args) {
//        int[] A = {2,1,4,7,3,2,5};
//        System.out.println(longestMountain(A));
//
//        int[] B ={2,2,2};
//        System.out.println(longestMountain(B));
          int[] C = {2,3};
        System.out.println(longestMountain(C));
    }
}

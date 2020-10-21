package com.dynamic;

//给你一段长度为n的绳子，想办法拆分成几段，拆分后乘积最大
//10 = 3+3+4 max = 36
public class lee_343 {

    public static int F(int n){
        if(n==2){
            return 1;
        }
        int res = -1;
        for(int i = 1;i<n-1;i++){
            res = Math.max(res,Math.max(i*F(n-i),i*(n-i)));
        }
        return res;
    }


    //记忆型动态规划
    public static int F1(int n,int[] dp){
        if(dp[n] != 0){
            return dp[n];
        }

        if(n==2){
            dp[2] = 1;
            return 1;
        }

        int res = -1;
        for(int i =1;i<n-1;i++){
            res = Math.max(res,Math.max(i*F1(n-i,dp),i*(n-i)));
        }
        dp[n] = res;
        return res;
    }

    //方法一采用递归，按照公式慢慢推
    //方法二在方法一的基础上用了一个数组，减少了重复计算
    //我们之前的方法都是在n的基础上去计算n-1,现在反过来尝试使用小数来推导大数
    public static int F3(int n){
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int[] dp =new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        for(int i =4;i<=n;i++){

            for(int j = 1;j<i;j++){

                    dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        long s1 = System.currentTimeMillis();
//        System.out.println(F(19));
//        long e1 = System.currentTimeMillis();
//        System.out.println("无记忆型递归花费时间："+(e1-s1));

//        int[] dp = new int[20];
//        long s2 = System.currentTimeMillis();
//        System.out.println(F1(19,dp));
//        long e2 = System.currentTimeMillis();
//        System.out.println("记忆性递归话费时间："+(e2-s2));

        long s3 = System.currentTimeMillis();
        System.out.println(F3(10));
        long e3 = System.currentTimeMillis();
        System.out.println("由下而上动态规划时间："+(e3-s3));
    }
}

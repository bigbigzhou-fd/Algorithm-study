package com.Oct;

public class C_lee_343 {

    //给你一个长度为n的绳子，最低要分成两段，要求你分的时候，让这些段的乘机最大
    public static int integerBreak(int n){

        if(n==1)
            return 0;

        if(n==2){//1 1 = 1
            return 1;
        }
        if(n==3){//1 1 1 = 1;1 2 = 2
            return 2;
        }

        int res = -1;
        for(int i = 1;i<n;i++){
            res = Math.max(res,i*integerBreak(n-i));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(33));
    }
}

package com.Oct;


import java.util.Arrays;

/*
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
 */
public class A_Lee_977 {

    public int[] sortedSquares(int[] A){
        for(int i=0;i<A.length;i++){
            A[i] = A[i]*A[i];

        }

        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {

    }
}

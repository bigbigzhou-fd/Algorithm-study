package com.Nov;

import java.util.Arrays;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-14 17:59
 * @description
 * 数组中一半奇数 一半偶数 奇数位置上放奇数 偶数位置上放偶数
 */
public class E_lee_922 {

    public int[] sortArrayByPartityII(int[] A){

        if(A==null ||A.length<=1){
            return A;
        }

        int i = 0;
        int j = 1;

        while(i < A.length && j<A.length){
            while( i < A.length && A[i] %2 ==0){
                i += 2;
            }

            while(j<A.length && A[j] %2 ==1){
                j += 2;
            }

            if(j>= A.length || i>= A.length){
                break;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
//        System.out.println(Arrays.toString(A));
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4,2,5,7};
        new E_lee_922().sortArrayByPartityII(A);

    }
}

package com.Oct;

import java.util.Arrays;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-27 10:53
 * @description csdn上的矩阵题目最后一个
 */
public class J_lee_73_matrixSetZero {

    public static  void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowf = new boolean[m];//每一行中是否存在0元素
        boolean[] colf = new boolean[n];//每一列中是否存在0元素
        Arrays.fill(rowf,false);
        Arrays.fill(colf,false);
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    rowf[i] = true;
                    colf[j] = true;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(rowf[i]  || colf[j]){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int[] b:matrix
             ) {
            System.out.println(Arrays.toString(b));
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(a);
    }
}

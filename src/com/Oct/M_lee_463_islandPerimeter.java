package com.Oct;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-30 14:09
 * @description
 * 计算二阶矩阵的边长
 */
public class M_lee_463_islandPerimeter {

    public static int islandPerimeter(int[][] grid){

        int sum = 0;

        //从上往下 从左往右
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    int count = 4;
                    //上面有格子
                    if(i-1>=0 && grid[i-1][j] == 1){
                        count --;
                    }
                    //左边有格子
                    if(j-1>=0 && grid[i][j-1] == 1){
                        count --;
                    }
                    //右边有格子
                    if(j+1<col && grid[i][j+1] == 1){
                        count--;
                    }
                    //下边有格子
                    if(i+1<row && grid[i+1][j] == 1){
                        count --;
                    }
                    sum +=count;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

}

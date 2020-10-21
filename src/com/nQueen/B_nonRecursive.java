package com.nQueen;

import java.util.Arrays;

//n皇后的非递归写法
public class B_nonRecursive {

    public static int count = 0;//记录总共有多少种放置方式

    //判断一个棋子放置的位置是否OK
    public static boolean isOK(int row,int[] place){
        for(int i =1;i<row;i++){
            if(place[i] == place[row])
                return false;
            if(Math.abs(i-row) == Math.abs(place[i]-place[row]))
                return false;
        }
        return true;
    }

    //非递归写法，尝试将n个棋子放到n行n列的盘子里面
    public static void F(int n){
        int[] place = new int[n+1];//place[i],i个皇后放置得位置
        int row=1;
        place[row] =1;

        while(row >0){

           if(row <= n && place[row] <= n){

                if(isOK(row,place)){//row行的皇后放在col的位置上
                    //我这一行放好了，从下一行再开始放
                    row ++;
                    if(row <= n) {
                        place[row] = 1;
                    }

                }else{
                    place[row]++;
                }

            }else{
               if(row > n){
                   count++;
                   System.out.println("第"+count+"种："+ Arrays.toString(place));
               }
                row--;//回到上一行
                place[row]++;//并且列数增加
           }
           }
        }

//    //总共有n个棋子
//    public static void trace(int n){
//        int[] place = new int[n+1];//放n的棋子的位置
//
//        int row,column;
//        while(true){
//            for(row = 1;row<=n;row++){
//
//                for(column = 1;column<=n;column++){
//                    place[row] = column;
//                    if(isOK(row,place)){
//
//                    }
//
//                }
//
//            }
//        }
//
//    }

    public static void main(String[] args) {
        F(1);

    }
}

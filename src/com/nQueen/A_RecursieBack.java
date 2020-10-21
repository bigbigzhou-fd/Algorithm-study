package com.nQueen;

import java.util.Arrays;

public class A_RecursieBack {

    public static int count = 0;//统计放置n个棋子的方法

    //我现在要放第i个棋子，总共有n个棋子,place[i],当前棋子放置的位置
    public static void placeChess(int i,int n,int[] place){

        if(i > n){//棋子全部放置成功
            count++;
            System.out.println("这是第"+count+"种解法："+ Arrays.toString(place));
            return;//！！！计算到这里你在不在返回，会到后面再继续判断的，所以要注意啊！！！
        }

        for(int k=1;k<=n;k++){
            place[i] = k;
            if(isOK(i,place)) {
                placeChess(i + 1, n, place);
            }
        }
        return;
    }

    public static boolean isOK(int i,int[] place){
        int t = 1;
        while(t<i){
            if(place[t] == place[i])//一条直线上
                return false;
            if(Math.abs(t-i) == Math.abs(place[t]-place[i])){//一条斜线上
                return false;
            }
            t++;
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 4;
        int place[] = new int[n+1];
        //我要尝试将n个棋子放在n行n列的盘子里面，要求不能再同一列，也不能在同一行
        placeChess(1,n,place);
    }
}

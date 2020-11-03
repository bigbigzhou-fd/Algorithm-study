package com.Nov;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-03 10:36
 * @description
 * 从左往右递增（可以有重复数字）
 * 从右往左必须严格递减
 */
public class B_lee_941 {

    public static boolean validMountainArray(int[] A){


        if(A == null || A.length<=2)
            return false;

        boolean flag = true;//上升阶段

        if(A[0] > A[1] )//没有上升阶段
            return false;

        for(int i = 1;i<A.length;i++){
            if(flag){
                if(i+1<A.length){
                    if(A[i] > A[i+1]){//转到下降阶段
                        flag = false;
                    }
                }else{
                    return false;//没有下降
                }
            }else{
                if(i+1 < A.length){
                    if(A[i] <= A[i+1])
                        return false;
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        int[] num1 = {2,1};
        System.out.println(validMountainArray(num1));

        int[] num2 = {3,5,5};
        System.out.println(validMountainArray(num2));

        int[] num3 = {0,3,2,1};
        System.out.println(validMountainArray(num3));
    }

}

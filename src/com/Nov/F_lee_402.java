package com.Nov;

import java.util.Arrays;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-15 18:18
 * @description
 * 丛数字中移除k位，保证数字最小
 */
public class F_lee_402 {

    public static String  removeKdigits(String num,int k){
        if(num.length() <= k){
            return "0";
        }

        int len = num.length();
        //从上一轮结束的位置开始选，同时end位置发生变化
        int end = len-k;
        int[] array = new int[len-k];

        int j =0;
        for(int i = 0;i<array.length;i++){

            if(i==0){
                j = 0;
            }

            end = len-(len-k-i);

            //截取到能选取的字符串
            String st = num.substring(j,end+1);
            System.out.println("st:"+st);



            int[] a  = F1(num,st,j);
            if(a == null){
                System.out.println("a是空的");
            }

            array[i] = a[0];
            j = a[1] +1;

            System.out.println("数字:"+a[0]+" 下标："+a[1]);
        }
        System.out.println(Arrays.toString(array));



        String res ="";
        if(array.length ==1){
            res += array[0];
           return res;
        }

        boolean flag = true;
        for(int i = 0;i<array.length;i++){

            if(i==array.length-1 && array[i] == 0 && flag){
                res = "0";
            }

            if(array[i] == 0 && flag)
                continue;
            else{
                res += array[i];
                flag = false;
            }
        }
        System.out.println("res:"+res);
        return res;
    }

    //返回字符串中最小位置的数字的下标
    public static int[]  F1(String ss,String st,int start){
        int[] res = new int[2];
//        res[0] :数字
//        res[1]:位置
        String s = "";
        for(int i = 0;i<=9;i++){
            s+=i;
            if(st.contains(s)){
                res[0] = i;
//                res[1] = st.indexOf(s);
                res[1] = ss.indexOf(s,start);
                return res;
            }
            s="";
        }

        return null;
    }

    //返回字符串中最小位置的数字的下标
    public static int[]  F(String st){
        int[] res = new int[2];
//        res[0] :数字
//        res[1]:位置
        String s = "";
        for(int i = 0;i<9;i++){
            s+=i;
            if(st.contains(s)){
                res[0] = i;
                res[1] = st.indexOf(s);
                return res;
            }
            s="";
        }

        return null;
    }

    public static void main(String[] args) {
//        String num = "1432219";
//        int k =3;
//        removeKdigits(num,k);

        String num = "100";
        int k =1;
        System.out.println(removeKdigits(num,k));

    }
}

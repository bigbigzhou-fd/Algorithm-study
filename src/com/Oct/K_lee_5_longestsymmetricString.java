package com.Oct;

import java.util.Arrays;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-28 15:11
 * @description
 * 输入: "babad"
 * 输出: "bab"
 */
public class K_lee_5_longestsymmetricString {

    public static String longestPalindrome(String s){
        if(s == null){
            return null;
        }
        if(s.length()==1){
            return s;
        }

        int len = s.length();

        int[] res = new int[len];//记录当前下标的最长串的长度

        int i=0;
        for(i=0;i<len;i++){
            int end  = len-1;
            while(end>i){

                if(s.charAt(end) == s.charAt(i)){
                    //拿到截取的字符串
                    String re = s.substring(i,end+1);//截取的字符串
//                    StringBuffer sb1 = new StringBuffer(re);
                    StringBuffer sb2 = new StringBuffer(re).reverse();//反转的字符串
                    String re1 = new String(sb2);
                    if(re.equals(re1)){
                        res[i] = end-i+1;
                        break;
                    }else{
                        end--;
                    }
                }else{
                    end--;
                }
                if(end <= i){
                    res[i] = 1;
                }
            }
        }
        int max = res[0];
        int mask = 0;//最长的下标
        for(int t = 0;t<len;t++){
            if(res[t]>max){
                max = res[t];
                mask = t;
            }
        }
//        System.out.println(Arrays.toString(res));
//        System.out.println(s.substring(mask,max));
//        System.out.println("mask:"+mask);
//        System.out.println(mask+max);
        return  s.substring(mask,mask+max);
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println("结果："+longestPalindrome(s));

        String s1 = "caba";
        System.out.println("结果："+longestPalindrome(s1));
//        System.out.println(s.substring(1,3));

//        String s = "12345678";
//        System.out.println(s.substring(0));
//        System.out.println(s.substring(1,2));
//        System.out.println(s.substring(1,3));

//        StringBuffer b1 = new StringBuffer("abcba");
//        StringBuffer b2 = new StringBuffer("abcba").reverse();
//        System.out.println(b1.equals(b2));
//        System.out.println(b1==b2);
//
//        String s1 = "abcba";
//        System.out.println(s.equals(s1));
//        System.out.println(s==s1);

    }
}

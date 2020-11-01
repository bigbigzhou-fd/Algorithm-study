package com.Oct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-31 15:07
 * @description
 *
 * 滑动窗口题目:
 *
 * 3. 无重复字符的最长子串
 *
 * 30. 串联所有单词的子串
 *
 * 76. 最小覆盖子串
 *
 * 159. 至多包含两个不同字符的最长子串
 *
 * 209. 长度最小的子数组
 *
 * 239. 滑动窗口最大值
 *
 * 567. 字符串的排列
 *
 * 632. 最小区间
 *
 * 727. 最小窗口子序列
 *
 */
public class N_lee_3 {

    //计算字符串s的最大长度
    public static int f(String s){

        if(s==null || s==""){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //记录变动的窗口
        int start=0;
        int maxlen = 1;
        for(int i = 0;i<s.length();i++){

            if(map.containsKey(s.charAt(i))){
//                    start = map.get(s.charAt(i))+1;
                start = Math.max(start,map.get(s.charAt(i))+1);
            }

            maxlen = Math.max(maxlen,i-start+1);
            map.put(s.charAt(i),i);
        }

        return maxlen;
    }

    public static int f2(String s){
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(f(s));
        System.out.println(f2(s));
    }
}

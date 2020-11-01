package com.Oct;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-31 13:34
 * @description
 * abcabcbb 3
 * bbbb 1
 * pwkew 3
 */
public class N_lee_3_longestUniqueSubString {


    public static int lengthOfLongestSubstring1(String s) {

        if(s==null){
            return 0;
        }
        if(s.length()==0 || s.length()==1){
            return s.length();
        }

        Map<Character, List<Integer>> map = new HashMap<>();

        //判断元素是否就只有一个，如果只有一个，就安全，否则就危险
        boolean dangerous[] = new boolean[s.length()];
        Arrays.fill(dangerous,false);//默认是安全的

        //计算以这个位置作为结尾元素的最大安全长度
        int maxsafe[] = new int[s.length()];

        for(int i=0;i<s.length();i++){
            char  c = s.charAt(i);
            List<Integer> list = null;

            if(!map.containsKey(c)){
                list = new ArrayList<Integer>();//list中存放元素出现的位置
                list.add(i);
                map.put(c,list);
                maxsafe[i] = i+1;//我是安全的
            }else{
                dangerous[i] = true;//这个元素已经存在了
                list = map.get(c);
                int frontend = list.get(list.size()-1);
                list.add(i);
                map.put(c,list);
                maxsafe[i] = i-frontend;//当前位置的最大安全长度
            }
        }
        int res = maxsafe[0];
        int longres = 1;
        for(int i = 1;i<s.length();i++){
            if(maxsafe[i]>maxsafe[i-1]){
                longres++;
                res = Math.max(longres,res);
            }else{
                longres = maxsafe[i-1];
            }
        }
//        System.out.println(res);
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s==null){
            return 0;
        }
        if(s.length()==0 || s.length()==1){
            return s.length();
        }

        Map<Character, List<Integer>> map = new HashMap<>();

        //判断元素是否就只有一个，如果只有一个，就安全，否则就危险
        boolean dangerous[] = new boolean[s.length()];
        Arrays.fill(dangerous,false);//默认是安全的

        //计算以这个位置作为结尾元素的最大安全长度
        int maxsafe[] = new int[s.length()];

        for(int i=0;i<s.length();i++){
            char  c = s.charAt(i);
            List<Integer> list = null;

            if(!map.containsKey(c)){
                list = new ArrayList<Integer>();//list中存放元素出现的位置
                list.add(i);
                map.put(c,list);
                maxsafe[i] = i+1;//我是安全的
            }else{
                dangerous[i] = true;//这个元素已经存在了
                list = map.get(c);
                int frontend = list.get(list.size()-1);
                list.add(i);
                map.put(c,list);
                maxsafe[i] = i-frontend;//当前位置的最大安全长度
            }
        }
        int res = maxsafe[0];
        int longres = 1;
        for(int i = 1;i<s.length();i++){
            if(maxsafe[i]>maxsafe[i-1]){
                longres++;
                res = Math.max(longres,res);
            }else{
                longres = maxsafe[i];
            }
        }
        String sb = new StringBuffer(s).reverse().toString();
        int reverseRes = lengthOfLongestSubstring1(sb);

        res = Math.max(res,reverseRes);

        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
//        String res = "abcabcbb";
//        lengthOfLongestSubstring(res);
//
//        String res1 = "bbbbb";
//        lengthOfLongestSubstring(res1);
//
//        String res2 = "pwwkew";
//        lengthOfLongestSubstring(res2);
        String res3 = "asjrjapa";
        lengthOfLongestSubstring(res3);

        String s = "";
        System.out.println(s.length());

    }
}

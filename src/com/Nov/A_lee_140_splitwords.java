package com.Nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-01 13:05
 * @description
 * 按照字典顺序截取字符串
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * //1.初次尝试拿到每个位置下面开始的字符串，但是最后拼接的时候是不是重复的太多
 */
public class A_lee_140_splitwords {

    public List<String> wordBreak(String s, List<String> wordDict){
            //以字符串每个位置为开始下标，判断这个下标下面是否存在字典中的单词，把它存放到几个里面
            Map<Integer,List<String>> map = new HashMap<>();

            for(int i=0;i<s.length();i++){

                for (String s1:wordDict) {
                    int len = s1.length();
                    if(i+len < s.length()){
                       String s2 =  s.substring(i,i+len);
                       if(s2.contains(s1)){
                           List<String> list = null;
                           if(!map.containsKey(i)){
                               list = new ArrayList<>();
                           }else{
                               list = map.get(i);
                           }
                           list.add(s1);
                           map.put(i,list);
                       }
                    }
                }

            }
        List<String> result = new ArrayList<>();

            List<String> list = map.get(0);
            if(list == null){//第一个位置就匹配不到合适的字符串
                return result;
            }



            return null;
    }

    public static void main(String[] args) {
        String a1 = "apple";
        String a2 = "appleapple";
        System.out.println(a2.indexOf(a1));
    }

}

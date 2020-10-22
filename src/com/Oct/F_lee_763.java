package com.Oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/22 19:50
 */
public class F_lee_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if (S.length() == 0)
            return list;

        int[] A = new int[26];
        Arrays.fill(A, -1);

        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';
            A[c] = i;//记录字母出现的位置
        }

//        for(int i = 0;i<S.length();i++){
//            System.out.println(S.charAt(i)+" "+A[S.charAt(i)-'a']);
//        }

        int max = A[S.charAt(0) - 'a'];//开始找每一段中最后出现字母的下标
        int len = 0;//记录每一段字母的长度

        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';//当前字母c
            len++;

            if (A[c] == i && A[c] == max) {//这个字母最后一次出现的位置就在我这里，一人组一个队伍吧
                list.add(len);
                len = 0;
                if (i + 1 < S.length()) {
                    max = A[S.charAt(i + 1) - 'a'];
                } else {
//                    System.out.println(list.toString());
                    return list;
                }
//                max = -1;
                continue;
            }

            if (A[c] > max) {
                max = A[c];
            }

        }
//        System.out.println(list.toString());
        return list;
    }
}

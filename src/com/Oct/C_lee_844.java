package com.Oct;

import java.util.Stack;

public class C_lee_844 {

    //给定两个字符串
    /*
    输入：S = "a##c", T = "#a#c"
    输出：true
    解释：S 和 T 都会变成 “c”。
     */
    public static boolean backspaceCompare(String S,String T){
        String s1 = "";
        Stack<Character> sta1 = new Stack<Character>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='#')
                sta1.push(S.charAt(i));

            if(S.charAt(i)=='#'){
                if(!sta1.empty()){
                    sta1.pop();
                }
            }
        }
        System.out.println("sta1:"+sta1.toString());

        Stack<Character> sta2 = new Stack<Character>();
        for(int i=0;i<T.length();i++){
            if(T.charAt(i)!='#')
                sta2.push(T.charAt(i));

            if(T.charAt(i)=='#'){
                if(!sta2.empty()){
                    sta2.pop();
                }
            }
        }
        System.out.println("sta2:"+sta2.toString());

        if(sta1.equals(sta2)){
//            System.out.println("相等");
            return true;
        }else{
//            System.out.println("不相等");
            return false;
        }


    }

    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";
        System.out.println(backspaceCompare(s,t));
    }
}

package com.homework;

import java.util.Arrays;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/31 22:02
 */
public class Demo03 {

    public static String s1 = "F-H";
    public static String s2 = "F+H";
    public static String[] D = new String[11];//D[0] --> dragon[0]

    public static void main(String[] args) {

        Arrays.fill(D, "");//这是给数组初始化的一个常用函数,就是从D[0]····D[n-1]里面的内容全部变成""(空的字符串)
        //18行内容等同于20-22
//        for(int i= 0;i<D.length;i++){
//            D[i]="";
//        }

        System.out.println(Dragon(3));
        //运行结果：F-H-F+H-F-H+F+H-F-H-F+H+F-H+F+H
    }

    public static String Dragon(int n) {
        if (n == 0) {
            D[0] = "F-H";
            return "F-H";
        } else {
            if (D[n - 1] == "") {
                Dragon(n - 1);
            }
            String s = "";
            for (int j = 0; j < D[n - 1].length(); j++) {//j=0;j<2;j++
                char c = D[n - 1].charAt(j);
                if (c == 'F') {
                    s = s + s1;
                } else if (c == 'H') {
                    s = s + s2;
                } else {
                    s = s + c;
                }
            }
            D[n] = s;
            return D[n];

        }
    }
}



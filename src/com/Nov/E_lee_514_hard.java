package com.Nov;

import java.util.*;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-14 19:32
 * @description
 * 旋转圆盘，让不同的字母放在符合的位置上面
 */
public class E_lee_514_hard {

    public  int findRotateSteps(String ring,String key){

//        if(key==null || key.length() ==0){
//            return 0;
//        }


        int len = ring.length();
        int row = key.length();
        int[][] array = new int[row][len];

        Map<Character, List> map = new HashMap<>();
        for(int i=0;i<ring.length();i++){
            ArrayList<Integer> list ;
            if( ! map.containsKey(ring.charAt(i))){
                list = new ArrayList<Integer>();

            }else{
                list = (ArrayList<Integer>) map.get(ring.charAt(i));
            }
            list.add(i);
            map.put(ring.charAt(i),list);
        }

        int center = 0;
        ArrayList<Integer>  lol;
        for(int i=0;i<row;i++){

            lol = (ArrayList<Integer>) map.get(key.charAt(i));

            if(i == 0){//找第一个字符
                for (Integer k:lol
                ) {

                    int clockwise;
                    int anticlockwise;

                    if(k == center){
                        clockwise = anticlockwise = 0;

                    }else if(k > center){
                        clockwise = k-center;
                        anticlockwise = ring.length()-clockwise;
                    }else{
                        clockwise = center-k;
                        anticlockwise = ring.length()-clockwise;
                    }

                    clockwise ++;
                    anticlockwise ++;

                    array[i][k] = Math.min(clockwise,anticlockwise);
                }
            }else{
                for (int j = 0;j<ring.length();j++){
                    if(array[i-1][j] != 0){
                        center = j;

                        for (Integer k:lol
                        ) {

                            int clockwise =0;
                            int anticlockwise =0;

                            if(k == center){
                                clockwise = anticlockwise = 0;

                            }else if(k > center){
                                clockwise = k-center;
                                anticlockwise = ring.length()-clockwise;
                            }else{
                                clockwise = center-k;
                                anticlockwise = ring.length()-clockwise;
                            }

                            clockwise ++;
                            anticlockwise ++;

                            if(array[i][k] ==0){
                                array[i][k] =  Math.min(clockwise,anticlockwise) + array[i-1][j];
                            }else{
                                array[i][k] = Math.min(Math.min(clockwise,anticlockwise) + array[i-1][j],array[i][k]);
                            }
                        }
                    }

                    }
                }
            }

        for (int[] c:array
             ) {
            System.out.println(Arrays.toString(c));
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0;i<len;i++){
            if(array[row-1][i]!=0){
                min = Math.min(min,array[row-1][i]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println(new E_lee_514_hard().findRotateSteps(ring,key));
    }
}

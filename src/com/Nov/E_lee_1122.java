package com.Nov;

import java.util.*;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-14 15:55
 * @description
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 */
public class E_lee_1122 {



    public static int[] relativeSortArray(int[] arr1,int[] arr2){

        if(arr2==null || arr2.length==0){
            if(arr1.length>0){
                Arrays.sort(arr1);
            }
            return arr1;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int a:arr1) {
            if(!map.containsKey(a))
                map.put(a,1);
            else{
                int value = map.get(a);
                value++;
                map.put(a,value);
            }
        }

        Map<Integer,Integer> map1 = new HashMap<>();
        for (int a:arr2) {
            if(!map1.containsKey(a))
                map1.put(a,1);
            else{
                int value = map1.get(a);
                value++;
                map1.put(a,value);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();

        List<Integer> list1 = new ArrayList<>();

        //先把arr1 按照 arr2 的样子搭起来
        for(int i =0;i<arr2.length;i++){
            if(map1.containsKey(arr2[i]) && map.containsKey(arr2[i])){
                int value = map.get(arr2[i]);
                while(value-- >0){
                    list.addLast(arr2[i]);
                }
                map.remove(arr2[i]);
            }
        }

        System.out.println("list--1:");
        for (Integer i:list
        ) {
            System.out.print(i+" ");
        }
        System.out.println();

//        System.out.println("list1:"+list1.toString());


        for (Integer i:arr1
             ) {
            if(!map1.containsKey(i)){
                list1.add(i);
            }
        }

        System.out.println("list1--"+list1.toString());
        Collections.sort(list1);
        for (Integer i:list1
             ) {
            list.addLast(i);
        }

        int f = 0;
        System.out.println("list--2:");
        for (Integer i:list
        ) {
            arr1[f++] = i;
//            System.out.print(i+" ");
        }
        System.out.println();


        System.out.println(Arrays.toString(arr1));
        return  arr1;
    }

    public static void main(String[] args) {

        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        relativeSortArray(arr1,arr2);
    }
}

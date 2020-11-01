package com.Oct;

import java.util.*;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-28 13:49
 * @description
 */
public class K_lee_1207_uniquenumber {

    public boolean uniqueOccurences(int[] arr){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i:arr) {
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
               int x =  map.get(i);
               map.put(i,++x);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer key:map.keySet()) {
            if(set.contains(map.get(key))){
                return false;
            }else{
                set.add(map.get(key));
            }
        }
        return true;
    }

    public void test(){

    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =1;i<10;i++){
            map.put(i,i);
        }
        //1.map遍历的方式
//        1.用iterator的方式
        Iterator<Map.Entry<Integer, Integer>> itor = map.entrySet().iterator();
        while(itor.hasNext()){
            Map.Entry<Integer, Integer> m = itor.next();
            System.out.println( "key:"+  m.getKey()+" value:"+m.getValue());
        }
        
//        2.使用keyset
        Set<Integer> set = map.keySet();
        for (Integer key:
             set) {
            System.out.println("key:"+key+" value:"+map.get(key));
        }
    }
}

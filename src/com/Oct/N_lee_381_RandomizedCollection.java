package com.Oct;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-31 12:22
 * @description
 *
 * ???不确定map查找元素的时间复杂度是否是1
 *
 * 设计数据结构
 * 1.插入一个元素的时间复杂度o(1)
 * 2.删除一个元素的时间复杂度o(1)
 * 3.随机获取一个每个元素的概率相等 1 1 2 1：2/3 2：1/3
 */
public class N_lee_381_RandomizedCollection {

    Map<Integer,Integer> map = new HashMap<>();

    //Initialize your data structure
    public N_lee_381_RandomizedCollection(){

    }

    //
    public boolean insert(int val){
        if(map.containsKey(val)){
            int value = map.get(val);
            map.put(val,++value);
            return false;
        }else {
            map.put(val, 1);
            return true;
        }
    }


    public boolean remove(int val){
        if(map.containsKey(val)){
            int value = map.get(val);
            value--;
            if(value == 0){
                map.remove(val);
            }else{
                map.put(val,value);
            }
            return true;
        }else{
            return false;
        }
    }

    public int getRandom(){

        return 0;
    }
}

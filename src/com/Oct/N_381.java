package com.Oct;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-31 17:00
 * @description
 */
public class N_381 {
    int n;//总共的数字的个数
    Random random;//生成随机数

    HashMap<Integer, Set<Integer>> map;
    ArrayList<Integer> list;

    //Initialize
    public N_381(){
        this.n = 0;
        this.random = new Random();
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<>();
    }

    //insert
    public boolean insert(int val){
        Set<Integer> set;
        list.add(val);
        if(map.containsKey(val)){
            
            set = map.get(val);
            set.add(n);
            map.put(val,set);
            this.n++;
            return false;//之前存在这个元素

        }else{
            set = new HashSet<>();
            set.add(n);
            this.n++;
            return true;//之前不存在这个元素
        }

    }

    //remove
    //1.找到最后一个元素的set集合  拿到下标
    //2.当前要删除元素的set集合    拿到下标
    //3.交换List中的两个元素的位置->list中删除掉最后一个元素
    //4.最后一个元素集合里面删除掉一个位置 添加上一个新的位置
    //5.当前元素集合里面删掉一个位置
    //6.元素个数-1
    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }
        int lastindex = n-1;
        Set lastset = map.get(list.get(lastindex));//存放最后一个元素位置的集合

        Set curset = map.get(val);//当前要删除元素的集合

        int currentindex = (int) curset.iterator().next();//获得要删除元素的下标

        swap(list,currentindex,lastindex);
        list.remove(lastindex);

        curset.remove(currentindex);
        if(curset.size() == 0){
            map.remove(val);
        }
        lastset.remove(n-1);
        lastset.add(currentindex);
        n--;
        return true;
    }

    //从n个元素里面随机的拿到一个元素，概率相等
    public int getRandom(){
        return list.get(random.nextInt(n));
    }

    //交换集合里面两个元素的位置
    public static void swap(ArrayList<Integer> list,int a,int b){
        int temp = list.get(a);
        list.set(temp,list.get(b));
        list.set(b,temp);
    }

}

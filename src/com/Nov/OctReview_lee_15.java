package com.Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-02 15:57
 * @description
 * 从数组里面找出不重复的3个数字 a+b+c ==0
 * 1.初始思路：三层循环
 *   1-1:重复元素的问题没办法处理
 */
public class OctReview_lee_15 {
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i= 0;i<nums.length-2;i++){
            if(nums[i] > 0) continue;
            if(list.size() > 0){
                List<Integer> listtemp = list.get(list.size()-1);
                if(nums[i] == listtemp.get(0))//这一次的遍历，和上次的开始元素是相同，这样会产生重复数组
                    continue;
            }

            for(int j = i+1;j<nums.length-1;j++){
                if(nums[i] + nums[j] >0) continue;

                for(int k=j+1;k<nums.length;k++){
                    int t = nums[i]+nums[j]+nums[k];
                    if(t > 0){
                        break;
                    }else if(t==0){
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        list.add(list1);
                        break;
                    }
                }
            }
        }
        for (List<Integer> list2:list
             ) {
//            System.out.println(list2.toArray());
            System.out.println(list2.toString());
        }

        return list;
    }


    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        threeSum(nums);
        int[] nums = {0,0,0,0};
        threeSum(nums);
    }
}

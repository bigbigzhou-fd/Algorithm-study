package com.Nov;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-03 09:52
 * @description
 */
public class OctReview_lee_220 {

    public static boolean containsNreabyAlmostDuplicate(int[] nums,int k,int t){

        boolean flag = false;

        for(int i=0;i<nums.length;i++){
            int j =1;
            while(j<=k){
                if((i+j)<nums.length){
                    long x1 = nums[i];
                    long y = nums[i+j];

                    long  x = Math.abs(x1-y);
                    if(x <= t){
                        flag = true;
//                        System.out.println(nums[i]+" "+nums[j]);
                        break;
                    }
                    j++;
                }else{
                    break;
                }

            }

            if(flag)
                break;
        }

        if(flag)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        containsNreabyAlmostDuplicate(nums,k,t);
    }

}

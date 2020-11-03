package com.Nov;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-03 10:55
 * @description
 * 两个有序数组找中位数，但是要求时间复杂度在o(log(m+n))!
 * 1.初始思路： 顺序遍历 -> 找到中间位置的数字
 */
public class B_lee_4 {

    public static double findMedianSortedArrays(int[] nums1,int[] nums2){

        int len = nums1.length +nums2.length;
        if(len == 0){
            return 0.00000;
        }
        if(nums1.length == 1 && nums2.length == 0){
            return nums1[0];
        }
        if(nums1.length == 0 && nums2.length == 1){
            return nums2[0];
        }

        if(nums1.length == 0){
           if(nums2.length %2 == 1){
               return  nums2[nums2.length/2];
           }else{
               return (nums2[nums2.length/2]+nums2[nums2.length/2-1])*1.0/2;
           }
        }

        if(nums2.length == 0){
            if(nums1.length %2 == 1){
                return  nums1[nums1.length/2];
            }else{
                return (nums1[nums1.length/2]+nums1[nums1.length/2-1])*1.0/2;
            }
        }

        int x,y;
        if(len%2 == 1){
            x = len/2+1;
            y = x;
        }else{
            x = len/2;
            y = x+1;
        }
        int i = 0,j=0;
        int t = 1;

        int temp1,temp2;
        if(nums1[0] < nums2[0]){
            i++;
            temp2 = nums1[0];
        }else{
            j++;
            temp2 = nums2[0];
        }

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                temp1 = temp2;
                temp2 = nums1[i];
                i++;

            }else{
                temp1 = temp2;
                temp2 = nums2[j];

                j++;
            }
            t++;
            if(len%2 == 1 && t == x){
                return temp2;
            }

            if(len%2 == 0 && t == y){
                return (temp1+temp2)*1.0/2;
            }
        }
        while(i<nums1.length){
            temp1 = temp2;
            temp2 = nums1[i++];
            t++;
            if(len%2 == 1 && t == x){
                return temp2;
            }

            if(len%2 == 0 && t == y){
                return (temp1+temp2)*1.0/2;
            }
        }
        while(j<nums2.length){
            temp1 = temp2;
            temp2 = nums2[j++];
            t++;
            if(len%2 == 1 && t == x){
                return temp2;
            }

            if(len%2 == 0 && t == y){
                return (temp1+temp2)*1.0/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = {};
        int nums2[] = {2,3};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}

package com.binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/number-of-flowers-in-full-bloom/description/?envType=daily-question&envId=2023-09-28
 */
public class LeetCode2251 {
    public static void main(String[] args) {
        int[][] flowers = {{1,10},{3,3}};
        int[] people = {3,3,2};
        int[] res = fullBloomFlowers(flowers, people);
        System.out.println(Arrays.toString(res));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int len = people.length;
        int[] res = new int[len];

        int[] startFlower = new int[flowers.length];
        int[] endFlower = new int[flowers.length];
        for(int i = 0; i < flowers.length; i++){
            startFlower[i] = flowers[i][0];
            endFlower[i] = flowers[i][1];
        }

        Arrays.sort(startFlower);
        Arrays.sort(endFlower);
        for (int i = 0; i < people.length; i++) {
            int start = binarySearch(startFlower, people[i], 0, flowers.length - 1);
            int end = binarySearch(endFlower, people[i], 0, flowers.length - 1);
            res[i] = end - start + 1;
            System.out.println(i+" "+start+" "+end);
        }
        return res;
    }

    /**
     * satrt <= flower 可以看见
     * end > flower
     * @param num
     * @param flower
     * @param start
     * @param end
     * @return
     */
    public static int binarySearch(int[] num, int flower, int start, int end) {
        int mid = (start + end) / 2;
        if(start >= end){
            return start;
        }

        if (num[mid] > flower) {
            mid = mid - 1;
            return binarySearch(num, flower, start, mid);
        } else {
            mid = mid + 1;
            return binarySearch(num, flower, mid, end);
        }

    }

}

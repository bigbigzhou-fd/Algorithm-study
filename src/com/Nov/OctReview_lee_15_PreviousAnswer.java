package com.Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-02 16:47
 * @description
 */
public class OctReview_lee_15_PreviousAnswer {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);

        if (nums.length <= 2 || nums == null) {
            return list;
        }

        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                return list;//数组已经排序，后面的数都比我大，相加之后不会再等于0了，可以直接返回了
            }

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                int n = nums[i] + nums[L] + nums[R];
                if (n == 0) {
                    List<Integer> list1 = new ArrayList<Integer>();
                    list1.add(nums[i]);
                    list1.add(nums[L]);
                    list1.add(nums[R]);
                    list.add(list1);

                    int left = nums[L];
                    int right = nums[R];
                    L = L + 1;
                    R = R - 1;
                    while (L < R && nums[L] == left) {
                        L++;
                    }
                    while (L < R && nums[R] == right) {
                        R--;
                    }
                    if (L >= R)
                        break;
                } else if (n < 0) {
                    L++;
                } else {
                    R--;
                }
            }

        }

        return list;
    }
}

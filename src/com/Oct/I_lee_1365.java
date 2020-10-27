package com.Oct;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//给定一个数组，统计有多少个数字小于这个数
public class I_lee_1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] A = new int[101];
        for(int i = 0;i<nums.length;i++){
            int x = nums[i];
            A[x]++;
        }
        int ans = 0;

        for(int i = 0;i<101;i++){
            if(A[i] != 0){
                int temp = A[i];
               A[i] = ans;
               ans += temp;
            }
        }
        for(int i = 0;i<nums.length;i++){
           int y = nums[i];
           nums[i] = A[y];
        }
//        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void test() throws ParseException {

        String day1 = "2020-10-31";
        String day2 = "2021-01-08";
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD");

        Date date1 = sf.parse(day1);
        Date date2 = sf.parse(day2);
        long day = 24*60*60*1000;
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        System.out.println(date1.getTime()/day);
        System.out.println(date2.getTime()/day);

        long z =date2.getTime()/day-date1.getTime()/day;
        System.out.println(z);
        //两个人的生日相差天数
        System.out.println(Integer.toBinaryString((int) z));
    }

    public static void main(String[] args) throws ParseException {
        int[] A= {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(A)));
    }
}

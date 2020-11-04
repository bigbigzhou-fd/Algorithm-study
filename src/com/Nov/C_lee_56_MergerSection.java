package com.Nov;

import java.util.*;
//思路解析
//1.输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
// * 输出: [[1,6],[8,10],[15,18]]
// * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//题解思路：
//    给你一个初始的数组，要求你把数组进行合并，其实关键代码就是其中两步：
//	1.首先可以先去intervals[i][0] 进行排序，刚开始做的时候就是我认为数组的起始元素就是有序的，但是后来提交，才发现所有的元素不是全部有序的，并且可能会有重复
//	  处理：遍历interval,放在map里面，遇到其实位置相同的数组，存放长度较大的，例如[2,5]和[2,6]就要[2,6]
//	        遍历map的key集合，按照key进行排序
//			得到一个有序的且没有重复元素的集合
//
//	2.拿到处理好的集合后
//	  2-1
//	      intervals1[i][1] < intervals1[i+1][0] 这种情况就肯定不用合并了
//		  直接把a[i][1]存放到map集合里面就可以
//
//	  2-2
//	     否则，两个数组存在重叠的部分，可以进行合并
//		  if(map.containsKey(intervals1[i - 1][0])){
//                    map.remove(intervals1[i - 1][0]);
//          }
//          intervals1[i][0] = Math.min(intervals1[i - 1][0], intervals1[i][0]);
//          intervals1[i][1] = Math.max(intervals1[i - 1][1], intervals1[i][1]);
//          map.put(intervals1[i][0], intervals1[i][1]);
//
//		  其实实际意义就是合并重复数组，同时更新一下当前（intervals1[i]）的情况，后面还要看intervals1[i+1]会不会和intervals1[i]发生重叠
//
//lee57就是在lee56的基础上面，向数组中添加了一个新的元素，别的都没有变
//最后提交的时候，56题的答案数组没有排序，57的答案需要排序，自己提交的时候就能看到
//
/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-04 15:03
 * @description 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class C_lee_56_MergerSection {

    public static int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] t : intervals
        ) {
            if(map.containsKey(t[0])){
                int value = map.get(t[0]);
                t[1] = Math.max(t[1],value);
            }
            map.put(t[0], t[1]);
        }

        Set<Integer> set = map.keySet();
        int[] keys = new int[set.size()];

        System.out.println("key-------start");
        int count= 0;
        for (Integer key:set
             ) {
            keys[count++] = key;
        }
        Arrays.sort(keys);
//        for(int i = 0;i<keys.length;i++){
//            System.out.println(i+" "+keys[i]);
//        }
        System.out.println("key-------------end");

        int i = 0;
        int[][] intervals1 = new int[map.size()][2];
        for (Integer key : keys
        ) {
//            System.out.println(i+" "+key + " " + map.get(key));
            intervals1[i][0] = key;
            intervals1[i][1] = map.get(key);
            i++;
        }
        map.clear();

        if (intervals1.length == 1) {
            return intervals1;
        }

//        System.out.println("整理后的数组");
//        for (int[] a:intervals1
//             ) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println("整理完毕");

        for (i = 1; i < intervals1.length; i++) {
            //数据已经进行了处理，数组中按照从小到大进行了排列
            if (intervals1[i - 1][1] < intervals1[i][0]) {//1-1.接不上
                map.put(intervals1[i - 1][0], intervals1[i - 1][1]);//后面元素不用动
            }else{
                if(map.containsKey(intervals1[i - 1][0])){
                    map.remove(intervals1[i - 1][0]);
                }
                intervals1[i][0] = Math.min(intervals1[i - 1][0], intervals1[i][0]);
                intervals1[i][1] = Math.max(intervals1[i - 1][1], intervals1[i][1]);
                map.put(intervals1[i][0], intervals1[i][1]);
            }
        }

        if (intervals1.length >= 2) {
            if (intervals1[intervals1.length - 2][1] < intervals1[intervals1.length - 1][0]) {//最后一个元素没有被添加进来
//                    map.remove(intervals[i-1][0]);
                map.put(intervals1[intervals1.length - 1][0], intervals1[intervals1.length - 1][1]);
            }
        }

        int len = map.size();
        int[][] a = new int[len][2];
        Set<Integer> set1 = map.keySet();
        int t = 0;
        for (Integer m : set1) {
            a[t][0] = m;
            a[t][1] = map.get(m);
            t++;
        }
//        System.out.println("最后结果");
//            for(int x = 0;x<len;x++){
//                System.out.println(Arrays.toString(a[x]));
//            }

        return a;
    }

    public static void main(String[] args) {

//        int[][] intervals = {{2, 3}, {5, 5}, {2, 2},{3,4},{3,4}};
//        System.out.println("--------------");
//        merge(intervals);
//
//        int[][] interval1 = {{1, 4}, {0, 4}};
//        System.out.println("--------------");
//        merge(interval1);

        int[][] interval2 = {{362,367},{314,315},{133,138},{434,443},{202,203},{144,145},{229,235},{205,212},{314,323},{128,129},{413,414},{342,345},{43,49},{333,342},{173,178},{386,391},{131,133},{157,163},{187,190},{186,186},{17,19},{63,69},{70,79},{386,391},{98,102},{236,239},{195,195},{338,338},{169,170},{151,153},{409,416},{377,377},{90,96},{156,165},{182,186},{371,372},{228,233},{297,306},{56,61},{184,190},{401,403},{221,228},{203,212},{39,43},{83,84},{66,68},{80,83},{32,32},{182,182},{300,306},{235,238},{267,272},{458,464},{114,120},{452,452},{372,375},{275,280},{302,302},{5,9},{54,62},{237,237},{432,439},{415,421},{340,347},{356,358},{165,168},{15,17},{259,265},{201,204},{192,197},{376,383},{210,211},{362,367},{481,488},{59,64},{307,315},{155,164},{465,467},{55,60},{20,24},{297,304},{207,210},{322,328},{139,142},{192,195},{28,36},{100,108},{71,76},{103,105},{34,38},{439,441},{162,168},{433,433},{368,369},{137,137},{105,112},{278,280},{452,452},{131,132},{475,480},{126,129},{95,104},{93,99},{394,403},{70,78}};
        System.out.println("-------start-------");
        int[][] a = merge(interval2);
        for (int[] b:
             a) {
            System.out.println(Arrays.toString(b));
        }
    }
    //        int[][] a = new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        merge(a);
//        System.out.println("---------------");
//        int[][] b = new int[][]{{1,4},{4,5}};
//        merge(b);
//        System.out.println("---------------");
//        int[][] c = new int[][]{{1,4},{0,4}};
//        merge(c);
//        System.out.println("---------------");
//        int[][] d = new int[][]{{4,5},{1,4},{0,1}};
//        merge(d);

//        int[][] intervals = {{2, 3}, {4, 5}, {6, 7},{8,9},{1,10}};
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int[] t : intervals
//        ) {
//            map.put(t[0], t[1]);
//        }
//        Set<Integer> set = map.keySet();
//        for (Integer key : set
//        ) {
//            System.out.println(key + " " + map.get(key));
//        }
//        System.out.println("--------------");
//        merge(intervals);

//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10},{15,18}};
}

//            第二遍尝试
//            if (intervals[i - 1][1] < intervals[i][0]) {//1-1.接不上
//                map.put(intervals[i - 1][0], intervals[i - 1][1]);//后面元素不用动
//            } else if (intervals[i - 1][0] > intervals[i][1]) {//1-2.接不上
//                map.put(intervals[i][0], intervals[i][1]);
//                int left = intervals[i][0];
//                int right = intervals[i][1];
//
//                intervals[i][0] = intervals[i - 1][0];
//                intervals[i][1] = intervals[i - 1][1];
//
//                intervals[i - 1][0] = left;
//                intervals[i - 1][1] = right;
//
//            } else {//2.除了接不上情况剩下全部都是接的上了
//                map.remove(intervals[i - 1][0]);
//                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
//                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
//                map.put(intervals[i][0], intervals[i][1]);
//            }
//            第一遍尝试
//                    if(intervals[i-1][1]>=intervals[i][0]){//能接上
//                         intervals[i][0] = intervals[i-1][0];
//                         intervals[i][1] = Math.max(intervals[i-1][1],intervals[i][1]);
//                         map.put(intervals[i][0],intervals[i][1]);
//                    }else if(){
//
//                    }else{
//                        map.put(intervals[i-1][0],intervals[i-1][1]);
//                    }

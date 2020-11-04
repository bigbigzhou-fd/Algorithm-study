package com.Nov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-04 13:48
 * @description
 * intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 */
public class C_lee_57 {
        public static int[][] insert(int[][] intervals,int[] newInterval){

            if((intervals==null || intervals.length==0)&& newInterval!=null){
                return new int[][]{{newInterval[0],newInterval[1]}};
            }


            int[][] c = merge(intervals, newInterval);

            if (c == null || c.length == 1) {
                return intervals;
            }

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int[] t : c
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
            int[] end = new int[set1.size()];
            int n = 0;
            for (Integer u:set1
                 ) {
                end[n++] = u;
            }
            Arrays.sort(end);

            int t = 0;
            for (Integer m : end) {
                a[t][0] = m;
                a[t][1] = map.get(m);
                t++;
            }
            System.out.println("最后结果");

            for(int x = 0;x<len;x++){
                System.out.println(Arrays.toString(a[x]));
            }

            return a;
        }
        public static int[][] merge(int[][] a,int[] b){
            int[][] c = new int[a.length+1][2];
            for(int i =0;i<a.length;i++){
                c[i][0] = a[i][0];
                c[i][1] = a[i][1];
            }

            c[c.length-1][0]=b[0];
            c[c.length-1][1]=b[1];
//            for (int[] t:c
//                 ) {
//                System.out.println(Arrays.toString(t));
//            }
            return c;
        }

    public static void main(String[] args) {
        int[][] a = {{0,1},{2,3},{7,8},{9,9}};
        int[] b = {19,26};
        insert(a,b);
    }

}

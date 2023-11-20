package com.treetravel;

import java.util.*;

public class LeetCode2316 {

    public long countPairs(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges
        ) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);

            List<Integer> list1 = map.getOrDefault(edge[1], new ArrayList<>());
            list1.add(edge[0]);
            map.put(edge[1], list1);
        }

//        List<Integer> countCircleList = new ArrayList<>();

        int res = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                int countCircle = travel(i, vis, map);
//                for(int count: countCircleList){
//                    res += count * countCircle;
//                }
                res += count * countCircle;
                count += countCircle;
//                countCircleList.add(countCircle);
            }
        }
//        System.out.println(countCircleList.size());
        return res;
    }

    public int travel(int i, boolean[] vis, Map<Integer, List<Integer>> map) {

        if (vis[i]) {
            return 0;
        } else {
            vis[i] = true;
        }
        List<Integer> list = map.get(i);
        if (list == null) {
            return 1;
        }
        int countCircle = 1;
        for (int num : list) {
           countCircle +=  travel(num, vis, map);
        }
        return countCircle;
    }

    public static void main(String[] args) {
        int[][] edges =
                {{1, 0}, {3, 1}, {0, 4}, {2, 1}};
        new LeetCode2316().countPairs(5, edges);
    }
}

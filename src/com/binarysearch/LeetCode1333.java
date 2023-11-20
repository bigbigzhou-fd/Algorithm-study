package com.binarysearch;

import java.util.*;

public class LeetCode1333 {




    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Info> listInfo = new ArrayList<>();
        for(int rest[]: restaurants){
            Info info = new Info(rest[0], rest[1], rest[2], rest[3], rest[4]);
            listInfo.add(info);
        }
        //过滤后返回餐馆的 id，按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序。
        // 简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。
        Collections.sort(listInfo, new Comparator<Info>() {
            @Override
            public int compare(Info info1, Info info2) {
                if(info1.rating != info2.rating){
                    return info2.rating - info1.rating;
                }else {
                    return info1.id - info2.id;
                }
            }
        });
        List<Integer> listRes = new ArrayList<>();
        for(Info list : listInfo){
            if(veganFriendly == 1 && list.veganFriendly == 0){
                continue;
            }
            if(maxPrice < list.price || maxDistance < list.distance){
                continue;
            }
            listRes.add(list.id);
        }
        return listRes;
    }

    class Info{
        int id;
        int rating;
        int veganFriendly;
        int price;
        int distance;

        public Info(int id, int rating, int veganFriendly, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.veganFriendly = veganFriendly;
            this.price = price;
            this.distance = distance;
        }
    }
}

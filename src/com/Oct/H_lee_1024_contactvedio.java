package com.Oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/24 12:23
 */
/*
输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
输出：3
解释：
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 */
public class H_lee_1024_contactvedio {

    public static int videoStitching(int[][] clips, int T) {
        //maxend[i] i代表开头 maxend[i]代表结尾
        int[] maxend = new int[T + 1];
        boolean flag = true;

        Arrays.fill(maxend, 0);
        for (int[] a : clips) {

            int start = a[0];
            int end = a[1];

            if (end >= T) {
                flag = false;
            }

            if (start > T)//凑不出
                continue;
            maxend[start] = Math.max(end, maxend[start]);//记录每一个最大的结尾的元素
        }
        for (int i = 0; i < T + 1; i++) {
            if (maxend[i] != 0) {
                System.out.println(i + " " + maxend[i]);
            }
        }

        if (flag) {
            return -1;
        }
//        for(int i =0;i<T;i++){
//            System.out.println(i+" "+maxend[i]);
//        }
        int sp = 0;

        int si = 0;
        int end = 0;
        while (si < T) {

            if (maxend[si] >= T) {
                sp++;
                return sp;
            }

            if (maxend[si] > 0) {


                if (maxend[si] == si) {
                    sp++;
                    end = si;
                    si = si + 1;
                } else {
                    end = si;
                    si = maxend[si];
                    sp++;
                }

            } else {
                int tsi = si;

                int tmax = 0;
                for (int t = end + 1; t < tsi; t++) {
                    if (maxend[t] > tmax) {
                        tmax = maxend[t];
                        end = t;
                        si = tmax;
                    }
                }

                if (tmax == 0) {//找不到元素连接上
                    return -1;
                } else {
                    sp++;
                    if (tmax >= T) {
                        return sp;
                    }
                }
            }
        }

//        System.out.println(sp);
        return sp;
    }

    public static void test(int[][] test) {
        System.out.println("函数开始");
        int len = 0;
        for (int[] a : test) {
            System.out.println(a[0] + ":" + a[1]);
            len++;
        }
        System.out.println(len);
    }

    public static void main(String[] args) {
//        int[][] test = {{0,1},{0,2,4,3},{6,2},{5,1}};
//        test(test);
//          int[][] clips = {{0,6},{1,7},{0,9},{2,10},{0,4},{0,2},{10,10},{7,9},{0,3}};
//          int T =15;
//         System.out.println(videoStitching(clips,T));

//         int[][] clips1 = {{0,4},{2,8}};
//         int T1 = 5;
//         System.out.println(videoStitching(clips1,T1));

//         int[][] clips2 = {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
//         int T2 = 5;
//         System.out.println(videoStitching(clips2,T2));
//
//         [[0,6],[1,7],[0,9],[2,10],[0,4],[0,2],[10,10],[7,9],[0,3]]
//        15

        int[][] clips1 = {{24, 28}, {10, 56}, {50, 78}, {38, 77}, {38, 78}, {3, 69}, {33, 49}, {66, 89}, {73, 83}, {6, 12}, {24, 86}, {67, 82}, {18, 26}, {1, 57}, {13, 30}, {8, 56}, {58, 78}, {2, 84}, {35, 39}, {45, 51}, {30, 32}, {19, 31}, {32, 70}, {1, 15}, {16, 18}, {32, 87}, {32, 87}, {39, 42}, {81, 84}, {25, 61}, {26, 34}, {10, 82}, {17, 34}, {56, 72}, {17, 22}, {8, 83}, {5, 21}, {3, 79}, {12, 73}, {0, 28}, {74, 76}, {41, 79}, {4, 60}, {51, 90}, {10, 41}, {47, 90}, {44, 56}, {13, 16}, {43, 83}, {0, 22}, {30, 40}, {8, 27}, {57, 58}, {0, 26}, {16, 66}, {62, 89}, {2, 74}, {17, 61}, {25, 28}, {23, 54}, {42, 79}, {14, 28}, {26, 77}, {34, 36}, {17, 42}, {72, 81}, {12, 87}, {3, 57}, {81, 88}, {65, 87}, {35, 74}, {19, 77}, {10, 53}, {38, 75}, {14, 90}, {10, 90}, {57, 62}, {37, 74}, {24, 80}, {52, 63}, {52, 55}, {64, 73}, {45, 79}, {12, 19}, {26, 38}, {40, 81}, {28, 48}, {33, 62}, {18, 50}, {9, 40}};
        int T1 = 72;
        System.out.println(videoStitching(clips1, T1));
    }
}

package com.Nov;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-11-02 17:11
 * @description
 * 初始思路：1.每次拿数字的最低位和1相与，得到1最低位就是1
 *         2.数字不停的右移1位，前面高的一位就变到最低位上了
 *         3.问题是，>>  << 你不会用！！！！
 */
public class OctReview_lee_191 {
    public static int hammingWeight(int n){
        int count = 0;
        String s = "";
        s += Integer.toOctalString(n);

        for(int m = 0;m<s.length();m++){
            if(s.charAt(m) == '1'){
                count++;
            }
        }

        System.out.println("count="+count);
        return count;
    }

    public static int hammingWeight1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        System.out.println("bits"+bits);
        return bits;
    }


    public static void main(String[] args) {
//        int n = 8;
//        String x = Integer.toBinaryString(n);
//        System.out.println(Integer.toBinaryString(n));

        int n = 00000000000000000000000000001011;
        System.out.println("n="+n);
        hammingWeight1(n);

        hammingWeight(n);


        System.out.println("字符串："+Integer.toString(n));
        System.out.println("二进制："+Integer.toBinaryString(n));
        System.out.println("八进制: "+Integer.toOctalString(n));
        System.out.println("十六进制"+Integer.toHexString(n));

//
//        System.out.println(Integer.toOctalString(260));
//        System.out.println(Integer.toOctalString(130));
    }
}

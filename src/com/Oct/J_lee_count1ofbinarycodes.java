package com.Oct;

/**
 * @Author zhouzhou
 * @program: Algorithm
 * @create: 2020-10-27 11:15
 * @description:统计无符号整数中0数字的个数
 */
//00000000000000000000000000001011 3
//00000000000000000000000010000000 1
//11111111111111111111111111111101 31
public class J_lee_count1ofbinarycodes {

    public static int hammingWeight(int n){
        String s = Integer.toOctalString(n);
        System.out.println(s);
        int count = 0;
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i)-'1' == 0)
                count++;
        }
        System.out.println(count);
        return count;
    }

    public static int count1(int n){
        int bits = 0;
        int mask = 1;
        for(int i=0;i<32;i++){
            if((n&mask)==1)
                bits++;

            n = n>>1;
        }
        System.out.println(bits);
        return bits;
    }

    public static void main(String[] args) {
//       int n= 00000000000000000000000000001011;
//       hammingWeight(n);

//       int n1 = 00000000000000000000000000001011;
//       count1(n1);
//       hammingWeight(n1);
//        System.out.println(Integer.parseInt("11111111111111111111111111111101"));

//        count1(11111111111111111111111111111101);
//       String n2 =  "11111111111111111111111111111101”;
//       hammingWeight(n2);
         int a = -3;
        String s = Integer.toBinaryString(a);
         System.out.println(s);

//        int b = Integer.parseInt(s);
//        System.out.println(b);


        int c = Integer.parseUnsignedInt(s);
        System.out.println(c);
    }

}

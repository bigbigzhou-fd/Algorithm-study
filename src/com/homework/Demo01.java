package com.homework;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/31 19:02
 * <p>
 * 写一程序，从键盘上输入1年份year（4位十进制数），判断其是否闰年。闰年的条件是：能被4整除、但不能被100整除，或者能被400整除。
 */
public class Demo01 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int year = sc.nextInt();
//
//        if(year%4==0&&year%100!=0){
//            System.out.println("闰年");
//        }else{
//            System.out.println("不是闰年");
//        }
        //计算1+··+10


//        int sum =0;
//        System.out.println("sum:"+sum);
////        for(int i =1;i<11;i++){
//            int x = sum+i;
//            sum =x;
////        }
//        int  i=1;
//        while(i<11){
//
//        }
//        System.out.println(sum);

//        Integer i ;
//        System.out.println("i="+i);

//        int i = 0;
//        int j = 0;
//        int x = ++j;
//        System.out.println("i++:"+(i++));
//        System.out.println("++j:"+(++j));
//        System.out.println("i="+i);
//        System.out.println("j="+j);

//        int sum =0;
//        System.out.println("sum:"+sum);
//        for(int i =1;i<11;i++){
//            int x = sum+i;
//            sum =x;
//        }
        System.out.println(Function(10));
    }

    @Test
    public void F1() {
        System.out.println("abc");
    }

    //从1+···+10 void
    public static int Function(int x) {
        if (x == 1) {
            return 1;
        } else {
//            return 2+1;
//            return  3+2+1;
//            return  4+F(3);

            return x + Function(x - 1);
        }

    }

}

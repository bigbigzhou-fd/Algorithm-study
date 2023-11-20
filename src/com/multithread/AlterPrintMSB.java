package com.multithread;

public class AlterPrintMSB {
    public static void main(String[] args) {
        char[] num = "1234567".toCharArray();
        char[] character = "abcdefg".toCharArray();

        Object object = new Object();
        Thread threadNum = new Thread(() -> {
            synchronized (object){
//                object.notify();
                for (char n:num
                     ) {
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+n);
//                    object.notify(); Q1为什么不是先 wait在 notify，这中间有什么关系
                }
            }
        }, "printNum");

        Thread threadCharacter = new Thread(() -> {
            synchronized (object){
//                try {
//                    object.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                for (char n : character
                ) {
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+n);

                }
            }
        }, "printCharacter");
        threadNum.start();
        threadCharacter.start();


    }
}

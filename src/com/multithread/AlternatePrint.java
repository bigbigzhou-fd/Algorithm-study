package com.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//1a2b3c4d
public class AlternatePrint {



    public static void main(String[] args) {

        Lock lockNum = new ReentrantLock();
        Lock lockChar = new ReentrantLock();
        Lock lock = new ReentrantLock();
        lockNum.lock();
        lockChar.lock();

        Thread threadNum = new Thread(new Runnable() {
            int num = 0;
            @Override
            public void run() {

                print(num);
                num ++;
                lock.unlock();
                lock.lock();
//                lockChar.lock();
//                lockNum.unlock();
            }
        });
        Thread threadChar = new Thread(new Runnable() {
            char charact = 'a';
            @Override
            public void run() {
                lock.lock();
                print(charact);
                charact ++;
                lock.unlock();
            }
        });
        lockChar.unlock();
        int i = 0;
        while(i<100){
            threadChar.start();
            threadNum.start();
            i++;
        }
    }

    public static void print(int i){
        System.out.println(Thread.currentThread().getName() +" "+i);

    }

    public static void print(char i){
        System.out.println(Thread.currentThread().getName() +" "+i);
    }


}

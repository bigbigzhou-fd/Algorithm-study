package com.multithread;
import java.util.concurrent.Semaphore;

public class AlternatePrintGPT {
    public static void main(String[] args) {
        Semaphore numSemaphore = new Semaphore(1);
        Semaphore charSemaphore = new Semaphore(0);

        Thread threadNum = new Thread(() -> {
            int num = 0;
            try {
                while (num < 100) {
                    numSemaphore.acquire();
                    System.out.println(num);
                    num++;
                    charSemaphore.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadChar = new Thread(() -> {
            char c = 'a';
            try {
                while (c <= 'z') {
                    charSemaphore.acquire();
                    System.out.println(c);
                    c++;
                    numSemaphore.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadNum.start();
        threadChar.start();
    }
}


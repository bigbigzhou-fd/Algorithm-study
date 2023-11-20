package com.multithread;

public class AlternatePrintGPT_2 {
    private static final Object lock = new Object();
    private static int num = 0;
    private static char character = 'a';

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                while (num < 6) {
                    synchronized (lock) {
                        if (num % 2 == 0) {
                            System.out.print(num);
                            num++;
                        }
                        lock.notify();
                        if (num < 6) {
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                while (character <= 'e') {
                    synchronized (lock) {
                        if (num % 2 != 0) {
                            System.out.print(character);
                            character++;
                        }
                        lock.notify();
                        if (character <= 'e') {
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
    }
}


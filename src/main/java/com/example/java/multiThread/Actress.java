package com.example.java.multiThread;

/**
 * 实现Runnable接口
 */
public class Actress implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts performing!");

        int count = 0;
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "'s show: " + (++count));
            if (count == 10) {
                keepRunning = false;
            }
            if (count % 2 == 0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " stops performing!");
    }
}
